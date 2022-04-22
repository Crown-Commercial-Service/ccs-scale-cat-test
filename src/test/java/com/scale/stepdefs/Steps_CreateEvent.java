package com.scale.stepdefs;

import com.scale.context.GlobalContext;
import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.API.APIBase;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.JSONUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;


public class Steps_CreateEvent {
    public APIBase apibase=new APIBase();
    private static final Logger log = LogManager.getLogger(Steps_CreateEvent.class);
    public static Response jsonResponse;
    ConfigurationReader configread = new ConfigurationReader();
    Map<String, Object> payload;
    String Endpoint;

    TestContext testContext;
    ScenarioContext scenarioContext;
    public Steps_CreateEvent(ScenarioContext scenarioContext, TestContext testContext) {
        this.scenarioContext = scenarioContext;
        this.testContext= testContext;
    }

    @Given("an API endpoint to create/update a/an new/existing event")
    public void getCreateEventEndpoint() {
        Endpoint =configread.get("create.update.event.endpoint");
    }


    @Given("an API endpoint to retrieve valid event types for a project")
    public void getRetrieveEventTypesEndpoint() {
        Endpoint =configread.get("Retrieve.eventtypes.endpoint");
    }


    @When("a {string} sends a request to create/update an/the event with type {string} and title {string} for {int}")
    public void createEventForProject(String UID, String type, String title, int procID) {
        jsonResponse=apibase.Requestpost(Endpoint.replace("procID",Integer.toString(procID)), "{\"nonOCDS\":{\"eventType\":\""+type+"\"},\"OCDS\":{\"title\":\""+title+"\"}}", UID);
        testContext.scenarioWrite(jsonResponse.asPrettyString());
        //payload =new JSONUtility().convertJSONtoMAP("./src/test/resources/TestData/CreateEventResponse.json");
    }

    @When("a {string} sends a request to create/update an/the event with type {string} and title {string}")
    public void createEvent(String UID, String type, String title) {
        Endpoint= Endpoint.replace("procID",GlobalContext.getGlobalInstance().getGlobalDataValue("ProcID"))+"/"+GlobalContext.getGlobalInstance().getGlobalDataValue("EventID");
        jsonResponse=apibase.Requestput(Endpoint, "{\"eventType\":\""+type+"\",\"name\":\""+title+"\"}", UID);
        testContext.scenarioWrite(jsonResponse.asPrettyString());
        //payload =new JSONUtility().convertJSONtoMAP("./src/test/resources/TestData/CreateEventResponse.json");
    }

    @When("an event should be created and the {string} should be returned in the response")
    public void validateCreateEventResponse(String title) {
        Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
        Assert.assertEquals("Event Name Validation",title,jsonResponse.jsonPath().getString("title"));
        Assert.assertEquals("Event Type Validation","RFI",jsonResponse.jsonPath().getString("eventType"));
        Assert.assertEquals("Event Type Validation","planned",jsonResponse.jsonPath().getString("status"));
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

    @When("a {string} sends a request to retrieve valid events for project")
    public void retrieveValidEventsForProject(String UID) {
        Endpoint= Endpoint.replace("procID",GlobalContext.getGlobalInstance().getGlobalDataValue("ProcID"));
        jsonResponse=apibase.Requestget(Endpoint, UID);
        testContext.scenarioWrite(jsonResponse.asPrettyString());
    }

    @Then("the {string} should be returned in the response")
    public void validateRetrievedEventTypes(String data) {
        List<String> expected = Arrays.asList(data.split(",", -1));
        List<String> actual =jsonResponse.jsonPath().getList("type");
        expected.sort(Comparator.naturalOrder());
        actual.sort(Comparator.naturalOrder());
        if(!((expected.equals(actual)))){
        Assert.fail("Expected Event Types are not returned");
        }
    }
}
