package com.scale.stepdefs.UI;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.Actions;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.ChooseHowToFindASupplier;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

/**
 * Class WhichPhasesTheProjectNeedResourceStepdefs has extend the Actions class
 * This class contains all the methods related to 
 * WhichPhasesTheProjectNeedResourceStepdefs page
 * 
 * @author 571154
 *
 */
public class WhichPhasesTheProjectNeedResourceStepdefs {
	
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(WhichPhasesTheProjectNeedResourceStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	ConfigurationReader configReader = new ConfigurationReader();

	/**
	 * WhichPhasesTheProjectNeedResourceStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public WhichPhasesTheProjectNeedResourceStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}     
        
	/**
	 * This stepdef calls the method 'setCheckBoxOption'
	 * which selects the check box options as per excel sheet
	 * @param radioButtonOptn
	 */
	@Given("Buyer selects the check box in Which phases of the project you need resource for page.")
	public void buyer_selects_the_check_box_in_Which_phases_of_the_project_you_need_resource_for_page() {
		
		objectManager.getWhichPhasesTheProjectNeedResource().setCheckBoxOption();
	}
}
