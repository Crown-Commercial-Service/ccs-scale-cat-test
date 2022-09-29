package com.scale.pages.FCA;

import com.scale.context.TestContext;
import com.scale.framework.utility.Actions;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import com.scale.pages.ONE_FC.ReviewandPublish;
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

/**
 * Class EnterWeightings has extend the Actions class
 *
 * @author 321020
 */
public class EnterWeightings extends Actions {

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
    private static final Logger log = LogManager.getLogger(EnterWeightings.class);

    /**
     * EnterWeightings constructor overloaded
     *
     * @param driver
     * @param scenario
     */
    public EnterWeightings(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        configReader = new ConfigurationReader();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath="//input[@id='1']")
    private WebElement Capacity;

    @FindBy(xpath="//input[@id='3']")
    private WebElement Servicecapability;

    @FindBy(xpath="//input[@id='4']")
    private WebElement Scalability;

    @FindBy(xpath="//input[@id='2']")
    private WebElement Security;

    @FindBy(xpath="//input[@id='5']")
    private WebElement Location;

    public void enterDimensionWeightings(String data) {
        waitForSeconds(1);
        String[] values = data.split("\\|");
        if(values.length-5!=0){
            Assert.fail("Number of Weightings provided is incorrect");
        }
        Capacity.sendKeys(values[0]);
        Servicecapability.sendKeys(values[2]);
        Scalability.sendKeys(values[3]);
        Security.sendKeys(values[1]);
        Location.sendKeys(values[4]);
    }
}
