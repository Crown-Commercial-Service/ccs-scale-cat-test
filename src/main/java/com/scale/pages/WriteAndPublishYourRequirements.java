package com.scale.pages;

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
	private static final Logger log = LogManager.getLogger(LoginPage.class);

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
