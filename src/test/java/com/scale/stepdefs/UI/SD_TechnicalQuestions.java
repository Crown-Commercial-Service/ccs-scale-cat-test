package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SD_TechnicalQuestions {
    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(SD_TechnicalQuestions.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * SD_TechnicalQuestions Stepdefs class constructor has overloaded
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_TechnicalQuestions(TestContext testContextObj, ScenarioContext scenarioContext) {

        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    /**
     * This stepdef calls the method setTechnicalQuestions that sets Technical Questions
     */
       @When("Buyer enters technical questions")
    public void buyerEntersTechnicalQuestions() {
           String data =TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S43_Technical Questions");
           objectManager.getTechnicalQuestionsObj().setTechnicalQuestions(data);
    }
}
