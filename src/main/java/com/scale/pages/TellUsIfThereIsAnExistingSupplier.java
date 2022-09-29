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
 * Class TellUsIfThereIsAnExistingSupplier Page has extend the Actions class
 * This class contains all the method related to TellUsIfThereIsAnExistingSupplier
 * page
 * 
 * @author 571154
 *
 */
public class TellUsIfThereIsAnExistingSupplier extends Actions {
	
	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(TellUsIfThereIsAnExistingSupplier.class);

	/**
	 * Login Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public TellUsIfThereIsAnExistingSupplier(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		textContext = new TestContext();
	}

	
	/**
	 * TellUsIfThereIsAnExistingSupplier page Xpaths
	 */
	
	@FindBy(xpath = "//h3[(text()='Yes')]/../../input")
	private WebElement yesRadioBtn;
	
	@FindBy(xpath = "//h3[(text()='Yes')]/../../following-sibling::div/div/div/input")
	private WebElement yesTextBox;
	
	@FindBy(xpath = "//h3[(text()='No')]/../../input")
	private WebElement noRadioBtn;
	
	private String yesRadioBtnString = "//h3[(text()='Yes')]/../../input";
	
	private String noRadioBtnString = "//h3[(text()='No')]/../../input";
	
	
	
	/**
	 * This method clicks on Selects the radio button option
	 * given in the excel data sheet
	 */
	public void selectRadioButton() {
		
		
		String radioButttonOptn = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S21_Radiobutton");
		
		switch (radioButttonOptn) {
		
		case "Yes":

			waitForSeconds(1);
			clickElementWithJavaScript(yesRadioBtnString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			enterText(yesTextBox, TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S21_Radiobutton_Yes_data"));
			scenario.log("Buyer has selected the 'Yes' radio Button");
			log.info("Buyer has selected the 'Yes' radio Button");
			scenario.log("Buyer has entered the value " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S21_Radiobutton_Yes_data"));
			log.info("Buyer has entered the value " + TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S21_Radiobutton_Yes_data"));
		
			break;

		case "No":
			
			waitForSeconds(1);
			clickElementWithJavaScript(noRadioBtnString);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer has selected the 'No' radio Button");
			log.info("Buyer has selected the 'No' radio Button");
			
			break;
		}
	}

}
