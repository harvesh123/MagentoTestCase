Feature: Purchase functionality of Magento Application

  Background: Generate Random User By User Generator
    Given Generate User On RandomUser

  Scenario: Verification of Purchase was successful
    Given Open Register User Page Of Magento Application
    And Enter Fields Value In Register User Page
    Then Verify User Successfully Registration
    And Go to Men Store Section
    And Click on Any Item to purchase
    Then Select Size Color and click on Add To Cart
    And Click on Checkout Page Button
    Then Enter Shipping Address Details In Page
    And Click on FlatRate Option And Click On Next Page Button
    Then Click On Place Order Button and Verify that the purchase was successful


