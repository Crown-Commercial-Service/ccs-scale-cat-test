package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class SD_FCA_EnterWeightings
 * This class contains all the stepdefs which is related to "EnterWeightings" page
 *
 * @author 321020
 */
public class SD_FCA_EnterWeightings {

    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(SD_FCA_EnterWeightings.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * ChooseRoles Stepdefs class constructor has overloaded
     *
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_FCA_EnterWeightings(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }
    @When("Buyer enters the dimension weightings")
    public void buyerEntersTheDimensionWeightings() {
        objectManager.getEnterWeightingsObj().enterDimensionWeightings(TestContext.FCATestDataMap.get(TestContext.TDID).get("S10_EnterWeightings"));
    }
}
