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

/**
 * Class SD_SkillCapabilities
 * This class contains all the stepdefs which is related to "Select essential skills and capabilities" page
 *
 * @author 321020
 */
public class SD_SkillCapabilities {
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
    public SD_SkillCapabilities(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    @When("Buyer selects the skills and capabilities")
    public void buyerSelectsTheSkillsAndCapabilities() {
        Map<String, String> ClusterData = new HashMap<>();
        for (String Key : TestContext.OneFCTestDataMap.get(TestContext.TDID).keySet()) {
            if (Key.contains("S36_Cluster_")) {
                ClusterData.put(Key.replace("S36_Cluster_", ""), TestContext.OneFCTestDataMap.get(TestContext.TDID).get(Key));
            }
        }
        objectManager.getSkillCapabilityObj().selectSkillCapability(ClusterData);
    }
}
