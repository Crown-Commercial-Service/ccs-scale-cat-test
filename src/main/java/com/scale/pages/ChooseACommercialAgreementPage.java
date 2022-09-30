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
 * Class Login Page has extend the Actions class
 * 
 * @author 571154
 *
 */
public class ChooseACommercialAgreementPage extends Actions{
	
	/**
	 * Variables declaration
	 */
	TestContext textContext=new TestContext();
	ConfigurationReader configReader;
	private BrowserFactory browserFactory = new BrowserFactory();
	private PageObjectManager objectManager;
	
	/**
	 * Logger initialization
	 */
	private static final Logger log = LogManager.getLogger(ChooseACommercialAgreementPage.class);
	
	public ChooseACommercialAgreementPage(WebDriver driver, Scenario scenario) {
		super.driver = driver;
		this.scenario = scenario;
		configReader = new ConfigurationReader();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
	}
	
	/**
	 * ChooseACommercialAgreementPage Xpaths
	 */
	@FindBy(xpath = "//button[@id='accordion-default-heading-1']")
	private WebElement  digitalSpecialistRolesAndProgrammesRM626;

	@FindBy(xpath = "//a[contains(text(),'Lot 1: Digital Programmes')]")
	private WebElement  lot1DigitalProgrammes;

	@FindBy(xpath = "//a[contains(text(),'Lot 2: Digital Specialists')]")
	private WebElement  lot2DigitalSpecialists;

	@FindBy(xpath = "//a[contains(text(),'See available suppliers')]")
	private WebElement  leeAvailableSuppliers;

	@FindBy(xpath = "//body/div[5]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/button[1]")
	private WebElement openAll;

	@FindBy(xpath = "//body/div[5]/main[1]/div[2]/div[1]")
	private WebElement  closeAll;

	@FindBy(xpath = "//body/div[5]/main[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/dl[1]/dd[1]/p[2]/a[1]")
	private WebElement  suppliers11;


	/**
	 * This method select the lot provided in the excel
	 * @param lotType
	 * @param CommercialAgreementType
	 */
	public void selectCALot(String lotType, String CommercialAgreementType) {

		if (CommercialAgreementType.contains("Digital Specialists and Programmes (RM6263)")) {

			clickElement(digitalSpecialistRolesAndProgrammesRM626);
			String lotTypeString = TestContext.CommonTestDataMap.get(TestContext.TDID).get("ChooseAgreement_Lot");

			switch (lotTypeString) {

			case "Lot 1: Digital Programmes":

				waitForSeconds(1);
				textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
				clickElement(lot1DigitalProgrammes);
				scenario.log("Buyer has selected the 'Digital Specialists and Programmes (RM6263) - Lot 1: Digital Programmes' ");
				log.info("Buyer has selected the 'Digital Specialists and Programmes (RM6263) - Lot 1: Digital Programmes' ");

				break;

			case "Lot 2: Digital Specialists":

				waitForSeconds(1);
				textContext.takeSnapShot(configReader.get("allPageScreenshot"), scenario, driver);
				clickElement(lot2DigitalSpecialists);
				scenario.log("Buyer has selected the 'Digital Specialists and Programmes (RM6263) - Lot 2: Digital Specialists' ");
				log.info("Buyer has selected the 'Digital Specialists and Programmes (RM6263) - Lot 2: Digital Specialists' ");

			}

		} else {

			// MCF3 Commercial Agreement

		}

	}
}
