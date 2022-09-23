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
 * Class AddAnyPerformanceIncentives has extend the Actions class
 * This class contains all the methods related to 
 * AddAnyPerformanceIncentives page
 * 
 * @author 571154
 *
 */
public class AddAnyPerformanceIncentives extends Actions {
	
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
	private static final Logger log = LogManager.getLogger(AddAnyPerformanceIncentives.class);

	/**
	 * DashboardPage constructor overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public AddAnyPerformanceIncentives(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	/**
	 * AddAnyPerformanceIncentives page Xpaths
	 */
	
	@FindBy(xpath = "//textarea[@id='rfp_prob_statement_e']")
	private WebElement performanceIncentivesTextbox ;
	
	@FindBy(xpath = "//textarea[@id='rfp_prob_statement_y']")
	private WebElement exitStrategyTextbox ;
	
	
	
	
	/**
	 * This method enters the value in the textbox
	 * 
	 */
	public void enterValueInTextBox() {
		
		/**
		 * This line of code enters the value in the textbox
		 */
		enterText(performanceIncentivesTextbox,TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S24_PerformanceIncentivesTextbox"));
		enterText(exitStrategyTextbox,TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S24_ExitStrategyTextbox"));
		
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		scenario.log("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S24_PerformanceIncentivesTextbox") +" in the 'Performance incentives' textbox " );
		scenario.log("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S24_ExitStrategyTextbox") +" in the 'Exit strategy' textbox " );
		log.info("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S24_PerformanceIncentivesTextbox") +" in the 'Performance incentives' textbox " );
		log.info("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S24_ExitStrategyTextbox") +" in the 'Exit strategy' textbox " );
		waitForSeconds(1);
	}
	
}
