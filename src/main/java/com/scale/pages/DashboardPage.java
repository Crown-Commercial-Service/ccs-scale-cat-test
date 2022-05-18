package com.scale.pages;

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

/**
 * Class DashboardPage has extend the Actions class
 * 
 * @author 571154
 *
 */
public class DashboardPage extends Actions {

	/**
	 * Object creation
	 */
	TestContext textContext = new TestContext();
	private BrowserFactory browserFactory = new BrowserFactory();

	/**
	 * Variables declaration
	 */
	ConfigurationReader configReader;
	private PageObjectManager objectManager;
	private static final Logger log = LogManager.getLogger(LoginPage.class);

	/**
	 * DashboardPage constructor overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public DashboardPage(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	/**
	 * Dashboard page Xpaths
	 */
	@FindBy(xpath = "//a[contains(text(),'Start a new Project')]")
	private WebElement startANewProject;

	@FindBy(xpath = "//a[@id='active-data-next']")
	private WebElement next;

	@FindBy(xpath = "//a[contains(text(),'Digital Specialists and Programmes')]")
	private WebElement digitalSpeciaListsAndProgrammes;

	@FindBy(xpath = "//a[contains(text(),'Management Consultancy Framework Three (MCF3)')]")
	private WebElement managementConsultancyFrameworkThreeMCF3;

	/**
	 * This method clicks on "StarANewProject" Link
	 */
	public void clickOnStarANewProject() {

		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		clickElement(startANewProject);
		scenario.log("Buyer clicks on 'Star a new Project' link");
		log.info("Buyer clicks on 'Star a new Project' link");
		waitForSeconds(1);
	}

}
