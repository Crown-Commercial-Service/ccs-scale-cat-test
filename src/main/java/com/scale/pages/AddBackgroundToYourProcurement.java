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
 * Class AddBackgroundToYourProcurement Page has extend the Actions class
 * This class contains all the method related to AddBackgroundToYourProcurement
 * page
 * 
 * @author 571154
 *
 */
public class AddBackgroundToYourProcurement extends Actions  {

	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(AddBackgroundToYourProcurement.class);

	/**
	 * AddBackgroundToYourProcurement Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public AddBackgroundToYourProcurement(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		textContext = new TestContext();
	}

	
	/**
	 * AddBackgroundToYourProcurement page Xpaths
	 */
	
	@FindBy(xpath = "//textarea[@id='rfp_prob_statement_e']")
	private WebElement keyBackgroundInformationTxtbox;
	
	@FindBy(xpath = "//textarea[@id='rfp_prob_statement_s']")
	private WebElement socialEconomicAndEnvironmentalTxtbox;
	
	
	

	/**
	 * This method enters the value in the textbox
	 * "Write your key background information here" and 
	 * "Social value, economic and environmental benefits" textbox
	 */
	public void enterValueInTextBox() {
		
		/**
		 * This line of code enters the value in the textbox
		 * "Write your key background information here"
		 */
		enterText(keyBackgroundInformationTxtbox,TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S11_keyBackground"));
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		scenario.log("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S11_keyBackground") +" in the 'key background information' textbox " );
		log.info("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S11_keyBackground") +" in the 'key background information' textbox " );
		waitForSeconds(1);
		
		
		/**
		 * This line of code enters the value in the textbox
		 * "Social value, economic and environmental benefits"
		 */
		enterText(socialEconomicAndEnvironmentalTxtbox,TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S11_SocialEcoEnvBenefits"));
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		scenario.log("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S11_SocialEcoEnvBenefits") +" in the 'key background information' textbox " );
		log.info("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S11_SocialEcoEnvBenefits") +" in the 'key background information' textbox " );
		waitForSeconds(1);
	}
	
	

}
