package com.scale.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scale.context.TestContext;
import com.scale.framework.utility.Actions;
import com.scale.framework.utility.ConfigurationReader;

import io.cucumber.java.Scenario;

/**
 * Class ManagementInformationAndReporting Page has extend the Actions class
 * This class contains all the method related to ManagementInformationAndReporting
 * page
 * 
 * @author 571154
 *
 */
public class ManagementInformationAndReporting extends Actions  {

	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(ManagementInformationAndReporting.class);

	/**
	 * Login Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public ManagementInformationAndReporting(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		textContext = new TestContext();
	}

	
	/**
	 * ManagementInformationAndReporting page Xpaths
	 */
	
	@FindBy(xpath = "//*[@id='rfp_prob_statement_1']")
	private WebElement specifyWhatYouExpectFromMITextbox ;
	
	
	/**
	 * This method enters the value in the textbox
	 * 
	 */
	public void enterValueInTextBox() {
		
		/**
		 * This line of code enters the value in the textbox
		 */
		enterText(specifyWhatYouExpectFromMITextbox,TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S22_TextBox"));
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		scenario.log("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S22_TextBox") +" in the 'Specify what you expect from MI ' textbox " );
		log.info("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S22_TextBox") +" in the 'Specify what you expect from MI ' textbox ");
		waitForSeconds(1);
	}
	
}
