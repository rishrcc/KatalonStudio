#Author: rgungah@partner.oney.fr
#https://oneytemp.atlassian.net/browse/ON-9942
@FormulaireDeContact
Feature: Send request to Help Service
  Testing of FormulaireDeContact for logged and unauthorized user

  @LoggedUserSendingRequestByChoosingThematiqueAndImage @TEST_XRAY-1455
  Scenario Outline: Verify that an logged user can send a request by choosing a thematique and by uploading an image
    Given <logged_user> accesses Contacter-nous on Help page
    And <logged_user> details are already filled in
    When user selects <thematique>
    And user specify <request> by uploading an image
    Then user should be able to send the request

    Examples: 
      | logged_user          | thematique | request                |
      | ljo_1635@mailsac.com | Mon compte | My card is not working |

  @LoggedUserSendingRequestByChoosingThematiqueAndPDF @TEST_XRAY-1456
  Scenario Outline: Verify that an logged user can send a request by choosing a thematique and by uploading a PDF
    Given <logged_user> accesses Contacter-nous on Help page
    And <logged_user> details are already filled in
    When user selects <thematique>
    And user makes a <request> by uploading a pdf
    Then user should be able to send the request

    Examples: 
      | logged_user          | thematique | request                |
      | ljo_1635@mailsac.com | Mon compte | My card is not working |

  @LoggedUserCannotSendRequestIfThematiqueIsNotSelected @TEST_XRAY-1457
  Scenario Outline: Verify that an logged user cannot send a request if a thematique is not selected
    Given <logged_user> accesses Contacter-nous on Help page
    And <logged_user> details are already filled in
    And user makes a <request> by uploading a pdf
    Then user should not be able to send the request

    Examples: 
      | logged_user          | request                |
      | ljo_1635@mailsac.com | My card is not working |

  @LoggedUserCannotSendRequestIfRequestIsNotEntered @TEST_XRAY-1458
  Scenario Outline: Verify that an logged user cannot send a request if a request is not entered
    Given <logged_user> accesses Contacter-nous on Help page
    And <logged_user> details are already filled in
    When user selects <thematique>
    Then user should not be able to send the request

    Examples: 
      | logged_user          | thematique |
      | ljo_1635@mailsac.com | Mon compte |

  @UnauthenticatedUserSendingRequestByChoosingThematiqueAndImage @TEST_XRAY-1459
  Scenario Outline: Verify that an unauthenticated user can send a request by choosing a thematique and by uploading an image
    Given unauthenticated user navigates to Contacter-nous on Help page
    When user selects <thematique>
    And user specify <request> by uploading an image
    And user fills in his <civilite>,<Prenom>,<Nom>,<Email>,<MobileNum>
    Then user should be able to send the request by validating the information provided

    Examples: 
      | thematique | request                | civilite | Prenom | Nom   | Email                | MobileNum |
      | Mon compte | My card is not working | Monsieur | Fname  | Lname | ljo_1635@mailsac.com | 658412568 |

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

  @UnauthenticatedUserCannotSendRequestIfThematiqueIsNotSelected @TEST_XRAY-1461
  Scenario Outline: Verify that an unauthenticated user cannot send a request if a thematique is not selected
    Given unauthenticated user navigates to Contacter-nous on Help page
    And user makes a <request> by uploading a pdf
    And user fills in his <civilite>,<Prenom>,<Nom>,<Email>,<MobileNum>
    Then user should not be able to validate the request

    Examples: 
      | request                | civilite | Prenom | Nom   | Email                | MobileNum |
      | My card is not working | Monsieur | Fname  | Lname | ljo_1635@mailsac.com | 658412568 |

  @UnauthenticatedUserCannotSendRequestIfRequestIsNotEntered @TEST_XRAY-1462
  Scenario Outline: Verify that an unauthenticated user cannot send a request if a request is not entered
    Given unauthenticated user navigates to Contacter-nous on Help page
    When user selects <thematique>
    And user fills in his <civilite>,<Prenom>,<Nom>,<Email>,<MobileNum>
    Then user should not be able to validate the request

    Examples: 
      | thematique | civilite | Prenom | Nom   | Email                | MobileNum |
      | Mon compte | Monsieur | Fname  | Lname | ljo_1635@mailsac.com | 658412568 |

  @UnauthenticatedUserCannotSendRequestIfPersonalDetailsAreNotEntered @TEST_XRAY-1463
  Scenario Outline: Verify that an unauthenticated user cannot send a request if personal details are not entered
    Given unauthenticated user navigates to Contacter-nous on Help page
    When user selects <thematique>
    And user makes a <request> by uploading a pdf
    Then user should not be able to validate the request

    Examples: 
      | thematique | request                |
      | Mon compte | My card is not working |

  @UnauthenticatedUserCannotSendRequestIfEmailFormatIsWrong @TEST_XRAY-1464
  Scenario Outline: Verify that an unauthenticated user cannot send a request if email format is incorrect
    Given unauthenticated user navigates to Contacter-nous on Help page
    When user selects <thematique>
    And user makes a <request> by uploading a pdf
    And user fills in his <civilite>,<Prenom>,<Nom>,<Email>,<MobileNum>
    Then user should not be able to validate the request

    Examples: 
      | thematique | request                | civilite | Prenom | Nom   | Email    | MobileNum |
      | Mon compte | My card is not working | Monsieur | Fname  | Lname | ljo_1635 | 658412568 |

  @UnauthenticatedUserCannotSendRequestIfMobileNumberIsWrong @TEST_XRAY-1465
  Scenario Outline: Verify that an unauthenticated user cannot send a request if mobile number is incorrect
    Given unauthenticated user navigates to Contacter-nous on Help page
    When user selects <thematique>
    And user makes a <request> by uploading a pdf
    And user fills in his <civilite>,<Prenom>,<Nom>,<Email>,<MobileNum>
    Then user should not be able to validate the request

    Examples: 
      | thematique | request                | civilite | Prenom | Nom   | Email                | MobileNum    |
      | Mon compte | My card is not working | Monsieur | Fname  | Lname | ljo_1635@mailsac.com | 658412568777 |
