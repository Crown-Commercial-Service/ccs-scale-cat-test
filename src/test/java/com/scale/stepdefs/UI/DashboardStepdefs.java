package com.scale.stepdefs.UI;


import com.scale.context.GlobalContext;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;

import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


/**
 * Class DashboardStepdefs
 * This class contains all the stepdefs of the
 * Dash board pages
 * 
 * @author 571154
 *
 */

public class DashboardStepdefs {
	
	/**
	 * Logger initialization
	 */
	private static final Logger log = LogManager.getLogger(DashboardStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	/**
	 * DashboardStepdefs class constructor has overloaded
	 * 
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public DashboardStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
		
	/**
	 * This stepdef calls the method clickOnAcceptAllCookiesBtn
	 * that clicks on AcceptAllCookies button
	 */
	@Given("Buyer clicks on Accept all cookies button")
	public void buyer_clicks_on_Accept_all_cookies_button() {
	    
		objectManager.getDashboard().clickOnAcceptAllCookiesBtn();
	}

	@Then("Buyer clicks on the event {string} link")
	public void buyerClicksOnTheEventLink(String arg0) {
		objectManager.getDashboard().clickOnEventLink(arg0);
	}

    @And("Buyer validates the published event")
    public void buyerValidatesThePublishedEvent() {
		Assert.assertEquals("Validate Published Event Status: ",objectManager.getDashboard().getPublishedEventStatus(),"Published");
		objectManager.getDashboard().clickOnEventLink(GlobalContext.getGlobalInstance().getGlobalDataValue("EventID"));
    }
}
