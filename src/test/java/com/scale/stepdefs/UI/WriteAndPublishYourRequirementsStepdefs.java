package com.scale.stepdefs.UI;

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
	
}
