package com.scale.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

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
 * Class HowLongTheProjectWillLast Page has extend the Actions class
 * This class contains all the method related to HowLongTheProjectWillLast
 * page
 * 
 * @author 571154
 *
 */
public class HowLongTheProjectWillLast extends Actions {
	
	/**
	 * Variables declaration
	 */
	TestContext textContext;
	ConfigurationReader configReader;
	private String signIn = "Sign in";
	private static final Logger log = LogManager.getLogger(HowLongTheProjectWillLast.class);

	/**
	 * HowLongTheProjectWillLast Page constructor has overloaded
	 * 
	 * @param driver
	 * @param scenario
	 */
	public HowLongTheProjectWillLast(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		textContext = new TestContext();
	}

	
	/**
	 * HowLongTheProjectWillLast page Xpaths
	 */
	
	@FindBy(xpath = "//legend[contains(text(),'Enter the date you want the project to start')]/following-sibling::div/div[2]/div/div/div/label[contains(text(),'Day')]/following-sibling::input")
	private WebElement  projectToStartDayTextBox;
	
	@FindBy(xpath = "//legend[contains(text(),'Enter the date you want the project to start')]/following-sibling::div/div[2]/div/div/div/label[contains(text(),'Month')]/following-sibling::input")
	private WebElement  projectToStartMonthTextBox;
	
	@FindBy(xpath = "//legend[contains(text(),'Enter the date you want the project to start')]/following-sibling::div/div[2]/div/div/div/label[contains(text(),'Year')]/following-sibling::input")
	private WebElement  projectToStartYearTextBox;
	
	
	@FindBy(xpath = "//legend[contains(text(),'Enter how long you think the project will run for  (Optional)')]/../div[2]/div/div/div/label[contains(text(),'Years')]/following-sibling::input")
	private WebElement  howLongProjectWillRunYearsTextBox;
	
	@FindBy(xpath = "//legend[contains(text(),'Enter how long you think the project will run for  (Optional)')]/../div[2]/div/div/div/label[contains(text(),'Month')]/following-sibling::input")
	private WebElement  howLongProjectWillRunMonthTextBox;
	
	@FindBy(xpath = "//legend[contains(text(),'Enter how long you think the project will run for  (Optional)')]/../div[2]/div/div/div/label[contains(text(),'Days')]/following-sibling::input")
	private WebElement  howLongProjectWillRunDayTextBox;
	
	
	@FindBy(xpath = "//legend[contains(text(),'Any extension period you wish to include (Optional)')]/../div[2]/div/div/div/label[contains(text(),'Years')]/following-sibling::input")
	private WebElement  extensionPeriodYearsTextBox;
	
	@FindBy(xpath = "//legend[contains(text(),'Any extension period you wish to include (Optional)')]/../div[2]/div/div/div/label[contains(text(),'Month')]/following-sibling::input")
	private WebElement  extensionPeriodMonthTextBox;

	@FindBy(xpath = "//legend[contains(text(),'Any extension period you wish to include (Optional)')]/../div[2]/div/div/div/label[contains(text(),'Days')]/following-sibling::input")
	private WebElement  extensionPeriodDaysTextBox;
	
	
	
	/**
	 * This method enters the date in "Enter the date you want the project to start"
	 * "Enter how long you think the project will run for (Optional)" &
	 * "Any extension period you wish to include (Optional)" text boxes
	 */
	public void enterDates() {
		
		Date date = Calendar.getInstance().getTime();
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat dateFormatDay = new SimpleDateFormat("dd"); 
        String strDay = dateFormatDay.format(date);
        System.out.println("Current Day: " + strDay); 
        
        
        if(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S17_ProjectToStartDate").equalsIgnoreCase("YES")) {
        	
        		Calendar c = Calendar.getInstance();
                int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            	c.add(Calendar.DATE, 1);
                String plus1day = dateFormat.format(c.getTime());
                
                String[] splitDate = plus1day.split("/");
                
                /**
                 * Entering the the date+1 in the "Enter the date you want the project to start"
                 */
                enterText(projectToStartDayTextBox,splitDate[1]);
            	enterText(projectToStartMonthTextBox,splitDate[0]);
            	enterText(projectToStartYearTextBox,splitDate[2]);
            	
            	scenario.log("Buyer Entered the date "+ plus1day + " in 'Enter the date you want the project to start' ");
        		log.info("Buyer Entered the date "+ plus1day + " in 'Enter the date you want the project to start' ");
        		waitForSeconds(1);
        	
        	  	/**
                 * Entering the the date in the "Enter how long you think the project will run for (Optional)"
                 * if its given in the excel sheet
                 */
            	if(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S17_HowLongProjectWillRunOptnalDate").equalsIgnoreCase("NO")) {
            		
            		scenario.log("Buyer has not entered any date in 'Enter how long you think the project will run for (Optional)' ");
            		log.info("Buyer has not entered any date in 'Enter how long you think the project will run for (Optional)' ");
            	
            	}else {
            		
            		String howLongProjectWillRunDate = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S17_HowLongProjectWillRunOptnalDate");
            		enterText(howLongProjectWillRunYearsTextBox,howLongProjectWillRunDate.split("/")[0]);
                	enterText(howLongProjectWillRunMonthTextBox,howLongProjectWillRunDate.split("/")[1]);
                	enterText(howLongProjectWillRunDayTextBox,howLongProjectWillRunDate.split("/")[2]);
                	
                	scenario.log("Buyer Entered the date "+ howLongProjectWillRunDate + " in 'Enter how long you think the project will run for (Optional)' ");
            		log.info("Buyer Entered the date "+ howLongProjectWillRunDate + " in 'Enter how long you think the project will run for (Optional)' ");
            	
            	}
            		
            	
            	/**
                 * Entering the the date in the "Any extension period you wish to include (Optional)"
                 * if its given in the excel sheet
                 */
            	if(TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S17_ExtensionPeriodOptnalDate").equalsIgnoreCase("NO")) {
            		
            		scenario.log("Buyer has not entered any date in 'Any extension period you wish to include (Optional)' ");
            		log.info("Buyer has not entered any date in 'Any extension period you wish to include (Optional)' ");
            	
            	}else {
            		
            		String howLongProjectWillRunDate = TestContext.OneFCTestDataMap.get(TestContext.TDID).get("S17_ExtensionPeriodOptnalDate");
            		enterText(extensionPeriodYearsTextBox,howLongProjectWillRunDate.split("/")[0]);
                	enterText(extensionPeriodMonthTextBox,howLongProjectWillRunDate.split("/")[1]);
                	enterText(extensionPeriodDaysTextBox,howLongProjectWillRunDate.split("/")[2]);
                	
                	scenario.log("Buyer Entered the date "+ howLongProjectWillRunDate + " in 'Any extension period you wish to include (Optional)' ");
            		log.info("Buyer Entered the date "+ howLongProjectWillRunDate + " in 'Any extension period you wish to include (Optional)' ");
            	
            	}
            		
            	textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
       	
        }else
        {
        	scenario.log("Buyer has not entered any dates");
    		log.info("Buyer has not entered any dates");
    		textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
        }
   	
	}

}
