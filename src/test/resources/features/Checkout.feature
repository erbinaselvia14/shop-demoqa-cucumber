Feature: Place Order

  Scenario: user check out item
    Given user go to login page web
    When search dress item
    And add dress item
    When search shirt item
    And add shirt item
    When user filling billing
    And user place order
    Then validate valid scenario