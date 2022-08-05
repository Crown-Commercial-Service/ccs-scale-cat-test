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


	/**
	 * This stepdef calls the method clickOnStarANewProject
	 * that clicks on StarANewProject link
	 */
	@When("Buyer clicks on {string} link")
	public void buyer_clicks_on_link(String linkName) {
	    
		objectManager.getDashboard().clickOnStarANewProject();
	}

}
