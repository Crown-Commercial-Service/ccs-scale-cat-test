package com.scale.stepdefs;

import com.scale.framework.utility.API.APIBase;
import com.scale.framework.utility.API.Auth;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.io.File;


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

    @Given("an Endpoint to create a project from agreement")
    public void anEndpointToCreateAProjectFromAgreement() {

    }

    @When("a request is sent to the Endpoint valid payload")
    public void aRequestIsSentToTheEndpointValidPayload() {
        String Endpoint =configread.get("create.project.endpoint");
        File Payload = new File("./src/test/resources/TestData/CreateProject.json");
        jsonResponse=apibase.Requestpost(Endpoint, Payload);

    }

    @Then("the created project details should be displayed in the response")
    public void theCreatedProjectDetailsShouldBeDisplayedInTheResponse() {
        Assert.assertEquals("Status Code Validation", 200, jsonResponse.getStatusCode());
    }
}
