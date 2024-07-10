#Author: rgungah@partner.oney.fr
#https://oneytemp.atlassian.net/browse/ON-9764
@FAQ
Feature: Frequently Asked Question
  Testing of FAQs section for logged and unauthorized user

  @LoggedUserSearchingByExistingKeyword @TEST_XRAY-1424
  Scenario Outline: Verify that an logged user can search questions by entering a existing keyword
    Given <logged_user> accesses FAQ on Help page
    When user types in <keyword>
    Then user should see <questions> related to the keyword
    And user should be able to choose the <questions> to view <answers>

    Examples: 
      | logged_user          | keyword | questions                                  | answers                                                                                                                                                             |
      | ljo_1635@mailsac.com | R       | Pourquoi connecter mes comptes bancaires ? | Connectez vos comptes bancaires vous permet de centraliser sur votre application tous vos comptes bancaires, même s’ils sont détenus dans des banques différentes.  |

  @LoggedUserSearchingByNonExistingKeyword @TEST_XRAY-1425
  Scenario Outline: Verify that an logged user can search questions by entering a non-existing keyword
    Given <logged_user> accesses FAQ on Help page
    When user types in <keyword>
    Then user should see no questions

    Examples: 
      | logged_user          | keyword |
      | ljo_1635@mailsac.com | Boule   |

  @LoggedUserSearchingByChoosingThematiques @TEST_XRAY-1426
  Scenario Outline: Verify that an logged user can search questions by choosing a thematique
    Given <logged_user> accesses FAQ on Help page
    When user chooses a <thematique>
    And user picks a <sub_category> of the thematique
    Then user should see <questions> related to the thematique
    And user should be able to view the <answer> by choosing a question

    Examples: 
      | logged_user          | thematique       | sub_category        | questions                                 | answer                                                                                              |
      | ljo_1635@mailsac.com | Mon compte Oney+ | Compte au quotidien | Comment augmenter mon plafond de compte ? | Si votre compte est déjà déplafonné, sachez que son plafond est calculé en fonction de vos revenus. |

  @LoggedUserSearchingByChoosingQuestion @TEST_XRAY-1427
  Scenario Outline: Verify that an logged user can search questions by choosing an already defined frequently asked question
    Given <logged_user> accesses FAQ on Help page
    When user picks a pre-defined <question>
    Then user should be able to see the <answer>

    Examples: 
      | logged_user          | question                               | answer                                                                                             |
      | ljo_1635@mailsac.com | Comment savoir où en est mon dossier ? | Un lien figure dans chacun des mails que nous vous avons envoyés concernant votre demande de prêt. |

  @UnauthenticatedUserSearchingByExistingKeyword @TEST_XRAY-1420
  Scenario Outline: Verify that an unauthenticated user can search questions by entering a existing keyword
    Given unauthenticated user is on FAQ page
    When user types in <keyword>
    Then user should see <questions> related to the keyword
    And user should be able to choose the <questions> to view <answers>

    Examples: 
      | keyword | questions                                  | answers                                                                                                                                                             |
      | R       | Pourquoi connecter mes comptes bancaires ? | Connectez vos comptes bancaires vous permet de centraliser sur votre application tous vos comptes bancaires, même s’ils sont détenus dans des banques différentes.  |

  @UnauthenticatedUserSearchingByNonExistingKeyword @TEST_XRAY-1421
  Scenario Outline: Verify that an unauthenticated user can search questions by entering a non-existing keyword
    Given unauthenticated user is on FAQ page
    When user types in <keyword>
    Then user should see no questions

    Examples: 
      | keyword |
      | Boule   |

  @UnauthenticatedUserSearchingByChoosingThematiques @TEST_XRAY-1422
  Scenario Outline: Verify that an unauthenticated user can search questions by choosing a thematique
    Given unauthenticated user is on FAQ page
    When user chooses a <thematique>
    And user picks a <sub_category> of the thematique
    Then user should see <questions> related to the thematique
    And user should be able to view the <answer> by choosing a question

    Examples: 
      | thematique       | sub_category        | questions                                 | answer                                                                                              |
      | Mon compte Oney+ | Compte au quotidien | Comment augmenter mon plafond de compte ? | Si votre compte est déjà déplafonné, sachez que son plafond est calculé en fonction de vos revenus. |

  @UnauthenticatedUserSearchingByChoosingQuestion @TEST_XRAY-1423
  Scenario Outline: Verify that an unauthenticated user can search questions by choosing an already defined frequently asked question
    Given unauthenticated user is on FAQ page
    When user picks a pre-defined <question>
    Then user should be able to see the <answer>

    Examples: 
      | question                               | answer                                                                                             |
      | Comment savoir où en est mon dossier ? | Un lien figure dans chacun des mails que nous vous avons envoyés concernant votre demande de prêt. |
