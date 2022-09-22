package com.scale.stepdefs.UI;

import com.scale.context.GlobalContext;
import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SD_FCPublished {
    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(SD_FCPublished.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * SD_TechnicalQuestions Stepdefs class constructor has overloaded
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_FCPublished(TestContext testContextObj, ScenarioContext scenarioContext) {

        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    @When("Buyer clicks on the {string} button")
    public void buyerClicksOnTheButton(String arg0) {
        String EventID= objectManager.getFCPublishedObj().getEventID();
        GlobalContext.getGlobalInstance().setGlobalDataValue("EventID",EventID);
        objectManager.getFCPublishedObj().clickGotoDashboard();
    }
}