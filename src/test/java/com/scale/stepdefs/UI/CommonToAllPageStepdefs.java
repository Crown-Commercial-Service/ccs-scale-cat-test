package com.scale.stepdefs.UI;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * Class CommonToAllPageStepdefs
 * This class contains all the stepdefs which is
 * common to all the pages
 * @author 571154
 *
 */
public class CommonToAllPageStepdefs {
	
	/**
	 * Logger 
	 */
	private static final Logger log = LogManager.getLogger(CommonToAllPageStepdefs.class);
	
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
	
	/**
	 * This stepdef is common to all the pages
	 * and it calls the method validatePageTitle
	 * that validates the page title
	 * @param pageName
	 */
	@Then("Buyer navigates to {string} page")
	public void buyer_navigates_to_page(String pageName) {
		objectManager.getcommonToAllPage().validatePageTitles(pageName);
	}

	
	@Given("Buyer validates {string} page {string}{string} & {string} is as per figma.")
	public void buyer_validates_page_is_as_per_figma(String PageName, String breadcrumbs, String Content, String Status) {
	    
	}
	
	/**
	 * This stepdef is common to all the pages
	 * and it calls the method validateHeaderBannerHelpSectionFooter
	 * that validates the Header, Banner Help section and Footer 
	 * of the pages
	 * 
	 * @param PageName
	 * @param Header
	 * @param Banner
	 * @param HelpSection
	 * @param Footer
	 */
	@Given("Buyer validates {string} page {string} {string} {string} & {string} is as per figma.")
	public void buyer_validates_page_is_as_per_figma(String PageName, String Header, String Banner, String HelpSection, String Footer) {
	    
		objectManager.getcommonToAllPage().validateHeaderBannerHelpSectionFooter();
	}
	
	/**
	 * This stepdef is common to all the pages
	 * and it calls the method validateProjectOverviewRelatedContent
	 * that validates RelatedContent of the pages
	 * 
	 * @param PageName
	 * @param AgreementDetails
	 * @param RelatedContent
	 */
	@Given("Buyer validates {string} page {string} & {string} is as per figma.")
	public void buyer_validates_page_is_as_per_figma(String PageName, String AgreementDetails, String RelatedContent) {
	   
	   objectManager.getcommonToAllPage().validateProjectOverviewRelatedContent();
	}

	/**
	 * This stepdef calls the method clickOnStarANewProject
	 * that clicks on StarANewProject link
	 */
	@When("Buyer clicks on {string} link")
	public void buyer_clicks_on_link(String linkName) {
		objectManager.getDashboard().clickOnStarANewProject();
	}

	@When("Buyer clicks on {string} button")
	public void buyerClicksOnButton(String arg0) {
		objectManager.getcommonToAllPage().clickSaveandContinue();
	}
}
