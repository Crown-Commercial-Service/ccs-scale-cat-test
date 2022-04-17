package com.scale.framework.utility;

import com.scale.framework.utility.API.Auth;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	private WebDriver driver;
	private Scenario scenario;
	private TakeScreenShot tekeScreenShot;
		private Auth auth;
	
	public PageObjectManager(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
	}
	

	public TakeScreenShot getScreeShot() {
		return tekeScreenShot == null ? tekeScreenShot = new TakeScreenShot(driver,scenario) : tekeScreenShot;
	}
	
	//API
	/*public Auth getAuth() {
		return auth == null ? auth = new Auth(driver,scenario) : auth;
	}*/
	

	
}