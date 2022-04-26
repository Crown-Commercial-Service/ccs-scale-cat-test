package com.scale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scale.framework.utility.Actions;


public class TermsAndAcronymsPage extends Actions {
	
	public TermsAndAcronymsPage(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='rfi_term_1']")
	private WebElement firstTerm;
	
	@FindBy(xpath="//textarea[@id='rfi_term_definition_1']")
	private WebElement firstTermDescription;
	
	@FindBy(xpath="//a[@href=1]")
	private WebElement firstClear;
	
	@FindBy(xpath="//input[@id='rfi_term_2']")
	private WebElement secondTerm;
	
	@FindBy(xpath="//textarea[@id='rfi_term_definition_2']")
	private WebElement secondTermDescription;
	
	@FindBy(xpath="//a[@href=2]")
	private WebElement secondClear;
	
	@FindBy(xpath="//input[@id='rfi_term_3']")
	private WebElement thirdTerm;
	
	@FindBy(xpath="//textarea[@id='rfi_term_definition_3']")
	private WebElement thirdTermDescription;
	
	@FindBy(xpath="//a[@href=3]")
	private WebElement thirdClear;
	
	@FindBy(xpath="//input[@id='rfi_term_4']")
	private WebElement fourthTerm;
	
	@FindBy(xpath="//textarea[@id='rfi_term_definition_4']")
	private WebElement fourthTermDescription;
	
	@FindBy(xpath="//a[@href=4]")
	private WebElement fourthClear;
	
	@FindBy(xpath="//input[@id='rfi_term_5']")
	private WebElement fifthTerm;
	
	@FindBy(xpath="//textarea[@id='rfi_term_definition_5']")
	private WebElement fifthTermDescription;
	
	@FindBy(xpath="//a[@href=5]")
	private WebElement fifthClear;
	
	@FindBy(xpath="//input[@id='rfi_term_6']")
	private WebElement sixthTerm;
	
	@FindBy(xpath="//textarea[@id='rfi_term_definition_6']")
	private WebElement sixthTermDescription;
	
	@FindBy(xpath="//a[@href=6]")
	private WebElement sixthClear;
	
	@FindBy(xpath="//input[@id='rfi_term_7']")
	private WebElement seventhTerm;
	
	@FindBy(xpath="//textarea[@id='rfi_term_definition_7']")
	private WebElement seventhTermDescription;
	
	@FindBy(xpath="//a[@href=7]")
	private WebElement seventhClear;
	
	@FindBy(xpath="//input[@id='rfi_term_8']")
	private WebElement eighthTerm;
	
	@FindBy(xpath="//textarea[@id='rfi_term_definition_8']")
	private WebElement eighthTermDescription;
	
	@FindBy(xpath="//a[@href=8]")
	private WebElement eighthClear;
	
	@FindBy(xpath="//input[@id='rfi_term_9']")
	private WebElement ninthTerm;
	
	@FindBy(xpath="//textarea[@id='rfi_term_definition_9']")
	private WebElement ninthTermDescription;
	
	@FindBy(xpath="//a[@href=9]")
	private WebElement ninthClear;
	
	@FindBy(xpath="//input[@id='rfi_term_10']")
	private WebElement tenthTerm;
	
	@FindBy(xpath="//textarea[@id='rfi_term_definition_10']")
	private WebElement tenthTermDescription;
	
	@FindBy(xpath="//a[@href=10]")
	private WebElement tenthClear;

}
