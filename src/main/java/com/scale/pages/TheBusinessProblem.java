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
import com.scale.pages.CommonToAllPage;

import io.cucumber.java.Scenario;

/**
 * Class TheBusinessProblem has extend the Actions class
 * 
 * @author 571154
 *
 */
public class TheBusinessProblem extends Actions {

	/**
	 * Object creation
	 */
	TestContext textContext = new TestContext();
	private BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * Variable declaration
	 */
	ConfigurationReader configReader;
	private PageObjectManager objectManager;
	private static final Logger log = LogManager.getLogger(TheBusinessProblem.class);

	/**
	 * TheBusinessProblem constructor overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public TheBusinessProblem(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	/**
	 * TheBusinessProblem page Xpaths
	 */
	
	@FindBy(xpath = "//*[@id='rfp_prob_statement_1']")
	private WebElement businessProblemTxtbox;
	
	
	/**
	 * This method enters the value in the textbox
	 * "Write your key background information here" and 
	 * "Social value, economic and environmental benefits" textbox
	 */
	public void enterValueInTextBox() {
		
		/**
		 * This line of code enters the value in the textbox
		 * "Write your key background information here"
		 */
		enterText(businessProblemTxtbox,TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S12_BusinessProblemTextBox"));
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		scenario.log("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S12_BusinessProblemTextBox") +" in the 'Business Problem' textbox " );
		log.info("Buyer enters " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S12_BusinessProblemTextBox") +" in the 'Business Problem' textbox " );
		waitForSeconds(1);
	}
	
}
