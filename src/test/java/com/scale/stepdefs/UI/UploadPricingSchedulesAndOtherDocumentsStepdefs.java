package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class UploadPricingSchedulesAndOtherDocumentsStepdefs
 * contains all the stepdefs related to
 * UploadPricingSchedulesAndOtherDocumentsStepdefs page
 * 
 * @author 571154
 *
 */
public class UploadPricingSchedulesAndOtherDocumentsStepdefs {

	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(UploadPricingSchedulesAndOtherDocumentsStepdefs.class);

	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	/**
	 * UploadPricingSchedulesAndOtherDocumentsStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public UploadPricingSchedulesAndOtherDocumentsStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	
	/**
	 * This stepdef is calls the method clickOnLinksAddOrChangUpload
	 * that clicks on link "<Upload your pricing schedule>"
	 * in page "<Upload pricing schedules and other documents>"
	 * 
	 * @param linkName
	 * @param pageName
	 */
	@Given("Buyer clicks on link {string} in page {string}")
	public void buyer_clicks_on_link_in_page(String linkName, String pageName) {
	 
		objectManager.getUploadPricingSchedulesAndOtherDocuments().clickOnLinksAddOrChangUpload();
	}
	
	/**
	 * This stepdef calls the method selectDocument button
	 * that selects the document
	 * 
	 */
	@Given("Buyer selects the document in page Upload your terms and conditions and other documents")
	public void buyer_selects_the_document_in_page_Upload_your_terms_and_conditions_and_other_documents() {
	    
		objectManager.getUploadPricingSchedulesAndOtherDocuments().selectDocument();
	}

	/**
	 * This stepdef calls the method clickOnUploadButton
	 * that click On Upload Button
	 * 
	 */
	@Given("Buyer clicks on upload button in page Upload your terms and conditions and other documents")
	public void buyer_clicks_on_upload_button_in_page_Upload_your_terms_and_conditions_and_other_documents() {
	    
		objectManager.getUploadPricingSchedulesAndOtherDocuments().clickOnUploadButton();
	}


}
