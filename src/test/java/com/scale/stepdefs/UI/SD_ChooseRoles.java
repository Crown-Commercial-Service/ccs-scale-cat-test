package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Class SD_ChooseRoles
 * This class contains all the stepdefs which is related to "Choose the roles you need" page
 *
 * @author 321020
 */
public class SD_ChooseRoles {

    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(SD_ChooseRoles.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * ChooseRoles Stepdefs class constructor has overloaded
     *
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_ChooseRoles(TestContext testContextObj, ScenarioContext scenarioContext) {
        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    @And("Buyer enters the quantity for the roles")
    public void entersTheQuantityForTheRoles() {
        Map<String, String> ClusterData = new HashMap<>();
        for (String Key : TestContext.OneFCTestDataMap.get(TestContext.TDID).keySet()) {
            if (Key.contains("S34_Cluster_")) {
                ClusterData.put(Key.replace("S34_Cluster_", ""), TestContext.OneFCTestDataMap.get(TestContext.TDID).get(Key));
            }
        }
        objectManager.getChooseRoleObj().selectCluster(ClusterData);
    }
}
