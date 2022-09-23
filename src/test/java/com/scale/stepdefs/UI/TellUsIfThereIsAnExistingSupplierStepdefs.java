package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class TellUsIfThereIsAnExistingSupplierStepdefs
 * This class contains all the stepdefs which is
 * related to TellUsIfThereIsAnExistingSupplierStepdefs page
 * 
 * @author 571154
 *
 */
public class TellUsIfThereIsAnExistingSupplierStepdefs {
	
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(TellUsIfThereIsAnExistingSupplierStepdefs.class);
	
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
	public TellUsIfThereIsAnExistingSupplierStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef calls the method selectRadioButton()
	 * that selects the radio button
	 */
	@Given("Buyer selects one of the option by selecting the radio button in Tell us if there is an existing supplier page")
	public void buyer_selects_one_of_the_option_by_selecting_the_radio_button_in_Tell_us_if_there_is_an_existing_supplier_page() {
	   
		objectManager.getTellUsIfThereIsAnExistingSupplier().selectRadioButton();
	}

}
