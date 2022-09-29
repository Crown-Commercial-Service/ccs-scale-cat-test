package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class ManagementInformationAndReportingStepdefs
 * This class contains all the stepdefs which is
 * related to ManagementInformationAndReportingStepdefs page
 * 
 * @author 571154
 *
 */
public class ManagementInformationAndReportingStepdefs {

	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(ManagementInformationAndReportingStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	ConfigurationReader configReader = new ConfigurationReader();

	/**
	 * ManagementInformationAndReportingStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public ManagementInformationAndReportingStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef calls the method 'enterValueInTextBox'
	 * which enters the value in the textbox
	 * 
	 */
	@Given("Buyer enters the value in text box Specify what you expect from MI submissions.")
	public void buyer_enters_the_value_in_text_box_Specify_what_you_expect_from_MI_submissions() {
		
		objectManager.getManagementInformationAndReporting().enterValueInTextBox();
	}
}
