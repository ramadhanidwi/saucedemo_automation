Feature: Checkout
  @Checkout
  Scenario: User Success Checkout Some Products
    Given User in page cart
    And User click Add To Cart button for products want to buy
    And User click Cart button
    Then User is on Your Cart page
    And User click Checkout button
    Then User is on form personal data page
    And User input firstname
    And User input lastname
    And User input postal code
    And User click Continue button
    Then User is on overview page
    And User click Finish button
    Then a success message page is launch