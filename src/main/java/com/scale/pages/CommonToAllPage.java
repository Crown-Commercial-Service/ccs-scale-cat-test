package com.scale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scale.framework.utility.Actions;

public class CommonToAllPage extends Actions {
	
	public CommonToAllPage(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	/**
	 * HEADER
	 */
	@FindBy(xpath="//header//a[text()='My account']")
	private WebElement headerMyAccount;
	
	@FindBy(xpath="//header//a[text()='Sign out']")
	private WebElement headerSignOut;
	
	@FindBy(xpath="//header//a/img")
	private WebElement headerGoToTheCCSHomepage;
	
	@FindBy(xpath="//header//a[text()='Create and award a contract']")
	private WebElement headerCreateAndAwardAContract;
	
	@FindBy(xpath="//header//a[text()='Home']")
	private WebElement headerHome;
	
	@FindBy(xpath="//header//a[text()='My Projects']")
	private WebElement headerMyProjects;
	
	@FindBy(xpath="//header//a[text()='CCS website']")
	private WebElement headerCCSWebsite;
	
	@FindBy(xpath="//header//a[text()='Guidance']")
	private WebElement headerGuidance;
	
	@FindBy(xpath="//header//a[text()='Get help']")
	private WebElement headerGetHelp;
	
	
	/**
	 * BANNER
	 */
	@FindBy(xpath="//a[contains(text(), 'feedback')]")
	private WebElement feedback;
	
	
	/**
	 * BREADCRUMBS
	 */
	@FindBy(xpath="//div[@class='govuk-breadcrumbs']//a[text()='Dashboard']")
	private WebElement breadcrumbDashboard;
	
	@FindBy(xpath="//div[@class='govuk-breadcrumbs']//a[text()='Choose a commercial agreement']")
	private WebElement breadcrumbChooseACommercialAgreement;
	
	@FindBy(xpath="//div[@class='govuk-breadcrumbs']//a[text()='Procurement overview']")
	private WebElement breadcrumbProcurementOverview;
	
	@FindBy(xpath="//div[@class='govuk-breadcrumbs']//a[text()='Do pre-market engagement']")
	private WebElement breadcrumbDoPreMarketEngagement;
	
	@FindBy(xpath="//div[@class='govuk-breadcrumbs']//a[text()=' Build your request for information']")
	private WebElement breadcrumbBuildYourRequestForInformation;
	
	
	/**
	 * PAGE HEADING
	 */
	@FindBy(xpath="//main//h1")
	private WebElement pageHeading;
	
	
	/**
	 * PROJECT OVERVIEW
	 */
	@FindBy(xpath="//p[text()='Selected agreement: ']/strong")
	private WebElement selectedAgreement;
	
	@FindBy(xpath="//p[text()='Agreement ID: ']/strong")
	private WebElement agreementID;
	
	@FindBy(xpath="//p[text()='Project ID / Name: ']/strong")
	private WebElement projectID;
	
	
	/**
	 * RELATED CONTENT
	 */
	@FindBy(xpath="//h2[text()='Related content']/following-sibling::p/a")
	private WebElement relatedContentLot;
	
	
	/**
	 * SAVE & CONTINUE
	 */
	@FindBy(xpath="//button[contains(text(), 'Save and continue')]")
	private WebElement saveAndContinue;
	
	
	/**
	 * RETURN TO CTA's
	 */
	@FindBy(xpath="//a[text()='Return to Build your Request for Information (RfI)']")
	private WebElement returnToBuildYourRFI;
	
	
	/**
	 * HELP
	 */
	@FindBy(xpath="//h2[text()='Help']/following-sibling::p/a[@href='https://www.crowncommercial.gov.uk/contact']")
	private WebElement helpEnquiryForm;
	
	@FindBy(xpath="//a[contains(@href, 'tel:')]")
	private WebElement helpTelephone;
	
	@FindBy(xpath="//a[@href='mailto:info@crowncommercial.gov.uk']")
	private WebElement helpEmail;
	
	
	/**
	 * FOOTER
	 */
	@FindBy(xpath="//a[text()='contact us']")
	private WebElement footerContactUs;
	
	@FindBy(xpath="//footer//a[text()='Terms and conditions']")
	private WebElement footerTermsAndConditions;
	
	@FindBy(xpath="//footer//a[text()='Privacy policy']")
	private WebElement footerPrivacyPolicy;
	
	@FindBy(xpath="//footer//a[text()='Cookie policy']")
	private WebElement footerCookiePolicy;
	
	@FindBy(xpath="//footer//a[text()='Accessibility statement']")
	private WebElement footerAccessibilityStatement;
	
	@FindBy(xpath="//footer//a[contains(text(),'Crown copyright')]")
	private WebElement footerCrownCopyright;
	
	@FindBy(xpath="//footer//a/img")
	private WebElement footerGoToTheCCSHomepage;
	

}
