package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.LoginPage;

import io.cucumber.java.en.When;

/**
 * Class ChooseACommercialAgreementPageStepdefs
 * 
 * @author 571154
 *
 */
public class ChooseACommercialAgreementPageStepdefs {
	
	/**
	 * Logger 
	 */
	private static final Logger log = LogManager.getLogger(ChooseACommercialAgreementPageStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	/**
	 * ChooseACommercialAgreementPageStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public ChooseACommercialAgreementPageStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef calls the methods selectCALot
	 * which selects the Lots
	 * 
	 * @param lotType
	 * @param commercialAgreement
	 */
	@When("Buyer selects the {string} under commercial agreement {string}")
	public void buyer_selects_the_under_commercial_agreement(String lotType, String commercialAgreement) {
	    
		objectManager.getChooseACommercialAgreementPage().selectCALot(lotType, commercialAgreement);
	}

	

}
