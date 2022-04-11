package com.scale.stepdefs;

import com.scale.POJO.CreateProject;
import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.API.APIBase;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.Log;
import com.scale.framework.utility.ReadExcelData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Steps_CreateProject {
    public APIBase apibase=new APIBase();
    private Logger log = Log.getLogger(SD_CreateProject.class);
    public static Response CaT_Response;
    public static Response Jaggaer_Response;
    ConfigurationReader configread = new ConfigurationReader();
    Map<String, Map<String, String>> TestDataMap = ReadExcelData.extractData("CreateProject");
    Map<String, Map<String, String>> UpdateDataMap = ReadExcelData.extractData("UpdateProject");
    Map<String, String> ResponseData = new HashMap<>();
    int counter = 1;
    String Endpoint,TDID,PROC_ID;

    TestContext testContext;
    ScenarioContext scenarioContext;
    public Steps_CreateProject(ScenarioContext scenarioContext, TestContext testContext) {
        this.scenarioContext = scenarioContext;
        this.testContext= testContext;
    }

    @Given("an API endpoint to create new project")
    public void getCreateProjectEndpoint() {
        Endpoint =configread.get("create.project.endpoint");
    }

    @When("another/an user from an/same/different organisation requests new/same project using {string}")
    public void createProject(String TestData) {
        this.TDID=TestData;
        CreateProject cpo = new CreateProject(TestDataMap.get(TDID).get("agreementId"),TestDataMap.get(TDID).get("lotId"));
        CaT_Response=apibase.Requestpost(Endpoint, cpo, TestDataMap.get(TDID).get("UserID"));
        //CreateProject cpo_res = CaT_Response.body().as(CreateProject.class);
        //CaT_Response=apibase.Requestpost(Endpoint, TestDataMap.get(TDID), TDID);
        testContext.scenarioWrite(CaT_Response.prettyPrint());
        ResponseData.put("ProcID"+counter,Integer.toString(CaT_Response.jsonPath().getInt("procurementID")));
        ResponseData.put("Name"+counter,CaT_Response.jsonPath().getString("defaultName.name"));
        counter++;
    }

    @Then("a project should have been created in Jaggaer with the prescribed fields and status as Running")
    public void validate_Project_In_Jaggaer() {
        String tenderCode = null;
        try {
            ResultSet rs = scenarioContext.postgresSqlConnection.getData("select external_project_id from procurement_projects where project_id ="+CaT_Response.jsonPath().getInt("procurementID"));
            while (rs.next() ) {
                tenderCode = rs.getString("external_project_id");
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String Endpoint =configread.get("JaggaerGETProjects");
        String param ="tenderCode=="+tenderCode;
        Jaggaer_Response=apibase.getRequestJaggaer(Endpoint,param);
        Assert.assertEquals("Project Status Validation", "project.state.running", Jaggaer_Response.jsonPath().getString("projectList.project[0].tender.tenderStatusLabel"));
    }

    @And("a valid response will be returned with the created project details")
    public void validateCreateProjectResponse() {
        Assert.assertEquals("Project Name Validation",TestDataMap.get(TDID).get("agreementId")+"-"+TestDataMap.get(TDID).get("lotId")+"-COGNIZANT BUSINESS SERVICES UK LIMITED",CaT_Response.jsonPath().getString("defaultName.name"));
    }


    @Then("Jaggaer Project Identifier is mapped to the procurement ID in Tenders DB")
    public void jaggaerProjectIdentifierIsMappedToTheRelatedCaTProjectIdentifierProcIDInTheCrossReferenceTable() {
        String tenderCode = null;
        try {
            ResultSet rs = scenarioContext.postgresSqlConnection.getData("select external_project_id from procurement_projects where project_id ="+CaT_Response.jsonPath().getInt("procurementID"));
            while (rs.next() ) {
                tenderCode = rs.getString("external_project_id");
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull("tenderCode Validation", tenderCode);
    }

    @Then("both projects should have been created with the same default name but with different procurement ID")
    public void validateNameAndProcID() {
        Assert.assertEquals("Default names are not same: ",ResponseData.get("Name1"),ResponseData.get("Name2"));
        Assert.assertTrue("ProcIDs are same",Integer.parseInt(ResponseData.get("ProcID1"))!=Integer.parseInt(ResponseData.get("ProcID2")));
    }

    @Then("both projects should have been created with different default name and procurement ID")
    public void validateNameAndProcIDAcrossOrg() {
        Assert.assertFalse("Default Names are same", ResponseData.get("Name1").contentEquals(ResponseData.get("Name2")));
        Assert.assertTrue("ProcIDs are same",Integer.parseInt(ResponseData.get("ProcID1"))!=Integer.parseInt(ResponseData.get("ProcID2")));
    }

    @Given("an API endpoint to update project name")
    public void anAPIEndpointToUpdateProjectName() {
        Endpoint =configread.get("update.project.endpoint");
    }

    @When("Buyer updates default project name with new {string}")
    public void userUpdatesTheProjectName(String TD) {
        TDID = TD;
        Endpoint=Endpoint.replace("procID",UpdateDataMap.get(TD).get("procID"));
        PROC_ID=UpdateDataMap.get(TD).get("procID");
        UpdateDataMap.get(TD).remove("procID");
        CaT_Response=apibase.Requestput(Endpoint, UpdateDataMap.get(TD),"default");
    }

    @Then("the new project name should be updated in Jaggaer and Tenders DB table")
    public void theNewProjectNameShouldBeUpdatedInJaggaerAndTendersDBTable() {
        String tenderCode = null;
        try {
            ResultSet rs = scenarioContext.postgresSqlConnection.getData("select external_project_id, project_name from procurement_projects where project_id ="+PROC_ID);
            while (rs.next() ) {
                tenderCode = rs.getString("external_project_id");
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String Endpoint =configread.get("JaggaerGETProjects");
        String param ="tenderCode=="+tenderCode;
        Jaggaer_Response=apibase.getRequestJaggaer(Endpoint,param);
        Assert.assertEquals("Project Name is TendersDB and Jaggaer are different", UpdateDataMap.get(TDID).get("name"), Jaggaer_Response.jsonPath().getString("projectList.project[0].tender.title"));
    }
}