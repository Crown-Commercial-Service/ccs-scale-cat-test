package com.scale.pages.RFI;

import com.scale.framework.utility.Actions;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Class PublishConfirmation has extend the Actions class
 * @author 571154
 *
 */
public class PublishConfirmation extends Actions {

	/**
	 * PublishConfirmation constructor overloaded
	 * @param driver
	 * @param scenario
	 */
    public PublishConfirmation(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(super.driver, Duration.ofSeconds(30));
    }
    
    /**
	 * PublishConfirmation Page Xpaths
	 */
    @FindBy(xpath = "//h1[contains(text(),'Your RfI is published')]")
    private WebElement lbl_ConfirmationTitle;

    @FindBy(xpath = "//*[@class='govuk-panel__title']")
    private WebElement lbl_Content;

    @FindBy(xpath = "//div/strong")
    private WebElement lbl_EventID;

    @FindBy(xpath = "//div[@class='govuk-panel__body']/p[@class='govuk-body']")
    private WebElement lbl_SubContent;

    @FindBy(xpath = "//a[contains(text(), 'Go to your project dashboard')]")
    private WebElement btn_GoToDasboard;

    @FindBy(xpath = "//a[contains(text(), 'Return to procurement overview')]  ")
    private WebElement btn_ReturnTo;

    
}
