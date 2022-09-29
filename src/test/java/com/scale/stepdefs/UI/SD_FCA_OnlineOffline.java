package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Class SD_FCA_OnlineOffline
 * This class contains all the stepdefs which is related to "Choose how to build your bid pack" page
 *
 * @author 321020
 */
public class SD_FCA_OnlineOffline {

    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(SD_FCA_OnlineOffline.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * ChooseRoles Stepdefs class constructor has overloaded
     *
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_FCA_OnlineOffline(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }
    @When("Buyer selects how to build the bid pack")
    public void buyerselectshowtobuildthebidpack() {
        objectManager.getOnlineOfflineObj().selectOnlineOffline();
    }
}
