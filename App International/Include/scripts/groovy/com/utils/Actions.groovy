package com.utils;
import static com.kms.katalon.core.model.FailureHandling.CONTINUE_ON_FAILURE
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;

import java.text.NumberFormat

import org.bson.Document

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase

import groovy.json.JsonSlurper
import internal.GlobalVariable;
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent



public class Actions {

	public static clickOnAideOnLoginPage() {
		//Click on Aide on Login page
		Mobile.delay(5)
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.btn_Aide]), 20)

		//Take screenshot
		visualTesting('signIn')

		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.btn_Aide]), 20)

		//Take screenshot
		Mobile.delay(3)
		visualTesting('aide')
	}

	public static clickonConsultFAQ() {
		//Click on Consulter Notre FAQ
		Mobile.delay(5)
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_ConsultezNotreFAQ]), 20)

		//Take screenshot
		Mobile.delay(2)
		visualTesting('consultezNotreFAQ')
	}

	public static typeKeyword(String keyword) {
		//Set existing keyword on text box
		Mobile.delay(5)
		Mobile.setText(findTestObject('Android/inputTextSearchQuestionFAQ'), keyword, 20)
	}

	public static verifyListedQuestion(String questions) {
		Mobile.delay(3)
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : questions]), 20)

		//Take screenshot
		Mobile.delay(2)
		visualTesting('listedQuestions')
	}

	public static verifyCorrectAnswerIsDisplayed(String questions, String answers) {
		//Click on suggested questions
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : questions]), 20)

		//Verify that correct answer is displayed
		Mobile.delay(3)
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : answers]), 20)

		//Take screenshot
		Mobile.delay(2)
		visualTesting('answer')
	}

	public static verifyNoAutoCompleteQueriesAreDisplayed() {
		Mobile.verifyElementNotExist(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.list_AutoCompleteQueries]), 20)
	}

	public static clickOnlistedThematique(String thematique) {

		Mobile.delay(3)
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : thematique]), 20)

		//Take screenshot
		Mobile.delay(2)
		visualTesting('thematiqueSubcategory')
	}

	public static clickOnThematiqueSubCategory(String sub_category) {

		Mobile.delay(3)
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : sub_category]), 20)

		//Take screenshot
		Mobile.delay(2)
		visualTesting('thematiqueQuestion')
	}

	public static clickOnThematiqueQuestion(String questions) {

		Mobile.delay(3)

		Mobile.tap(findTestObject('Common/elementText',[('elementText') : questions]), 20)


		//Take screenshot
		Mobile.delay(2)
		visualTesting('thematiqueAnswer')
	}

	public static verifyAnswerForThematique(String answer) {
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : answer]), 10)
	}

	public static scrollDown() {

		Mobile.delay(3)

		int deviceWidth = Mobile.getDeviceWidth()
		println deviceWidth

		int deviceEnd = deviceWidth/10

		Mobile.swipe(deviceWidth-80, deviceWidth-80, deviceWidth-80, deviceEnd+350)

		Mobile.delay(3)
	}

	public static clickOnPredefinedQuestion(String question) {
		Mobile.delay(3)

		Mobile.tap(findTestObject('Common/elementText',[('elementText') : question]), 20)
	}

	public static verifyAnswerForPredefinedQuestion(String answer) {
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : answer]), 10)

		//Take screenshot
		visualTesting("predefinedAnswer")
	}


	public static loginWithAnotherAccount(String logged_user) {
		Mobile.delay(10)

		if (Mobile.verifyElementExist(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_SeConnecter]), 10,FailureHandling.OPTIONAL) == true) {
			//Click on Se Connecter
			Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_SeConnecter]), 10)

			//Input Email - To cater for iOS element
			Mobile.delay(5)
			Mobile.waitForElementPresent(findTestObject('Android/signup_inputs_email'),10)
			Mobile.setText(findTestObject('Android/signup_inputs_email'),logged_user, 10)

			visualTesting('loginPage')

			//Click on Suivant
			Mobile.waitForElementPresent(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_ConfimerLogin]), 10)
			Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_ConfimerLogin]), 10)

		}

		else {
			//Click on Se Connecter avec un autre compte
			Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_SeConnecterAvecAutreCompte]), 10)


			//Click on Se Connecter
			//Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_SeConnecter]), 10)

			//Input Email - To cater for iOS element
			Mobile.delay(5)
			Mobile.waitForElementPresent(findTestObject('Android/signup_inputs_email'),10)
			Mobile.setText(findTestObject('Android/signup_inputs_email'),logged_user, 10)

			visualTesting('loginPage')

			//Click on Suivant
			Mobile.waitForElementPresent(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_ConfimerLogin]), 10)
			Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_ConfimerLogin]), 10)
		}
	}



	public static inputStrongAuthenticationCode() {
		//Input OTP
		Mobile.delay(5)

		visualTesting('strongAuthCode')

		if (GlobalVariable.ApplicationOS == 'Android')
		{

			AndroidDriver<?> driver = MobileDriverFactory.getDriver()
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
		}

		else
		{
			println "Please define code for iOS"
		}
	}
	public static skipPinCode() {
		//Click on skip
		Mobile.delay(10)
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.btn_PasserCetterEtape]), 50)

		visualTesting('skipPinCode')

		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.btn_PasserCetterEtape]), 20)
		Mobile.delay(3)
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.btn_PasserCetterEtape]), 20, FailureHandling.OPTIONAL)

		visualTesting('homepage')
	}

	public static clickOnProfileIcon()
	{
		Mobile.delay(5)

		//Click on Profile icon
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.btn_Profile]), 20)

		//Take screenshot
		Mobile.delay(2)
		visualTesting('profilPage')


	}

	public static clickOnAideProfilePage()
	{
		Mobile.delay(3)

		//Click on Aide
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_ProfileAide]), 20)

		//Take screenshot
		visualTesting("profileAide")
	}

	public static clickOnContactezNous()
	{
		Mobile.delay(2)

		//Click on Contactez-Nous
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_ContactezNous]), 20)

		//Take screenshot
		visualTesting("ContactezNous")
	}

	public static verifyUserEmailFilledIn(String logged_user) {

		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText'):logged_user]), 20)

		Mobile.verifyElementExist(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.icn_Locked]), 20)

	}

	public static chooseAThematique(String thematique) {

		//Click on Choisir une thematique
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_chooseThematique]), 20)

		//Take screenshot for the list of thematique
		Mobile.delay(2)
		visualTesting("listOfThematiques")

		//Pick one thematique
		Mobile.tap(findTestObject('Common/elementText',[('elementText'):thematique]), 20)
	}

	public static preciseRequest(String request) {

		//Click on Preciser ma demande
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_preciserDemande]), 20)

		//Take screenshot
		Mobile.delay(2)
		visualTesting("maDemande")

		//Type a message
		Mobile.setText(findTestObject('Android/inputDemande'), request, 20)
	}

	public static uploadImage() {

		//Click on Telecharger un fichier
		Mobile.tap(findTestObject('Common/elementText',[('elementText'):GlobalVariable.btn_uploadFile]), 20)

		//Take screenshot
		visualTesting("uploadOptions")

		//Select Img
		Mobile.tap(findTestObject('Common/elementText',[('elementText'):GlobalVariable.btn_accessImg]), 20)

		//Select image
		Mobile.tap(findTestObject('Common/mobileImg'), 20)

	}

	public static uploadPDF() {

		//Click on Telecharger un fichier
		Mobile.tap(findTestObject('Common/elementText',[('elementText'):GlobalVariable.btn_uploadFile]), 20)

		//Take screenshot
		visualTesting("uploadOptions")

		//Select Img
		Mobile.tap(findTestObject('Common/elementText',[('elementText'):GlobalVariable.btn_accessPDF]), 20)

		//Select Documents tabs in Mobile
		Mobile.tap(findTestObject('Common/elementText',[('elementText'):GlobalVariable.btn_mobileDocuments]), 20)

		//Select PDF
		Mobile.delay(3)
		Mobile.tap(findTestObject('Common/mobilePDF'), 20)

	}

	public static clickOnSaveDemande() {

		//Click on Enregistrer
		Mobile.delay(2)
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_enregistrerDemande]), 20)
	}

	public static sendDemandeRequest() {

		//Take Screenshot
		visualTesting("sendRequestFilledForm")

		//Click on Envoyer ma demande
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_sendRequest]), 20)

		//Verify that request is sent
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText'):GlobalVariable.txt_requestSent]), 20)

	}

	public static sendDemandeRequestNotSent() {

		//Take Screenshot
		visualTesting("sendRequestFilledForm")

		//Click on Envoyer ma demande
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_sendRequest]), 20)

		//Verify that request is sent message do not appear
		Mobile.verifyElementNotExist(findTestObject('Common/elementText',[('elementText'):GlobalVariable.txt_requestSent]), 10)

	}

	public static fillContactUsForm(String civilite,String Prenom,String Nom,String Email,String MobileNum) {

		Mobile.delay(2)

		//Take screenshot
		visualTesting("contactUSForm")

		if (Mobile.verifyElementExist(findTestObject('Android/contactUsMobileNum'), 10,FailureHandling.OPTIONAL) == true)
		{

			//Select Civilite
			Mobile.tap(findTestObject('Common/elementText',[('elementText'):civilite]), 20)

			//Set Prenom
			Mobile.setText(findTestObject('Android/contactUsPrenom'), Prenom, 10)

			//Set Nom
			Mobile.setText(findTestObject('Android/contactUsNom'), Nom, 10)

			//Set e-mail
			Mobile.setText(findTestObject('Android/contactUsEmail'), Email, 10)

			//Set Phone number
			Mobile.setText(findTestObject('Android/contactUsMobileNum'), MobileNum, 10)
		}
		
		else
		{
			scrollDown()
			
			//Select Civilite
			Mobile.tap(findTestObject('Common/elementText',[('elementText'):civilite]), 20)

			//Set Prenom
			Mobile.setText(findTestObject('Android/contactUsPrenom'), Prenom, 10)

			//Set Nom
			Mobile.setText(findTestObject('Android/contactUsNom'), Nom, 10)

			//Set e-mail
			Mobile.setText(findTestObject('Android/contactUsEmail'), Email, 10)

			//Set Phone number
			Mobile.setText(findTestObject('Android/contactUsMobileNum'), MobileNum, 10)
		}

	}

	public static validateContactUsForm() {


		//Accept radio button
		Mobile.tap(findTestObject('Common/elementText',[('elementText'):GlobalVariable.rad_contactUsAdult]), 20)

		//Take sceenshot
		visualTesting("validateContactUsForm")

		//Click on Valider
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.btn_contactUsValidate]), 20)
	}

	public static verifyContactUsRequestSent() {

		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText'):GlobalVariable.txt_requestSent]), 20)

		//Take screenshot
		visualTesting("requestSent")
	}

	public static verifyContactUsNotRequestSent() {

		Mobile.verifyElementNotExist(findTestObject('Common/elementText',[('elementText'):GlobalVariable.txt_requestSent]), 20)

		//Take scrseenshot
		visualTesting("requestNotSent")
	}

	public static visualTesting(String screenshot)
	{
		Mobile.delay(2)
		if (GlobalVariable.takeBaseline == true)
		{
			Mobile.takeScreenshot(GlobalVariable.BaselinePath + screenshot + "_Baseline.png")
		}

		if (GlobalVariable.takeActual == true)
		{
			Mobile.takeScreenshot(GlobalVariable.ActualPath + screenshot + "_Actual.png")
		}
		Mobile.delay(1)
	}

	//--------------------Deprecated Functions but can be reused---------------------------------------------------------------//

	public static enterPinCode() {
		//Input PIN
		Mobile.delay(5)

		visualTesting('enterPinCode')

		if (GlobalVariable.ApplicationOS == 'Android')
		{

			AndroidDriver<?> driver = MobileDriverFactory.getDriver()
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0))

		}

		else
		{
			println "Please define code for iOS"
		}

	}


	public static goToYourInformation() {
		//Click on Vos information
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.yourInformation]), 10)
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.yourInformation]), 10)

		Mobile.delay(3)

		visualTesting('YourInformationPage')
	}

	public static clickOnCloseMyAccount() {
		//Click on Cloturer mon compte
		Mobile.waitForElementPresent(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.closeMyAccount]), 10)
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.closeMyAccount]), 10)

		Mobile.delay(3)

		//Verify UI on Carousel 1
		visualTesting('closeAccountCarousel1')

		//Click on Suivant
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountClosing_Next]), 10)

		//Verify UI on Carousel 2
		visualTesting('closeAccountCarousel2')

		//Click on Suivant
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountClosing_Next]), 10)

		//Verify UI on Carousel 3
		visualTesting('closeAccountCarousel3')

		//Click on Suivant
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountClosing_Next]), 10)

		//Verify UI on Carousel 4
		visualTesting('closeAccountCarousel4')
	}

	public static confirmAccountClosure() {

		//Click on Oui, cloturer mon compte
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.continueClosing]), 10)

		//Etape 1
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountClosing_Next]), 10)

		//Verify UI for step 1
		visualTesting('etape1')
		Mobile.delay(3)

		//Go to Step 2
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountClosing_Next]), 10)

		//Verify UI for step 2
		visualTesting('etape2')
		Mobile.delay(3)

		//Go to Step 3
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountClosing_Next]), 10)

		//Verify UI for Step 3
		visualTesting('etape3')
		Mobile.delay(3)

		//Go to step 4
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountClosing_Next]), 10)

		//Verify UI for Step 4
		visualTesting('etape4')
		Mobile.delay(3)

		//Go to next screen - motif
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountClosing_Next]), 10)
	}

	public static inputMotiveForClosing() {

		//Verify that if motif is not selected, the confirm button is present
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountCloseConfirm]), 10)

		//Click on "Choisir un motif"
		Mobile.waitForElementPresent(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.chooseMotif]), 10)
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.chooseMotif]), 10)

		//Verify UI of all Motives
		visualTesting('closeAccountSelectReason')

		//Select Plafond trop bas reason
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.plafondbas]),10)

		//On last question screen, verify that confirm button is clickable and click on Modifier
		Mobile.waitForElementPresent(findTestObject('Common/bankAccount_motiveScreens_modifyMotive',[('Modify') : GlobalVariable.Modify]), 10)
		Mobile.tap(findTestObject('Common/bankAccount_motiveScreens_modifyMotive',[('Modify') : GlobalVariable.Modify]), 10)

		//Click on Pour d'autres raison
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.otherReason]), 10)
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.otherReason]), 10)

		//Add a text for the reason
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.enterDemande]), 10)
		Mobile.setText(findTestObject('Common/elementText',[('elementText') : GlobalVariable.enterDemande]), 'Account Closure test by automation', 10)

		//Click on Enregistrer
		Mobile.waitForElementPresent(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.registerMotif]), 10)
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.registerMotif]), 10)

		//Click on Confirmer
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountCloseConfirm]), 10)
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountCloseConfirm]), 10)
	}

	public static selectMotiveForClosing() {
		//Verify that if motif is not selected, the confirm button is not clickable
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountCloseConfirm]), 10)

		//Click on "Choisir un motif"
		Mobile.waitForElementPresent(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.chooseMotif]), 10)
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.chooseMotif]), 10)

		//Select Plafond trop bas reason
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.plafondbas]),10)

		//Click on Confirmer
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountCloseConfirm]), 10)
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountCloseConfirm]), 10)
	}

	public static addBeneficiaryWhileClosing() {
		//Verify that the Suivant button is disabled when all fields are blank
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountClosing_Next]), 10)

		visualTesting('addBeneficiary')

		//Add Nom du beneficiare
		Mobile.setText(findTestObject('Android/newBeneficiary_inputs_name'), 'Auto', 10)

		//Add Iban
		Mobile.setText(findTestObject('Android/newBeneficiary_inputs_iban'), 'FR7630006000011234567890189', 10)

		//Add BIC
		Mobile.setText(findTestObject('Android/newBeneficiary_inputs_bic'), 'AGRIFRPP', 10)

		//Add email for confirmation
		Mobile.setText(findTestObject('Android/newBeneficiary_inputs_email'), GlobalVariable.dynEmail, 10)

		//Click on Suivant
		Mobile.tap(findTestObject('Common/saveBeneficiary'), 10)
	}

	public static selectFirstBeneficiary() {

		//Verify that Nouveau beneficiare button is displayed and clickable
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.newBeneficiary]), 10)

		visualTesting('BeneficiaryListed')

		//Select First Beneficiary
		Mobile.tap(findTestObject('Android/selectFirstBeneficiary'), 10)
	}

	public static validateAccountClosure() {
		//Verify that the Recapitulatif de cloture screen is displayed
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.recapAccClose]), 10)

		visualTesting('validateCancelAccountClosure')

		//Verify that Button to cancel the closure is present
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.cancelAccClose]), 10)

		//Click on Valider la cloture
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.validateAccClose]), 10)
	}

	public static acceptClosureOnSummaryScreen() {
		//Click on Terminer
		Mobile.delay(5)

		visualTesting('SummaryScreenAccClosure')

		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accCloseComplete]), 10)
	}

	public static cancelAccountClosure() {
		Mobile.delay(5)
		//Verify that the Recapitulatif de cloture screen is displayed
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.recapAccClose]), 10)

		visualTesting('CancelAccountClosure')

		//Click on Annuler la cloture
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.cancelAccClose]), 10)

		//Verify that Cloturer mon compte is present
		Mobile.waitForElementPresent(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.closeMyAccount]), 10)
	}

	//verification steps will change as per new UI
	public static verifyAccountIsFrozen() {

		//Check in db that the status is frozen
		MongoClientURI connectionString = new MongoClientURI(GlobalVariable.mongoPreprodURI)
		MongoClient mongoClient = new MongoClient(connectionString)
		println ("Connect to database successfully")

		MongoDatabase mongoDb = mongoClient.getDatabase("odb_account_management")
		MongoCollection<Document> mongoUsersCollection = mongoDb.getCollection("accounts")

		Document acc_details = mongoUsersCollection.find(new Document('uid', GlobalVariable.UID)).first()
		def full_acc_details = acc_details.toJson()
		println full_acc_details

		JsonSlurper slurper = new JsonSlurper()
		Map parsedJson = slurper.parseText(full_acc_details)

		//to use external id instead - Still in dev yet to be deployed on preprod
		String status_frozen = parsedJson.situation.status
		//String accountId = parsedJson.id
		println status_frozen

		//Verify that the button on Vos information has been greyed out
		//Mobile.delay(5)
		//Mobile.waitForElementPresent(findTestObject('Android/bankAccount_accountClosingInfo_accountClosed'),10)
		//String cloture_encour = Mobile.getText(findTestObject('Android/bankAccount_accountClosingInfo_accountClosed'),10)
		Mobile.verifyMatch(status_frozen, GlobalVariable.txtaccountFrozen, false)

		visualTesting('accClosed')
	}

	public static executeCallback45toCloseAccount() {

		//Execute api to simulate callback45 - account closed
		def close_account = WS.sendRequest(findTestObject('Object Repository/API/Callback 45 - Close Account'))
		String close_account_status = close_account.getStatusCode()
		println "Status code for card transaction:" + close_account_status

		//Check in db that the status is frozen
		MongoClientURI connectionString = new MongoClientURI(GlobalVariable.mongoPreprodURI)
		MongoClient mongoClient = new MongoClient(connectionString)
		println ("Connect to database successfully")

		MongoDatabase mongoDb = mongoClient.getDatabase("odb_account_management")
		MongoCollection<Document> mongoUsersCollection = mongoDb.getCollection("accounts")

		Document acc_details = mongoUsersCollection.find(new Document('uid', GlobalVariable.UID)).first()
		def full_acc_details = acc_details.toJson()
		println full_acc_details

		JsonSlurper slurper = new JsonSlurper()
		Map parsedJson = slurper.parseText(full_acc_details)

		//to use external id instead - Still in dev yet to be deployed on preprod
		String status_closed = parsedJson.situation.status
		//String accountId = parsedJson.id
		println status_closed

		//Verify that the button on Vos information has been greyed out
		//Mobile.delay(5)
		//Mobile.waitForElementPresent(findTestObject('Android/bankAccount_accountClosingInfo_accountClosed'),10)
		//String cloture_encour = Mobile.getText(findTestObject('Android/bankAccount_accountClosingInfo_accountClosed'),10)
		Mobile.verifyMatch(status_closed, GlobalVariable.txtaccountClosed, false)

		//Close drawer
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.closeDrawer]), 10)

		//Tap on Tableau de bord
		Mobile.waitForElementPresent(findTestObject('Common/homepage_actions_tableu_de_bord'), 10)
		Mobile.tap(findTestObject('Common/homepage_actions_tableu_de_bord'), 10)

		Mobile.delay(3)

		//Verify that the banner has changed
		visualTesting('TableauDeBordAfterClosure')
	}

	public static clickOnConfirmCloseAccount() {
		//Verify that Gardez mon compte ouvert button is present
		Mobile.verifyElementExist(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.keepAccOpen]), 10)

		//Click on Oui, cloturer mon compte
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.continueClosing]), 10)

		visualTesting('accClosedConfirm')
	}

	public static accountCannotBeClosed(String reason) {
		//Verify reason why account closure cannot happen
		Mobile.delay(3)
		String reason_closure_cannot_happen = Mobile.getText(findTestObject('Android/accountClosingInfo_accountClosingWarning'),10)
		Mobile.verifyMatch(reason_closure_cannot_happen, reason, false)


		if (reason == 'Votre compte est débiteur')
		{
			visualTesting('cannotCloseAcc_debiteur')
		}
		if (reason == 'Paiements Fractionnés en cours')
		{
			visualTesting('cannotCloseAcc_fractionne')
		}

	}

	// 5th Oct 2022 - to re-organize object repository.
	public static orderCard() {

		//Click on Voir
		Mobile.delay(4)
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.homepageSee]), 10)

		//Verify that modify address button is present
		Mobile.delay(6)

		//UI check for Modify address
		visualTesting('validateAddress_beforeCheck')

		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.modifyAddress]), 10)

		//Click on checkbox
		Mobile.tap(findTestObject('Android/subscription_CheckAddress'), 10)

		//UI check after checking address
		visualTesting('validateAddress_afterCheck')

		//Click on Validate
		//Resource-id: ACTION_CHECK_ADDRESS_VALID_ADDRESS
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.validateAddress]), 10)
	}

	public static definePIN() {

		Mobile.delay(10)

		visualTesting('createWishpin')

		if (GlobalVariable.ApplicationOS == 'Android')
		{
			AndroidDriver<?> driver = MobileDriverFactory.getDriver()
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5))

			Mobile.delay(5)
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2))
			driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5))
			Mobile.delay(60)
		}

		else
		{
			println "Please define code for iOS"
		}
	}

	public static verifyCardCannotBeOrdered() {

		//Verify that "Ma carte" is present
		//Resource-id: ACTION_HOMEPAGE_SHOW_CARD
		Mobile.delay(60)
		Mobile.verifyElementExist(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.myCard]), 10)

		//UI after order card
		visualTesting('cardOrdered')

		//Verify that "Voir" is not displayed
		Mobile.verifyElementNotExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.homepageSee]), 10)
	}

	public static verifyCardDetails() {

		//Click on Gérer
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.manageCard]), 10)
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.manageCard]), 10)

		//UI for Manage card
		visualTesting('manageCard')

		//Verify Bloquer temporairement is present
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.temporaryBlocked]), 10)

		//Verify Afficher le numéro de la carte
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.displayCardNumber]), 10)

		//Verify foreign payment toggle
		String paiement_etranger_toggle = Mobile.getText(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.foreignPayment]), 10)
		Mobile.verifyMatch(paiement_etranger_toggle, 'ON', false)

		//verify online payment toggle
		String online_payment_toggle = Mobile.getText(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.onlinePayment]), 10)
		Mobile.verifyMatch(online_payment_toggle, 'ON', false)

		//Verify manage plafond button is available
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.manageCard]), 10,CONTINUE_ON_FAILURE)

		//Verify Card opposition is present
		//Mobile.scrollToText(GlobalVariable.cardOpposition)
		//Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.cardOpposition]), 10,CONTINUE_ON_FAILURE)
	}

	public static checkNotificationOnCardStatusChange()
	//1. Need to cater for dev environment as well, 2. UID is needed, 3. SCA token is needed for API, 4. email needed to get sca token
	{
		//Connect to db to get Card id to use in Card update api
		MongoClientURI connectionString = new MongoClientURI(GlobalVariable.mongoPreprodURI)
		MongoClient mongoClient = new MongoClient(connectionString)
		println ("Connect to database successfully")

		MongoDatabase mongoDb = mongoClient.getDatabase("odb_account_management")
		MongoCollection<Document> mongoUsersCollection = mongoDb.getCollection("accounts")

		Document uid_details = mongoUsersCollection.find(new Document('uid', GlobalVariable.UID)).first()
		def full_user_details = uid_details.toJson()
		println full_user_details

		JsonSlurper slurper = new JsonSlurper()
		Map parsedJson = slurper.parseText(full_user_details)
		String card_id = parsedJson.cards[0].cid
		println card_id
		GlobalVariable.card_id = card_id

		//Get SCA_TOKEN
		def signIn = WS.sendRequest(findTestObject('Object Repository/API/6- Sign in'))
		def parsed_sca = signIn.getHeaderFields().getAt("sca_token")
		String sca_token = parsed_sca.toString()
		def sca_token_trim = sca_token.substring(1,sca_token.length()-1);
		GlobalVariable.sca_token = sca_token_trim
		println sca_token_trim

		//Call API to send card
		def SEND_CARD = WS.sendRequest(findTestObject('Object Repository/API/Callback Card Status - Send'))
		String SEND_CARD_CODE = SEND_CARD.getStatusCode()
		println "Status code for sending card:" + SEND_CARD_CODE

		//UI to check tips
		visualTesting('cardSend')

		//Call API to activate card
		def ACTIVATE_CARD = WS.sendRequest(findTestObject('Object Repository/API/Callback Card Status - Activate'))
		String ACTIVATE_CARD_CODE = ACTIVATE_CARD.getStatusCode()
		println "Status code for activating card:" + ACTIVATE_CARD_CODE

		//UI to check tip
		visualTesting('cardActivated')
	}

	public static verifyOfferOnProfile(String offer)
			//Create 2 new user with offer Original and First
	{
		//View Offer on Profile
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : offer]), 10)

		//UI Verification
		if (offer == 'Oney+  First')
		{
			visualTesting('OneyFirst_overview')
		}

		if (offer == 'Oney+  Original')
		{
			visualTesting('OneyOriginal_overview')
		}

		//Click on Voir
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.homepageSee]), 10)

		//Verify that correct offer is displayed
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : offer]), 10)

		//UI verification
		if (offer == 'Oney+  First')
		{
			visualTesting('OneyFirst_details')
		}

		if (offer == 'Oney+  Original')
		{
			visualTesting('OneyOriginal_details')
		}

		//Click on Fermer
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.closeDrawer]), 10)
	}

	public static manageCard()
	//17 Oct 2022 - refactor object repo
	{
		//Click on Gérer
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.manageCard]), 10)
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.manageCard]), 10)

		visualTesting('CardManagementScreen')
	}

	public static viewOfferName(String offer)
	{
		//Verify that the correct offer is displayed
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : offer]), 10)
	}

	public static viewCardNumber()
	{
		//Click on Afficher le numero
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.displayCardNumber]), 10)
		Mobile.delay(10)

	}

	public static verifyCardNumberUI()
	{
		Mobile.delay(20)

		//Verify UI when
		visualTesting('cardNumberImg')
	}

	public static acceptAggregationTermsAndConditions()
	{

		//Verify the tips is present on homepage
		Mobile.waitForElementPresent(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.chooseBankTips]), 10)

		//Verify actionRequiredActivate
		visualTesting('homepageChooseBankTips')

		//Click on Voir
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.homepageSee]), 10)
		Mobile.delay(5)

		//Verify drawer
		visualTesting('connectBankDrawer1')

		//Click on "Connecter un compte bancaire
		//Resource-id: AUTOBALANCE_INTRODUCTION_GO_TO_AUTOBALANCE_PROCESS
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.connectBank]), 10)

		//Verify UI for drawer
		visualTesting('connectBankDrawer2')

		//Click on "Continue"
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.connectBank2]), 10)

		//Verify UI before accepting conditions
		visualTesting('connectBankDrawer3')

		//Accept Terms and Conditions
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.connectBankAcceptTC]), 10)

		//Verify UI after accept terms and conditions
		visualTesting('connectBankDrawer4')

		//Click on Continue
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.connectBankContinue]), 10)

		//Connect my bank account
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.connectMyBank]), 10)

		//Verify UI for connecting bank
		visualTesting('connectMyBankhome')

		//Tap on Connecter un compte bancaire
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.connectMyBank]), 10)

		//Verify UI for Accepting to connect bank
		visualTesting('connectMyBankAccept')

		//Verify that bank account connection can be denied
		Mobile.verifyElementExist(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.denyConnectBank]), 10)

		//Accept conditions
		Mobile.tap(findTestObject('Android/acceptSecureConnection'), 10)

		//Accept the bank account connect
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.acceptConnectBank]), 10)

	}

	public static connectToBank()
	{
		//See more banks
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.seeMoreBanks]), 10)

		//Verify List of banks UI
		visualTesting('bankList')

		//Tap on Voir plus de banques
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.seeMoreBanks]), 10)

		//Verify dropdown UI
		visualTesting('bankList_dropdown')

		//Type bank name
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.txtBankList]), 10)
		Mobile.setText(findTestObject('Common/elementText',[('elementText') : GlobalVariable.txtBankList]), "Custom Bank Oney+" ,10)

		//UI check for dropdown
		visualTesting('bankDisplayed')

		//Click on Bank name
		Mobile.tap(findTestObject('Common/selectBankFromList'), 10)

		//Input Identifiant
		Mobile.waitForElementPresent(findTestObject('Android/inputIdentifiant'), 10)

		//UI check for capture username and password screen
		visualTesting('username_passwordbank')

		//Input identifiant
		Mobile.setText(findTestObject('Android/inputIdentifiant'), "Identifiant" ,10)

		//Input Code
		Mobile.setText(findTestObject('Android/inputCode'), "1234" ,10)
		Mobile.delay(5)

		//Click on connect
		//Resource-id: ACTION_AGGREGATE_BANKAUTH_SUBMIT_FORM
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.bankAuthConnect]), 10)
		Mobile.delay(10)

		//Select from comptes lists
		visualTesting('choseBankStrangePage')

		//Select Custom bank account N1
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : 'Custom bank account N°1']), 10)

		//Click on continue
		//Resource-id: ACTION_AGGREGATE_BANKACCOUNT_SUBMIT
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.submitBankAccount]), 10)

		/*
		 //UI check for accounts display
		 visualTesting('moreThanOneAcc')
		 //Click on Account - Compte Cheque
		 Mobile.tap(findTestObject('Common/selectAccount'), 10)
		 //UI check after selecting bank accoun
		 visualTesting('selectOneAcc')
		 //Click on Continue
		 Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.submitBankAccount]), 10)
		 Mobile.delay(5)
		 */

	}

	public static renameAccount()
	{

		//Rename account - Neep to tap and clear all text before settext
		Mobile.waitForElementPresent(findTestObject('Android/renameAccount'), 20)

		//UI check for Renaming account
		visualTesting('formToRenameAcc')

		//Rename account. 1.(Get full name of the person)
		Mobile.setText(findTestObject('Android/renameAccount'), GlobalVariable.xpo_display_name_trim ,10)

		//Click on Register
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.registerBankName]), 10)

		//UI check after renaming bank name
		Mobile.delay(3)
		visualTesting('afterRenameAcc')
		Mobile.delay(10)
	}

	public static allMyAccountsConnected()
	{

		//Click on All my account are connected
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.allMyAccAreConnected]), 10)

		//Verify that the account is under review
		Mobile.delay(5)
		visualTesting('analyseTerminer')

		//Click on I understand
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.eligibilityAnalysisFinish]), 10)

		//UI Check after analysis
		visualTesting('analyseResult')

	}

	public static executeCommandforAccountActivation()
	{
		//Connect to db to get Card id to use in Card update api
		MongoClientURI connectionString = new MongoClientURI(GlobalVariable.mongoPreprodURI)
		MongoClient mongoClient = new MongoClient(connectionString)
		println ("Connect to database successfully")

		MongoDatabase mongoDb = mongoClient.getDatabase("odb_aggregation")
		MongoCollection<Document> mongoUsersCollection = mongoDb.getCollection("bankaccounts")

		Document bankacc_details = mongoUsersCollection.find(new Document('userId', GlobalVariable.UID)).first()
		def full_bankacc_details = bankacc_details.toJson()
		println full_bankacc_details

		JsonSlurper slurper = new JsonSlurper()
		Map parsedJson = slurper.parseText(full_bankacc_details)

		//to use external id instead - Still in dev yet to be deployed on preprod
		String accountId = parsedJson.provider.externalId
		//String accountId = parsedJson.id
		println accountId
		GlobalVariable.accountId = accountId

		//Execute API to activate account by passing accountID
		def customProvider = WS.sendRequest(findTestObject('Object Repository/API/custom-provider-fragile_client'))
		String customProviderCODE = customProvider.getStatusCode()
		println "Status code for custom provider:" + customProviderCODE

		Mobile.delay(120)

		MongoDatabase mongoDb1 = mongoClient.getDatabase('odb_account')
		MongoCollection<Document> mongoUsersCollection1 = mongoDb1.getCollection('users')
		Document oneyuser = mongoUsersCollection1.find(new Document('uid', GlobalVariable.UID)).first()

		def All_details1 = oneyuser.toJson()
		println(All_details1)

		Map parsedJson1 = slurper.parseText(All_details1)
		String profile_status1 = parsedJson1.user_profile.status
		println profile_status1

		//UI Check if Solde is displaying on homepage
		visualTesting('aggregationActiveHomepage')

		if (profile_status1 != 'active')
		{
			KeywordUtil.markFailed("User has not been activated")
		}

	}

	public static navigateToMyAccounts()
	{
		Mobile.delay(3)

		//Click on Mes comptes
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.myAccounts]), 10)

	}

	public static manageMyAccount()
	{

		//Wait for Gerer to appear
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.manageAccount]), 10)

		//Visual check on the accounts
		visualTesting('vosComptesConnectes')

		//Tap on Gerer
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.manageAccount]), 10)
	}

	public static deleteAggregatedBankAccount()
	{
		//Wait for pop up to appear
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.disconnectBankAccount]), 10)

		//UI Check on pop
		visualTesting('managebankAccountoptions')

		//Click on Deconnecter
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.disconnectBankAccount]), 10)

		//Wait for Summary screen
		Mobile.waitForElementPresent(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.bankAccountDeleteConfirmation]), 10)

		//Visual check of summary page
		visualTesting('bankAccountDeleteSummary')

		//Click on Deconnecter
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.bankAccountDeleteConfirmation]), 10)

		//Verify that the page is blank
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.noBankAccountText]), 10)

		//Visual check after bank account has been deleted
		visualTesting('noBankAccountDisconnect')
	}

	public static simulateTransaction3x(String card)
	{
		JsonSlurper slurper = new JsonSlurper()

		//Get token
		def XPO_ACCESS = WS.sendRequest(findTestObject('Object Repository/API/X1- SMO Get STS access token'))
		def get_token_result = slurper.parseText(XPO_ACCESS.getResponseBodyContent())
		def xpo_access_token = get_token_result.getAt("access_token")
		GlobalVariable.xpo_access_token = xpo_access_token
		println xpo_access_token

		//Execute api to simulate card transaction
		GlobalVariable.cardNo = card
		println GlobalVariable.cardNo
		def card_transaction = WS.sendRequest(findTestObject('Object Repository/API/cardAuthorization3x'))
		def result_card_transaction = slurper.parseText(card_transaction.getResponseBodyContent())

		String cardTransactionCODE = card_transaction.getStatusCode()
		println "Status code for card transaction:" + cardTransactionCODE

		//Retrieve id
		String cardauth_id = result_card_transaction.getAt("id")
		GlobalVariable.cardauth_id = cardauth_id
		println GlobalVariable.cardauth_id

		Mobile.delay(20)

		visualTesting('afterCardtransaction')
	}

	public static simulateTransaction4x(String card)
	{
		JsonSlurper slurper = new JsonSlurper()

		//Get token
		def XPO_ACCESS = WS.sendRequest(findTestObject('Object Repository/API/X1- SMO Get STS access token'))
		def get_token_result = slurper.parseText(XPO_ACCESS.getResponseBodyContent())
		def xpo_access_token = get_token_result.getAt("access_token")
		GlobalVariable.xpo_access_token = xpo_access_token
		println xpo_access_token

		//Execute api to simulate card transaction
		GlobalVariable.cardNo = card
		println GlobalVariable.cardNo
		def card_transaction = WS.sendRequest(findTestObject('Object Repository/API/cardAuthorization4x'))
		def result_card_transaction = slurper.parseText(card_transaction.getResponseBodyContent())

		String cardTransactionCODE = card_transaction.getStatusCode()
		println "Status code for card transaction:" + cardTransactionCODE

		//Retrieve id
		String cardauth_id = result_card_transaction.getAt("id")
		GlobalVariable.cardauth_id = cardauth_id
		println GlobalVariable.cardauth_id

		Mobile.delay(20)

		visualTesting('afterCardtransaction')
	}

	public static performReversalOfTransaction()
	{

		def cardreversal_transaction = WS.sendRequest(findTestObject('Object Repository/API/TransactionReversal'))
		String cardTransactionreversal = cardreversal_transaction.getStatusCode()
		println "Status code for card transaction reversal:" + cardTransactionreversal

		Mobile.delay(20)

		visualTesting("afterReversalOfTransaction")
	}

	public static checkAmountAfterReversalOfTransaction()
	{
		Mobile.delay(5)

		String finalAmtwithCurr = Mobile.getText(findTestObject('Android/getInitialAmt'), 10)
		String finalAmtwithoutCurr = finalAmtwithCurr.split('€').join("")
		String finalAmtwithoutCurrwithoutComma = finalAmtwithoutCurr.replace(',', '.')
		double finalamount = finalAmtwithoutCurrwithoutComma.toDouble()
		println finalamount
		String finalAmountAfterReversalStr = finalamount.toString()


		NumberFormat nf = NumberFormat.getInstance()
		nf.setMinimumFractionDigits(2)
		nf.setMaximumFractionDigits(2)

		String expectedAmtAfterReversal = nf.format(GlobalVariable.initialAmt)
		String expectedAmtAfterReversalstr = expectedAmtAfterReversal.toString()
		println expectedAmtAfterReversalstr

		Mobile.verifyMatch(finalAmountAfterReversalStr, expectedAmtAfterReversal, false)

		String annule = Mobile.getText(findTestObject('Common/cancelledTransaction'), 10)
		Mobile.verifyMatch(annule, 'Annulée', false)
	}

	public static splitPaymentx3()
	{

		Mobile.delay(3)

		//Click on Fractionner button on Homepage
		Mobile.tap(findTestObject('Common/splitTransaction',[('elementText') : GlobalVariable.split]), 10)

		Mobile.delay(3)

		//UI check
		visualTesting('splitPaymentscreen')

		//Verify that the amount for 3x and 4x tab menu are correctly calculated
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.amount3x]), 10)
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.amount4x]), 10)

		//Verify amount for first echenance and frais de fractionnement
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.firstPayment_fraisFractionnementx3]), 10)

		//Verify amount due
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.amountDuex3]), 10)

		//Click on Fractionner button on "Choisissez le nombre de mensualites
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.Fractionner]), 10)
	}

	public static splitPaymentx4()
	{

		Mobile.delay(3)

		//Click on Fractionner button on Homepage
		Mobile.tap(findTestObject('Common/splitTransaction',[('elementText') : GlobalVariable.split]), 10)

		Mobile.delay(3)


		//Verify that the amount for 3x and 4x tab menu are correctly calculated
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.amount3x]), 10)
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.amount4x]), 10)

		//Click on 4x
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.select4xFractionner]), 10)

		Mobile.delay(3)

		//UI check
		visualTesting('splitPaymentscreen')

		//Verify amount for first echenance and frais de fractionnement
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.firstPayment_fraisFractionnementx4]), 10)

		//Verify amount due
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.amountDuex4]), 10)

		//Click on Fractionner button on "Choisissez le nombre de mensualites
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.Fractionner]), 10)
	}

	public static proceedWithSplitPayment()
	{
		Mobile.delay(5)

		//Verify UI of contract page
		visualTesting('fractionnerContractScreen')

		//Check radio button
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.fractionnerTermsConditions]), 10)

		Mobile.delay(5)

		//Click on Subscribe button
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.fractionnerSouscrire]), 10)

		Mobile.delay(5)
	}

	public static rateApp()
	{
		Mobile.delay(5)

		if (Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.rateApp]), 50) == true)
		{
			//Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.rateApp]), 10)
			//Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.rateAppSubmit]), 10)
			//Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.submitAppRating]), 10)
			//Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.rateAppSubmit]), 10)

			Mobile.tap(findTestObject('Common/closeRateApp'), 10)

		}
	}

	public static verifySplitPaymentAppearsOnHomepage()
	{
		Mobile.delay(5)

		//UI check of split payment on Homepage
		visualTesting('splitPaymentHomePage')

		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.splitAppearsOnHomepage]), 10)
	}

	public static verifyAmountIsUpdatedAfter3xSplitpayment()

	{
		String finalAmtwithCurr = Mobile.getText(findTestObject('Android/getInitialAmt'), 10)
		String finalAmtwithoutCurr = finalAmtwithCurr.split('€').join("")
		String finalAmtwithoutCurrwithoutComma = finalAmtwithoutCurr.replace(',', '.')
		double finalamount = finalAmtwithoutCurrwithoutComma.toDouble()
		println finalamount

		NumberFormat nf = NumberFormat.getInstance()
		nf.setMinimumFractionDigits(2)
		nf.setMaximumFractionDigits(2)

		double cal3x = ((3.18) - ((3.18/3) + (0.0145*3.18)))
		println cal3x

		String expectedAmtAfter3xSplit = nf.format(GlobalVariable.initialAmt - 3.18 + cal3x)
		String expectedAmtAfter3xSplitstr = expectedAmtAfter3xSplit.toString()
		println expectedAmtAfter3xSplitstr
		String finalAmountAfter3xSplitStr = finalamount.toString()
		GlobalVariable.autobalanceFilterExpAmt3xSplit = expectedAmtAfter3xSplitstr
		Mobile.verifyMatch(finalAmountAfter3xSplitStr, expectedAmtAfter3xSplitstr, false)

		visualTesting('amountUpdatedAfter3x')
	}

	public static verifyAmountIsUpdatedAfter4xSplitpayment()

	{
		String finalAmtwithCurr = Mobile.getText(findTestObject('Android/getInitialAmt'), 10)
		String finalAmtwithoutCurr = finalAmtwithCurr.split('€').join("")
		String finalAmtwithoutCurrwithoutComma = finalAmtwithoutCurr.replace(',', '.')
		double finalamount = finalAmtwithoutCurrwithoutComma.toDouble()
		println finalamount

		NumberFormat nf = NumberFormat.getInstance()
		nf.setMinimumFractionDigits(2)
		nf.setMaximumFractionDigits(2)

		double cal4x = ((3.18) - ((3.18/4) + (0.022*3.18)))
		println cal4x

		String expectedAmtAfter4xSplit = nf.format(GlobalVariable.initialAmt - 3.18 + cal4x)
		String expectedAmtAfter4xSplitstr = expectedAmtAfter4xSplit.toString()
		println expectedAmtAfter4xSplitstr
		String finalAmountAfter4xSplitStr = finalamount.toString()
		GlobalVariable.autobalanceFilterExpAmt4xSplit = expectedAmtAfter4xSplitstr
		Mobile.verifyMatch(finalAmountAfter4xSplitStr, expectedAmtAfter4xSplitstr, false)

		visualTesting('amountUpdatedAfter4x')
	}


	public static verifySplitPaymentAppearsOnAllContracts()
	{
		//Click on fractionnements
		Mobile.waitForElementPresent(findTestObject('Common/homepage_actions_fractionnements'), 10)
		Mobile.tap(findTestObject('Common/homepage_actions_fractionnements'), 10)

		//Wait for the page to load by waiting on tous mes contracts
		Mobile.waitForElementPresent(findTestObject('Common/elementText',[('elementText') : GlobalVariable.fractionnementsAllMyContracts]), 10)

		//UI Check to view Fractionnements homescreen
		visualTesting('fractionnementHomeScreen')

		//Click on tous mes contract
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.fractionnementsAllMyContracts]), 10)

		//Verify that the fractionement is En cours
		Mobile.delay(5)
		Mobile.verifyElementExist(findTestObject('Common/fractionnement_firstnode'), 10)

		//UI check for all split contracts
		visualTesting('allmycontracts')

		//Click on most recent transaction
		Mobile.tap(findTestObject('Common/fractionnement_firstnode'), 10)

		//UI check for most recent split contract
		visualTesting('mostrecent_allmycontracts')
	}

	public static proceedWithRetract()
	{
		//Click on Rétracter de mon paiement fractionné
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.retractPaymentFractionner]), 10)

		//UI check
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountCloseConfirm]), 10)
		visualTesting('confirmRetracter')

		//Click on confirmer
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.accountCloseConfirm]), 10)

		//Verify that summary screen is displayed
		Mobile.verifyElementExist(findTestObject('Common/retractSummaryConfirm'), 10)

		//UI Check
		visualTesting('retractSummaryScreen')

		//Click on confirmer
		Mobile.tap(findTestObject('Common/retractSummaryConfirm'), 10)

		//Verify that the terminer button is displayed
		Mobile.verifyElementExist(findTestObject('Common/elementText',[('elementText') : GlobalVariable.retractTerminer]), 10)

		//UI Check for Retraction terminer
		visualTesting('retractionTerminer')

		//Click on Terminer
		Mobile.tap(findTestObject('Common/elementText',[('elementText') : GlobalVariable.retractTerminer]), 10)

		//Verify after retraction page - en cour
		Mobile.delay(5)
		visualTesting('FinancementAnnulerEnCour')
	}

	public static checkAmountBeforeCardAuthorization()
	{
		Mobile.delay(5)

		//UI check before performing a transaction
		visualTesting("autobalanceHomepageBeforeDeduct")

		//Get initial amount
		String iniAmtwithCurr = Mobile.getText(findTestObject('Android/getInitialAmt'), 10)
		String iniAmtwithoutCurr = iniAmtwithCurr.split('€').join("")
		String iniAmtwithoutCurrwithoutComma = iniAmtwithoutCurr.replace(',', '.')
		double amount = iniAmtwithoutCurrwithoutComma.toDouble()
		println amount
		GlobalVariable.initialAmt = amount
	}

	public static checkAmountAfterCardAuthorization()
	{
		Mobile.delay(3)

		//UI check before performing a transaction
		visualTesting("autobalanceHomepageAfterDeduct")

		//Verify final amount on homepage
		String finalAmtwithCurr = Mobile.getText(findTestObject('Android/getInitialAmt'), 10)
		String finalAmtwithoutCurr = finalAmtwithCurr.split('€').join("")
		String finalAmtwithoutCurrwithoutComma = finalAmtwithoutCurr.replace(',', '.')
		double finalamount = finalAmtwithoutCurrwithoutComma.toDouble()
		println finalamount

		NumberFormat nf = NumberFormat.getInstance()
		nf.setMinimumFractionDigits(2)
		nf.setMaximumFractionDigits(2)

		String expectedAmt = nf.format(GlobalVariable.initialAmt - 3.18)
		String expectedAmtstr = expectedAmt.toString()
		println expectedAmtstr
		String finalAmountStr = finalamount.toString()
		GlobalVariable.autobalanceFilterExpAmt = expectedAmtstr
		Mobile.comment(GlobalVariable.autobalanceFilterExpAmt)
		Mobile.verifyMatch(finalAmountStr, expectedAmtstr, false)

	}

	public static verifyOperationUnderBankAccount()
	{
		//Click on bank account
		Mobile.tap(findTestObject('Common/elementTestID',[('elementTestID') : GlobalVariable.bankAccountBB]), 10)

		//Verify that object to retrieve current amount is displayed
		Mobile.verifyElementExist(findTestObject('Android/autoBalanceAmountOps'), 10)

		//UI check
		visualTesting('autobalanceAllOperations')

		Mobile.delay(5)

		//Verify amount
		String filterAmtwithCurr = Mobile.getText(findTestObject('Android/autoBalanceAmountOps'), 10)
		String finalfilterAmtwithoutCurr = filterAmtwithCurr.split('€').join("")
		String finalfilterAmtwithoutCurrwithoutComma = finalfilterAmtwithoutCurr.replace(',', '.')
		println finalfilterAmtwithoutCurrwithoutComma
		Mobile.verifyMatch(finalfilterAmtwithoutCurrwithoutComma, GlobalVariable.autobalanceFilterExpAmt, false)

		Mobile.verifyElementExist(findTestObject('Common/todayText'), 10)
		Mobile.verifyElementExist(findTestObject('Common/splitTransactionOnAllOps'), 10)
	}

	public static performClearingOfTransaction()
	{
		def cardclearing_transaction = WS.sendRequest(findTestObject('Object Repository/API/transactionClearing'))
		String cardTransactionClearing = cardclearing_transaction.getStatusCode()
		println "Status code for card transaction clearing:" + cardTransactionClearing

		Mobile.delay(20)

		visualTesting("afterClearingOfTransaction")
	}

	public static verifySplitPaymentCannotBePerformedOnTransaction()
	{
		Mobile.delay(5)

		//Verify that fractionner button is not available
		Mobile.verifyElementNotExist(findTestObject('Common/splitTransaction',[('elementText') : GlobalVariable.split]), 20)

	}

}