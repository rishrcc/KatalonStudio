import com.utils.Actions

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class FormulaireDeContact {

	//@LoggedUserSendingRequestByChoosingThematiqueAndImage
	@Given("(.*) accesses Contacter-nous on Help page")
	def logged_user_acesses_Contact_Nous_on_Help_page(String logged_user) {

		Actions.loginWithAnotherAccount(logged_user)
		Actions.inputStrongAuthenticationCode()
		Actions.skipPinCode()
		Actions.clickOnProfileIcon()
		Actions.clickOnAideProfilePage()
		Actions.clickOnContactezNous()
	}

	@And("(.*) details are already filled in")
	def user_details_are_already_filled_in(String logged_user) {

		Actions.verifyUserEmailFilledIn(logged_user)
	}

	@When("user selects (.*)")
	def user_selects_thematique(String thematique) {

		Actions.chooseAThematique(thematique)
	}

	@And("user specify (.*) by uploading an image")
	def user_specify_request_by_uploading_an_image(String request) {

		Actions.preciseRequest(request)
		Actions.uploadImage()
		Actions.clickOnSaveDemande()
	}

	@And("user makes a (.*) by uploading a pdf")
	def user_makes_a_request_by_uploading_a_pdf(String request) {

		Actions.preciseRequest(request)
		Actions.uploadPDF()
		Actions.clickOnSaveDemande()
	}

	@Then("user should be able to send the request")
	def user_should_be_able_to_send_the_request() {
		Actions.sendDemandeRequest()
	}

	//@LoggedUserCannotSendRequestIfThematiqueIsNotSelected
	@Then("user should not be able to send the request")
	def user_should_not_be_able_to_send_the_request() {
		Actions.sendDemandeRequestNotSent()
	}

	//@UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage
	@Given("unauthenticated user navigates to Contacter-nous on Help page")
	def unauthenticated_user_navigates_to_Contacter_nous_on_Help_page() {

		Actions.clickOnAideOnLoginPage()
		Actions.clickOnContactezNous()
	}

	//@UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage
	@And("user fills in his (.*),(.*),(.*),(.*),(.*)")
	def user_fills_in_his_civilite_Prenom_Nom_Email_MobileNum(String civilite,String Prenom,String Nom,String Email,String MobileNum) {
		Actions.fillContactUsForm(civilite, Prenom, Nom, Email, MobileNum)
	}

	@Then("user should be able to send the request by validating the information provided")
	def user_should_be_able_to_send_the_request_by_validating_the_information_provided() {
		Actions.validateContactUsForm()
		Actions.verifyContactUsRequestSent()
	}

	//@UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected
	@Then("user should not be able to validate the request")
	def user_should_not_be_able_to_validate_the_request() {
		Actions.validateContactUsForm()
		Actions.verifyContactUsNotRequestSent()
	}
}