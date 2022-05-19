package com.scale.stepdefs.UI;



import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPageStepdefs {
	
	
	//private Logger log = Log.getLogger(LoginPageStepdefs.class);

	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	ConfigurationReader configReader = new ConfigurationReader();

	public LoginPageStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	
	@When("Buyer enters valid {string} and {string} of the {string}")
	public void buyer_enters_valid_and_of_the(String userName, String password, String TDID) {
		
		TestContext.TDID=TDID;
		TestContext.OneFCTestDataMap.get(TDID).get("UserID");
		objectManager.getLoginPage().loginByuerUi(TestContext.ConfigData.get(TestContext.OneFCTestDataMap.get(TDID).get("UserID")), TestContext.ConfigData.get("data-key"));
		
	}
	
	@When("Buyer clicks on Sign In button")
	public void buyer_clicks_on_Sign_In_button() {
		
		objectManager.getLoginPage().clickOnSignInButton();
	    
	}
	
	

}
