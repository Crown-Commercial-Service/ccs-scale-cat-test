package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;


/**
 * Class EnterYourProjectRequirementsStepdefs
 * This class contains all the stepdefs which is
 * related to EnterYourProjectRequirementsStepdefs page
 * 
 * @author 571154
 *
 */
public class EnterYourProjectRequirementsStepdefs {
	
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(EnterYourProjectRequirementsStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	ConfigurationReader configReader = new ConfigurationReader();

	/**
	 * LoginPageStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public EnterYourProjectRequirementsStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef calls the method enterValueInTextBox()
	 * which enters the values in the textbox
	 * 
	 */
	@Given("Buyer enters the value in text boxs Name of the group and requirement and Describe the requirement")
	public void buyer_enters_the_value_in_text_boxs_Name_of_the_group_and_requirement_and_Describe_the_requirement() {
		
		objectManager.getEnterYourProjectRequirements().setProjectRequirements();
	}
}
