package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Class ProcurementOverviewPageStepdefs
 * @author 571154
 *
 */
public class ProcurementOverviewPageStepdefs {
	
	/**
	 * Variables declaration
	 */
	private static final Logger log = LogManager.getLogger(ProcurementOverviewPageStepdefs.class);
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	
	/**
	 * ProcurementOverviewPageStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public ProcurementOverviewPageStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef call the method procurementOverviewPageContent
	 * which validates the content of the ProcurementOverview page
	 * 
	 */
	@Given("Buyer validates the page content")
	public void buyer_validates_the_page_content() {
	 
		objectManager.getProcurementOverviewPage().procurementOverviewPageContent();
	}
	
	/**
	 * This stepdef call the method clickOnStartPremarketEngagementBtn
	 * that clicks the StartPremarketEngagement Button
	 * 
	 * @param ButtonName
	 * @param Section
	 */
	@When("Buyers clicks on {string} button under section {string}")
	public void buyers_clicks_on_button_under_section(String ButtonName, String Section) {
	  
		objectManager.getProcurementOverviewPage().clickOnStartPremarketEngagementBtn();
	}

	
	
}
