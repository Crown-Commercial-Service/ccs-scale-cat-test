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
 * Class AboutAddingContextAndRequirements has extend the Actions class
 * This class contains all the methods related to 
 * AboutAddingContextAndRequirements page
 * 
 * @author 571154
 *
 */
public class AboutAddingContextAndRequirements extends Actions {

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
	private static final Logger log = LogManager.getLogger(AboutAddingContextAndRequirements.class);

	/**
	 * AboutAddingContextAndRequirements constructor overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public AboutAddingContextAndRequirements(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	/**
	 * AboutAddingContextAndRequirements page Xpaths
	 */
	
	@FindBy(xpath = "//button[@class='govuk-button save-button']")
	private WebElement  ContinueBtn;
	
	/**
	 * This method clicks on Continue button
	 */
	public void clickOnContinueButton() {

		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		clickElement(ContinueBtn);
		scenario.log("Buyer clicks on Continue button");
		log.info("Buyer clicks on Continue Button");
		waitForSeconds(1);
	}
}
