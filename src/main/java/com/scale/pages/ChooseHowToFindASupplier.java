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
 * Class ChooseHowToFindASupplier has extend the Actions class
 * 
 * @author 571154
 *
 */
public class ChooseHowToFindASupplier extends Actions{
	
	
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
	private static final Logger log = LogManager.getLogger(ChooseHowToFindASupplier.class);

	/**
	 * DashboardPage constructor overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public ChooseHowToFindASupplier(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	/**
	 * ChooseHowToFindASupplier page Xpaths
	 */
	
	@FindBy(xpath = "//*[@id='fc_route_to_market']")
	private WebElement  furtherCompetitionRadioBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Save and continue')]")
	private WebElement  saveAndContinueBtn;
	
	
	private String furtherCompetitionRadioBtnStrng="//*[@id='fc_route_to_market-2']";
	
	/**
	 * This method clicks on Selects the radio button option
	 * given in the excel data sheet
	 */
	public void selectRadioButton() {
		
		
		String radioButttonOptn = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S2_Radiobutton");
		
		switch (radioButttonOptn) {
		
		case "1FC":

			waitForSeconds(1);
			clickElementWithJavaScript(furtherCompetitionRadioBtnStrng);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the 'Further competition' radio Button");
			log.info("Buyer has selected the 'Further competition' radio Button");
		
			break;

		case "2FC":

			waitForSeconds(1);
			clickElementWithJavaScript("//input[@value='2-stage']");
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the 'Further competition with capability assessment' radio Button");
			log.info("Buyer has selected the 'Further competition with capability assessment' radio Button");
			
			break;
	}
	}
	
	
	/**
	 * This method clicks on Save and continue button
	 */
	public void clickOnSaveAndContinueButton() {

		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		clickElement(saveAndContinueBtn);
		scenario.log("Buyer clicks on Save and continue button");
		log.info("Buyer clicks on Save and continue Button");
		waitForSeconds(1);
	}
	
}
