package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class AddContextToYour1FCStepdefs
 * This class contains all the stepdefs which is
 * related to AddContextToYour1FCStepdefs page
 * 
 * @author 571154
 *
 */
public class AddContextToYour1FCStepdefs {

	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(AddContextToYour1FCStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	ConfigurationReader configReader = new ConfigurationReader();

	/**
	 * AddContextToYour1FCStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public AddContextToYour1FCStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef calls the method clickOnAboutAddingContextAndRequirementsLink
	 * that clicks on link "<About adding context and requirements>"
	 * 
	 * @param linkName
	 */
	@Given("Buyer clicks on link {string}")
	public void buyer_clicks_on_link(String linkName) {
	    
		objectManager.getAddContextToYour1FC().clickOnAboutAddingContextAndRequirementsLink();
	}

}
