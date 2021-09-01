package com.scale.context;

import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.scale.framework.utility.BrowserFactory;
import com.scale.framework.utility.ConfigurationReader;
import com.scale.framework.utility.JSONUtility;
import com.scale.framework.utility.Log;
import com.scale.framework.utility.PageObjectManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.util.List;


public class TestContext extends BrowserFactory {

	private Logger log = Log.getLogger(TestContext.class);
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
		this.scenario.write(message);
	}

	
	public void takeSnapShot() {
		// Code to take full page screenshot
		ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
		scenario.write("URL - " + driver.getCurrentUrl());
		PageSnapshot snapshot = Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS, true);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");

		try {
			ImageIO.write(snapshot.getImage(), "png", imageStream);
			imageStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] source = imageStream.toByteArray();
		scenario.embed(source, "image/png");
	}

	public JSONUtility getJsonUtilityObj() {
		return jsonUtilityObj;
	}
	
	
	
	@Given("^User has environment setup for ([^\"]*)$")
	public void user_has_environment_setup_for(String scenarioID) throws Throwable {
	    scenarioContext.setContext(jsonUtilityObj.convertJSONtoMAP(scenarioID));
	    scenario.write("validating response when " + scenarioContext.getContext("scenarioID"));
	}

}
