package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.LoginPage;

import io.cucumber.java.en.When;

public class ChooseACommercialAgreementPageStepdefs {
	
	private static final Logger log = LogManager.getLogger(LoginPage.class);

	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	public ChooseACommercialAgreementPageStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	@When("Buyer selects the {string} under commercial agreement {string}")
	public void buyer_selects_the_under_commercial_agreement(String lotType, String commercialAgreement) {
	    
		objectManager.getChooseACommercialAgreementPage().selectCALot(lotType, commercialAgreement);
	}

	

}
