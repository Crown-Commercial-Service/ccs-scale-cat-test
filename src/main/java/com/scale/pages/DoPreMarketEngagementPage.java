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

public class DoPreMarketEngagementPage extends Actions {
	
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
	private static final Logger log = LogManager.getLogger(LoginPage.class);
	
	/**
	 * DoPreMarketEngagement constructor overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public DoPreMarketEngagementPage(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		}
		
		/**
		 * Page title
		 */
		@FindBy(xpath = "//h1[contains(text(),'Do pre-market engagement')]")
		private WebElement  pageTitleDoPreMarketEngagement;
	
		/**
		 * Locators of section 1 (1.Project and colleagues)
		 */
			
		@FindBy(xpath = "//span[text()='1. ' ]/..")
		private WebElement  section1TitleProjectAndcolleagues;

		@FindBy(xpath = "//a[contains(text(),'Name your project')]")
		private WebElement  section1Link1NameYourProject;
		
		@FindBy(xpath = "//a[contains(text(),'Name your project')]/ancestor::span/following-sibling::strong")
		private WebElement  section1Link1NameYourProjectStatusOptional;
		
		
		@FindBy(xpath = "//a[contains(text(),'Change who is going to lead the procurement')]")
		private WebElement  section1Link2ChangeWhoIsGoingToLeadTheProcurement;
		
		@FindBy(xpath = "//a[contains(text(),'Change who is going to lead the procurement')]/ancestor::span/following-sibling::strong")
		private WebElement  section1Link2ChangeWhoIsGoingToLeadTheProcurementStatusOptional;
		
		
		@FindBy(xpath = "//a[contains(text(),'Add colleagues to your project')]")
		private WebElement  section1Link3AddColleaguesToYourProject;
		
		@FindBy(xpath = "//a[contains(text(),'Add colleagues to your project')]/ancestor::span/following-sibling::strong")
		private WebElement  section1Link3AddColleaguesToYourProjectStatusOptional;
		
		
		/**
		 * Locators of section 2 (2.Build your RfI)
		 */
		
		@FindBy(xpath = "//span[text()='2. ' ]/..")
		private WebElement  section2TitleProjectAndcolleagues;

		@FindBy(xpath = "//a[contains(text(),'Build your RfI')]")
		private WebElement  section2Link1BuildYourRfI;
		
		@FindBy(xpath = "//a[contains(text(),'Build your RfI')]/ancestor::span/following-sibling::strong")
		private WebElement  section2Link1BuildYourRfIToDO;
		
		
		/**
		 * Locators of section 3 (3.Review and publish your RfI)
		 */
		
		@FindBy(xpath = "//span[text()='3. ' ]/..")
		private WebElement  section3TitleProjectAndcolleagues;
		
		//Link 1 Upload documents
		@FindBy(xpath = "//strong[contains(text(),'Upload documents')]")
		private WebElement  section3Link1UploadDocuments;
		
		//Link 1 Upload documents status
		@FindBy(xpath = "//strong[contains(text(),'Upload documents')]/ancestor::span/following-sibling::strong")
		private WebElement  section3Link1UploadDocumentsAndStatusCannotStartYet;
		
		
		//Link 2 See the suppliers who will receive your RfI
		@FindBy(xpath = "//strong[contains(text(),'See the suppliers who will receive your RfI')]")
		private WebElement  section3Link2SeeTheSuppliersWhoWillReceiveYourRfI;
		
		//Link 2 See the suppliers who will receive your RfI Status
		@FindBy(xpath = "//strong[contains(text(),'See the suppliers who will receive your RfI')]/ancestor::span/following-sibling::strong")
		private WebElement  section3Link2SeeTheSuppliersWhoWillReceiveYourRfIAndStatusCannotStartYet;	
		
		
		//Link 3 Your RfI timeline
		@FindBy(xpath = "//strong[contains(text(),'Your RfI timeline')]")
		private WebElement  section3Link3YourRfITimeline;
		
		//Link 3 Your RfI timeline Status
		@FindBy(xpath = "//strong[contains(text(),'Your RfI timeline')]/ancestor::span/following-sibling::strong")
		private WebElement  section3Link3YourRfITimelineAndStatusCannotStartYet;
				
				
		//Link 4 Review and publish your RfI
		@FindBy(xpath = "//strong[contains(text(),'Review and publish your RfI')]")
		private WebElement  section3Link4ReviewAndPublishYourRfI;
		
		//Link 4 Review and publish your RfI Status
		@FindBy(xpath = "//strong[contains(text(),'Review and publish your RfI')]/ancestor::span/following-sibling::strong")
		private WebElement  section3Link4ReviewAndPublishYourRfIStatusCannotStartYet;
				
		
		/**
		 * doPreMarketEngagementPageContent method validates the DoPreMarketEngagement page contents, Links & Status
		 * 
		 */
		public void doPreMarketEngagementPageContent() {

			waitForSeconds(1);

			String[] contentDetails = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("DoPreMarketEngagementPageContentButtonStatus").split("!");
			
			/**
			 * Section 1 (1.Project and colleagues) validation
			 */
			
			assertTrue(getText(section1TitleProjectAndcolleagues).equalsIgnoreCase(contentDetails[0]));
			
			//Section1 Link 1
			assertTrue(getText(section1Link1NameYourProject).equalsIgnoreCase(contentDetails[1]));
			
			//Section1 Link 1 Status
			assertTrue(getText(section1Link1NameYourProjectStatusOptional).equalsIgnoreCase(contentDetails[2]));
			
			
			//Section1 Link 2
			assertTrue(getText(section1Link2ChangeWhoIsGoingToLeadTheProcurement).equalsIgnoreCase(contentDetails[3]));
			
			//Section1 Link 2 Status
			assertTrue(getText(section1Link2ChangeWhoIsGoingToLeadTheProcurementStatusOptional).equalsIgnoreCase(contentDetails[4]));
			
			
			//Section1 Link 3
			assertTrue(getText(section1Link3AddColleaguesToYourProject).equalsIgnoreCase(contentDetails[5]));
			
			//Section1 Link 3 Status
			assertTrue(getText(section1Link3AddColleaguesToYourProjectStatusOptional).equalsIgnoreCase(contentDetails[6]));
			
			
			/**
			 * Section 2 (2.Build your RfI) validation
			 */
			
			assertTrue(getText(section2TitleProjectAndcolleagues).equalsIgnoreCase(contentDetails[7]));
			
			//Section2 Link 1
			assertTrue(getText(section2Link1BuildYourRfI).equalsIgnoreCase(contentDetails[8]));
			
			//Section2 Link 1 Status
			assertTrue(getText(section2Link1BuildYourRfIToDO).equalsIgnoreCase(contentDetails[9]));
		
			
			/**
			 * Section 3 (3.Review and publish your RfI) validation
			 */
			
			assertTrue(getText(section3TitleProjectAndcolleagues).equalsIgnoreCase(contentDetails[10]));
			
			//Section3 Link 1
			assertTrue(getText(section3Link1UploadDocuments).equalsIgnoreCase(contentDetails[11]));
			
			//Section3 Link 1 Status
			assertTrue(getText(section3Link1UploadDocumentsAndStatusCannotStartYet).equalsIgnoreCase(contentDetails[12]));
		
			
			//Section3 Link 2
			assertTrue(getText(section3Link2SeeTheSuppliersWhoWillReceiveYourRfI).equalsIgnoreCase(contentDetails[13]));
			
			//Section3 Link 2 Status
			assertTrue(getText(section3Link2SeeTheSuppliersWhoWillReceiveYourRfIAndStatusCannotStartYet).equalsIgnoreCase(contentDetails[14]));
		
			
			//Section3 Link 3
			assertTrue(getText(section3Link3YourRfITimeline).equalsIgnoreCase(contentDetails[15]));
			
			//Section3 Link 3 Status
			assertTrue(getText(section3Link3YourRfITimelineAndStatusCannotStartYet).equalsIgnoreCase(contentDetails[16]));
		
			
			//Section3 Link 4
			assertTrue(getText(section3Link4ReviewAndPublishYourRfI).equalsIgnoreCase(contentDetails[17]));
			
			//Section3 Link 4 Status
			assertTrue(getText(section3Link4ReviewAndPublishYourRfIStatusCannotStartYet).equalsIgnoreCase(contentDetails[18]));
			
			scenario.log("Buyer validated the DoPreMarketEngagement page contents");
			log.info("Buyer validated the DoPreMarketEngagement page contents");
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			
		}
		
		
		public void clickOnNameyourProjectLink() {
			
			clickElement(section1Link1NameYourProject);
			textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
			scenario.log("Buyer clicks on StartPreMarketEngagement Button");
			log.info("Buyer clicks on StartPreMarketEngagement Button");
		}
		
}
