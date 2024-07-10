import java.nio.file.Files

import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.Before
import internal.GlobalVariable


public class Hooks {

	@Before
	public void beforeScenario(Scenario scenario) {

		if (GlobalVariable.ApplicationOS == 'Android') {
			Mobile.startApplication(RunConfiguration.getProjectDir() + "\\App\\Android\\OneyPreprod.apk", false)
		}

		else {
			Mobile.startApplication(RunConfiguration.getProjectDir() + "\\App\\iOS\\OneyPreprod.ipa", false)
		}
	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			String filepath = Mobile.takeScreenshot()
			File file = new File(filepath)
			scenario.embed(Files.readAllBytes(file.toPath()), "image/png")
		}
	}

	//FAQ - Starts Here
	@Before("@UnauthenticatedUserSearchingByExistingKeyword")
	public void setPathUnauthenticatedUserSearchingByExistingKeyword() {

		setUIPath.globalUnauthenticatedUserSearchingByExistingKeyword()

		File directory_UnauthenticatedUserSearchingByExistingKeyword_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByExistingKeyword\\Comparison\\");
		directory_UnauthenticatedUserSearchingByExistingKeyword_com.mkdirs();

		File directory_UnauthenticatedUserSearchingByExistingKeyword_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByExistingKeyword\\Difference\\");
		directory_UnauthenticatedUserSearchingByExistingKeyword_dif.mkdirs();

		File directory_UnauthenticatedUserSearchingByExistingKeyword_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByExistingKeyword\\Actual\\");
		directory_UnauthenticatedUserSearchingByExistingKeyword_act.mkdirs();

		File directory_UnauthenticatedUserSearchingByExistingKeyword_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByExistingKeyword\\Baseline\\");
		directory_UnauthenticatedUserSearchingByExistingKeyword_base.mkdirs();
	}

	@Before("@UnauthenticatedUserSearchingByNonExistingKeyword")
	public void setPathUnauthenticatedUserSearchingByNonExistingKeyword() {

		setUIPath.globalUnauthenticatedUserSearchingByNonExistingKeyword()

		File directory_UnauthenticatedUserSearchingByNonExistingKeyword_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByNonExistingKeyword\\Comparison\\");
		directory_UnauthenticatedUserSearchingByNonExistingKeyword_com.mkdirs();

		File directory_UnauthenticatedUserSearchingByNonExistingKeyword_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByNonExistingKeyword\\Difference\\");
		directory_UnauthenticatedUserSearchingByNonExistingKeyword_dif.mkdirs();

		File directory_UnauthenticatedUserSearchingByNonExistingKeyword_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByNonExistingKeyword\\Actual\\");
		directory_UnauthenticatedUserSearchingByNonExistingKeyword_act.mkdirs();

		File directory_UnauthenticatedUserSearchingByNonExistingKeyword_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByNonExistingKeyword\\Baseline\\");
		directory_UnauthenticatedUserSearchingByNonExistingKeyword_base.mkdirs();
	}

	@Before("@UnauthenticatedUserSearchingByChoosingThematiques")
	public void setPathUnauthenticatedUserSearchingByChoosingThematiques() {

		setUIPath.globalUnauthenticatedUserSearchingByChoosingThematiques()

		File directory_UnauthenticatedUserSearchingByChoosingThematiques_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingThematiques\\Comparison\\");
		directory_UnauthenticatedUserSearchingByChoosingThematiques_com.mkdirs();

		File directory_UnauthenticatedUserSearchingByChoosingThematiques_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingThematiques\\Difference\\");
		directory_UnauthenticatedUserSearchingByChoosingThematiques_dif.mkdirs();

		File directory_UnauthenticatedUserSearchingByChoosingThematiques_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingThematiques\\Actual\\");
		directory_UnauthenticatedUserSearchingByChoosingThematiques_act.mkdirs();

		File directory_UnauthenticatedUserSearchingByChoosingThematiques_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingThematiques\\Baseline\\");
		directory_UnauthenticatedUserSearchingByChoosingThematiques_base.mkdirs();
	}

	@Before("@UnauthenticatedUserSearchingByChoosingQuestion")
	public void setPathUnauthenticatedUserSearchingByChoosingQuestion() {

		setUIPath.globalUnauthenticatedUserSearchingByChoosingQuestion()

		File directory_UnauthenticatedUserSearchingByChoosingQuestion_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingQuestion\\Comparison\\");
		directory_UnauthenticatedUserSearchingByChoosingQuestion_com.mkdirs();

		File directory_UnauthenticatedUserSearchingByChoosingQuestion_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingQuestion\\Difference\\");
		directory_UnauthenticatedUserSearchingByChoosingQuestion_dif.mkdirs();

		File directory_UnauthenticatedUserSearchingByChoosingQuestion_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingQuestion\\Actual\\");
		directory_UnauthenticatedUserSearchingByChoosingQuestion_act.mkdirs();

		File directory_UnauthenticatedUserSearchingByChoosingQuestion_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingQuestion\\Baseline\\");
		directory_UnauthenticatedUserSearchingByChoosingQuestion_base.mkdirs();
	}

	@Before("@LoggedUserSearchingByExistingKeyword")
	public void setPathLoggedUserSearchingByExistingKeyword() {

		setUIPath.globalLoggedUserSearchingByExistingKeyword()

		File directory_LoggedUserSearchingByExistingKeyword_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByExistingKeyword\\Comparison\\");
		directory_LoggedUserSearchingByExistingKeyword_com.mkdirs();

		File directory_LoggedUserSearchingByExistingKeyword_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByExistingKeyword\\Difference\\");
		directory_LoggedUserSearchingByExistingKeyword_dif.mkdirs();

		File directory_LoggedUserSearchingByExistingKeyword_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByExistingKeyword\\Actual\\");
		directory_LoggedUserSearchingByExistingKeyword_act.mkdirs();

		File directory_LoggedUserSearchingByExistingKeyword_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByExistingKeyword\\Baseline\\");
		directory_LoggedUserSearchingByExistingKeyword_base.mkdirs();
	}

	@Before("@LoggedUserSearchingByNonExistingKeyword")
	public void setPathLoggedUserSearchingByNonExistingKeyword() {

		setUIPath.globalLoggedUserSearchingByNonExistingKeyword()

		File directory_LoggedUserSearchingByNonExistingKeyword_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByNonExistingKeyword\\Comparison\\");
		directory_LoggedUserSearchingByNonExistingKeyword_com.mkdirs();

		File directory_LoggedUserSearchingByNonExistingKeyword_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByNonExistingKeyword\\Difference\\");
		directory_LoggedUserSearchingByNonExistingKeyword_dif.mkdirs();

		File directory_LoggedUserSearchingByNonExistingKeyword_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByNonExistingKeyword\\Actual\\");
		directory_LoggedUserSearchingByNonExistingKeyword_act.mkdirs();

		File directory_LoggedUserSearchingByNonExistingKeyword_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByNonExistingKeyword\\Baseline\\");
		directory_LoggedUserSearchingByNonExistingKeyword_base.mkdirs();
	}

	@Before("@LoggedUserSearchingByChoosingThematiques")
	public void setPathLoggedUserSearchingByChoosingThematiques() {

		setUIPath.globalLoggedUserSearchingByChoosingThematiques()

		File directory_LoggedUserSearchingByChoosingThematiques_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingThematiques\\Comparison\\");
		directory_LoggedUserSearchingByChoosingThematiques_com.mkdirs();

		File directory_LoggedUserSearchingByChoosingThematiques_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingThematiques\\Difference\\");
		directory_LoggedUserSearchingByChoosingThematiques_dif.mkdirs();

		File directory_LoggedUserSearchingByChoosingThematiques_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingThematiques\\Actual\\");
		directory_LoggedUserSearchingByChoosingThematiques_act.mkdirs();

		File directory_LoggedUserSearchingByChoosingThematiques_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingThematiques\\Baseline\\");
		directory_LoggedUserSearchingByChoosingThematiques_base.mkdirs();
	}

	@Before("@LoggedUserSearchingByChoosingQuestion")
	public void setPathLoggedUserSearchingByChoosingQuestion() {

		setUIPath.globalLoggedUserSearchingByChoosingQuestion()

		File directory_LoggedUserSearchingByChoosingQuestion_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingQuestion\\Comparison\\");
		directory_LoggedUserSearchingByChoosingQuestion_com.mkdirs();

		File directory_LoggedUserSearchingByChoosingQuestion_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingQuestion\\Difference\\");
		directory_LoggedUserSearchingByChoosingQuestion_dif.mkdirs();

		File directory_LoggedUserSearchingByChoosingQuestion_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingQuestion\\Actual\\");
		directory_LoggedUserSearchingByChoosingQuestion_act.mkdirs();

		File directory_LoggedUserSearchingByChoosingQuestion_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingQuestion\\Baseline\\");
		directory_LoggedUserSearchingByChoosingQuestion_base.mkdirs();
	}
	//FAQ - Ends Here

	//Formulaire de contact - Starts Here
	@Before("@LoggedUserSendingRequestByChoosingThematiqueAndImage")
	public void setPathLoggedUserSendingRequestByChoosingThematiqueAndImage()
	{

		setUIPath.globalLoggedUserSendingRequestByChoosingThematiqueAndImage()

		File directory_LoggedUserSendingRequestByChoosingThematiqueAndImage_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndImage\\Comparison\\");
		directory_LoggedUserSendingRequestByChoosingThematiqueAndImage_com.mkdirs();

		File directory_LoggedUserSendingRequestByChoosingThematiqueAndImage_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndImage\\Difference\\");
		directory_LoggedUserSendingRequestByChoosingThematiqueAndImage_dif.mkdirs();

		File directory_LoggedUserSendingRequestByChoosingThematiqueAndImage_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndImage\\Actual\\");
		directory_LoggedUserSendingRequestByChoosingThematiqueAndImage_act.mkdirs();

		File directory_LoggedUserSendingRequestByChoosingThematiqueAndImage_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndImage\\Baseline\\");
		directory_LoggedUserSendingRequestByChoosingThematiqueAndImage_base.mkdirs();
	}

	@Before("@LoggedUserSendingRequestByChoosingThematiqueAndPDF")
	public void setPathLoggedUserSendingRequestByChoosingThematiqueAndPDF()
	{

		setUIPath.globalLoggedUserSendingRequestByChoosingThematiqueAndPDF()

		File directory_LoggedUserSendingRequestByChoosingThematiqueAndPDF_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndPDF\\Comparison\\");
		directory_LoggedUserSendingRequestByChoosingThematiqueAndPDF_com.mkdirs();

		File directory_LoggedUserSendingRequestByChoosingThematiqueAndPDF_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndPDF\\Difference\\");
		directory_LoggedUserSendingRequestByChoosingThematiqueAndPDF_dif.mkdirs();

		File directory_LoggedUserSendingRequestByChoosingThematiqueAndPDF_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndPDF\\Actual\\");
		directory_LoggedUserSendingRequestByChoosingThematiqueAndPDF_act.mkdirs();

		File directory_LoggedUserSendingRequestByChoosingThematiqueAndPDF_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndPDF\\Baseline\\");
		directory_LoggedUserSendingRequestByChoosingThematiqueAndPDF_base.mkdirs();
	}

	@Before("@LoggedUserCannotSendRequestIfThematiqueIsNotSelected")
	public void setPathLoggedUserCannotSendRequestIfThematiqueIsNotSelected()
	{

		setUIPath.globalLoggedUserCannotSendRequestIfThematiqueIsNotSelected()

		File directory_LoggedUserCannotSendRequestIfThematiqueIsNotSelected_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfThematiqueIsNotSelected\\Comparison\\");
		directory_LoggedUserCannotSendRequestIfThematiqueIsNotSelected_com.mkdirs();

		File directory_LoggedUserCannotSendRequestIfThematiqueIsNotSelected_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfThematiqueIsNotSelected\\Difference\\");
		directory_LoggedUserCannotSendRequestIfThematiqueIsNotSelected_dif.mkdirs();

		File directory_LoggedUserCannotSendRequestIfThematiqueIsNotSelected_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfThematiqueIsNotSelected\\Actual\\");
		directory_LoggedUserCannotSendRequestIfThematiqueIsNotSelected_act.mkdirs();

		File directory_LoggedUserCannotSendRequestIfThematiqueIsNotSelected_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfThematiqueIsNotSelected\\Baseline\\");
		directory_LoggedUserCannotSendRequestIfThematiqueIsNotSelected_base.mkdirs();
	}

	@Before("@LoggedUserCannotSendRequestIfRequestIsNotEntered")
	public void setPathLoggedUserCannotSendRequestIfRequestIsNotEntered()
	{

		setUIPath.globalLoggedUserCannotSendRequestIfRequestIsNotEntered()

		File directory_LoggedUserCannotSendRequestIfRequestIsNotEntered_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfRequestIsNotEntered\\Comparison\\");
		directory_LoggedUserCannotSendRequestIfRequestIsNotEntered_com.mkdirs();

		File directory_LoggedUserCannotSendRequestIfRequestIsNotEntered_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfRequestIsNotEntered\\Difference\\");
		directory_LoggedUserCannotSendRequestIfRequestIsNotEntered_dif.mkdirs();

		File directory_LoggedUserCannotSendRequestIfRequestIsNotEntered_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfRequestIsNotEntered\\Actual\\");
		directory_LoggedUserCannotSendRequestIfRequestIsNotEntered_act.mkdirs();

		File directory_LoggedUserCannotSendRequestIfRequestIsNotEntered_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfRequestIsNotEntered\\Baseline\\");
		directory_LoggedUserCannotSendRequestIfRequestIsNotEntered_base.mkdirs();
	}

	@Before("@UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage")
	public void setPathUnauthenticatedUserSendingRequestByChoosingThematiqueAndImage()
	{

		setUIPath.globalUnauthenticatedUserSendingRequestByChoosingThematiqueAndImage()

		File directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage\\Comparison\\");
		directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage_com.mkdirs();

		File directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage\\Difference\\");
		directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage_dif.mkdirs();

		File directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage\\Actual\\");
		directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage_act.mkdirs();

		File directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage\\Baseline\\");
		directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage_base.mkdirs();
	}

	@Before("@UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF")
	public void setPathUnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF()
	{

		setUIPath.globalUnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF()

		File directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF\\Comparison\\");
		directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF_com.mkdirs();

		File directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF\\Difference\\");
		directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF_dif.mkdirs();

		File directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF\\Actual\\");
		directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF_act.mkdirs();

		File directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF\\Baseline\\");
		directory_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF_base.mkdirs();
	}

	@Before("@UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected")
	public void setPathUnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected()
	{

		setUIPath.globalUnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected()

		File directory_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected\\Comparison\\");
		directory_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected_com.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected\\Difference\\");
		directory_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected_dif.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected\\Actual\\");
		directory_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected_act.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected\\Baseline\\");
		directory_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected_base.mkdirs();
	}

	@Before("@UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered")
	public void setPathUnauthenticatedUserCannotSendRequestIfRequestIsNotEntered()
	{

		setUIPath.globalUnauthenticatedUserCannotSendRequestIfRequestIsNotEntered()

		File directory_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered\\Comparison\\");
		directory_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered_com.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered\\Difference\\");
		directory_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered_dif.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered\\Actual\\");
		directory_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered_act.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered\\Baseline\\");
		directory_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered_base.mkdirs();
	}
	
	@Before("@UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered")
	public void setPathUnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered()
	{

		setUIPath.globalUnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered()

		File directory_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered\\Comparison\\");
		directory_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered_com.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered\\Difference\\");
		directory_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered_dif.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered\\Actual\\");
		directory_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered_act.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered\\Baseline\\");
		directory_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered_base.mkdirs();
	}
	
	@Before("@UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong")
	public void setPathUnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong()
	{

		setUIPath.globalUnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong()

		File directory_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong\\Comparison\\");
		directory_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong_com.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong\\Difference\\");
		directory_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong_dif.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong\\Actual\\");
		directory_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong_act.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong\\Baseline\\");
		directory_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong_base.mkdirs();
	}
	
	@Before("@UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong")
	public void setPathUnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong()
	{

		setUIPath.globalUnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong()

		File directory_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong_com = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong\\Comparison\\");
		directory_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong_com.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong_dif = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong\\Difference\\");
		directory_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong_dif.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong_act = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong\\Actual\\");
		directory_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong_act.mkdirs();

		File directory_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong_base = new File(RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong\\Baseline\\");
		directory_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong_base.mkdirs();
	}
	//Formulaure de contact - Ends Here
}

