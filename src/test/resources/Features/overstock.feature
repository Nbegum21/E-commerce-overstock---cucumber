@test_overstock
Feature: overstock Test Functionalities

  Background:
    Given a user is on the Home Page
    And click on No Thanks

  @Positive_test
  Scenario:  check login is successful with valid credentials
    When user Mouse hover to account option and click sign in option
    And user enter email"nbegum.realtor@gmail.com" and password"Lovely1234"
    And user click on sign in Button
    Then user is navigated to homepage page

  @dataDriven_YestMultiUser
  Scenario Outline: check login is successful with valid credentials for multiple users
    When user Mouse hover to account option and click sign in option
    And user enter email"<email>" and password"<password>"
    And user click on sign in Button
    Then user is navigated to homepage page
    Examples:
      |  email                   |password   |
      |nbegum.realtor@gmail.com  | Lovely1234|
      |delightfulnur80@yahoo.com | Qatek2022 |



  @dataDriven_test
  Scenario:  check user is successful login using Data table s
    When user Mouse hover to account option and click sign in option
    And  user click on login button upon entering credentials
      | email                    |password     |
      |nbegum.realtor@gmail.com |Lovely1234   |
    Then user is navigated to homepage page


  @negative_test
  Scenario:  check Sign in is unsuccessful with invalid credentials
    When user Mouse hover to account option and click sign in option
    And user enter email"nbegum.realtor@gmail.com" and password"Lovely12"
    And user click on sign in Button
    Then  user is failed to sign in



  @JewelryItem_test
  Scenario: user searching for purchase  movado women watches from jewelry  page
    When a user search for a Movado Womens Watch from searching bar
    And user clicked on item from searching result
    And user add the item  to the cart for purchase movado watch
    Then  user successfully checkout the item from the cart


  @WallDecorItem_test
  Scenario:  user checking for wall decor Items
    When a user searching for Wall Decor items
    And user select a Metal 36.5" Wall Decor, Multi item from the searching result
    And user add the item  to the cart from the product page
    Then  user able to checkout successfully  from the cart

   @Furniture_purchase
    Scenario: Purchase a tv stand from the Furniture page
      When a user searching for fireplace TV stand from search bar
      And the user clicked Strick & Bolton Amsden Electric Fireplace TV Stand from the search result
      And the user add the Tv stand to the cart with the preferred configuration for the purchase
      Then the tv stand is purchased successfully

     @KidsItem_test
     Scenario: check baby gift from the kids page
       When user able to click on Kids button
       And user able to click on gift for kids and able to select the kids storage
       And user able to click on add to cart button
       Then user landed on check out page

  @HomeImproveItem_test
      Scenario: purchase a Portable Air Conditioner form Home Improve page
        When a user searching for Portable Air Conditioners click on search button
        And User click on  item from searching product page
        And user able to click on add to cart button from selecting item
        Then user the item purchase successfully


@OutDoorItem_test
  Scenario: Purchase a garden Accents wooden Metal Lanterns Set from outdoor item
    When a user click on outdoor option for purchase garden Accents  items
    And user select a item from garden accents page
    And user able to added the item to cart from product page
    Then user successfully purchased the clearance item form the cart














