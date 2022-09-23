package com.scale.pages.ONE_FC;

import com.scale.context.TestContext;
import com.scale.framework.utility.Actions;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Class QualityWeighting has extend the Actions class
 *
 * @author 321020
 */
public class QualityWeighting extends Actions {

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
    private static final Logger log = LogManager.getLogger(QualityWeighting.class);

    /**
     * QualityWeighting constructor overloaded
     *
     * @param driver
     * @param scenario
     */
    public QualityWeighting(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        configReader = new ConfigurationReader();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath="//input[@id='Question 1']")
    private WebElement Technical;

    @FindBy(xpath="//input[@id='Question 2']")
    private WebElement Cultural;

    @FindBy(xpath="//input[@id='Question 3']")
    private WebElement SocialValue;

    public void setQualityWeighting(String data) {
        waitForSeconds(1);
        Technical.clear();
        Technical.sendKeys(data.split("~")[0]);
        Cultural.clear();
        Cultural.sendKeys(data.split("~")[1]);
        SocialValue.clear();
        SocialValue.sendKeys(data.split("~")[2]);
    }
}