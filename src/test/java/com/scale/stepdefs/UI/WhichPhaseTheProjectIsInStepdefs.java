package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class WhichPhaseTheProjectIsInStepdefs
 * This class contains all the stepdefs which is
 * related to WhichPhaseTheProjectIsInStepdefs page
 * 
 * @author 571154
 *
 */
public class WhichPhaseTheProjectIsInStepdefs {
	
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(WhichPhaseTheProjectIsInStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	ConfigurationReader configReader = new ConfigurationReader();

	/**
	 * WhichPhaseTheProjectIsInStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public WhichPhaseTheProjectIsInStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
		
	/**
	 * This stepdef calls the method 'selectRadioButton'
	 * which selects the radio button
	 * @param radioButtonOptn
	 */
	@Given("Buyer selects the {string} radio button in Which phase the project is in page.")
	public void buyer_selects_the_radio_button_in_Which_phase_the_project_is_in_page(String string) {
	    
		objectManager.getWhichPhaseTheProjectIsIn().selectRadioButton();
	}




}
