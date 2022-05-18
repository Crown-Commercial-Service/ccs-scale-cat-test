package com.scale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scale.framework.utility.Actions;

public class SecurityAndVettingRequirementsPage extends Actions {
	
	public SecurityAndVettingRequirementsPage(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ccs_vetting_type")
	private WebElement noSecurityClearanceNeeded;
	
	@FindBy(id="ccs_vetting_type-2")
	private WebElement baselinePersonnelSecurityStandard;
	
	@FindBy(xpath="//a[text()='Read more about BPSS clearance.']")
	private WebElement readMoreAboutBPSSClearance;
	
	@FindBy(id="ccs_vetting_type-3")
	private WebElement counterTerroristCheck;
	
	@FindBy(xpath="//a[text()='Read more about CTC clearance.']")
	private WebElement readMoreAboutCTCClearance;
	
	@FindBy(id="ccs_vetting_type-4")
	private WebElement securityCheck;
	
	@FindBy(xpath="//a[text()='Read more about SC clearance']")
	private WebElement readMoreAboutSClearance;
	
	@FindBy(id="ccs_vetting_type-5")
	private WebElement enhancedSecurityCheck;
	
	@FindBy(xpath="//a[text()=' Read more about eSC clearance.']")
	private WebElement readMoreAboutESCClearance;
	
	@FindBy(id="ccs_vetting_type-6")
	private WebElement developedVetting;
	
	@FindBy(xpath="//a[text()=' Read more about Developed Vetting']")
	private WebElement readMoreAboutDevelopedVetting;
	
	@FindBy(id="ccs_vetting_type-7")
	private WebElement enhancedDevelopedVetting;
	
	@FindBy(xpath="//a[text()=' Read more about Enhanced Developed Vetting']")
	private WebElement readMoreAboutEnhancedDevelopedVetting;
	
	
}
