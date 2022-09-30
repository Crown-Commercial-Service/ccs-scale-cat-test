package com.scale.pages;

import java.io.File;
import java.io.IOException;
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
 * Class UploadPricingSchedulesAndOtherDocuments has extend the Actions class
 * And has all the methods related to UploadPricingSchedulesAndOtherDocuments
 * page
 * 
 * @author 571154
 *
 */
public class UploadPricingSchedulesAndOtherDocuments extends Actions{

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
	private static final Logger log = LogManager.getLogger(UploadPricingSchedulesAndOtherDocuments.class);

	/**
	 * UploadPricingSchedulesAndOtherDocuments constructor overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public UploadPricingSchedulesAndOtherDocuments(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	/**
	 * UploadPricingSchedulesAndOtherDocuments page Xpaths
	 */
	
	@FindBy(xpath = "//strong[contains(text(),'Upload your pricing schedule')]/../following-sibling::a")
	private WebElement linksUploadYourPricinSchedule;
	
	@FindBy(xpath = "//*[@id='rfp_offline_document']")
	private WebElement chooseFilebutton;
	
	@FindBy(xpath = "//button[contains(text(),'upload')]")
	private WebElement clickOnUploadButton;
	
	@FindBy(xpath = "//strong[(text()='DOC.doc')]")
	private WebElement uploadedFileNameLink;

	/**
	 * This method clicks on UploadYourPricinSchedule in page 
	 * <2. Upload pricing schedules and other documents>
	 */
	public void clickOnLinksAddOrChangUpload() {
		
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		clickElement(linksUploadYourPricinSchedule);
		scenario.log("Buyer clicks on Upload Your Pricing Schedule Link in page '2. Upload pricing schedules and other documents'");
		log.info("Buyer clicks on Upload Your Pricing Schedule Link in page '2. Upload pricing schedules and other documents'");
		waitForSeconds(1);
	}
	
	/**
	 * This method clicks selects the document
	 */
	public void selectDocument() throws IOException {
		
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		enterText(chooseFilebutton, new File(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S6_DocPath")).getCanonicalPath());
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


}
