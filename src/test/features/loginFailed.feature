Feature: Login Failed
  @Negative
  Scenario: User Failed Login

    Given User launch the application
    When User input unregistered username
    And User input registered password for failed
    And User click login button for failed
    Then error message launched