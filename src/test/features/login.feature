Feature: Login Into Application
  @Positive
  Scenario: User Success Login

    Given User launch the application success
    And User input registered username
    And User input registered password
    And User click login button
    Then Page home launched

