package com.scale.stepdefs;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;

import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class DashboardStepdefs {
	
	private static final Logger log = LogManager.getLogger(LoginPage.class);

	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;

	public DashboardStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
		
	

	@When("Buyer clicks on {string} link")
	public void buyer_clicks_on_link(String linkName) {
	    
		objectManager.getDashboard().clickOnStarANewProject();
	}

}
