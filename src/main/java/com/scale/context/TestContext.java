package com.scale.context;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.JSONUtility;
import com.scale.framework.utility.PageObjectManager;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.util.List;

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
	}


	
	@After
	public void cleanUp() throws Exception {
		if (configReader.get("browserName").equalsIgnoreCase("chrome_profile")
				|| configReader.get("browserName").equalsIgnoreCase("CHROME_HEADLESS")) {
			browserFactory.deleteDirectory();
		}

		log.info("=================" + scenario.getName() + " execution ends" + "===================\n");

		if (driver != null) {
			takeSnapShot();
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

	public PageObjectManager getObjectManager() {
		return objectManager;
	}

	public WebDriver getDriver() {
		return this.driver;
	}
	public void scenarioWrite(String message) {
		this.scenario.log(message);
	}

	
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
	
	
	@Given("^User has environment setup for ([^\"]*)$")
	public void user_has_environment_setup_for(String scenarioID) {
	    scenarioContext.setContext(jsonUtilityObj.convertJSONtoMAP(scenarioID));
	    scenario.log("validating response when " + scenarioContext.getContext("scenarioID"));
	}

}
