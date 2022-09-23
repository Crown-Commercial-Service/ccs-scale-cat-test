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
 * Class ConfirmIfYouNeedAContractedOutService Page has extend the Actions class
 * This class contains all the method related to ConfirmIfYouNeedAContractedOutService
 * page
 * 
 * @author 571154
 *
 */
public class ConfirmIfYouNeedAContractedOutService extends Actions{
	
	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(ConfirmIfYouNeedAContractedOutService.class);

	/**
	 * Login Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public ConfirmIfYouNeedAContractedOutService(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		textContext = new TestContext();
	}

	
	/**
	 * ConfirmIfYouNeedAContractedOutService page Xpaths
	 */
	
	@FindBy(xpath = "//*[@id='ccs_vetting_type']")
	private WebElement iNeedAContractedOutServiceRadioButton;
	
	private String iNeedAContractedOutService = "//*[@id='ccs_vetting_type']";
	
	@FindBy(xpath = "//*[@id='ccs_vetting_type-2']")
	private WebElement iNeedSupplyOfResourceRadioButton;
	
	private String iNeedSupplyOfResource = "//*[@id='ccs_vetting_type-2']";
	
	/**
	 * This method clicks on Selects the radio button option
	 * given in the excel data sheet
	 */
	public void selectRadioButton() {
		
		
		String radioButttonOptn = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S7_Radiobutton");
		
		switch (radioButttonOptn) {
		
		case "I need a contracted out service":

			waitForSeconds(1);
			clickElementWithJavaScript(iNeedAContractedOutService);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the 'I need a contracted out service' radio Button");
			log.info("Buyer has selected the 'I need a contracted out service' radio Button");
		
			break;

		case "I need supply of resource":
			
			waitForSeconds(1);
			clickElementWithJavaScript(iNeedSupplyOfResource);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the 'I need supply of resource' radio Button");
			log.info("Buyer has selected the 'I need supply of resource' radio Button");
			
			break;
		}
	}

}
