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
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.Scenario;

/**
 * Class UploadYourPricingSchedule has extend the Actions class
 * And has all the methods related to UploadYourPricingSchedule
 * page
 * 
 * @author 571154
 *
 */
public class UploadYourPricingSchedule extends Actions {
	
	
	/**
	 * Object creation
	 */
	TestContext textContext = new TestContext();
	private BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * Variables declaration
	 */
	ConfigurationReader configReader;
	private PageObjectManager objectManager;
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(UploadYourPricingSchedule.class);

	/**
	 * UploadYourPricingSchedule constructor overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public UploadYourPricingSchedule(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	/**
	 * UploadYourPricingSchedule page Xpaths
	 */
	@FindBy(xpath = "//*[@id='rfp_offline_document']")
	private WebElement chooseFilebutton;
	
	@FindBy(xpath = "//button[contains(text(),'upload')]")
	private WebElement clickOnUploadButton;
	
	@FindBy(xpath = "//strong[(text()='CSV.csv')]")
	private WebElement uploadedFileNameLink;
	
	@FindBy(xpath = "//*[@id='rfp_confirm_upload']")
	private WebElement iConfirmCheckBox;
	
	private String iConfirmCheckBoxStrng = "//*[@id='rfp_confirm_upload']";
	
	
	
	
	/**
	 * This method clicks selects the document
	 */
	public void selectDocument() {
		
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		enterText(chooseFilebutton, TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S5_DocPath"));
		scenario.log("Buyer selects the document");
		log.info("Buyer selects the document");
		waitForSeconds(1);
	}
	
	
	/**
	 * This method clicks Upload button
	 */
	public void clickOnUploadButton() {
		
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		clickElement(clickOnUploadButton);
		waitForElementToBeVisible(uploadedFileNameLink);
		scenario.log("Buyer clicks on Upload button");
		log.info("Buyer clicks on Upload button");
		waitForSeconds(1);
	}

	/**
	 * This method clicks Upload button
	 */
	public void clickOnIConfirmCheckBox() {
		
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		clickElementWithJavaScript(iConfirmCheckBoxStrng);
		scenario.log("Buyer clicks on I Confirm CheckBox");
		log.info("Buyer clicks on I Confirm CheckBox");
		waitForSeconds(1);
	}

}
