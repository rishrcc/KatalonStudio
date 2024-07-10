import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import com.utils.*


class FAQ {

	//@UnauthenticatedUserSearchingByExistingKeyword

	@Given("unauthenticated user is on FAQ page")
	def unlogged_user_acesses_FAQ_on_Help_page()
	{
		Actions.clickOnAideOnLoginPage()
		Actions.clickonConsultFAQ()
	}

	@When("user types in (.*)")
	def user_types_in_existing_keyword(String keyword)
	{
		Actions.typeKeyword(keyword)
	}

	@Then("user should see (.*) related to the keyword")
	def user_should_see_questions_related_to_the_keyword(String questions)
	{
		Actions.verifyListedQuestion(questions)
	}

	@And("user should be able to choose the (.*) to view (.*)")
	def user_should_be_able_to_choose_the_question_to_view_answers(String questions, String answers)
	{
		Actions.verifyCorrectAnswerIsDisplayed(questions,answers)
	}

	//@UnauthenticatedUserSearchingByNonExistingKeyword

	@Then("user should see no questions")
	def user_should_see_no_questions()
	{
		Actions.verifyNoAutoCompleteQueriesAreDisplayed()
	}


	//@UnauthenticatedUserSearchingByChoosingThematiques

	@When("user chooses a (.*)")
	def user_chooses_a_thematique(String thematique)
	{
		Actions.clickOnlistedThematique(thematique)
	}

	@And("user picks a (.*) of the thematique")
	def user_selects_a_sub_category_of_the_thematique(String sub_category)
	{
		Actions.clickOnThematiqueSubCategory(sub_category)
	}


	@Then("user should see (.*) related to the thematique")
	def user_should_see_questions_related_to_the_thematique(String questions)
	{
		Actions.clickOnThematiqueQuestion(questions)
	}

	@And("user should be able to view the (.*) by choosing a question")
	def user_should_be_able_to_view_the_answer_by_choosing_a_question(String answer)
	{
		Actions.verifyAnswerForThematique(answer)
	}

	//@UnauthenticatedUserSearchingByChoosingQuestion

	@When("user picks a pre-defined (.*)")
	def user_chooses_a_predefined_question(String question)
	{
		Actions.scrollDown()
		Actions.clickOnPredefinedQuestion(question)
	}

	@Then("user should be able to see the (.*)")
	def user_should_be_able_to_view_the_answer(String answer)
	{
		Actions.verifyAnswerForPredefinedQuestion(answer)
	}

	//@LoggedUserSearchingByExistingKeyword

	@Given("(.*) accesses FAQ on Help page")
	def logged_user_acesses_FAQ_on_Help_page(String logged_user)
	{
		Actions.loginWithAnotherAccount(logged_user)
		Actions.inputStrongAuthenticationCode()
		Actions.skipPinCode()
		Actions.clickOnProfileIcon()
		Actions.clickOnAideProfilePage()
		Actions.clickonConsultFAQ()
	}

}