package com.scale.framework.utility;


import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.scale.context.TestContext;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserFactory {
	Scenario scenario;
	private Logger log = LogManager.getLogger(BrowserFactory.class);
	private WebDriver driver;
	private ConfigurationReader configReader;
	public static final String URL = "";
	String destination = null;
	DesiredCapabilities caps = null;
	public static final String USERNAME = "";
	public static final String AUTOMATE_KEY = "";
	public static final String browserStackURL = "https://" + USERNAME + ":" + AUTOMATE_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	HashMap<String, Object> browserstackOptions = new HashMap<>();
	HashMap<String, String> bsLocalArgs = new HashMap<>();
	

	public WebDriver initiateDriver(String browserName, Scenario scenario) throws MalformedURLException {
		configReader = new ConfigurationReader();
		log.info("Opening " + browserName + "browser");
		this.scenario = scenario;

		switch (browserName.toUpperCase()) {
			case "FIREFOX":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			case "CHROME":
				WebDriverManager.chromedriver().setup();
				ChromeOptions option = new ChromeOptions();
				//option.addArguments("--ignore-certificate-errors");
				//option.addArguments("--ignore-ssl-errors=yes");
				driver = new ChromeDriver(option);
				driver.manage().window().maximize();
				log.info("Open the Chrome Browser");
				break;
			case "IE":
				WebDriverManager.iedriver().setup();
				InternetExplorerOptions ieOptions = new InternetExplorerOptions();
				ieOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				ieOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				ieOptions.setCapability("ignoreZoomSetting", true);
				ieOptions.setCapability("ignoreProtectedModeSettings", true);
				driver = new InternetExplorerDriver(ieOptions);
				driver.manage().window().maximize();
				break;
			case "EDGE":
				WebDriverManager.edgedriver().setup();
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				//EdgeDriverService service = EdgeDriverService.createDefaultService();
				driver = new EdgeDriver(edgeOptions);
				driver.manage().window().maximize();
				break;
			case "SAFARI":
				driver = new SafariDriver();
				driver.manage().window().maximize();
				break;
			case "GRID_FIREFOX":
				FirefoxOptions ffOptions = new FirefoxOptions();
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), ffOptions);
				break;
			case "GRID_CHROME":
				ChromeOptions chromeOptions = new ChromeOptions();
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
				break;
			case "CHROME_HEADLESS":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox");
				options.addArguments("--headless");
				options.setExperimentalOption("useAutomationExtension", false);
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("window-size=1920,1080");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				break;

			// ********************* BROWSERSTACK WINDOWS *********************************

			case "BROWSERSTACK_WIN_CHROME":
				bsLocalArgs.put("key", AUTOMATE_KEY);
				caps = new DesiredCapabilities();
				// Windows
				// BS Windows CHROME
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "latest");
				caps.setCapability("resolution", "1280x800");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.14.0");

				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				log.info("Open the Chrome Browser");

				caps.setCapability("name", scenario.getName());
				caps.acceptInsecureCerts();
				caps.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(browserStackURL), caps);
				break;

			case "BROWSERSTACK_WIN_IE":
				bsLocalArgs.put("key", AUTOMATE_KEY);
				caps = new DesiredCapabilities();
				// BS Windows IE
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "IE");
				caps.setCapability("browser_version", "11.0");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.5.2");

				caps.setCapability("bstack:options", browserstackOptions);
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				caps.setCapability("name", scenario.getName());
				caps.acceptInsecureCerts();
				caps.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(browserStackURL), caps);
				break;

			case "BROWSERSTACK_WIN_EDGE":
				bsLocalArgs.put("key", AUTOMATE_KEY);
				caps = new DesiredCapabilities();
				// BS Windows EDGE
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Edge");
				caps.setCapability("browser_version", "latest");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.5.2");

				caps.setCapability("bstack:options", browserstackOptions);
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				caps.setCapability("name", scenario.getName());
				caps.acceptInsecureCerts();
				caps.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(browserStackURL), caps);
				break;

			case "BROWSERSTACK_WIN_FIREFOX":
				bsLocalArgs.put("key", AUTOMATE_KEY);
				caps = new DesiredCapabilities();
				// BS Windows FIREFOX
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "latest");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.10.0");

				caps.setCapability("bstack:options", browserstackOptions);
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				caps.setCapability("name", scenario.getName());
				caps.acceptInsecureCerts();
				caps.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(browserStackURL), caps);
				break;

			// ********************* BROWSERSTACK MAC *********************************

			case "BROWSERSTACK_MAC_SAFARI":
				bsLocalArgs.put("key", AUTOMATE_KEY);
				caps = new DesiredCapabilities();
				// BS MAC SAFARI (Mojave)
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Catalina");
				caps.setCapability("browser", "Safari");
				caps.setCapability("browser_version", "13.1");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.14.0");

				caps.setCapability("bstack:options", browserstackOptions);
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				caps.setCapability("name", scenario.getName());
				caps.acceptInsecureCerts();
				caps.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(browserStackURL), caps);
				break;

			case "BROWSERSTACK_MAC_CHROME":
				bsLocalArgs.put("key", AUTOMATE_KEY);
				caps = new DesiredCapabilities();
				// BS MAC CHROME (Catalin)
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Catalina");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "latest");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.14.0");

				caps.setCapability("name", scenario.getName());
				caps.acceptInsecureCerts();
				caps.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(browserStackURL), caps);
				break;

			case "BROWSERSTACK_MAC_FIREFOX":
				bsLocalArgs.put("key", AUTOMATE_KEY);
				caps = new DesiredCapabilities();
				// BS MAC FIREFOX (Catalin)
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "Catalina");
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "latest");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.10.0");

				caps.setCapability("bstack:options", browserstackOptions);
				caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				caps.setCapability("name", scenario.getName());
				caps.acceptInsecureCerts();
				caps.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(browserStackURL), caps);
				break;

			// ************ BROWSERSTACK ANDROID ***********************************

			case "BROWSERSTACK_ANDROID_CHROME":
				bsLocalArgs.put("key", AUTOMATE_KEY);
				caps = new DesiredCapabilities();
				// BS ANDROID CHROME
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "11.0");
				caps.setCapability("os_version", "11.0");
				caps.setCapability("device", "Samsung Galaxy S21");
				caps.setCapability("real_mobile", "true");
				caps.setCapability("browserstack.local", "false");

				caps.setCapability("name", scenario.getName());
				caps.acceptInsecureCerts();
				caps.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(browserStackURL), caps);
				break;

			case "BROWSERSTACK_ANDROID_SAMSUNG_INTERNET":

				break;

			// ********************* IOS ******************************

			case "BROWSERSTACK_IOS_CHROME":
				// BS IOS CHROME
				bsLocalArgs.put("key", AUTOMATE_KEY);
				caps = new DesiredCapabilities();
				// Iphone12
				caps.setCapability("browser", "Chrome");
				caps.setCapability("os_version", "14");
				caps.setCapability("device", "iPhone 12");
				caps.setCapability("real_mobile", "true");
				caps.setCapability("browserstack.local", "false");

				caps.setCapability("name", scenario.getName());
				caps.acceptInsecureCerts();
				caps.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(browserStackURL), caps);
				break;

			case "BROWSERSTACK_IOS_SAFARI":
				// BS IOS SAFARI
				bsLocalArgs.put("key", AUTOMATE_KEY);
				caps = new DesiredCapabilities();
				// Iphone12
				caps.setCapability("browser", "Safari");
				caps.setCapability("os_version", "14");
				caps.setCapability("device", "iPhone 12");
				caps.setCapability("real_mobile", "true");
				caps.setCapability("browserstack.local", "false");

				caps.setCapability("name", scenario.getName());
				caps.acceptInsecureCerts();
				caps.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(browserStackURL), caps);
				break;

		}
		return driver;
	}

	public void launchURL(String url) {
		TestContext textContext=new TestContext();
		// driver.get(url);
		driver.navigate().to(url);
		log.info(URL + " launched");
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		
	}

	public void launchURL(String portalName, String portalExtension) {
		driver.get(configReader.get(portalName) + portalExtension);
		log.info(URL + " launched");
	}

	public static String randomString(int count) {
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	public static void copyFiles(String source, String destination) {
		File src = new File(source);
		File dest = new File(destination);
		try {
			FileUtils.copyDirectory(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteDirectory() {
		try {
			if (!destination.isEmpty() || !destination.equalsIgnoreCase("")) {
				FileUtils.deleteDirectory(new File(destination));
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public void launchURL() {
		driver.get(configReader.getApplicationURL());
	}
}