package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

import java.io.IOException;

/**
 * Class UploadYourPricingScheduleStepdefs
 * contains all the stepdefs related to
 * UploadYourPricingScheduleStepdefs page
 * 
 * @author 571154
 *
 */
public class UploadYourPricingScheduleStepdefs {

	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(UploadYourPricingScheduleStepdefs.class);

	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	/**
	 * UploadYourPricingScheduleStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public UploadYourPricingScheduleStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	
	/**
	 * This stepdef calls the method selectDocument button
	 * that selects the document
	 * 
	 */
	@Given("Buyer selects the document in page Upload your pricing schedule")
	public void buyer_selects_the_document_in_page_Upload_your_pricing_schedule() throws IOException {
	    
		objectManager.getUploadYourPricingSchedule().selectDocument();
	}

	/**
	 * This stepdef calls the method clickOnUploadButton
	 * that click On Upload Button
	 * 
	 */
	@Given("Buyer clicks on upload button in page Upload your pricing schedule")
	public void buyer_clicks_on_upload_button_in_page_Upload_your_pricing_schedule() {
	   
		objectManager.getUploadYourPricingSchedule().clickOnUploadButton();
	}
	
	/**
	 * This stepdef calls the method clickOnIConfirmCheckBox 
	 * that click the IConfirmCheckBox
	 * 
	 */
	@Given("Buyer selects the I confirm checkbox")
	public void buyer_selects_the_I_confirm_checkbox() {
	 
		objectManager.getUploadYourPricingSchedule().clickOnIConfirmCheckBox();
	}
	
	

}
