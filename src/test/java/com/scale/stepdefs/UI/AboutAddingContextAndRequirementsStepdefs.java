package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class AboutAddingContextAndRequirementsStepdefs
 * contains all the stepdefs related to
 * AboutAddingContextAndRequirementsStepdefs page
 * 
 * @author 571154
 *
 */
public class AboutAddingContextAndRequirementsStepdefs {

	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(AboutAddingContextAndRequirementsStepdefs.class);

	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	/**
	 * AboutAddingContextAndRequirementsStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public AboutAddingContextAndRequirementsStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef calls the method clickOnContinueButton
	 * that clicks on Continue button
	 * @param radioButtton
	 */
	@Given("Buyer clicks on Continue button")
	public void buyer_clicks_on_Continue_button() {
	   
		objectManager.getAboutAddingContextAndRequirements().clickOnContinueButton();
	}

}
