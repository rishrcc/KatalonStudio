import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.ui.Console
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil
import java.awt.image.BufferedImage
import javax.imageio.ImageIO


List<String> Filename = ['Homepage','LoginPage','StrongAuthCode','SkipPinCode','ProfilPage',
	'YourInformationPage','closeAccountCarousel1','closeAccountCarousel2','closeAccountCarousel3','closeAccountCarousel4'
	,'etape1','etape2','etape3','etape4','closeAccountSelectReason','validateCancelAccountClosure']


for (int cnt = 0; cnt < Filename.size(); cnt++)
{
	BufferedImage expectedImage = ImageIO.read(new File(GlobalVariable.BaselinePath + Filename[cnt] + "_Baseline.png"))
	BufferedImage actualImage = ImageIO.read(new File(GlobalVariable.ActualPath + Filename[cnt] + "_Actual.png"))

	if ((CustomKeywords.'ScreenshotCompare.compareImages'(Filename[cnt])==true) & CustomKeywords.'ScreenshotCompare.getDifferencePercent'(actualImage, expectedImage) > 0.10 )
	{

		KeywordUtil.markFailed(Filename[cnt])
	}
}