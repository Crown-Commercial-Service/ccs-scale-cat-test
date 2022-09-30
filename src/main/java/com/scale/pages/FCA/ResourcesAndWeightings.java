package com.scale.pages.FCA;

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

/**
 * Class ResourcesAndWeightings has extend the Actions class
 *
 * @author 321020
 */
public class ResourcesAndWeightings extends Actions {

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
    private static final Logger log = LogManager.getLogger(ResourcesAndWeightings.class);

    /**
     * ResourcesAndWeightings constructor overloaded
     *
     * @param driver
     * @param scenario
     */
    public ResourcesAndWeightings(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        configReader = new ConfigurationReader();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void enterResourcesAndWeightings(Map<String, String> Data){
        for(String Cluster: Data.keySet()){
            driver.findElement(By.xpath("//li/a[text()='"+Cluster+"']")).click();
            waitForSeconds(2);
            String[] pairs = Data.get(Cluster).split("~");
            for (String pair : pairs) {
                String[] values = pair.split("\\|");
                String RoleFamily = values[0].replaceAll(" ", "");
                driver.findElement(By.xpath("//input[contains(@id,'"+RoleFamily+"')][@name='weight_staff']")).clear();
                driver.findElement(By.xpath("//input[contains(@id,'"+RoleFamily+"')][@name='weight_staff']")).sendKeys(values[1]);

                driver.findElement(By.xpath("//input[contains(@id,'"+RoleFamily+"')][@name='weight_vetting']")).clear();
                driver.findElement(By.xpath("//input[contains(@id,'"+RoleFamily+"')][@name='weight_vetting']")).sendKeys(values[2]);

                driver.findElement(By.xpath("//div[text()='"+values[3]+"']/preceding-sibling::input[@name='SFIA_weightage']")).clear();
                driver.findElement(By.xpath("//div[text()='"+values[3]+"']/preceding-sibling::input[@name='SFIA_weightage']")).sendKeys(values[4]);;
            }
        }
    }
}
