package com.scale.stepdefs.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

/**
 * Class WriteAndPublishYourRequirementsStepdefs
 * This class contains all the stepdefs which is
 * related to WriteAndPublishYourRequirements page
 * 
 * @author 571154
 *
 */
public class WriteAndPublishYourRequirementsStepdefs {

	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(WriteAndPublishYourRequirementsStepdefs.class);
	
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
	public WriteAndPublishYourRequirementsStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}

	/**
	 * This stepdef calls the method clickOnStarANewProject
	 * that clicks on StarANewProject link
	 */
	@When("Buyer clicks on {string} page link.")
	public void buyer_clicks_on_link(String linkName) {
		objectManager.getWriteAndPublishYourRequirements().clickLink(linkName);
	}
}
