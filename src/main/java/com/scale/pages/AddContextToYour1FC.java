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
 * Class AddContextToYour1FC Page has extend the Actions class
 * This class contains all the method related to AddContextToYour1FC
 * page
 * 
 * @author 571154
 *
 */
public class AddContextToYour1FC extends Actions {
	
	
	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(AddContextToYour1FC.class);

	/**
	 * Login Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public AddContextToYour1FC(WebDriver driver, Scenario scenario) {
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
	
	@FindBy(xpath = "//strong[(text()='About adding context and requirements')]/../following-sibling::a")
	private WebElement AddOrEditLink;
	
	/**
	 * This method clicks the Links "Add or edit" next to label "About adding context and requirements"
	 */
	public void clickOnAboutAddingContextAndRequirementsLink() {
		
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			clickElement(AddOrEditLink);
			scenario.log("Buyer clicks on 'About adding context and requirements' Link");
			log.info("Buyer clicks on 'About adding context and requirements' Link");
			waitForSeconds(1);
		}

}
