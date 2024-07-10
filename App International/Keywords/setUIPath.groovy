import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import cucumber.api.Scenario
import cucumber.api.java.Before
import cucumber.api.java.After
import internal.GlobalVariable

import com.kms.katalon.core.configuration.RunConfiguration
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import groovy.ui.Console
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import org.apache.commons.io.FileUtils as FileUtils


public class setUIPath {

	//FAQ - Start Here
	@Keyword
	public static globalUnauthenticatedUserSearchingByExistingKeyword() {
		String BaselinePath_UnauthenticatedUserSearchingByExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByExistingKeyword\\Baseline\\"
		String ActualPath_UnauthenticatedUserSearchingByExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByExistingKeyword\\Actual\\"
		String ComparisonPath_UnauthenticatedUserSearchingByExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByExistingKeyword\\Comparison\\"
		String DifferencePath_UnauthenticatedUserSearchingByExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByExistingKeyword\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserSearchingByExistingKeyword
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserSearchingByExistingKeyword
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserSearchingByExistingKeyword
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserSearchingByExistingKeyword
	}

	@Keyword
	public static globalUnauthenticatedUserSearchingByNonExistingKeyword() {
		String BaselinePath_UnauthenticatedUserSearchingByNonExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByNonExistingKeyword\\Baseline\\"
		String ActualPath_UnauthenticatedUserSearchingByNonExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByNonExistingKeyword\\Actual\\"
		String ComparisonPath_UnauthenticatedUserSearchingByNonExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByNonExistingKeyword\\Comparison\\"
		String DifferencePath_UnauthenticatedUserSearchingByNonExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByNonExistingKeyword\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserSearchingByNonExistingKeyword
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserSearchingByNonExistingKeyword
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserSearchingByNonExistingKeyword
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserSearchingByNonExistingKeyword
	}

	@Keyword
	public static globalUnauthenticatedUserSearchingByChoosingThematiques() {
		String BaselinePath_UnauthenticatedUserSearchingByChoosingThematiques = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingThematiques\\Baseline\\"
		String ActualPath_UnauthenticatedUserSearchingByChoosingThematiques = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingThematiques\\Actual\\"
		String ComparisonPath_UnauthenticatedUserSearchingByChoosingThematiques = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingThematiques\\Comparison\\"
		String DifferencePath_UnauthenticatedUserSearchingByChoosingThematiques = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingThematiques\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserSearchingByChoosingThematiques
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserSearchingByChoosingThematiques
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserSearchingByChoosingThematiques
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserSearchingByChoosingThematiques
	}

	@Keyword
	public static globalUnauthenticatedUserSearchingByChoosingQuestion() {
		String BaselinePath_UnauthenticatedUserSearchingByChoosingQuestion = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingQuestion\\Baseline\\"
		String ActualPath_UnauthenticatedUserSearchingByChoosingQuestion = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingQuestion\\Actual\\"
		String ComparisonPath_UnauthenticatedUserSearchingByChoosingQuestion = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingQuestion\\Comparison\\"
		String DifferencePath_UnauthenticatedUserSearchingByChoosingQuestion = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSearchingByChoosingQuestion\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserSearchingByChoosingQuestion
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserSearchingByChoosingQuestion
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserSearchingByChoosingQuestion
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserSearchingByChoosingQuestion
	}

	@Keyword
	public static globalLoggedUserSearchingByExistingKeyword() {
		String BaselinePath_LoggedUserSearchingByExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByExistingKeyword\\Baseline\\"
		String ActualPath_LoggedUserSearchingByExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByExistingKeyword\\Actual\\"
		String ComparisonPath_LoggedUserSearchingByExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByExistingKeyword\\Comparison\\"
		String DifferencePath_LoggedUserSearchingByExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByExistingKeyword\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_LoggedUserSearchingByExistingKeyword
		GlobalVariable.ActualPath = ActualPath_LoggedUserSearchingByExistingKeyword
		GlobalVariable.DifferencePath = DifferencePath_LoggedUserSearchingByExistingKeyword
		GlobalVariable.ComparisonPath = ComparisonPath_LoggedUserSearchingByExistingKeyword
	}

	@Keyword
	public static globalLoggedUserSearchingByNonExistingKeyword() {
		String BaselinePath_LoggedUserSearchingByNonExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByNonExistingKeyword\\Baseline\\"
		String ActualPath_LoggedUserSearchingByNonExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByNonExistingKeyword\\Actual\\"
		String ComparisonPath_LoggedUserSearchingByNonExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByNonExistingKeyword\\Comparison\\"
		String DifferencePath_LoggedUserSearchingByNonExistingKeyword = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByNonExistingKeyword\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_LoggedUserSearchingByNonExistingKeyword
		GlobalVariable.ActualPath = ActualPath_LoggedUserSearchingByNonExistingKeyword
		GlobalVariable.DifferencePath = DifferencePath_LoggedUserSearchingByNonExistingKeyword
		GlobalVariable.ComparisonPath = ComparisonPath_LoggedUserSearchingByNonExistingKeyword
	}

	@Keyword
	public static globalLoggedUserSearchingByChoosingThematiques() {
		String BaselinePath_LoggedUserSearchingByChoosingThematiques = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingThematiques\\Baseline\\"
		String ActualPath_LoggedUserSearchingByChoosingThematiques = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingThematiques\\Actual\\"
		String ComparisonPath_LoggedUserSearchingByChoosingThematiques = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingThematiques\\Comparison\\"
		String DifferencePath_LoggedUserSearchingByChoosingThematiques = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingThematiques\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_LoggedUserSearchingByChoosingThematiques
		GlobalVariable.ActualPath = ActualPath_LoggedUserSearchingByChoosingThematiques
		GlobalVariable.DifferencePath = DifferencePath_LoggedUserSearchingByChoosingThematiques
		GlobalVariable.ComparisonPath = ComparisonPath_LoggedUserSearchingByChoosingThematiques
	}

	@Keyword
	public static globalLoggedUserSearchingByChoosingQuestion() {
		String BaselinePath_LoggedUserSearchingByChoosingQuestion = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingQuestion\\Baseline\\"
		String ActualPath_LoggedUserSearchingByChoosingQuestion = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingQuestion\\Actual\\"
		String ComparisonPath_LoggedUserSearchingByChoosingQuestion = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingQuestion\\Comparison\\"
		String DifferencePath_LoggedUserSearchingByChoosingQuestion = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSearchingByChoosingQuestion\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_LoggedUserSearchingByChoosingQuestion
		GlobalVariable.ActualPath = ActualPath_LoggedUserSearchingByChoosingQuestion
		GlobalVariable.DifferencePath = DifferencePath_LoggedUserSearchingByChoosingQuestion
		GlobalVariable.ComparisonPath = ComparisonPath_LoggedUserSearchingByChoosingQuestion
	}

	//FAQ - Ends Here

	//Formulaire de Contact - Starts Here
	@Keyword
	public static globalLoggedUserSendingRequestByChoosingThematiqueAndImage()
	{
		String BaselinePath_LoggedUserSendingRequestByChoosingThematiqueAndImage = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndImage\\Baseline\\"
		String ActualPath_LoggedUserSendingRequestByChoosingThematiqueAndImage = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndImage\\Actual\\"
		String ComparisonPath_LoggedUserSendingRequestByChoosingThematiqueAndImage = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndImage\\Comparison\\"
		String DifferencePath_LoggedUserSendingRequestByChoosingThematiqueAndImage = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndImage\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_LoggedUserSendingRequestByChoosingThematiqueAndImage
		GlobalVariable.ActualPath = ActualPath_LoggedUserSendingRequestByChoosingThematiqueAndImage
		GlobalVariable.DifferencePath = DifferencePath_LoggedUserSendingRequestByChoosingThematiqueAndImage
		GlobalVariable.ComparisonPath = ComparisonPath_LoggedUserSendingRequestByChoosingThematiqueAndImage
	}

	@Keyword
	public static globalLoggedUserSendingRequestByChoosingThematiqueAndPDF()
	{
		String BaselinePath_LoggedUserSendingRequestByChoosingThematiqueAndPDF = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndPDF\\Baseline\\"
		String ActualPath_LoggedUserSendingRequestByChoosingThematiqueAndPDF = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndPDF\\Actual\\"
		String ComparisonPath_LoggedUserSendingRequestByChoosingThematiqueAndPDF = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndPDF\\Comparison\\"
		String DifferencePath_LoggedUserSendingRequestByChoosingThematiqueAndPDF = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserSendingRequestByChoosingThematiqueAndPDF\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_LoggedUserSendingRequestByChoosingThematiqueAndPDF
		GlobalVariable.ActualPath = ActualPath_LoggedUserSendingRequestByChoosingThematiqueAndPDF
		GlobalVariable.DifferencePath = DifferencePath_LoggedUserSendingRequestByChoosingThematiqueAndPDF
		GlobalVariable.ComparisonPath = ComparisonPath_LoggedUserSendingRequestByChoosingThematiqueAndPDF
	}

	@Keyword
	public static globalLoggedUserCannotSendRequestIfThematiqueIsNotSelected() 
	{
		String BaselinePath_LoggedUserCannotSendRequestIfThematiqueIsNotSelected = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfThematiqueIsNotSelected\\Baseline\\"
		String ActualPath_LoggedUserCannotSendRequestIfThematiqueIsNotSelected = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfThematiqueIsNotSelected\\Actual\\"
		String ComparisonPath_LoggedUserCannotSendRequestIfThematiqueIsNotSelected = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfThematiqueIsNotSelected\\Comparison\\"
		String DifferencePath_LoggedUserCannotSendRequestIfThematiqueIsNotSelected = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfThematiqueIsNotSelected\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_LoggedUserCannotSendRequestIfThematiqueIsNotSelected
		GlobalVariable.ActualPath = ActualPath_LoggedUserCannotSendRequestIfThematiqueIsNotSelected
		GlobalVariable.DifferencePath = DifferencePath_LoggedUserCannotSendRequestIfThematiqueIsNotSelected
		GlobalVariable.ComparisonPath = ComparisonPath_LoggedUserCannotSendRequestIfThematiqueIsNotSelected
	}

	@Keyword
	public static globalLoggedUserCannotSendRequestIfRequestIsNotEntered() 
	{
		String BaselinePath_LoggedUserCannotSendRequestIfRequestIsNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfRequestIsNotEntered\\Baseline\\"
		String ActualPath_LoggedUserCannotSendRequestIfRequestIsNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfRequestIsNotEntered\\Actual\\"
		String ComparisonPath_LoggedUserCannotSendRequestIfRequestIsNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfRequestIsNotEntered\\Comparison\\"
		String DifferencePath_LoggedUserCannotSendRequestIfRequestIsNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\LoggedUserCannotSendRequestIfRequestIsNotEntered\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_LoggedUserCannotSendRequestIfRequestIsNotEntered
		GlobalVariable.ActualPath = ActualPath_LoggedUserCannotSendRequestIfRequestIsNotEntered
		GlobalVariable.DifferencePath = DifferencePath_LoggedUserCannotSendRequestIfRequestIsNotEntered
		GlobalVariable.ComparisonPath = ComparisonPath_LoggedUserCannotSendRequestIfRequestIsNotEntered
	}

	@Keyword
	public static globalUnauthenticatedUserSendingRequestByChoosingThematiqueAndImage() 
	{
		String BaselinePath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage\\Baseline\\"
		String ActualPath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage\\Actual\\"
		String ComparisonPath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage\\Comparison\\"
		String DifferencePath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage
	}

	@Keyword
	public static globalUnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF()
	{
		String BaselinePath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF\\Baseline\\"
		String ActualPath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF\\Actual\\"
		String ComparisonPath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF\\Comparison\\"
		String DifferencePath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF
	}

	@Keyword
	public static globalUnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected() 
	{
		String BaselinePath_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected\\Baseline\\"
		String ActualPath_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected\\Actual\\"
		String ComparisonPath_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected\\Comparison\\"
		String DifferencePath_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected
	}

	@Keyword
	public static globalUnauthenticatedUserCannotSendRequestIfRequestIsNotEntered() 
	{
		String BaselinePath_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered\\Baseline\\"
		String ActualPath_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered\\Actual\\"
		String ComparisonPath_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered\\Comparison\\"
		String DifferencePath_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered
	}

	@Keyword
	public static globalUnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered() 
	{
		String BaselinePath_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered\\Baseline\\"
		String ActualPath_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered\\Actual\\"
		String ComparisonPath_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered\\Comparison\\"
		String DifferencePath_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered
	}

	@Keyword
	public static globalUnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong() 
	{
		String BaselinePath_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong\\Baseline\\"
		String ActualPath_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong\\Actual\\"
		String ComparisonPath_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong\\Comparison\\"
		String DifferencePath_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong
	}

	@Keyword
	public static globalUnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong() 
	{
		String BaselinePath_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong\\Baseline\\"
		String ActualPath_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong\\Actual\\"
		String ComparisonPath_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong\\Comparison\\"
		String DifferencePath_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong = RunConfiguration.getProjectDir() + "\\Screenshots\\UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong\\Difference\\"

		GlobalVariable.BaselinePath = BaselinePath_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong
		GlobalVariable.ActualPath = ActualPath_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong
		GlobalVariable.DifferencePath = DifferencePath_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong
		GlobalVariable.ComparisonPath = ComparisonPath_UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong
	}
	//Formulaire de Contact - Ends Here

}
