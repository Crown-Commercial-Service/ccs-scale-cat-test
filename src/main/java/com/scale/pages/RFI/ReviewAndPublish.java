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
 * Class ReviewAndPublish has extend the Actions class
 * @author 571154
 *
 */
public class ReviewAndPublish extends Actions {

	/**
	 * ReviewAndPublish constructor overloaded
	 * @param driver
	 * @param scenario
	 */
	public ReviewAndPublish(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(super.driver, Duration.ofSeconds(30));
    }
	
	
	/**
	 * ReviewAndPublish Page Xpaths
	 */
    //TODO: - Add Elements

    @FindBy(xpath = "//a[contains(text(), 'Return to Do Pre-market engagement')]")
    private WebElement lnk_ReturnTo;

    @FindBy(xpath = "//button[@class='govuk-button doc_upload_button']")
    private WebElement btn_Upload;

    @FindBy(xpath = "//input[@id='rfi_offline_document']")
    private WebElement btn_ChooseFiles;

    @FindBy(xpath = "//h1[contains(text(),'Upload documents or add links (Optional)')]")
    private WebElement lbl_UploadFilesTitle;

    

}
