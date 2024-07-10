#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @UnauthenticatedUserSendingRequestByChoosingThematiqueAndPDF @TEST_XRAY-1460
  Scenario Outline: Verify that an unauthenticated user can send a request by choosing a thematique and by uploading an image
    Given unauthenticated user navigates to Contacter-nous on Help page
    When user selects <thematique>
    And user makes a <request> by uploading a pdf
    And user fills in his <civilite>,<Prenom>,<Nom>,<Email>,<MobileNum>
    Then user should be able to send the request by validating the information provided

    Examples: 
      | thematique | request                | civilite | Prenom | Nom   | Email                | MobileNum |
      | Mon compte | My card is not working | Monsieur | Fname  | Lname | ljo_1635@mailsac.com | 658412568 |