package com.scale.pages.RFI;

import com.scale.framework.utility.Actions;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SelectSuppliers extends Actions{

    @FindBy(xpath = "//a[contains(text(), 'Download this list')]")
    private WebElement btn_Download;

    @FindBy(xpath = "//button[contains(text(),'Save and continue')]")
    private WebElement btn_SaveAndContinue;

    @FindBy(xpath = "//a[contains(text(), 'Return to Run pre-market engagement')]")
    private WebElement lnk_ReturnTo;

    public SelectSuppliers(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(super.driver, Duration.ofSeconds(30));
    }
}