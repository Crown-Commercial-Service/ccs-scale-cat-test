package com.scale.stepdefs;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.API.APIBase;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.JSONUtility;
import com.scale.framework.utility.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


public class SD_CreateProject  {
    public APIBase apibase=new APIBase();
    private Logger log = Log.getLogger(SD_CreateProject.class);
    public static Response jsonResponse;
    ConfigurationReader configread = new ConfigurationReader();
    Map<String, Object> payload;

    TestContext testContext;
    ScenarioContext scenarioContext;
    public SD_CreateProject(ScenarioContext scenarioContext, TestContext testContext) {
        this.scenarioContext = scenarioContext;
        this.testContext= testContext;
    }

    @When("a POST request is sent to the Endpoint with a valid payload")
    public void aRequestIsSentToTheEndpointValidPayload() {
        String Endpoint =configread.get("create.project.endpoint");
        File Payload = new File("./src/test/resources/TestData/CreateProject.json");
        jsonResponse=apibase.Requestpost(Endpoint, Payload);
        testContext.scenarioWrite(jsonResponse.prettyPrint());

    }

    @Then("a project is created in Jaggaer and the details are returned in the response")
    public void theCreatedProjectDetailsShouldBeDisplayedInTheResponse() {
        Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
        payload =new JSONUtility().convertJSONtoMAP("./src/test/resources/TestData/CreateProject.json");
        Assert.assertEquals("Project Name Validation",payload.get("agreementID")+"-"+payload.get("lotID")+"-CCS",jsonResponse.jsonPath().getString("defaultName.name"));
    }

    @And("validate project status in Jaggaer")
    public void theProjectShouldBeInRunningStatus() {
        String Endpoint =configread.get("JaggaerGETProjects");
        String param ="tenderTitle=="+payload.get("agreementID")+"-"+payload.get("lotID")+"-CCS";
        jsonResponse=apibase.getRequestJaggaer(Endpoint,param);
        Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
        Assert.assertEquals("Project Status Validation", "project.state.running", jsonResponse.jsonPath().getString("projectList.project[0].tender.tenderStatusLabel"));
    }


    @When("a request is sent to the Create Event Endpoint for the ProcID {int}")
    public void aRequestIsSentToTheEndpointWithAValidPayload(int ProcID) {
        String Endpoint =configread.get("create.event.endpoint");
        jsonResponse=apibase.Requestpost(Endpoint+ ProcID +"/events", "{}");
        testContext.scenarioWrite(jsonResponse.prettyPrint());
    }

    @Then("the events are created and the details should be returned in the response")
    public void theEventsAreCreatedAndTheDetailsShouldBeReturnedInTheResponse() {
        payload =new JSONUtility().convertJSONtoMAP("./src/test/resources/TestData/CreateEventResponse.json");
        Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
        Assert.assertEquals("Event Name Validation",payload.get("agreementID")+"-"+payload.get("lotID")+"-CCS-RFP",jsonResponse.jsonPath().getString("name"));
        Assert.assertEquals("Event Type Validation","RFP",jsonResponse.jsonPath().getString("eventType"));
        Assert.assertEquals("Event Type Validation","planning",jsonResponse.jsonPath().getString("status"));
    }

    @And("validate the details in Jaggaer")
    public void validateTheDetailsInJaggaer() {
        String Endpoint =configread.get("JaggaerGETEvents");

        String param ="rfxReferenceCode=="+jsonResponse.jsonPath().getString("eventSupportID");
        String EventName = jsonResponse.jsonPath().getString("name");

        jsonResponse=apibase.getRequestJaggaer(Endpoint,param);
        Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
        Assert.assertEquals("Event Name Validation", EventName, jsonResponse.jsonPath().getString("dataList.rfx[0].rfxSetting.shortDescription"));
    }

    @When("a GET request is sent to the endpoint")
    public void aGETRequestIsSentToTheEndpoint() {
        String Endpoint =configread.get("Retrieve.eventtypes.endpoint");
        jsonResponse=apibase.getRequest(Endpoint);
        testContext.scenarioWrite(jsonResponse.prettyPrint());
    }

    @Then("all  possible event types are returned in the response")
    public void allPossibleEventTypesAreReturnedInTheResponse() {
        Assert.assertEquals("Event Types Validation","[\n" +
                "    \"EOI\",\n" +
                "    \"RFI\",\n" +
                "    \"RFP\",\n" +
                "    \"DA\",\n" +
                "    \"SL\"\n" +
                "]",jsonResponse.body().asString());
    }

    @And("Validate Project in CaT DB")
    public void validateDB() {
        try {
            String projectName = payload.get("agreementID")+"-"+payload.get("lotID")+"-CCS";
            ResultSet rs = scenarioContext.postgresSqlConnection.getData("select external_reference_id from procurement_projects where project_name ="+"'"+projectName+"'");
            while (rs.next() ) {
                String  name = rs.getString("external_reference_id");
                System.out.println("Name : "+name);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
