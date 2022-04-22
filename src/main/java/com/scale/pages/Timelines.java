package com.scale.pages;

import com.scale.framework.utility.Actions;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Timelines extends Actions  {

    @FindBy(id = "By.id('change_clarification_date_2')")
    private WebElement changeButton;

    @FindBy(id = "By.id('clarification_date-day_2')")
    private WebElement day;

    @FindBy(id = "By.id('clarification_date-month_2')")
    private WebElement month;

    @FindBy(id = "By.id('clarification_date-year_2')")
    private WebElement year;

    @FindBy(id = "By.id('clarification_date-hour_2')")
    private WebElement hour;

    @FindBy(id = "By.id('clarification_date-minute_2')")
    private WebElement minute;

    @FindBy(id = "By.id('clarification_date-hourFormat')")
    private WebElement format;

    @FindBy(xpath = "By.xpath('//option[. = 'AM']')")
    private WebElement AMPM;

    public Timelines(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(super.driver, Duration.ofSeconds(30));
    }

    //Instead of going with the Page Objects for all, it would easier to create dynamic elements as only a number changes
    public int setCounter(String field) {
        int fieldNum = 0;
        switch (field) {
            case "A":
                fieldNum = 1;
                break;

            case "B":
                fieldNum = 2;
                break;

            default:

        }
        return fieldNum;
    }

    public void clickChange(String FieldName) {
        driver.findElement(By.id("change_clarification_date_" + setCounter(FieldName))).click();
    }

}

