package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SD_ScoringCriteria {

    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(SD_SkillCapabilities.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * SecurityVetting Stepdefs class constructor has overloaded
     *
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_ScoringCriteria(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    @When("Buyer enters scoring criteria")
    public void buyerEntersScoringCriteria() {
        String Data = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S48_Scoring Criteria");;
        objectManager.getScoringCriteriaObj().setScoringCriteria(Data);
    }
}
