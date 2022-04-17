package com.scale.framework.utility;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TakeScreenShot extends Actions {
	private WebDriver driver;

	public TakeScreenShot(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}

	//@AfterStep
	public void takeSnapShot1() {
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
	
	
	public void screenShot() throws IOException {
	    File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    File dest= new File("filPath/screenshot_"+timestamp()+".png");
	    FileUtils.copyFile(scr, dest);
	}

	public String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
}
