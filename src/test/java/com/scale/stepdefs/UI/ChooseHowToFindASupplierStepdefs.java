package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.LoginPage;

import io.cucumber.java.en.Given;

/**
 * Class ChooseHowToFindASupplierStepdefs
 * contains all the stepdefs related to
 * ChooseHowToFindASupplierStepdefs page
 * 
 * @author 571154
 *
 */
public class ChooseHowToFindASupplierStepdefs {
	
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(ChooseHowToFindASupplierStepdefs.class);

	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	/**
	 * ChooseHowToFindASupplierStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public ChooseHowToFindASupplierStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	
	/**
	 * This stepdef calls the method selectRadioButton
	 * which select the radio button
	 * @param radioButtton
	 */
	@Given("Buyer selects the {string} radio button.")
	public void buyer_selects_the_radio_button(String radioButtton) {
		
		objectManager.getChooseHowToFindASupplier().selectRadioButton();
	}
	
	/**
	 * This stepdef calls the method clickOnSaveAndContinueButton
	 * that clicks on SaveAndContinue Button
	 * 
	 */
	@Given("Buyer clicks on Save and continue button")
	public void buyer_clicks_on_Save_and_continue_button() {
	    
		objectManager.getChooseHowToFindASupplier().clickOnSaveAndContinueButton();
	}


}
