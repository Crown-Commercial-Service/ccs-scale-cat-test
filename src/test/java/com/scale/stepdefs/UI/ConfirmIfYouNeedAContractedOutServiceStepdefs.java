package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class ConfirmIfYouNeedAContractedOutServiceStepdefs
 * This class contains all the stepdefs which is
 * related to ConfirmIfYouNeedAContractedOutServiceStepdefs page
 * 
 * @author 571154
 *
 */
public class ConfirmIfYouNeedAContractedOutServiceStepdefs {

	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(ConfirmIfYouNeedAContractedOutServiceStepdefs.class);
	
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
	public ConfirmIfYouNeedAContractedOutServiceStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef is calls the method clickOnSection2Links
	 * that clicks on link "<Upload your pricing schedule>" under section2
	 */
	@Given("Buyer selects one of the option by selecting the radio button")
	public void buyer_selects_one_of_the_option_by_selecting_the_radio_button() {
	    
		objectManager.getConfirmIfYouNeedAContractedOutService().selectRadioButton();
	}

	
	

}
