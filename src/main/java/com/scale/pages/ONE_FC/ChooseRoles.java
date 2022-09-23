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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Class ChooseRoles has extend the Actions class
 * @author 321020
 *
 */
public class ChooseRoles extends Actions{

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
	private static final Logger log = LogManager.getLogger(ChooseRoles.class);

	/**
	 * ChooseRoles constructor overloaded
	 * @param driver
	 * @param scenario
	 */
	public ChooseRoles(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	/**
	 * ChooseRoles constructor overloaded
	 * @param Data - Map with Cluster as the Key and all the roles and quantities as values in the format below
	 * {Data = Role1, SFIA level X|Qunantity~Role2, SFIA level Y|Quauntity}
	 */

	public void selectCluster(Map<String, String> Data){
	for(String Clusters: Data.keySet()){
		driver.findElement(By.xpath("//li/a[text()='"+Clusters+"']")).click();
		waitForSeconds(1);
		String[] pairs = Data.get(Clusters).split("~");
		for (String pair : pairs) {
			enterQuantity(pair.split("\\|")[0], Integer.parseInt(pair.split("\\|")[1]));
		}
	}
}

	public void enterQuantity(String Role, int quantity) {
		driver.findElement(By.xpath("//div[text()='"+Role+"']/preceding-sibling::input[@name='SFIA_weightage']")).clear();
		driver.findElement(By.xpath("//div[text()='"+Role+"']/preceding-sibling::input[@name='SFIA_weightage']"))
				.sendKeys(Integer.toString(quantity));
	}
}