package com.scale.stepdefs;

import com.scale.context.TestContext;
import com.scale.framework.utility.APIUtil;
import com.scale.framework.utility.CommonValidations;
import com.scale.framework.utility.ScenarioContext;
import com.scale.framework.utility.SingletonObjectManager;
import com.scale.validations.AddPlace;
import com.scale.validations.FTSE;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class ApiStepDefs extends APIUtil {
    private TestContext testContextObj;
    private SingletonObjectManager singletonObjectManager;
    private ScenarioContext scenarioContext;
    private Scenario scenario;
    private FTSE ftse;
    private AddPlace addPlace;
    Response response;

    public ApiStepDefs(TestContext testContextObj) {
        this.testContextObj = testContextObj;
        this.singletonObjectManager = testContextObj.getSingletonObjectManager();
        this.scenarioContext = testContextObj.scenarioContext;
        this.scenario = testContextObj.scenario;
        ftse = singletonObjectManager.getFTSEObj();
        addPlace = singletonObjectManager.getAddPlace();
    }

    @Given("Add Place Payload request is updated")
    public void add_Place_Payload_request_is_updated() {
        // addPlace.postRequest();
    }

    @Given("{string} request payload is updated for {string}")
    public void request_payload_is_updated_for(String API,String method) {
        addPlace.postRequest(method);
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String API, String method) {
        addPlace.postResponse(method);
    }

    @Then("API call should be success with {string} for {string}")
    public void api_call_should_be_success_with(String statusCode, String method) {
        addPlace.validateResponseCode(statusCode,method);

    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {
        assertEquals(getJsonPath(response, keyValue), Expectedvalue);
    }
}
