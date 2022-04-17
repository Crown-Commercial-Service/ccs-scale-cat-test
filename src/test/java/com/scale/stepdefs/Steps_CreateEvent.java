package com.scale.stepdefs;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.API.APIBase;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.JSONUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


public class Steps_CreateEvent {
    public APIBase apibase=new APIBase();
    private static final Logger log = LogManager.getLogger(Steps_CreateEvent.class);
    public static Response jsonResponse;
    ConfigurationReader configread = new ConfigurationReader();
    Map<String, Object> payload;

    TestContext testContext;
    ScenarioContext scenarioContext;
    public Steps_CreateEvent(ScenarioContext scenarioContext, TestContext testContext) {
        this.scenarioContext = scenarioContext;
        this.testContext= testContext;
    }

    @When("a request is sent to the Create Event Endpoint for the ProcID {int}")
    public void aRequestIsSentToTheEndpointWithAValidPayload(int ProcID) {
        String Endpoint =configread.get("create.event.endpoint");
        //jsonResponse=apibase.Requestpost(Endpoint+ ProcID +"/events", "{}");
        testContext.scenarioWrite(jsonResponse.prettyPrint());
    }

    @Then("the events are created and the details should be returned in the response")
    public void theEventsAreCreatedAndTheDetailsShouldBeReturnedInTheResponse() {
        payload =new JSONUtility().convertJSONtoMAP("./src/test/resources/TestData/CreateEventResponse.json");
        Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
        Assert.assertEquals("Event Name Validation",payload.get("agreementId")+"-"+payload.get("lotId")+"-CCS-RFP",jsonResponse.jsonPath().getString("name"));
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

    @And("validate the event details in the DB")
    public void validateTheEventDetailsInTheDB() {
        try {
            String projectName = jsonResponse.jsonPath().getString("dataList.rfx[0].rfxSetting.shortDescription");
            ResultSet rs = scenarioContext.postgresSqlConnection.getData("select project_id, external_reference_id from procurement_projects where project_name ="+"'"+projectName+"'");
            while (rs.next() ) {
                String  project_details = "project_id= "+rs.getString("project_id")+"external_reference_id= "+rs.getString("external_reference_id");
                System.out.println(project_details);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @When("a GET request is sent to the endpoint")
    public void aGETRequestIsSentToTheEndpoint() {
        String Endpoint =configread.get("Retrieve.eventtypes.endpoint");
        //jsonResponse=apibase.getRequest(Endpoint);
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

}
