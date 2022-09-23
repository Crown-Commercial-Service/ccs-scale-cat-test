package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class SD_FCA_ServiceCapabilities
 * This class contains all the stepdefs which is related to "SD_FCA_ServiceCapabilities" page
 *
 * @author 321020
 */
public class SD_FCA_ServiceCapabilities {

    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(SD_FCA_ServiceCapabilities.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * SD_FCA_ServiceCapabilities Stepdefs class constructor has overloaded
     *
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_FCA_ServiceCapabilities(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    @When("Buyer selects service capabilities")
    public void buyerSelectsServiceCapabilities() {
        objectManager.getServiceCapabilitiesObj().selectServiceCapabilities();
    }
}
