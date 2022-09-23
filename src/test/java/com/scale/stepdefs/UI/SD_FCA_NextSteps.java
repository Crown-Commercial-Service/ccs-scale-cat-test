package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class SD_FCA_NextSteps
 * This class contains all the stepdefs which is related to "Number of suppliers to take to further competition" page
 *
 * @author 321020
 */
public class SD_FCA_NextSteps {

    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(SD_FCA_NextSteps.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * SD_FCA_NextSteps Stepdefs class constructor has overloaded
     *
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_FCA_NextSteps(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    @And("Buyer selects {string} option")
    public void buyerSelectsOption(String arg0) {
        objectManager.getNextStepsObj().nextSteps();
    }
}