Feature: Login User

  Scenario: User valid Login
    Given user go to login page
    When user enter username and password
    And user click button login
    Then go to page valid login