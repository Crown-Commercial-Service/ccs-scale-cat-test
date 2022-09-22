package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import com.scale.stepdefs.UI.SD_TechnicalQuestions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SD_ReviewandPublish {
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
    public SD_ReviewandPublish(TestContext testContextObj, ScenarioContext scenarioContext) {

        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }
    @And("Buyer selects the checkbox")
    public void buyerSelectsTheCheckbox() {
        objectManager.getReviewandPublishObj().clickCheckBox();

    }

    @When("Buyer clicks {string} button")
    public void buyerClicksButton(String arg0) {
        objectManager.getReviewandPublishObj().clickPublish();
    }
}
