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
 * Class WhichPhaseTheProjectIsIn Page has extend the Actions class
 * This class contains all the method related to WhichPhaseTheProjectIsIn
 * page
 * 
 * @author 571154
 *
 */
public class WhichPhaseTheProjectIsIn extends Actions {
	
	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(WhichPhaseTheProjectIsIn.class);

	/**
	 * WhichPhaseTheProjectIsIn Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public WhichPhaseTheProjectIsIn(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		textContext = new TestContext();
	}

	
	/**
	 * WhichPhaseTheProjectIsIn page Xpaths
	 */
	
	@FindBy(xpath = "//*[text()='Not started']/../../input")
	private WebElement  notStartedRadioButton;
	
	@FindBy(xpath = "//*[text()='Discovery']/../../input")
	private WebElement  discoveryRadioButton;
	
	@FindBy(xpath = "//*[text()='Alpha']/../../input")
	private WebElement  alphaRadioButton;
		
	@FindBy(xpath = "//*[text()='Beta']/../../input")
	private WebElement  betaRadioButton;
	
	@FindBy(xpath = "//*[text()='Beta']/../../input")
	private WebElement  liveRadioButton;
	
	@FindBy(xpath = "//*[text()='Not applicable']/../../input")
	private WebElement  notApplicableButton;
	
	private String notStartedRadioButtonString="//*[text()='Not started']/../../input";
	private String discoveryRadioButtonString="//*[text()='Discovery']/../../input";
	private String alphaRadioButtonString="//*[text()='Alpha']/../../input";
	private String betaRadioButtonString="//*[text()='Beta']/../../input";
	private String liveRadioButtonString="//*[text()='Beta']/../../input";
	private String notApplicableButtonString="//*[text()='Not applicable']/../../input";
	
	
	
	
	
	/**
	 * This method Selects the radio button option
	 * given in the excel data sheet
	 */
	public void selectRadioButton() {
		
		
		String radioButttonOptn = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton");
		
		switch (radioButttonOptn) {
		
		case "Not started":

			waitForSeconds(1);
			clickElementWithJavaScript(notStartedRadioButtonString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton")+  " radio Button");
			log.info("Buyer has selected the " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton")+  " radio Button");
		
			break;

		case "Discovery":
			
			waitForSeconds(1);
			clickElementWithJavaScript(discoveryRadioButtonString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton")+  " radio Button");
			log.info("Buyer has selected the " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton")+  " radio Button");
		
			break;
			
		case "Alpha":

			waitForSeconds(1);
			clickElementWithJavaScript(alphaRadioButtonString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the "
					+ TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton") + " radio Button");
			log.info("Buyer has selected the "
					+ TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton") + " radio Button");

			break;
			
		case "Beta":

			waitForSeconds(1);
			clickElementWithJavaScript(betaRadioButtonString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the "
					+ TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton") + " radio Button");
			log.info("Buyer has selected the "
					+ TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton") + " radio Button");

			break;
			
		case "Live":

			waitForSeconds(1);
			clickElementWithJavaScript(liveRadioButtonString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the "
					+ TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton") + " radio Button");
			log.info("Buyer has selected the "
					+ TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton") + " radio Button");

			break;
			
		case "Not applicable":

			waitForSeconds(1);
			clickElementWithJavaScript(notApplicableButtonString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the "
					+ TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton") + " radio Button");
			log.info("Buyer has selected the "
					+ TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S15_Radiobutton") + " radio Button");

			break;
	}
	}


}
