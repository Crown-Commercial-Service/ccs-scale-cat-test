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
import com.scale.framework.utility.ConfigurationReader;
import io.cucumber.java.Scenario;

/**
 * Class Login Page has extend the Actions class
 * 
 * @author 571154
 *
 */
public class LoginPage extends Actions {

	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(LoginPage.class);

	/**
	 * Login Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public LoginPage(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		textContext = new TestContext();
	}

	
	/**
	 * LoginPage Xpaths
	 */

	@FindBy(xpath = "//button[contains(text(),'Accept additional cookies')]")
	private WebElement acceptAllCookies;

	@FindBy(xpath = "//input[contains(@id,'email')]")
	private WebElement userName;

	@FindBy(xpath = "//input[contains(@id,'password')]")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInBtn;

	
	/**
	 * This method clicks on AcceptAllCookies button, & SignIn link & Enters Values
	 * in UserName and Password text field
	 * 
	 * @param UserName
	 * @param Password
	 */
	public void loginByuerUi(String UserName, String Password) {
		clickElement(acceptAllCookies);
		waitForSeconds(1);
		//clickByLinkText(signIn);
		waitForSeconds(1);
		enterText(userName, UserName);
		enterText(password, Password);
		waitForSeconds(1);
		scenario.log("User entered the UserName and Password");
		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		log.info("Enter the UserName and Password");
	}

	/**
	 * This method clicks on SignIn button
	 */
	public void clickOnSignInButton() {

		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
		clickElement(signInBtn);
		scenario.log("Buyer clicks on Sign In button");
		log.info("Buyer clicks on SignIn Button");
		waitForSeconds(1);
	}

}
