package com.scale.pages;

import com.scale.context.TestContext;
import com.scale.framework.utility.Actions;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

/**
 * Class CommonToAllPage has extend the Actions class
 *
 * @author 571154
 */
public class CommonToAllPage extends Actions {

    /**
     * Object creation
     */
    TestContext textContext = new TestContext();
    private BrowserFactory browserFactory = new BrowserFactory();

    /**
     * Variable declaration
     */
    ConfigurationReader configReader;
    private PageObjectManager objectManager;
    private static final Logger log = LogManager.getLogger(CommonToAllPage.class);

    /**
     * CommonToAllPage constructor overloaded
     *
     * @param driver
     * @param scenario
     */
    public CommonToAllPage(WebDriver driver, Scenario scenario) {
        super.driver = driver;
        this.scenario = scenario;
        configReader = new ConfigurationReader();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    /**
     * Other page Xpaths
     */
    @FindBy(xpath = "//h1[contains(text(),'Procurement overview')]")
    private WebElement procOverviewChooseAgreement;

    @FindBy(xpath = "//h1[contains(text(),'Choose a commercial agreement')]")
    private WebElement pageTitleChooseAgreement;

    @FindBy(xpath = "//h1[contains(text(),'Find suppliers and run your procurement online.')]")
    private WebElement pageTitleDashboard;

    @FindBy(xpath = "//strong[contains(text(),'Procurement overview')]")
    private WebElement procurementOverviewPageTitle;

    @FindBy(xpath = "//strong[contains(text(),'Choose how to find a supplier')]")
    private WebElement chooseHowToFindASuppliePageTitle;

    @FindBy(xpath = "//h1[contains(text(),'Write and publish your requirements')]")
    private WebElement writeAndPublishYourRequirementsPageTitle;

    /**
     * Page title
     */
    @FindBy(xpath = "//h1[contains(text(),'Do pre-market engagement')]")
    private WebElement pageTitleDoPreMarketEngagement;

    @FindBy(xpath = "//h1[contains(text(),'Sign in to the Public Procurement Gateway')]")
    private WebElement pageTitleSignInToThePublicProcurementGateway;

    /**
     * HEADER Xpaths
     */
    @FindBy(xpath = "//header//a[text()='My account']")
    private WebElement headerMyAccount;

    @FindBy(xpath = "//header//a[text()='Sign out']")
    private WebElement headerSignOut;

    @FindBy(xpath = "//header//a/img")
    private WebElement headerGoToTheCCSHomepage;

    @FindBy(xpath = "//header//a[text()='Contract Award Service']")
    private WebElement headerCreateAndAwardAContract;

    @FindBy(xpath = "//header//a[text()='Home']")
    private WebElement headerHome;

    @FindBy(xpath = "//header//a[text()='My Projects']")
    private WebElement headerMyProjects;

    @FindBy(xpath = "//header//a[text()='CCS website']")
    private WebElement headerCCSWebsite;

    @FindBy(xpath = "//header//a[text()='Guidance']")
    private WebElement headerGuidance;

    @FindBy(xpath = "//header//a[text()='Get help']")
    private WebElement headerGetHelp;

    /**
     * BANNER Xpaths
     */
    @FindBy(xpath = "//a[contains(text(), 'feedback')]")
    private WebElement feedback;

    /**
     * BREADCRUMBS Xpaths
     */
    @FindBy(xpath = "//div[@class='govuk-breadcrumbs']//a[text()='Dashboard']")
    private WebElement breadcrumbDashboard;

    @FindBy(xpath = "//div[@class='govuk-breadcrumbs']//a[text()='Choose a commercial agreement']")
    private WebElement breadcrumbChooseACommercialAgreement;

    @FindBy(xpath = "//div[@class='govuk-breadcrumbs']//a[text()='Procurement overview']")
    private WebElement breadcrumbProcurementOverview;

    @FindBy(xpath = "//div[@class='govuk-breadcrumbs']//a[text()='Do pre-market engagement']")
    private WebElement breadcrumbDoPreMarketEngagement;

    @FindBy(xpath = "//div[@class='govuk-breadcrumbs']//a[text()=' Build your request for information']")
    private WebElement breadcrumbBuildYourRequestForInformation;

    /**
     * PAGE HEADING Xpaths
     */
    @FindBy(xpath = "//main//h1")
    private WebElement pageHeading;

    /**
     * PROJECT OVERVIEW Xpaths
     */
    @FindBy(xpath = "//p[text()='Selected agreement: ']/strong")
    private WebElement selectedAgreement;

    @FindBy(xpath = "//p[text()='Agreement ID: ']/strong")
    private WebElement agreementID;

    @FindBy(xpath = "//p[text()='Project ID / Name: ']/strong")
    private WebElement projectID;

    /**
     * RELATED CONTENT Xpaths
     */
    @FindBy(xpath = "//h2[text()='Related content']/following-sibling::p/a")
    private WebElement relatedContentLot;

    /**
     * SAVE & CONTINUE Xpaths
     */
    @FindBy(xpath = "//button[contains(text(), 'Save and continue')]")
    private WebElement saveAndContinue;

    /**
     * RETURN TO CTA's Xpaths
     */
    @FindBy(xpath = "//a[text()='Return to Build your Request for Information (RfI)']")
    private WebElement returnToBuildYourRFI;

    /**
     * HELP Section Xpaths
     */
    @FindBy(xpath = "//h2[text()='Help']/following-sibling::p/a[@href='https://www.crowncommercial.gov.uk/contact']")
    private WebElement helpEnquiryForm;

    @FindBy(xpath = "//a[contains(@href, 'tel:')]")
    private WebElement helpTelephone;

    @FindBy(xpath = "//a[@href='mailto:info@crowncommercial.gov.uk']")
    private WebElement helpEmail;

    @FindBy(xpath = "//a[@href='mailto:info@crowncommercial.gov.uk']/../following-sibling::p")
    private WebElement helpEmailContent;

    /**
     * FOOTER Xpaths
     */
    @FindBy(xpath = "//a[text()='contact us']")
    private WebElement footerContactUs;

    @FindBy(xpath = "//footer//a[text()='Terms and conditions']")
    private WebElement footerTermsAndConditions;

    @FindBy(xpath = "//footer//a[text()='Privacy policy']")
    private WebElement footerPrivacyPolicy;

    @FindBy(xpath = "//footer//a[text()='Cookie policy']")
    private WebElement footerCookiePolicy;

    @FindBy(xpath = "//footer//a[text()='Accessibility statement']")
    private WebElement footerAccessibilityStatement;

    @FindBy(xpath = "//footer//a[contains(text(),'Crown copyright')]")
    private WebElement footerCrownCopyright;

    @FindBy(xpath = "//footer//a/img")
    private WebElement footerGoToTheCCSHomepage;


    /**
     * validateHeaderBannerHelpSectionFooter method validates the HEADER, BANNER,
     * HELP Section & FOOTER
     */
    public void validateHeaderBannerHelpSectionFooter() {

        waitForSeconds(1);

        /**
         * Validate HEADER
         */
        String[] header = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("Header").split("!");
        assertTrue(getText(headerMyAccount).equalsIgnoreCase(header[0]));
        assertTrue(getText(headerSignOut).equalsIgnoreCase(header[1]));
        assertTrue(isElementPresentByXpath(headerGoToTheCCSHomepage));
        assertTrue(getText(headerCreateAndAwardAContract).equalsIgnoreCase(header[2]));
        assertTrue(getText(headerHome).equalsIgnoreCase(header[3]));
        assertTrue(getText(headerMyProjects).equalsIgnoreCase(header[4]));
        assertTrue(getText(headerCCSWebsite).equalsIgnoreCase(header[5]));
        assertTrue(getText(headerGuidance).equalsIgnoreCase(header[6]));
        assertTrue(getText(headerGetHelp).equalsIgnoreCase(header[7]));

        scenario.log("Buyer has successfully validated the page Header");
        log.info("Buyer has successfully validated the page Header");

        /**
         * Validate BANNER
         */

        assertTrue(
                getText(feedback).equalsIgnoreCase(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("Banner")));
        scenario.log("Buyer has successfully validated the page Banner (feedback)");
        log.info("Buyer has successfully validated the page Banner (feedback)");

        /**
         * Validate RETURN TO CTA's
         */

        /*
         * assertTrue(isElementPresentByXpath(returnToBuildYourRFI));
         * scenario.log("Buyer has successfully validated the Return To CTA link");
         * log.info("Buyer has successfully validated the Return To CTA link");
         */

        /**
         * Validate HELP
         */
        String[] helpSection = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("HelpSection").split("!");
        assertTrue(getText(helpEnquiryForm).equalsIgnoreCase(helpSection[0]));
        assertTrue(getText(helpTelephone).equalsIgnoreCase(helpSection[1]));
        assertTrue(getText(helpEmail).equalsIgnoreCase(helpSection[2]));
        assertTrue(getText(helpEmailContent).equalsIgnoreCase(helpSection[3]));
        scenario.log("Buyer has successfully validated the page Help Section");
        log.info("Buyer has successfully validated the page Help Section");

        /**
         * Validate FOOTER
         */
        String[] footer = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("Footer").split("!");
        assertTrue(getText(footerContactUs).equalsIgnoreCase(footer[0]));
        assertTrue(getText(footerTermsAndConditions).equalsIgnoreCase(footer[1]));
        assertTrue(getText(footerPrivacyPolicy).equalsIgnoreCase(footer[2]));
        assertTrue(getText(footerCookiePolicy).equalsIgnoreCase(footer[3]));

        assertTrue(getText(footerAccessibilityStatement).equalsIgnoreCase(footer[4]));
        assertTrue(getText(footerCrownCopyright).equalsIgnoreCase(footer[5]));
        assertTrue(isElementPresentByXpath(footerGoToTheCCSHomepage));

        scenario.log("Buyer has successfully validated the page Footer Section");
        log.info("Buyer has successfully validated the page Footer Section");
        textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);

    }

    /**
     * validateProjectOverviewRelatedContent method validates the PROJECT OVERVIEW &
     * RELATED CONTENT section
     */
    public void validateProjectOverviewRelatedContent() {

        waitForSeconds(1);

        /**
         * Validate PROJECT OVERVIEW/Agreement Details
         */

        String[] agreementDetails = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("SelectedAgreement")
                .split("!");
        assertTrue(getText(selectedAgreement).equalsIgnoreCase(agreementDetails[0]));
        assertTrue(getText(agreementID).equalsIgnoreCase(agreementDetails[1]));
        assertTrue(getText(projectID).equalsIgnoreCase(agreementDetails[2]));
        scenario.log("Buyer has successfully validated the page Agreement Details");
        log.info("Buyer has successfully validated the page Agreement Details");

        /**
         * Validate RELATED CONTENT
         */

        assertTrue(isElementPresentByXpath(relatedContentLot));
        scenario.log("Buyer has successfully validated the page Related Content");
        log.info("Buyer has successfully validated the page Related Content");
        textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);

    }


    /**
     * This method is common to all the pages for validating the Page Title
     *
     * @param ExpectedTitle
     */
    public void validatePageTitles(String ExpectedTitle) {

        String ActualTitle = null;
        if (driver.findElements(By.xpath("//h1[contains(@class,'govuk-heading')]/strong")).size() > 0) {
            ActualTitle = driver.findElement(By.xpath("//h1[contains(@class,'govuk-heading')]/strong")).getText().trim();
        } else {
            ActualTitle = driver.findElement(By.xpath("//h1[contains(@class,'govuk-heading')]")).getText().trim();
        }
        waitForSeconds(1);
        Assert.assertEquals("Page title validation: ", ExpectedTitle, ActualTitle);
        scenario.log("Buyer validates the page title: " + ExpectedTitle);
        textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
        log.info("Buyer validates the page title: " + ExpectedTitle);
    }

    /**
     * This method is common to all the pages for validating the Page Title
     *
     * @param pageName
     */
    public void validatePageTitle(String pageName) {

        switch (pageName) {

            case "<Sign in to the Public Procurement Gateway>":

                waitForSeconds(1);
                assertTrue(getText(pageTitleSignInToThePublicProcurementGateway)
                        .equalsIgnoreCase(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("Login_Title")));
                scenario.log("Buyer validates the page title: " + getText(pageTitleSignInToThePublicProcurementGateway));
                textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
                log.info("Buyer validates the page title: " + getText(pageTitleSignInToThePublicProcurementGateway));

                break;

            case "<Find suppliers and run your procurement online>":

                waitForSeconds(1);
                assertTrue(getText(pageTitleDashboard)
                        .equalsIgnoreCase(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("Dashboard_Title")));
                scenario.log("Buyer validates the page title: " + getText(pageTitleDashboard));
                textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
                log.info("Buyer validates the page title: " + getText(pageTitleDashboard));

                break;

            case "<Choose a commercial agreement>":

                waitForSeconds(1);
                assertTrue(getText(pageTitleChooseAgreement).equalsIgnoreCase(
                        TestContext.OneFCTestDataMap.get(TestContext.TDID).get("ChooseAgreement_Title")));
                scenario.log("Buyer validates the page title: " + getText(pageTitleChooseAgreement));
                textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
                log.info("Buyer validates the page title: " + getText(pageTitleChooseAgreement));
                break;

            case "<Procurement overview>":

                waitForSeconds(1);
                assertTrue(getText(procurementOverviewPageTitle).equalsIgnoreCase(
                        TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S1_Title")));
                scenario.log("Buyer validates the page title: " + getText(procurementOverviewPageTitle));
                textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
                log.info("Buyer validates the page title: " + getText(procurementOverviewPageTitle));
                break;

            case "<Choose how to find a supplier>":

                waitForSeconds(1);
                assertTrue(getText(chooseHowToFindASuppliePageTitle).equalsIgnoreCase(
                        TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S2_Title")));
                scenario.log("Buyer validates the page title: " + getText(chooseHowToFindASuppliePageTitle));
                textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
                log.info("Buyer validates the page title: " + getText(chooseHowToFindASuppliePageTitle));
                break;


            case "<Write and publish your requirements>":

                waitForSeconds(1);
                assertTrue(getText(writeAndPublishYourRequirementsPageTitle).equalsIgnoreCase(
                        TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S3_Title")));
                scenario.log("Buyer validates the page title: " + getText(writeAndPublishYourRequirementsPageTitle));
                textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
                log.info("Buyer validates the page title: " + getText(writeAndPublishYourRequirementsPageTitle));
                break;

            case "<Do pre-market engagement>":

                waitForSeconds(1);
                assertTrue(getText(pageTitleDoPreMarketEngagement).equalsIgnoreCase(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("DoPreMarketEngagement_PageTitle")));
                scenario.log("Buyer validates the page title: " + getText(pageTitleDoPreMarketEngagement));
                textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
                log.info("Buyer validates the page title: " + getText(pageTitleDoPreMarketEngagement));

                break;


            case "<Name your project>":

                waitForSeconds(1);
                assertTrue(getText(pageTitleDoPreMarketEngagement).equalsIgnoreCase(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("DoPreMarketEngagement_PageTitle")));
                scenario.log("Buyer validates the page title: " + getText(pageTitleDoPreMarketEngagement));
                textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
                log.info("Buyer validates the page title: " + getText(pageTitleDoPreMarketEngagement));

                break;

        }

    }

    public void clickSaveandContinue() {
        saveAndContinue.click();
    }

    public void clickContinue(String ButtonName) {
        driver.findElement(By.xpath("//button[contains(text(), '"+ButtonName+"')]")).click();
    }

}
