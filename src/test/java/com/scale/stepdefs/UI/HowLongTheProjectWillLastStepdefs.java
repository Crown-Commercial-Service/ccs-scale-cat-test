package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class HowLongTheProjectWillLastStepdefs has extend the Actions class
 * This class contains all the methods related to 
 * HowLongTheProjectWillLastStepdefs page
 * 
 * @author 571154
 *
 */
public class HowLongTheProjectWillLastStepdefs {

	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(HowLongTheProjectWillLastStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	ConfigurationReader configReader = new ConfigurationReader();

	/**
	 * HowLongTheProjectWillLastStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public HowLongTheProjectWillLastStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}     
	
	/**
	 * This stepdef calls the method 'enterDates'
	 * which enters the dates
	 * @param radioButtonOptn
	 */
	@Given("Buyer enters the dates")
	public void buyer_enters_the_dates() {
	    
		objectManager.getHowLongTheProjectWillLast().enterDates();
	}

}
