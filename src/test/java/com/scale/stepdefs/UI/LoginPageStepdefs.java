package com.scale.stepdefs.UI;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * Class LoginPageStepdefs
 * This class contains all the stepdefs which is
 * related to login pages
 * @author 571154
 *
 */
public class LoginPageStepdefs {
	
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(LoginPageStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	ConfigurationReader configReader = new ConfigurationReader();

	/**
	 * LoginPageStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public LoginPageStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef call the method loginByuerUi
	 * which enters the username and password
	 * 
	 * @param userName
	 * @param password
	 * @param TDID
	 */
	@When("Buyer enters valid {string} and {string} of the {string}")
	public void buyer_enters_valid_and_of_the(String userName, String password, String TDID) {

		TestContext.TDID=TDID;
		TestContext.CommonTestDataMap.get(TDID).get("UserID");
		objectManager.getLoginPage().loginByuerUi(TestContext.ConfigData.get(TestContext.CommonTestDataMap.get(TDID).get("UserID")), TestContext.ConfigData.get("data-key"));
		
	}
	
	/**
	 * This stepdef call the method clickOnSignInButton
	 * which clicks the SignIn button
	 * 
	 */
	@When("Buyer clicks on Sign In button")
	public void buyer_clicks_on_Sign_In_button() {
		
		objectManager.getLoginPage().clickOnSignInButton();
	    
	}
	
	

}
