package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class AddBackgroundToYourProcurementStepdefs
 * This class contains all the stepdefs which is
 * related to AddBackgroundToYourProcurementStepdefs page
 * 
 * @author 571154
 *
 */
public class AddBackgroundToYourProcurementStepdefs {
	
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(AddBackgroundToYourProcurementStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	ConfigurationReader configReader = new ConfigurationReader();

	/**
	 * WriteAndPublishYourRequirementsStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public AddBackgroundToYourProcurementStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	

	/**
	 * This stepdef calls the method 'enterValueInTextBox'
	 * which enters the value in the textboxs
	 * 'Write your key background information here' &
	 * 'Social value, economic and environmental benefits'
	 * @param txtBox1
	 * @param txtBox2
	 */
	@Given("Buyer enters the value in {string} and {string} text box.")
	public void buyer_enters_the_value_in_and_text_box(String txtBox1, String txtBox2) {
		
		objectManager.getAddBackgroundToYourProcurement().enterValueInTextBox();
	}

	
	

}
