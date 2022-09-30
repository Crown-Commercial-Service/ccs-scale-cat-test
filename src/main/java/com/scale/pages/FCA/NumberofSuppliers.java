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

/**
 * Class NumberofSuppliers has extend the Actions class
 *
 * @author 321020
 */
public class NumberofSuppliers extends Actions {

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
    private static final Logger log = LogManager.getLogger(NumberofSuppliers.class);

    /**
     * NumberofSuppliers constructor overloaded
     *
     * @param driver
     * @param scenario
     */
    public NumberofSuppliers(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        configReader = new ConfigurationReader();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void enterNumberofSuppliers(String Count) {
        driver.findElement(By.xpath("//input[@name='ca_supplier_count']")).clear();
        driver.findElement(By.xpath("//input[@name='ca_supplier_count']")).sendKeys(Count);
    }
}
