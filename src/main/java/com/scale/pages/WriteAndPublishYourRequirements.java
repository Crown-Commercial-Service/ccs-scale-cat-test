package com.scale.pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
 * Class WriteAndPublishYourRequirements Page has extend the Actions class
 * This calss contains all the method related to WriteAndPublishYourRequirements
 * page
 * 
 * @author 571154
 *
 */
public class WriteAndPublishYourRequirements extends Actions  {
	
	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(WriteAndPublishYourRequirements.class);

	/**
	 * Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public WriteAndPublishYourRequirements(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		textContext = new TestContext();
	}

	
	/**
	 * WriteAndPublishYourRequirements page Xpaths
	 */
	
	@FindBy(xpath = "//a[contains(text(),'Upload your pricing schedule')]")
	private WebElement section2UploadYourPricingScheduleLink;
	
	@FindBy(xpath = "//strong[contains(text(),'Upload your pricing schedule')]/../following-sibling::a")
	private WebElement linksUploadYourPricinSchedule;
	
	@FindBy(xpath = "//a[contains(text(),'Confirm if you need a contracted out service or supply of resource.')]")
	private WebElement section2ConfirmIfYouNeedAContractedLink;
	
	@FindBy(xpath = "//a[contains(text(),'Add context and requirements')]")
	private WebElement section3addContextAndRequirementsLink;
	
	/**
	 * This method clicks on Section2 Links as per the parameter passed
	 */
	public void clickOnSection2Links(String linkName) {
		
		
		switch (linkName) {

		case "<Upload your pricing schedule>":

			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			clickElement(section2UploadYourPricingScheduleLink);
			scenario.log("Buyer clicks on Upload Your Pricing Schedule Link under Section2");
			log.info("Buyer clicks on Upload Your Pricing Schedule Link under Section2");
			waitForSeconds(1);

			break;

		case "<Confirm if you need a contracted out service or supply of resource.>":

			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			clickElement(section2ConfirmIfYouNeedAContractedLink);
			scenario.log("Buyer clicks on 'Confirm if you need a contracted out service or supply of resource' Link under Section2");
			log.info("Buyer clicks on 'Confirm if you need a contracted out service or supply of resource' Link under Section2");
			waitForSeconds(1);

			break;
	}
		

	}
	
	
	/**
	 * This method clicks on Section2 Links as per the parameter passed
	 */
	public void clickOnSection3Links() {
		
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			clickElement(section3addContextAndRequirementsLink);
			scenario.log("Buyer clicks on 'Add context and requirements' Link under Section3");
			log.info("Buyer clicks on 'Add context and requirements' Link under Section3");
			waitForSeconds(1);
		}
	
	
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
	 * Locators
	 */
	@FindBy(xpath="//a[contains(text(),'Choose the roles you need')]")
	private WebElement ChooseRoles;

	@FindBy(xpath="//a[contains(text(),'Choose the roles you need')]")
	private WebElement SecurityVetting;

	public void clickLink(String Link){
		waitForSeconds(1);
		clickElement(driver.findElement(By.xpath("//a[contains(text(),'"+Link+"')]")));
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		scenario.log("Buyer clicks on '"+Link+"' link");
		log.info("Buyer clicks on '"+Link+"' link");
	}


}
