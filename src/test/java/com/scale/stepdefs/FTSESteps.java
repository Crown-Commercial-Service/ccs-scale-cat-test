package com.scale.stepdefs;

import com.scale.context.TestContext;
import com.scale.framework.utility.ScenarioContext;
import com.scale.framework.utility.SingletonObjectManager;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.scale.validations.FTSE;

public class FTSESteps {
    private TestContext testContextObj;
    private SingletonObjectManager singletonObjectManager;
    private ScenarioContext scenarioContext;
    private Scenario scenario;
    private FTSE ftse;

    public FTSESteps(TestContext testContextObj){
        this.testContextObj = testContextObj;
        this.singletonObjectManager = testContextObj.getSingletonObjectManager();
        this.scenarioContext = testContextObj.scenarioContext;
        this.scenario = testContextObj.scenario;
        ftse = singletonObjectManager.getFTSEObj();
    }

    @When("^POST request is updated for FTSE request$")
    public void POST_request_is_updated_for_FTSE_Request() { ftse.postRequest();}

    @When("^POST request is triggered for FTSE stocks$")
    public void POST_request_is_triggered_for_FTSE_Stocks() { ftse.postResponse(); }

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
}
