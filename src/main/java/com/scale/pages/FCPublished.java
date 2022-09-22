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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Class ReviewandPublish has extend the Actions class
 *
 * @author 321020
 */
public class FCPublished extends Actions {

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
    private static final Logger log = LogManager.getLogger(FCPublished.class);

    /**
     * ReviewandPublish constructor overloaded
     *
     * @param driver
     * @param scenario
     */
    public FCPublished(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        configReader = new ConfigurationReader();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath="//h1/strong[contains(text(),'Your further competition has been published')]")
    private WebElement FCPublished_Title;

    @FindBy(xpath="//a[contains(text(),'Go to your project dashboard')]")
    private WebElement GotoDashboard;

    public String getEventID() {
        wait.until(ExpectedConditions.visibilityOf(FCPublished_Title));
        return driver.findElement(By.xpath("//div/strong")).getText();
    }

    public void clickGotoDashboard() {
        GotoDashboard.click();
    }

}