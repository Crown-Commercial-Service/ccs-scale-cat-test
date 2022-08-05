package com.scale.context;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.JSONUtility;
import com.scale.framework.utility.PageObjectManager;
import com.scale.framework.utility.ReadExcelData;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to make all the before activity under tag "@before" i.e. making 
 * connection, creating the objects etc. 
 * 
 */
public class TestContext extends BrowserFactory {

	private static final Logger log = LogManager.getLogger(TestContext.class);
	private WebDriver driver;
	private BrowserFactory browserFactory;
	private PageObjectManager objectManager;
	public Scenario scenario;
	public ScenarioContext scenarioContext;
	private JSONUtility jsonUtilityObj;
	public List<String> navigationButtonList;
	public String allPageScreenshotFlag;
	public ConfigurationReader configReader;
	protected WebDriverWait wait;
	
	public static HashMap<String, String> ConfigData = GlobalContext.getGlobalInstance().getGlobalData();
	public static Map<String, Map<String, String>> OneFCTestDataMap = ReadExcelData.extractData("UI_Testdata.xlsx","OneFCFlowTestDataSanity");
	public static String TDID;
	
	/**
	 * This method execute before the steps and setups
	 * the connection for configReader, Screenshot.
	 * @param scenario
	 * @throws MalformedURLException
	 */
	@Before
	public void setUp(Scenario scenario) throws MalformedURLException {
		log.info("=================" + scenario.getName() + " execution starts" + "===================");
		this.scenario = scenario;
		scenarioContext = new ScenarioContext();
		jsonUtilityObj =new JSONUtility();
		configReader = new ConfigurationReader();
		allPageScreenshotFlag = configReader.get("allPageScreenshot");
		long threadId = Thread.currentThread().getId();
		String processName = ManagementFactory.getRuntimeMXBean().getName();
		log.info("Started in thread: " + threadId + ", in JVM: " + processName);
		//log.info("Successfully lunched the chrome browser");
		objectManager = new PageObjectManager(this.driver, scenario);
	}


	/**
	 * This method executes at the end of the steps
	 * and closes all the connections
	 * @throws Exception
	 */
	@After
	public void cleanUp() throws Exception {
		if (configReader.get("browserName").equalsIgnoreCase("chrome_profile")
				|| configReader.get("browserName").equalsIgnoreCase("CHROME_HEADLESS")) {
			browserFactory.deleteDirectory();
		}

		log.info("=================" + scenario.getName() + " execution ends" + "===================\n");

		if (driver != null) {
			//takeSnapShot();
			driver.quit();
			driver = null;
		}

		if (jsonUtilityObj != null) {
			jsonUtilityObj = null;
		}

		if (scenarioContext != null) {
			scenarioContext.clearContext();
		}

	}
	
	/**
	 * This method will return the Object of the class
	 * @return
	 */
	public PageObjectManager getObjectManager() {
		return objectManager;
	}

	/**
	 * This method will return the driver instance
	 * @return
	 */
	public WebDriver getDriver() {
		return this.driver;
	}
	public void scenarioWrite(String message) {
		this.scenario.log(message);
	}

	/**
	 * This methods takes the screenshots
	 */
	public void takeSnapShot() {
		// Code to take full page screenshot
		ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
		scenario.log("URL - " + driver.getCurrentUrl());
		PageSnapshot snapshot = Shutterbug.shootPage(driver, Capture.FULL_SCROLL, true);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");

		try {
			ImageIO.write(snapshot.getImage(), "png", imageStream);
			imageStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] source = imageStream.toByteArray();
		scenario.attach(source, "image/png","");
	}

	public JSONUtility getJsonUtilityObj() {
		return jsonUtilityObj;
	}
	
	/**
	 * This method is overloaded to full page take screen shot and call from any 
	 *  class when its required
	 * @param allPageScreenshotFlag allPageScreenshotFlag
	 * @param scenario Cucumber scenario
	 * @param driver Webdriver
	 * 
	 * 
	 */
	public void takeSnapShot(String allPageScreenshotFlag, Scenario scenario, WebDriver driver) {

		if (allPageScreenshotFlag.equalsIgnoreCase("true")) {

			// Code to take full page screenshot
			ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
			scenario.log("URL - " + driver.getCurrentUrl());
			PageSnapshot snapshot = Shutterbug.shootPage(driver, Capture.FULL_SCROLL, true);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");

			try {
				ImageIO.write(snapshot.getImage(), "png", imageStream);
				imageStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			byte[] source = imageStream.toByteArray();
			scenario.attach(source, "image/png", "");
		}

	}
	
	/**
	 * This stepdef setups the environment
	 * @param scenarioID
	 */
	@Given("^User has environment setup for ([^\"]*)$")
	public void user_has_environment_setup_for(String scenarioID) {
	    scenarioContext.setContext(jsonUtilityObj.convertJSONtoMAP(scenarioID));
	    scenario.log("validating response when " + scenarioContext.getContext("scenarioID"));
	}
	
	
	/**
	 * This stepdef launches the URL
	 */
	@Given("Active or Registered buyer launches CAS application landing page of the {string}")
	public void active_or_Registered_buyer_launches_CAS_application_landing_page_of_the(String TDID) {
		
		try {
			TestContext.TDID=TDID;
			
			this.driver = initiateDriver(configReader.getBrowserName(),scenario);
			launchURL(configReader.get("CASURL"));
			
			objectManager = new PageObjectManager(this.driver, scenario);
			assertTrue("Successfully launched the CAS application landing page",true);
			log.info("Successfully launched the CAS application landing page");
			//objectManager.getLoginPage().login();
			
		} catch (MalformedURLException e) {
			
			assertFalse("Unable to launched the CAS application landing page",false);
			log.info("Unable to launched the CAS application landing page");
		}
	}

	
	
	/**
	 * This stepdef launches the URL
	 */
	@Given("Active or Registered buyer launches CAS application landing page")
	public void active_or_registered_buyer_launches_cas_application_landing_page() {
		
		try {
			this.driver = initiateDriver(configReader.getBrowserName(),scenario);
			launchURL(configReader.get("CASURL"));
			
			objectManager = new PageObjectManager(this.driver, scenario);
			assertTrue("Successfully launched the CAS application landing page",true);
			log.info("Successfully launched the CAS application landing page");
			//objectManager.getLoginPage().login();
			
		} catch (MalformedURLException e) {
			
			assertFalse("Unable to launched the CAS application landing page",false);
			log.info("Unable to launched the CAS application landing page");
		}
		
	}
	

}
