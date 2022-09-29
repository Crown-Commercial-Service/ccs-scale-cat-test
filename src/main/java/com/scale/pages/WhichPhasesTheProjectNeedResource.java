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
 * Class WhichPhasesTheProjectNeedResource
 * contains all the stepdefs related to
 * WhichPhasesTheProjectNeedResource page
 * 
 * @author 571154
 *
 */
public class WhichPhasesTheProjectNeedResource extends Actions {
	
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
	private static final Logger log = LogManager.getLogger(WhichPhasesTheProjectNeedResource.class);

	/**
	 * DashboardPage constructor overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public WhichPhasesTheProjectNeedResource(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	/**
	 * WhichPhasesTheProjectNeedResource page Xpaths
	 */
	
	@FindBy(xpath = "//*[contains(text(),'Discovery')]/../input")
	private WebElement  discoveryCheckBox;
	
	private String discovery="//*[contains(text(),'Discovery')]/../input";
	
	@FindBy(xpath = "//*[contains(text(),'Alpha')]/../input")
	private WebElement  alphaCheckBox;
	
	private String alpha="//*[contains(text(),'Alpha')]/../input";
	
	@FindBy(xpath = "//*[contains(text(),'Beta')]/../input")
	private WebElement  betaCheckBox;
	
	private String beta="//*[contains(text(),'Beta')]/../input";
	
	@FindBy(xpath = "//*[contains(text(),'Live')]/../input")
	private WebElement  liveCheckBox;
	
	private String live="//*[contains(text(),'Live')]/../input";
	
	@FindBy(xpath = "//*[contains(text(),'Service design phases do not apply to your project')]/../input")
	private WebElement  serviceDesignCheckBox;
	
	private String serviceDesign="//*[contains(text(),'Service design phases do not apply to your project')]/../input";
	
	/**
	 * This method Selects the radio button option
	 * given in the excel data sheet
	 */
	public void setCheckBoxOption() {
		
		/**
         * This if condition checks Discovery option is mentioned YES in excel sheet or not
         * and if its mentioned YES then it will select it.
         */
		if (TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S16_CheckboxDiscovery").equalsIgnoreCase("YES")) {

			clickElementWithJavaScript(discovery);
		}
		
		/**
         * This if condition checks Alpha option is mentioned YES in excel sheet or not
         * and if its mentioned YES then it will select it.
         */
		if (TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S16_CheckboxAlpha").equalsIgnoreCase("YES")) {

			clickElementWithJavaScript(alpha);
		}
		
		/**
         * This if condition checks Beta option is mentioned YES in excel sheet or not
         * and if its mentioned YES then it will select it.
         */
		if (TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S16_CheckboxBeta").equalsIgnoreCase("YES")) {

			clickElementWithJavaScript(beta);
		}
		
		/**
         * This if condition checks Live option is mentioned YES in excel sheet or not
         * and if its mentioned YES then it will select it.
         */
		if (TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S16_CheckboxLive").equalsIgnoreCase("YES")) {

			clickElementWithJavaScript(live);
		}
		
		/**
         * This if condition checks ServiceDesign option is mentioned YES in excel sheet or not
         * and if its mentioned YES then it will select it.
         */
		if (TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S16_CheckboxServiceDesign").equalsIgnoreCase("YES")) {

			clickElementWithJavaScript(serviceDesign);
		}
		
		
	
	}
	

}
