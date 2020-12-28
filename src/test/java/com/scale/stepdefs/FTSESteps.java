package com.scale.stepdefs;

import com.scale.context.TestContext;
import com.scale.framework.utility.ScenarioContext;
import com.scale.framework.utility.SingletonObjectManager;
import com.scale.validations.AddPlace;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.scale.validations.FTSE;

public class FTSESteps {
    private TestContext testContextObj;
    private SingletonObjectManager singletonObjectManager;
    private ScenarioContext scenarioContext;
    private Scenario scenario;
    private FTSE ftse;
    private AddPlace addPlace;

    public FTSESteps(TestContext testContextObj) {
        this.testContextObj = testContextObj;
        this.singletonObjectManager = testContextObj.getSingletonObjectManager();
        this.scenarioContext = testContextObj.scenarioContext;
        this.scenario = testContextObj.scenario;
        ftse = singletonObjectManager.getFTSEObj();
        addPlace = singletonObjectManager.getAddPlace();
    }

    @When("^POST request is updated for FTSE request$")
    public void POST_request_is_updated_for_FTSE_Request() {
        ftse.postRequest();
    }

    @When("^POST request is triggered for FTSE stocks$")
    public void POST_request_is_triggered_for_FTSE_Stocks() {
        ftse.postResponse();
    }

    @Then("^User should get Expected results for FTSE$")
    public void user_should_get_expected_result_for_FTSE() {
        ftse.validateResponseCode();
        if (scenarioContext.getContext("ExpectedStatus").equalsIgnoreCase("200"))
            ftse.validateResponse_200();
        else if (scenarioContext.getContext("ExpectedStatus").equalsIgnoreCase("403"))
            ftse.validateResponse_403();
        else if (scenarioContext.getContext("ExpectedStatus").equalsIgnoreCase("500"))
            ftse.validateResponse_500();
    }

    @Given("Add Place Payload request is updated")
    public void add_Place_Payload_request_is_updated() {
        addPlace.postRequest();
    }

    @When("user calls addPlaceAPI with {string} http request")
    public void user_calls_addPlaceAPI_with_http_request(String method) {
        ftse.postResponse();
    }

    @Then("API call should be success with {string}")
    public void api_call_should_be_success_with(String string) {

    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String string, String string2) {

    }
}
