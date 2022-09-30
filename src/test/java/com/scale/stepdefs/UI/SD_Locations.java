package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SD_Locations {
    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(WriteAndPublishYourRequirementsStepdefs.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * SecurityVetting Stepdefs class constructor has overloaded
     *
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_Locations(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    @When("Buyer selects the regions for Further Competition")
    public void buyerSelectsTheRegionsfor1FC() {
        objectManager.getLocationObj().selectLocationfor1FC(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S37_Locations"));
    }

    @When("Buyer selects the regions for Capability Assessment")
    public void buyerSelectsTheRegionsforFCA() {
        objectManager.getLocationObj().selectLocationforFCA(TestContext.FCATestDataMap.get(TestContext.TDID).get("S17_Locations"));
    }
}
