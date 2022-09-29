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
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.Scenario;

/**
 * Class AddYourServiceLevelsAndKPIs has extend the Actions class
 * 
 * @author 571154
 *
 */
public class AddYourServiceLevelsAndKPIs extends Actions {
	
	/**
	 * Object creation
	 */
	TestContext textContext = new TestContext();
	private BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * Variable declaration
	 */
	ConfigurationReader configReader;
	private PageObjectManager objectManager;
	private static final Logger log = LogManager.getLogger(AddYourServiceLevelsAndKPIs.class);

	/**
	 * CommonToAllPage constructor overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public AddYourServiceLevelsAndKPIs(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}
	
	/**
	 * Xpaths
	 */
	@FindBy(xpath = "//*[@id='ccs_rfpTerm_add']")
	private WebElement addAnotherItemLink;
	
	
	/**
	 * This method enters the value in the textbox
	 * 
	 */
	public void setKPIs() {
		
		String[] values = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S23_TextBoxKPIs").split("~");
		for(int i=1;i<= values.length;i++){
            waitForSeconds(1);
            
            for (int j=i;j==i;j++) {
               
            	driver.findElement(By.xpath("//input[@id='rfp_term_service_levels_KPI_"+i+"']")).sendKeys(values[i-1].split("\\|")[0]);
                driver.findElement(By.xpath("//textarea[@id='rfp_term_definition_service_levels_KPI_"+i+"']")).sendKeys(values[i-1].split("\\|")[1]);
                driver.findElement(By.xpath("//input[@id='rfp_term_percentage_KPI_"+i+"']")).sendKeys(values[i-1].split("\\|")[2]);
             }
            
            if(values.length>1 && i<values.length){
                clickElement(addAnotherItemLink);
                waitForSeconds(1);
             }
            
        }

		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		scenario.log("Buyer has successfully added the KPIs");
		log.info("Buyer has successfully added the KPIs");
		
    }

}
