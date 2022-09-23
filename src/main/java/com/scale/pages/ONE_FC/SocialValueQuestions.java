package com.scale.pages.ONE_FC;

import com.scale.context.TestContext;
import com.scale.framework.utility.Actions;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Class SocialValueQuestions has extend the Actions class
 * @author 321020
 *
 */
public class SocialValueQuestions extends Actions{

	/**
	 * Object creation
	 */
	TestContext textContext=new TestContext();
	private BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * Variables declaration
	 */
	ConfigurationReader configReader;
	private PageObjectManager objectManager;
	private static final Logger log = LogManager.getLogger(SocialValueQuestions.class);

	/**
	 * SocialValueQuestions constructor overloaded
	 * @param driver
	 * @param scenario
	 */
	public SocialValueQuestions(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}
	@FindBy(xpath="//button[contains(text(),'Add another question')]")
	private WebElement AddAnother;

	public void setSocialValueQuestions(String Data){
		String[] values = Data.split("~");
		for(int i=1;i<=values.length;i++){
			waitForSeconds(1);
			driver.findElement(By.xpath("//textarea[@id='fc_question_"+i+"_1']")).sendKeys(values[i-1].split("\\|")[0]);
			driver.findElement(By.xpath("//textarea[@id='fc_question_"+i+"_2']")).sendKeys(values[i-1].split("\\|")[1]);
			driver.findElement(By.xpath("//textarea[@id='fc_question_"+i+"_3']")).sendKeys(values[i-1].split("\\|")[2]);
			driver.findElement(By.xpath("//input[@id='fc_question_precenate_"+i+"']")).clear();
			driver.findElement(By.xpath("//input[@id='fc_question_precenate_"+i+"']")).sendKeys(values[i-1].split("\\|")[3]);
			if(values.length>1 && i<(values.length)){
				AddAnother.click();
			}
		}
	}
}