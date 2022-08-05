package com.scale.pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.scale.context.TestContext;
import com.scale.framework.utility.Actions;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.PageObjectManager;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

/**
 * Class ProcurementOverviewPage has extend the Actions class
 * @author 571154
 *
 */
public class ProcurementOverviewPage extends Actions{
	
	/**
	 * Object creation
	 */
	TestContext textContext=new TestContext();
	private BrowserFactory browserFactory = new BrowserFactory();
	
	/**
	 * Variables declaration
	 */
	ConfigurationReader configReader;
	private PageObjectManager objectManager;
	
	/**
	 * Logger
	 */
	private static final Logger log = LogManager.getLogger(ProcurementOverviewPage.class);
	
	/**
	 * ProcurementOverviewPage constructor overloaded
	 * @param driver
	 * @param scenario
	 */
	public ProcurementOverviewPage(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}
	
	/**
	 * Procurement Overview Page Xpaths
	 */
	
	/**
	 * Section 1 locator (1. See available suppliers)
	 */
	
	@FindBy(xpath = "//span[contains(text(),'1.')]")
	private WebElement  section1SeeAvailableSuppliersContent1;
	
	@FindBy(xpath = "//span[contains(text(),'1.')]/..")
	private WebElement  section1SeeAvailableSuppliersContent;
	
	@FindBy(xpath = "//a[contains(text(),'See available suppliers')]")
	private WebElement  section1SeeAvailableSuppliersBtn;

	
	@FindBy(xpath = "//span[contains(text(),'1.')]/../strong")
	private WebElement  section1StatusOptional;

	
	/**
	 * Section 2 locator (2. Do pre-market engagement)
	 */
	
	@FindBy(xpath = "//span[contains(text(),'2.')]")
	private WebElement  section2StartPreMarketEngagementContent1;
	
	@FindBy(xpath = "//span[contains(text(),'2.')]/..")
	private WebElement  section2StartPreMarketEngagementContent;
	
	@FindBy(xpath = "//a[contains(text(),'Start pre-market engagement')]")
	private WebElement  StartPreMarketEngagementBtn;

	@FindBy(xpath = "//span[contains(text(),'2.')]/../strong")
	private WebElement  section2StatusOptional;
	
	@FindBy(xpath = "//a[contains(text(),'Write and publish requirements')]")
	private WebElement  WriteAndPublishYourRequirementsBtn;

	/**
	 * Section 3 locator (3. Write and publish your requirements)
	 */
	
	@FindBy(xpath = "//span[contains(text(),'3.')]")
	private WebElement  section3WriteAndPublishYourRequirementsContent1;
	
	@FindBy(xpath = "//span[contains(text(),'3.')]/..")
	private WebElement  section3WriteAndPublishYourRequirementsContent;
	
	@FindBy(xpath = "//a[contains(text(),'Write and publish your requirements')]")
	private WebElement  section3WriteAndPublishYourRequirementsBtn;

	@FindBy(xpath = "//span[contains(text(),'3.')]/../strong")
	private WebElement section3StatusToDo;

	
	/**
	 * Section 4 locator (4. Do evaluation)
	 */
	
	@FindBy(xpath = "//span[contains(text(),'4.')]")
	private WebElement  section4DoEvaluationContent1;
	
	@FindBy(xpath = "//span[contains(text(),'4.')]/..")
	private WebElement  section4DoEvaluationContent;
	
	@FindBy(xpath = "//span[contains(text(),'4.')]/../strong")
	private WebElement section4StatusCannotStartYet;
	
	/**
	 * Section 5 locator (5. Award the contract)
	 */
	
	@FindBy(xpath = "//span[contains(text(),'5.')]")
	private WebElement  section5AwardTheContractContent1;
	
	@FindBy(xpath = "//span[contains(text(),'5.')]/..")
	private WebElement  section5AwardTheContractContent;
	
	@FindBy(xpath = "//span[contains(text(),'5.')]/../strong")
	private WebElement section5StatusCannotStartYet;
	
	
	/**
	 * Section 6 locator (6. Publish your contract)
	 */
	
	@FindBy(xpath = "//span[contains(text(),'6.')]")
	private WebElement  section6PublishYourContractContent1;
	
	@FindBy(xpath = "//span[contains(text(),'6.')]/..")
	private WebElement  section6PublishYourContractContent;
	
	@FindBy(xpath = "//span[contains(text(),'6.')]/../strong")
	private WebElement section6CannotStartYet;
	
	
	
	/**
	 * procurementOverviewPageContent method validates the procurementOverview page contents & Status
	 * 
	 */
	public void procurementOverviewPageContent() {

		waitForSeconds(1);

		String[] contentDetails = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("ProcurementOverviewPageContentButtonStatus").split("!");
		
		/**
		 * Section 1 (1. See available suppliers) validation
		 */
		
		String[] section1Content = getText(section1SeeAvailableSuppliersContent).split("\\R");
		
		//Section1 Title check
		assertTrue(section1Content[0].equalsIgnoreCase(contentDetails[0]));
		//Section1 Status check
		assertTrue(section1Content[1].equalsIgnoreCase(contentDetails[1]));
		//Section1 Button check
		assertTrue(getText(section1SeeAvailableSuppliersBtn).equalsIgnoreCase(contentDetails[2]));
		
		/**
		 * Section 2 locator (2. Do pre-market engagement)
		 */
		
		String[] section2Content = getText(section2StartPreMarketEngagementContent).split("\\R");

		// Section2 Title check
		assertTrue(section2Content[0].equalsIgnoreCase(contentDetails[3]));
		// Section2 Status check
		assertTrue(section2Content[1].equalsIgnoreCase(contentDetails[4]));
		// Section2 Button check
		assertTrue(getText(StartPreMarketEngagementBtn).equalsIgnoreCase(contentDetails[5]));
		
		
		/**
		 * Section 3 locator (3. Write and publish your requirements)
		 */
		
		String[] section3Content = getText(section3WriteAndPublishYourRequirementsContent).split("\\R");

		// Section2 Title check
		assertTrue(section3Content[0].equalsIgnoreCase(contentDetails[6]));
		// Section2 Status check
		assertTrue(section3Content[1].equalsIgnoreCase(contentDetails[7]));
		// Section2 Button check
		assertTrue(getText(section3WriteAndPublishYourRequirementsBtn).equalsIgnoreCase(contentDetails[8]));
		
		
		/**
		 * Section 4 locator (4. Do evaluation)
		 */
		
		String[] section4Content = getText(section4DoEvaluationContent).split("\\R");

		// Section2 Title check
		assertTrue(section4Content[0].equalsIgnoreCase(contentDetails[9]));
		// Section2 Status check
		assertTrue(section4Content[1].equalsIgnoreCase(contentDetails[10]));
		
		/**
		 * Section 5 locator (5. Award the contract)
		 */
		
		String[] section5Content = getText(section5AwardTheContractContent).split("\\R");

		// Section2 Title check
		assertTrue(section5Content[0].equalsIgnoreCase(contentDetails[11]));
		// Section2 Status check
		assertTrue(section5Content[1].equalsIgnoreCase(contentDetails[12]));
		
		/**
		 * Section 6 locator (6. Publish your contract)
		 */
		
		String[] section6Content = getText(section6PublishYourContractContent).split("\\R");

		// Section2 Title check
		assertTrue(section6Content[0].equalsIgnoreCase(contentDetails[13]));
		// Section2 Status check
		assertTrue(section6Content[1].equalsIgnoreCase(contentDetails[14]));
		
		scenario.log("Buyer validated the ProcurementOverview page contents");
		log.info("Buyer validated the ProcurementOverview page contents");
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
	}
	
	
	/**
	 * clickOnWriteAndPublishYourRequirementsBtn method clicks 
	 * the button mentioned in the excel data
	 * 
	 */
	public void clickOnStartPremarketEngagementBtn() {
		
		String section = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S1_Section");
		
		switch (section) {
		
		case "2. Do pre-market engagement":

			waitForSeconds(1);
			clickElement(StartPreMarketEngagementBtn);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer clicks on StartPreMarketEngagement Button");
			log.info("Buyer clicks on StartPreMarketEngagement Button");
		
			break;

		case "3. Write and publish your requirements":

			waitForSeconds(1);
			clickElement(WriteAndPublishYourRequirementsBtn);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer clicks on WriteAndPublishYourRequirements Button");
			log.info("Buyer clicks on WriteAndPublishYourRequirements Button");
		
			break;
			
	}

}
	
}