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
 * Class ChooseIfThisIsNewReplacementOrExpanded Page has extend the Actions class
 * This class contains all the method related to ChooseIfThisIsNewReplacementOrExpanded
 * page
 * 
 * @author 571154
 *
 */
public class ChooseIfThisIsNewReplacementOrExpanded extends Actions  {
	
	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(ChooseIfThisIsNewReplacementOrExpanded.class);

	/**
	 * Login Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public ChooseIfThisIsNewReplacementOrExpanded(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		textContext = new TestContext();
	}

	
	/**
	 * AddContextToYour1FC page Xpaths
	 */
	
	@FindBy(xpath = "//h3[(text()='Not sure')]/../../input")
	private WebElement notSureRadioBtn;
	
	@FindBy(xpath = "//h3[(text()='New products or services')]/../../input")
	private WebElement newProductsOrServicesRadioBtn;
	
	@FindBy(xpath = "//h3[(text()='Replacement products or services')]/../../input")
	private WebElement replacementProductsOrServicesRadioBtn;
	
	@FindBy(xpath = "//h3[(text()='Expanded products or services')]/../../input")
	private WebElement expandedProductsOrServicesRadioBtn;
	
	private String notSureRadioBtnString = "//h3[(text()='Not sure')]/../../input";
	
	private String newProductsOrServicesRadioBtnString = "//h3[(text()='New products or services')]/../../input";
	
	private String replacementProductsOrServicesRadioBtnString = "//h3[(text()='Replacement products or services')]/../../input";
	
	private String expandedProductsOrServicesRadioBtnString = "//h3[(text()='Expanded products or services')]/../../input";


	/**
	 * This method clicks on Selects the radio button option
	 * given in the excel data sheet
	 */
	public void selectRadioButton() {
		
		
		String radioButttonOptn = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S20_Radiobutton");
		
		switch (radioButttonOptn) {
		
		case "Not sure":

			waitForSeconds(1);
			clickElementWithJavaScript(notSureRadioBtnString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the 'Not sure' radio Button");
			log.info("Buyer has selected the 'Not sure' radio Button");
		
			break;

		case "New products or services":
			
			waitForSeconds(1);
			clickElementWithJavaScript(newProductsOrServicesRadioBtnString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the 'New products or services' radio Button");
			log.info("Buyer has selected the 'New products or services' radio Button");
			
			break;
			
		case "Replacement products or services":
			
			waitForSeconds(1);
			clickElementWithJavaScript(replacementProductsOrServicesRadioBtnString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the 'Replacement products or services' radio Button");
			log.info("Buyer has selected the 'Replacement products or services' radio Button");
			
			break;
			
		case "Expanded products or services":
			
			waitForSeconds(1);
			clickElementWithJavaScript(expandedProductsOrServicesRadioBtnString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the 'Expanded products or services' radio Button");
			log.info("Buyer has selected the 'Expanded products or services' radio Button");
			
			break;
		}
	}
}
