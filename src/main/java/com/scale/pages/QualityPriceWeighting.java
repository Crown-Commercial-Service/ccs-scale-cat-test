package com.scale.pages;

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
 * Class QualityPriceWeighting has extend the Actions class
 *
 * @author 321020
 */
public class QualityPriceWeighting extends Actions {

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
    private static final Logger log = LogManager.getLogger(QualityPriceWeighting.class);

    /**
     * QualityPriceWeighting constructor overloaded
     *
     * @param driver
     * @param scenario
     */
    public QualityPriceWeighting(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        configReader = new ConfigurationReader();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath="//input[@id='Question 1']")
    private WebElement Quality;

    @FindBy(xpath="//input[@id='Question 2']")
    private WebElement Price;

    public void setQualityPriceWeighting(String data) {
        waitForSeconds(1);
        Quality.clear();
        Quality.sendKeys(data.split("~")[0]);
        Price.clear();
        Price.sendKeys(data.split("~")[1]);
    }
}