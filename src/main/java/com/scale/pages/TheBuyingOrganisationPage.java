package com.scale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scale.framework.utility.Actions;

public class TheBuyingOrganisationPage extends Actions {
	
	public TheBuyingOrganisationPage(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[text()='Name of the organisation doing the procurement']/following-sibling::p/strong")
	private WebElement orgDoingTheProcurement;
	
	@FindBy(id="rfi_contracting_auth")
	private WebElement orgUsingProductOrServices;

}
