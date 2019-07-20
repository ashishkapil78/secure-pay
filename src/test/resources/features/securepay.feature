Feature: SecurepayTest
  To search securepay on google and complete contact form without submitting

  Scenario: search Securepay
    Given Launch google page
    When I search securepay on google
    Then I click securepay
    When I click contact us menu
    Then Contact-us page is displayed
    Then Contact-us form is completed