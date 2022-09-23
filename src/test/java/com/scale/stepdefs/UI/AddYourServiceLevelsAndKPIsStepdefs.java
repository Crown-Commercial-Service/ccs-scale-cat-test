package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class AddYourServiceLevelsAndKPIsStepdefs
 * This class contains all the stepdefs which is
 * related to KPI pages
 * @author 571154
 *
 */
public class AddYourServiceLevelsAndKPIsStepdefs {
	
	/**
	 * Logger 
	 */
	private static final Logger log = LogManager.getLogger(AddYourServiceLevelsAndKPIsStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	
	/**
	 * CommonToAllPageStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public AddYourServiceLevelsAndKPIsStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	
	/**
	 * 
	 * This stepdef is calls the method setKPIs()
	 * which enters the value in the textbox
	 * 
	 */
	@Given("Buyer enters the value in text boxs for service level requirement or KPI")
	public void buyer_enters_the_value_in_text_boxs_for_service_level_requirement_or_KPI() {
	    
		objectManager.getAddYourServiceLevelsAndKPIs().setKPIs();
	}


	
}
