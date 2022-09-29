package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class ChooseIfThisIsNewReplacementOrExpandedStepdefs
 * This class contains all the stepdefs which is
 * related to ChooseIfThisIsNewReplacementOrExpandedStepdefs page
 * 
 * @author 571154
 *
 */
public class ChooseIfThisIsNewReplacementOrExpandedStepdefs {
	
	
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(ChooseIfThisIsNewReplacementOrExpandedStepdefs.class);
	
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
	public ChooseIfThisIsNewReplacementOrExpandedStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef calls the method selectRadioButton()
	 * that selects the radio button
	 */
	@Given("Buyer selects one of the option by selecting the radio button in Choose if this is new, replacement or expanded product or service page")
	public void buyer_selects_one_of_the_option_by_selecting_the_radio_button_in_Choose_if_this_is_new_replacement_or_expanded_product_or_service_page() {
	    
		objectManager.getChooseIfThisIsNewReplacementOrExpanded().selectRadioButton();
	}

}
