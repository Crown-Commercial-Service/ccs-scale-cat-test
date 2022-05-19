package com.scale.stepdefs;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * Class CommonToAllPageStepdefs
 * @author 571154
 *
 */
public class CommonToAllPageStepdefs {
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	
	/**
	 * CommonToAllPageStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public CommonToAllPageStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
		
	@Then("Buyer navigates to {string} page")
	public void buyer_navigates_to_page(String pageName) {
		objectManager.getcommonToAllPage().validatePageTitle(pageName);
	}

	
	@Given("Buyer validates {string} page {string}{string} & {string} is as per figma.")
	public void buyer_validates_page_is_as_per_figma(String PageName, String breadcrumbs, String Content, String Status) {
	    
	}
	
		
	@Given("Buyer validates {string} page {string} {string} {string} & {string} is as per figma.")
	public void buyer_validates_page_is_as_per_figma(String PageName, String Header, String Banner, String HelpSection, String Footer) {
	    
		objectManager.getcommonToAllPage().validateHeaderBannerHelpSectionFooter();
	}

	@Given("Buyer validates {string} page {string} & {string} is as per figma.")
	public void buyer_validates_page_is_as_per_figma(String PageName, String AgreementDetails, String RelatedContent) {
	   
	   objectManager.getcommonToAllPage().validateProjectOverviewRelatedContent();
	}



}
