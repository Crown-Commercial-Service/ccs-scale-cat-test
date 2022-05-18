package com.scale.pages;

import com.scale.framework.utility.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhereTheSuppliedStaffWillWorkPage extends Actions {
	
	public WhereTheSuppliedStaffWillWorkPage(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="required_locations")
	private WebElement northEastEngland;
	
	@FindBy(id="required_locations-2")
	private WebElement northWestEngland;
	
	@FindBy(id="required_locations-3")
	private WebElement yorkshireAndTheHumber;
	
	@FindBy(id="required_locations-4")
	private WebElement eastMidlands;
	
	@FindBy(id="required_locations-5")
	private WebElement eastOfEngland;
	
	@FindBy(id="required_locations-6")
	private WebElement london;
	
	@FindBy(id="required_locations-7")
	private WebElement southEastEngland;
	
	@FindBy(id="required_locations-8")
	private WebElement southWestEngland;
	
	@FindBy(id="required_locations-9")
	private WebElement wales;
	
	@FindBy(id="required_locations-10")
	private WebElement scotland;
	
	@FindBy(id="required_locations-11")
	private WebElement northIreland;
	
	@FindBy(id="required_locations-12")
	private WebElement westMidlands;
	
	@FindBy(id="required_locations-14")
	private WebElement noSpecificLocation;
	

}
