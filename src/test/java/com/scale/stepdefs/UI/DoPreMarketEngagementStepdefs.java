package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * Class DoPreMarketEngagementStepdefs
 * @author 571154
 *
 */
public class DoPreMarketEngagementStepdefs {
	
	/**
	 * Variables declaration
	 */
	private static final Logger log = LogManager.getLogger(LoginPage.class);
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	
	/**
	 * DoPreMarketEngagementStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public DoPreMarketEngagementStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	
	
	@Given("Buyer validates the Do pre-market engagement page content")
	public void buyer_validates_the_do_pre_market_engagement_page_content() {
	    
		objectManager.getDoPreMarketEngagementPage().doPreMarketEngagementPageContent();
	}
	
	@When("Buyers clicks on {string} link.")
	public void buyers_clicks_on_link(String string) {
	   
		objectManager.getDoPreMarketEngagementPage().clickOnNameyourProjectLink();
	}

}
