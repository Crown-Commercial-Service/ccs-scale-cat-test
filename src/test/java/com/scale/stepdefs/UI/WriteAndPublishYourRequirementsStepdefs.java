package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

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
	 * WriteAndPublishYourRequirementsStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public WriteAndPublishYourRequirementsStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef is calls the method clickOnSection2Links
	 * that clicks on link "<Upload your pricing schedule>" under section2
	 * @param linkName
	 * @param section
	 */
	@Given("Buyer clicks on link {string} under section{int}")
	public void buyer_clicks_on_link_under_section(String linkName, Integer section) {
	    
		objectManager.getWriteAndPublishYourRequirements().clickOnSection2Links(linkName);
		
	}
	
	/**
	 * 
	 * This stepdef calls the method clickOnSection3Links
	 * that clicks on link "<Add context and requirements>" under section3
	 * 
	 * @param link
	 * @param section
	 */
	@Given("Buyer clicks on link {string} under section{int} Add context to your further competition")
	public void buyer_clicks_on_link_under_section_Add_context_to_your_further_competition(String link, Integer section) {
	    
		objectManager.getWriteAndPublishYourRequirements().clickOnSection3Links();
	}
	
	
}
