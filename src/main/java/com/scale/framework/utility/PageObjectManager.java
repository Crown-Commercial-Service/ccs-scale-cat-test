package com.scale.framework.utility;

import com.scale.framework.utility.API.Auth;
import com.scale.pages.ChooseACommercialAgreementPage;
import com.scale.pages.CommonToAllPage;
import com.scale.pages.DashboardPage;
import com.scale.pages.LoginPage;
import com.scale.pages.ProcurementOverviewPage;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	private WebDriver driver;
	private Scenario scenario;
	private TakeScreenShot tekeScreenShot;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private ChooseACommercialAgreementPage chooseACommercialAgreementPage;
	private ProcurementOverviewPage procurementOverviewPage;
	private CommonToAllPage commonToAllPage;
	private Auth auth;
	
	public PageObjectManager(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
	}
	
	public TakeScreenShot getScreeShot() {
		return tekeScreenShot == null ? tekeScreenShot = new TakeScreenShot(driver,scenario) : tekeScreenShot;
	}
	
	public LoginPage getLoginPage() {
		return loginPage == null ? loginPage = new LoginPage(driver,scenario) : loginPage;
	}
	
	public DashboardPage getDashboard() {
		return dashboardPage == null ? dashboardPage = new DashboardPage(driver,scenario) : dashboardPage;
	}
	
	public ChooseACommercialAgreementPage getChooseACommercialAgreementPage() {
		return chooseACommercialAgreementPage == null ? chooseACommercialAgreementPage = new ChooseACommercialAgreementPage(driver,scenario) : chooseACommercialAgreementPage;
	}

	public ProcurementOverviewPage getProcurementOverviewPage() {
		return procurementOverviewPage == null ? procurementOverviewPage = new ProcurementOverviewPage(driver,scenario) : procurementOverviewPage;
	}
	
	public CommonToAllPage getcommonToAllPage() {
		return commonToAllPage == null ? commonToAllPage = new CommonToAllPage(driver,scenario) : commonToAllPage;
	}
	
	
	
	
	//API
	/*public Auth getAuth() {
		return auth == null ? auth = new Auth(driver,scenario) : auth;
	}*/
	

	
}