package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;


/**
 * Class AddAnyPerformanceIncentivesStepdefs
 * contains all the stepdefs related to
 * AddAnyPerformanceIncentivesStepdefs page
 * 
 * @author 571154
 *
 */
public class AddAnyPerformanceIncentivesStepdefs {
	
	
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(AddAnyPerformanceIncentivesStepdefs.class);

	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	/**
	 * ChooseHowToFindASupplierStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public AddAnyPerformanceIncentivesStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	
	/**
	 * This stepdef calls the method enterValueInTextBox()
	 * which enters the values in the textbox
	 * 
	 */

	@Given("Buyer enters the value in text boxs performance incentives and exit strategy")
	public void buyer_enters_the_value_in_text_boxs_performance_incentives_and_exit_strategy() {
		
		objectManager.getAddAnyPerformanceIncentives().enterValueInTextBox();
	}

}
