Feature: Add To Cart
  @AddToCart
  Scenario: User Success add to cart some product
    Given User launch the application to add the cart
    When User click 'Add To Cart' button
    And User click the button with the cart logo
    Then Page cart will launch
