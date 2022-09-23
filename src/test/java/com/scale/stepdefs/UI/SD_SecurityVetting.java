package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Class SD_ChooseRoles
 * This class contains all the stepdefs which is related to "Set your highest security and vetting requirements" page
 *
 * @author 321020
 */
public class SD_SecurityVetting {
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
    public SD_SecurityVetting(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    @When("Buyer selects the security and vetting level")
    public void buyerSelectsTheSecurityAndVettingLevel() {
        objectManager.getSecurityVettingObj().selectSecurityLevel(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S35_Security Level"));
    }
}
