package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SD_SocialValueQuestions {
    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(WriteAndPublishYourRequirementsStepdefs.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * SD_SocialValueQuestions Stepdefs class constructor has overloaded
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_SocialValueQuestions(TestContext testContextObj, ScenarioContext scenarioContext) {

        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    /**
     * This stepdef calls the method setSocialValueQuestions that sets Technical Questions
     */
    @When("Buyer enters social value questions")
    public void buyerEntersSocialValueQuestions() {
        String data =TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S45_Social Value Questions");
        objectManager.getSocialValueQuestionsObj().setSocialValueQuestions(data);
    }
}
