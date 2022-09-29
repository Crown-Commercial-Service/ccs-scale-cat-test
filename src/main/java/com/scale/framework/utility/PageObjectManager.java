package com.scale.framework.utility;


import com.scale.framework.utility.API.Auth;

import com.scale.pages.AboutAddingContextAndRequirements;
import com.scale.pages.AddAnyPerformanceIncentives;
import com.scale.pages.AddBackgroundToYourProcurement;
import com.scale.pages.AddContextToYour1FC;
import com.scale.pages.AddYourServiceLevelsAndKPIs;
import com.scale.pages.ChooseACommercialAgreementPage;
import com.scale.pages.ChooseHowToFindASupplier;
import com.scale.pages.ChooseIfThisIsNewReplacementOrExpanded;
import com.scale.pages.CommonToAllPage;
import com.scale.pages.ConfirmIfYouNeedAContractedOutService;
import com.scale.pages.DashboardPage;

import com.scale.pages.EnterYourProjectRequirements;
import com.scale.pages.HowLongTheProjectWillLast;
import com.scale.pages.LoginPage;
import com.scale.pages.ManagementInformationAndReporting;
import com.scale.pages.ProcurementOverviewPage;
import com.scale.pages.TellUsIfThereIsAnExistingSupplier;
import com.scale.pages.UploadPricingSchedulesAndOtherDocuments;
import com.scale.pages.UploadYourPricingSchedule;
import com.scale.pages.WhichPhaseTheProjectIsIn;
import com.scale.pages.WhichPhasesTheProjectNeedResource;
import com.scale.pages.WriteAndPublishYourRequirements;

import com.scale.pages.*;
import com.scale.pages.FCA.*;
import com.scale.pages.ONE_FC.*;
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

	private UploadYourPricingSchedule uploadYourPricingSchedule;
	private UploadPricingSchedulesAndOtherDocuments uploadPricingSchedulesAndOtherDocuments;
	private ConfirmIfYouNeedAContractedOutService confirmIfYouNeedAContractedOutService;
	private AddContextToYour1FC addContextToYour1FC;
	private AboutAddingContextAndRequirements aboutAddingContextAndRequirements;
	private AddBackgroundToYourProcurement addBackgroundToYourProcurement;
	private WhichPhaseTheProjectIsIn whichPhaseTheProjectIsIn;
	private WhichPhasesTheProjectNeedResource whichPhasesTheProjectNeedResource;
	private HowLongTheProjectWillLast howLongTheProjectWillLast;
	private TheBusinessProblem theBusinessProblem;
	private ChooseIfThisIsNewReplacementOrExpanded chooseIfThisIsNewReplacementOrExpanded;
	private TellUsIfThereIsAnExistingSupplier tellUsIfThereIsAnExistingSupplier;
	private ManagementInformationAndReporting managementInformationAndReporting;
	private AddYourServiceLevelsAndKPIs addYourServiceLevelsAndKPIs;
	private AddAnyPerformanceIncentives addAnyPerformanceIncentives;
	private EnterYourProjectRequirements enterYourProjectRequirements;
	
	

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
	private EnterWeightings enterWeightings;
	private GrowthScale growthScale;
	private NextSteps nextSteps;
	private NumberofSuppliers numberofSuppliers;
	private ResourcesAndWeightings resourcesAndWeightings;
	private ReviewSuitableSuppliers reviewSuitableSuppliers;
	private FCASecurityVetting fcaSecurityVetting;
	private ServiceCapabilities serviceCapabilities;
	private Subcontractors subcontractors;



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

	
	
	public UploadYourPricingSchedule getUploadYourPricingSchedule() {
		return uploadYourPricingSchedule == null ? uploadYourPricingSchedule = new UploadYourPricingSchedule(driver,scenario) : uploadYourPricingSchedule;
	}
	
	public UploadPricingSchedulesAndOtherDocuments getUploadPricingSchedulesAndOtherDocuments() {
		return uploadPricingSchedulesAndOtherDocuments == null ? uploadPricingSchedulesAndOtherDocuments = new UploadPricingSchedulesAndOtherDocuments(driver,scenario) : uploadPricingSchedulesAndOtherDocuments;
	}
	
	public ConfirmIfYouNeedAContractedOutService getConfirmIfYouNeedAContractedOutService() {
		return confirmIfYouNeedAContractedOutService == null ? confirmIfYouNeedAContractedOutService = new ConfirmIfYouNeedAContractedOutService(driver,scenario) : confirmIfYouNeedAContractedOutService;
	}
	
	public AddContextToYour1FC getAddContextToYour1FC() {
		return addContextToYour1FC == null ? addContextToYour1FC = new AddContextToYour1FC(driver,scenario) : addContextToYour1FC;
	}
	
	public AboutAddingContextAndRequirements getAboutAddingContextAndRequirements() {
		return aboutAddingContextAndRequirements == null ? aboutAddingContextAndRequirements = new AboutAddingContextAndRequirements(driver,scenario) : aboutAddingContextAndRequirements;
	}
	
	public AddBackgroundToYourProcurement getAddBackgroundToYourProcurement() {
		return addBackgroundToYourProcurement == null ? addBackgroundToYourProcurement = new AddBackgroundToYourProcurement(driver,scenario) : addBackgroundToYourProcurement;
	}
	
	public WhichPhaseTheProjectIsIn getWhichPhaseTheProjectIsIn() {
		return whichPhaseTheProjectIsIn == null ? whichPhaseTheProjectIsIn = new WhichPhaseTheProjectIsIn(driver,scenario) : whichPhaseTheProjectIsIn;
	}
	
	public WhichPhasesTheProjectNeedResource getWhichPhasesTheProjectNeedResource() {
		return whichPhasesTheProjectNeedResource == null ? whichPhasesTheProjectNeedResource = new WhichPhasesTheProjectNeedResource(driver,scenario) : whichPhasesTheProjectNeedResource;
	}
	
	public HowLongTheProjectWillLast getHowLongTheProjectWillLast() {
		return howLongTheProjectWillLast == null ? howLongTheProjectWillLast = new HowLongTheProjectWillLast(driver,scenario) : howLongTheProjectWillLast;
	}
	
	public TheBusinessProblem getTheBusinessProblem() {
		return theBusinessProblem == null ? theBusinessProblem = new TheBusinessProblem(driver,scenario) : theBusinessProblem;
	}
	
	public ChooseIfThisIsNewReplacementOrExpanded getChooseIfThisIsNewReplacementOrExpanded() {
		return chooseIfThisIsNewReplacementOrExpanded == null ? chooseIfThisIsNewReplacementOrExpanded = new ChooseIfThisIsNewReplacementOrExpanded(driver,scenario) : chooseIfThisIsNewReplacementOrExpanded;
	}
	
	public TellUsIfThereIsAnExistingSupplier getTellUsIfThereIsAnExistingSupplier() {
		return tellUsIfThereIsAnExistingSupplier == null ? tellUsIfThereIsAnExistingSupplier = new TellUsIfThereIsAnExistingSupplier(driver,scenario) : tellUsIfThereIsAnExistingSupplier;
	}
	
	public ManagementInformationAndReporting getManagementInformationAndReporting() {
		return managementInformationAndReporting == null ? managementInformationAndReporting = new ManagementInformationAndReporting(driver,scenario) : managementInformationAndReporting;
	}
	
	public AddYourServiceLevelsAndKPIs getAddYourServiceLevelsAndKPIs() {
		return addYourServiceLevelsAndKPIs == null ? addYourServiceLevelsAndKPIs = new AddYourServiceLevelsAndKPIs(driver,scenario) : addYourServiceLevelsAndKPIs;
	}
	
	public AddAnyPerformanceIncentives getAddAnyPerformanceIncentives() {
		return addAnyPerformanceIncentives == null ? addAnyPerformanceIncentives = new AddAnyPerformanceIncentives(driver,scenario) : addAnyPerformanceIncentives;
	}
	
	public EnterYourProjectRequirements getEnterYourProjectRequirements() {
		return enterYourProjectRequirements == null ? enterYourProjectRequirements = new EnterYourProjectRequirements(driver,scenario) : enterYourProjectRequirements;
	}
	
	
	//API
	/*public Auth getAuth() {
		return auth == null ? auth = new Auth(driver,scenario) : auth;
	}*/
	


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
	public EnterWeightings getEnterWeightingsObj() {
		return enterWeightings == null ? enterWeightings = new EnterWeightings(driver,scenario) : enterWeightings;
	}
	public GrowthScale getGrowthScaleObj() {
		return growthScale == null ? growthScale = new GrowthScale(driver,scenario) : growthScale;
	}

	public NextSteps getNextStepsObj() {
		return nextSteps == null ? nextSteps = new NextSteps(driver,scenario) : nextSteps;
	}

	public NumberofSuppliers getNumberofSuppliersObj() {
		return numberofSuppliers == null ? numberofSuppliers = new NumberofSuppliers(driver,scenario) : numberofSuppliers;
	}

	public ResourcesAndWeightings getResourcesAndWeightingsObj() {
		return resourcesAndWeightings == null ? resourcesAndWeightings = new ResourcesAndWeightings(driver,scenario) : resourcesAndWeightings;
	}

	public ReviewSuitableSuppliers getReviewSuitableSuppliersObj() {
		return reviewSuitableSuppliers == null ? reviewSuitableSuppliers = new ReviewSuitableSuppliers(driver,scenario) : reviewSuitableSuppliers;
	}

	public FCASecurityVetting getFCASecurityVettingObj() {
		return fcaSecurityVetting == null ? fcaSecurityVetting = new FCASecurityVetting(driver,scenario) : fcaSecurityVetting;
	}

	public ServiceCapabilities getServiceCapabilitiesObj() {
		return serviceCapabilities == null ? serviceCapabilities = new ServiceCapabilities(driver,scenario) : serviceCapabilities;
	}

	public Subcontractors getSubcontractorsObj() {
		return subcontractors == null ? subcontractors = new Subcontractors(driver,scenario) : subcontractors;
	}



}