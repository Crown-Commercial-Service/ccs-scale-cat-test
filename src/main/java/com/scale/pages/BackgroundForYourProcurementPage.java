package com.scale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scale.framework.utility.Actions;

public class BackgroundForYourProcurementPage extends Actions {
	
	public BackgroundForYourProcurementPage(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="rfi_prob_statement")
	private WebElement backgroundInformation;

}
