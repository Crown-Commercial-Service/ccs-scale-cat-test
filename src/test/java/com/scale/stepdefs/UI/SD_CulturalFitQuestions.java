package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SD_CulturalFitQuestions {
    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(WriteAndPublishYourRequirementsStepdefs.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * Your Assessment Criteria Stepdefs class constructor has overloaded
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_CulturalFitQuestions(TestContext testContextObj, ScenarioContext scenarioContext) {

        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    /**
     * This stepdef calls the method clickAddEditLink that clicks on Add or Edit link for a specific page
     */

    @When("Buyer enters cultural fit questions")
    public void buyerEntersCulturalFitQuestions() {
        String data =TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S44_Cultural fit Questions");
        objectManager.getCulturalFitQuestionsObj().setCulturalFitQuestions(data);
    }
}
