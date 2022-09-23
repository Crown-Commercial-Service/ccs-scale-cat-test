package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class SD_FCA_ResourcesAndWeightings
 * This class contains all the stepdefs which is related to "SD_FCA_ResourcesAndWeightings" page
 *
 * @author 321020
 */
public class SD_FCA_ResourcesAndWeightings {

    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(SD_FCA_ResourcesAndWeightings.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * SD_FCA_ResourcesAndWeightings Stepdefs class constructor has overloaded
     *
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_FCA_ResourcesAndWeightings(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }
    @When("Buyer selects resources and set weightings")
    public void buyerSelectsResourcesAndSetWeightings() {
        objectManager.getResourcesAndWeightingsObj().enterResourcesAndWeightings();
    }
}
