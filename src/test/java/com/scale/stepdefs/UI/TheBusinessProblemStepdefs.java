package com.scale.stepdefs.UI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.scale.context.ScenarioContext;
import com.scale.context.TestContext;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.en.Given;

/**
 * Class TheBusinessProblemStepdefs
 * This class contains all the stepdefs
 * of TheBusinessProblemStepdefs pages
 * @author 571154
 *
 */
public class TheBusinessProblemStepdefs {

	/**
	 * Logger 
	 */
	private static final Logger log = LogManager.getLogger(TheBusinessProblemStepdefs.class);
	
	/**
	 * Variables declaration
	 */
	private PageObjectManager objectManager;
	public ScenarioContext scenarioContext;
	
	/**
	 * TheBusinessProblemStepdefs class constructor has overloaded
	 * @param testContextObj
	 * @param scenarioContext
	 */
	public TheBusinessProblemStepdefs(TestContext testContextObj, ScenarioContext scenarioContext) {
		testContextObj.getDriver();
		objectManager = testContextObj.getObjectManager();
		this.scenarioContext = scenarioContext;
	}
	
	/**
	 * This stepdef calls the method 'enterValueInTextBox'
	 * which enters the value in the textboxs
	 * 'The business problem you need to solve' 
	 */
	@Given("Buyer enters the value in text box The business problem you need to solve.")
	public void buyer_enters_the_value_in_text_box_The_business_problem_you_need_to_solve() {
	    
		objectManager.getTheBusinessProblem().enterValueInTextBox();
	}

	
}
