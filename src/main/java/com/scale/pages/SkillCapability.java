package com.scale.pages;

import com.scale.context.TestContext;
import com.scale.framework.utility.Actions;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

/**
 * Class SkillCapability has extend the Actions class
 * @author 321020
 *
 */
public class SkillCapability extends Actions{

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
	private static final Logger log = LogManager.getLogger(SkillCapability.class);

	/**
	 * SkillCapability constructor overloaded
	 * @param driver
	 * @param scenario
	 */
	public SkillCapability(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	public void selectSkillCapability(Map<String, String> Data){
		for(String Clusters: Data.keySet()){
			driver.findElement(By.xpath("//li/a[text()='"+Clusters+"']")).click();
			waitForSeconds(1);
			String[] Skills = Data.get(Clusters).split("~");
			for (String skill : Skills) {
				driver.findElement(By.xpath("//label[contains(text(),'"+skill+"')]/preceding-sibling::input[@type='checkbox']")).click();
			}
		}
	}
}