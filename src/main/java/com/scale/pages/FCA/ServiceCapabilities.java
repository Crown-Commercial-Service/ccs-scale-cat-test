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
 * Class ServiceCapabilities has extend the Actions class
 *
 * @author 321020
 */
public class ServiceCapabilities extends Actions {

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
    private static final Logger log = LogManager.getLogger(ServiceCapabilities.class);

    /**
     * ServiceCapabilities constructor overloaded
     *
     * @param driver
     * @param scenario
     */
    public ServiceCapabilities(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        configReader = new ConfigurationReader();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void selectServiceCapabilities(Map<String, String> Data){
        for(String Cluster: Data.keySet()){
            driver.findElement(By.xpath("//li/a[text()='"+Cluster+"']")).click();
            waitForSeconds(1);
            String[] Skills = Data.get(Cluster).split("~");
            if(Skills.length==1){
                driver.findElement(By.xpath("//h2[text()='"+Cluster+"']/following-sibling::div[1]//input[@value='whole']")).click();
                driver.findElement(By.xpath("//h2[text()='"+Cluster+"']/following-sibling::div[1]//input[@name='weight_vetting_whole']")).clear();
                driver.findElement(By.xpath("//h2[text()='"+Cluster+"']/following-sibling::div[1]//input[@name='weight_vetting_whole']")).sendKeys(Skills[0]);
            }
            else{
                driver.findElement(By.xpath("//h2[text()='"+Cluster+"']/following-sibling::div[1]//input[@value='partial']")).click();
                for (String skill : Skills) {
                driver.findElement(By.xpath("//label[contains(text(),'"+skill.split("\\|")[0]+"')]/following-sibling::div[1]//input[@name='weight_vetting_partial']")).sendKeys(skill.split("\\|")[1]);
                }
            }
        }
    }
}
