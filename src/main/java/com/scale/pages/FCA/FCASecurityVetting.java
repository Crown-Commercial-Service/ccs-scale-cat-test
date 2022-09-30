package com.scale.pages.FCA;

import com.scale.context.TestContext;
import com.scale.framework.utility.Actions;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Class FCASecurityVetting has extend the Actions class
 *
 * @author 321020
 */
public class FCASecurityVetting extends Actions {

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
    private static final Logger log = LogManager.getLogger(FCASecurityVetting.class);

    @FindBy(xpath="//input[contains(@value,'None')]")
    private WebElement No;

    @FindBy(xpath="//input[contains(@value,'BPSS')]")
    private WebElement BPSS;

    @FindBy(xpath="//div[@id='conditional-ccs_ca_choose_security-2']/div/input")
    private WebElement BPSS_txt;

    @FindBy(xpath="//input[contains(@value,'CTC')]")
    private WebElement CTC;

    @FindBy(xpath="//div[@id='conditional-ccs_ca_choose_security-3']/div/input")
    private WebElement CTC_txt;

    @FindBy(xpath="//input[contains(@value,'SC')]")
    private WebElement SC;

    @FindBy(xpath="//div[@id='conditional-ccs_ca_choose_security-4']/div/input")
    private WebElement SC_txt;

    @FindBy(xpath="//input[contains(@value,'DV')]")
    private WebElement DV;

    @FindBy(xpath="//div[@id='conditional-ccs_ca_choose_security-5']/div/input")
    private WebElement DV_txt;

    /**
     * FCASecurityVetting constructor overloaded
     *
     * @param driver
     * @param scenario
     */
    public FCASecurityVetting(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        configReader = new ConfigurationReader();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }


    public void enterSecurityVetting(String data){
        waitForSeconds(1);
        switch(data.split("\\|")[0].trim()){
            case "None":
                No.click();
                break;
            case "BPSS":
                BPSS.click();
                BPSS_txt.clear();
                BPSS_txt.sendKeys(data.split("\\|")[1]);
                break;
            case "CTC":
                CTC.click();
                CTC_txt.clear();
                CTC_txt.sendKeys(data.split("\\|")[1]);
                break;
            case "SC":
                SC.click();
                SC_txt.clear();
                SC_txt.sendKeys(data.split("\\|")[1]);
                break;
            case "DV":
                DV.click();
                DV_txt.clear();
                DV_txt.sendKeys(data.split("\\|")[1]);
                break;
            default:
                Assert.fail("Invalid Security Level defined: "+ data.split("\\|")[0]);
        }
    }

}
