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
 * Class EnterYourProjectRequirements Page has extend the Actions class
 * This class contains all the method related to EnterYourProjectRequirements
 * page
 * 
 * @author 571154
 *
 */
public class EnterYourProjectRequirements extends Actions {
	
	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(EnterYourProjectRequirements.class);

	/**
	 * Login Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public EnterYourProjectRequirements(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		textContext = new TestContext();
	}

	/**
	 * Xpaths
	 */
	@FindBy(xpath = "//button[@class='govuk-button add-another-btn']")
	private WebElement addAnotherItembutton;
	
	
	/**
	 * This method enters the value in the textbox
	 * 
	 */
	public void setProjectRequirements() {
		
		String[] values = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S25_TextBoxProjectRequirements").split("~");
		 int k=0;
		 
		for (int i = 1; i <= values.length; i++) {
			waitForSeconds(1);
			for (int j = 0; j <= 2; j++) {
				driver.findElement(By.xpath("//textarea[@id='fc_question_" + i + "_1_Requirements_" + (k) + "']")).sendKeys(values[i - 1].split("\\|")[j]);
				k++;
			}

			if (values.length > 1 && i < values.length) {
				clickElement(addAnotherItembutton);
				waitForSeconds(1);
			}

		}

		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		scenario.log("Buyer has successfully added the KPIs");
		log.info("Buyer has successfully added the KPIs");
		
    }

}
