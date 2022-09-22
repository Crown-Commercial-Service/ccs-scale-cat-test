package com.scale.stepdefs.UI;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SD_QualityPriceWeighting {
    /**
     * Variables declaration
     */
    private static final Logger log = LogManager.getLogger(SD_QualityPriceWeighting.class);
    private PageObjectManager objectManager;
    public ScenarioContext scenarioContext;
    ConfigurationReader configReader = new ConfigurationReader();

    /**
     * SD_QualityPriceWeighting Stepdefs class constructor has overloaded
     * @param testContextObj
     * @param scenarioContext
     */
    public SD_QualityPriceWeighting(TestContext testContextObj, ScenarioContext scenarioContext) {

        testContextObj.getDriver();
        objectManager = testContextObj.getObjectManager();
        this.scenarioContext = scenarioContext;
    }

    @When("Buyer enters quality and price weighting")
    public void buyerEntersQualityAndPriceWeighting() {
        String data =TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S41_quality and price weighting");
        objectManager.getQualityPriceWeightingObj().setQualityPriceWeighting(data);
    }
}
