package com.scale.framework.utility;

import com.scale.framework.utility.API.Auth;
import com.scale.pages.*;
import com.scale.pages.RFI.DoPreMarketEngagementPage;

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
	private DoPreMarketEngagementPage doPreMarketEngagement;
	private ChooseHowToFindASupplier chooseHowToFindASupplier;
	private WriteAndPublishYourRequirements writeAndPublishYourRequirements;
	private ChooseRoles chooseRoles;
	private SecurityVetting securityVetting;
	private SkillCapability skillCapability;
	private Location location;
	private AssessmentCriteria assessmentCriteria;
	private QualityPriceWeighting qualityPriceWeighting;
	private QualityWeighting qualityWeighting;
	private TechnicalQuestions technicalQuestions;
	private CulturalFitQuestions culturalFitQuestions;
	private SocialValueQuestions socialValueQuestions;
	private ScoringCriteria scoringCriteria;
	private ReviewandPublish reviewandPublish;
	private FCPublished fcPublished;

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
	
	public DoPreMarketEngagementPage getDoPreMarketEngagementPage() {
		return doPreMarketEngagement == null ? doPreMarketEngagement = new DoPreMarketEngagementPage(driver,scenario) : doPreMarketEngagement;
	}
	
	public ChooseHowToFindASupplier getChooseHowToFindASupplier() {
		return chooseHowToFindASupplier == null ? chooseHowToFindASupplier = new ChooseHowToFindASupplier(driver,scenario) : chooseHowToFindASupplier;
	}

	public WriteAndPublishYourRequirements getWriteAndPublishYourRequirements() {
		return writeAndPublishYourRequirements == null ? writeAndPublishYourRequirements = new WriteAndPublishYourRequirements(driver,scenario) : writeAndPublishYourRequirements;
	}

	public ChooseRoles getChooseRoleObj() {
		return chooseRoles == null ? chooseRoles = new ChooseRoles(driver,scenario) : chooseRoles;
	}

	public SecurityVetting getSecurityVettingObj() {
		return securityVetting == null ? securityVetting = new SecurityVetting(driver,scenario) : securityVetting;
	}

	public SkillCapability getSkillCapabilityObj() {
		return skillCapability == null ? skillCapability = new SkillCapability(driver,scenario) : skillCapability;
	}
	public Location getLocationObj() {
		return location == null ? location = new Location(driver,scenario) : location;
	}
	public AssessmentCriteria getAssessmentCriteriaObj() {
		return assessmentCriteria == null ? assessmentCriteria = new AssessmentCriteria(driver,scenario) : assessmentCriteria;
	}

	public QualityPriceWeighting getQualityPriceWeightingObj() {
		return qualityPriceWeighting == null ? qualityPriceWeighting = new QualityPriceWeighting(driver,scenario) : qualityPriceWeighting;
	}
	public QualityWeighting getQualityWeightingObj() {
		return qualityWeighting == null ? qualityWeighting = new QualityWeighting(driver,scenario) : qualityWeighting;
	}
	public TechnicalQuestions getTechnicalQuestionsObj() {
		return technicalQuestions == null ? technicalQuestions = new TechnicalQuestions(driver,scenario) : technicalQuestions;
	}
	public CulturalFitQuestions getCulturalFitQuestionsObj() {
		return culturalFitQuestions == null ? culturalFitQuestions = new CulturalFitQuestions(driver,scenario) : culturalFitQuestions;
	}
	public SocialValueQuestions getSocialValueQuestionsObj() {
		return socialValueQuestions == null ? socialValueQuestions = new SocialValueQuestions(driver,scenario) : socialValueQuestions;
	}
	public ScoringCriteria getScoringCriteriaObj() {
		return scoringCriteria == null ? scoringCriteria = new ScoringCriteria(driver,scenario) : scoringCriteria;
	}
	public ReviewandPublish getReviewandPublishObj() {
		return reviewandPublish == null ? reviewandPublish = new ReviewandPublish(driver,scenario) : reviewandPublish;
	}
	public FCPublished getFCPublishedObj() {
		return fcPublished == null ? fcPublished = new FCPublished(driver,scenario) : fcPublished;
	}

}