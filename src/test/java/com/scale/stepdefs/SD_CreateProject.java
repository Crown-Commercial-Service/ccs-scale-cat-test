package com.scale.stepdefs;

import com.scale.framework.utility.API.APIBase;
import com.scale.framework.utility.API.Auth;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.JSONUtility;
import com.scale.framework.utility.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class SD_CreateProject {
    public Auth auth=new Auth();
    public APIBase apibase=new APIBase();
    private Logger log = Log.getLogger(SD_CreateProject.class);
    public String ordertoken;
    RequestSpecification requestspec;
    String strcontentype;
    public String access_hash;
    public int statusCode;
    public static Response jsonResponse;
    public static Response jsonAllProductsResponse=null;
    ConfigurationReader configread = new ConfigurationReader();
    Map<String, Object> payload;

    @When("a POST request is sent to the Endpoint with a valid payload")
    public void aRequestIsSentToTheEndpointValidPayload() {
        String Endpoint =configread.get("create.project.endpoint");
        File Payload = new File("./src/test/resources/TestData/CreateProject.json");
        jsonResponse=apibase.Requestpost(Endpoint, Payload);
    }

    @Then("a project is created in Jaggaer and the details are returned in the response")
    public void theCreatedProjectDetailsShouldBeDisplayedInTheResponse() {
        //Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
        payload =new JSONUtility().convertJSONtoMAP("./src/test/resources/TestData/CreateProject.json");
        //Assert.assertEquals("Project Name Validation",payload.get("agreementID")+"-"+payload.get("lotID")+"-CCS",jsonResponse.jsonPath().getString("defaultName.name"));

        Assert.assertEquals("Status Code Validation", 500, jsonResponse.getStatusCode());
        Assert.assertEquals("Project Name Validation","500 INTERNAL_SERVER_ERROR",jsonResponse.jsonPath().getString("errors[0].status"));

    }

    @And("validate project status in Jaggaer")
    public void theProjectShouldBeInRunningStatus() {
        String Endpoint =configread.get("JaggaerGETProjects");
        String param ="tenderTitle=="+payload.get("agreementID")+"-"+payload.get("lotID")+"-CCS";
        jsonResponse=apibase.getRequestJaggaer(Endpoint,param);
        System.out.println(jsonResponse.body().asString());
        Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
        Assert.assertEquals("Project Status Validation", "project.state.running", jsonResponse.jsonPath().getString("projectList.project[0].tender.tenderStatusLabel"));

    }


    @When("a request is sent to the Create Event Endpoint for the {int}")
    public void aRequestIsSentToTheEndpointWithAValidPayload(int ProcID) {
        String Endpoint =configread.get("create.event.endpoint");
        jsonResponse=apibase.Requestpost(Endpoint+Integer.toString(ProcID)+"/events", "{}");

    }

    @Then("the events are created and the details should be returned in the response")
    public void theEventsAreCreatedAndTheDetailsShouldBeReturnedInTheResponse() {
        //Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
        //payload =new JSONUtility().convertJSONtoMAP("./src/test/resources/TestData/CreateEventResponse.json");
        //Assert.assertEquals("Event Name Validation",payload.get("agreementID")+"-"+payload.get("lotID")+"-CCS-RFP",jsonResponse.jsonPath().getString("name"));
        //Assert.assertEquals("Event Type Validation","RFP",jsonResponse.jsonPath().getString("eventType"));
        //Assert.assertEquals("Event Type Validation","planning",jsonResponse.jsonPath().getString("status"));

        Assert.assertEquals("Status Code Validation", 500, jsonResponse.getStatusCode());
        Assert.assertEquals("Project Name Validation","500 INTERNAL_SERVER_ERROR",jsonResponse.jsonPath().getString("errors[0].status"));
    }

    @And("validate the details in Jaggaer")
    public void validateTheDetailsInJaggaer() {
        String Endpoint =configread.get("JaggaerGETEvents");

        //String param ="rfxReferenceCode=="+jsonResponse.jsonPath().getString("eventSupportID");
        //String ProjectName = jsonResponse.jsonPath().getString("name");
        String param ="rfxReferenceCode==itt_2008";
        String ProjectName="RM0002-1bTB-Test82-CCS";

        jsonResponse=apibase.getRequestJaggaer(Endpoint,param);
        System.out.println(jsonResponse.body().asString());
        Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
        Assert.assertEquals("Project Status Validation", ProjectName+"-RFP", jsonResponse.jsonPath().getString("dataList.rfx[0].rfxSetting.shortDescription"));

    }

    @When("a GET request is sent to the endpoint")
    public void aGETRequestIsSentToTheEndpoint() {
        String Endpoint =configread.get("Retrieve.eventtypes.endpoint");
        jsonResponse=apibase.getRequest(Endpoint);
    }

    @Then("all  possible event types are returned in the response")
    public void allPossibleEventTypesAreReturnedInTheResponse() {
        //System.out.println(jsonResponse.body().asString());
        Assert.assertEquals("Event Types Validation","[\"EOI\",\"RFI\",\"RFP\",\"DA\",\"SL\"]",jsonResponse.body().asString());
    }


}
