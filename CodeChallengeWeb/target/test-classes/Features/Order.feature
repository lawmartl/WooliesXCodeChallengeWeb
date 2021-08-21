Feature: feature to test order placement

  ## Script Enhancements
  ## -------------------
  ## 1. We can increase the coverage by considering few other flows like:
  ## 		1.1. Add items from POPULAR/BEST SELLER categories displayed in the home page.
  ## 		1.2. Add items from sections like WOMEN/DRESSES/T-SHIRTS.
  ## 		1.3. Add items to the cart as a guest user and login during checkout process.
  ## 2. We can capture step-by-step screenshots which will help developers to reproduce any issues.
  ## 3. We can export captured values like Total Price, Order Reference Number etc. to excel spreadsheet for easy reference.
  ##
  ## Assumptions
  ## -----------
  ## 1. Item1 and Item2 should be full name of the items as displayed in the application.
  ## 2. If search results display more than one item with the same name, script will pick the first item.
  ##
  @Test
  Scenario Outline: user wants to be able to add 2 items to the cart and place an order
    Given application is launched
    And user is logged in using <username> and <password>
    And user add <item1> to the cart
    And user add <item2> to the cart
    When user proceed to checkout
    And user selects payment method as <paymentmethod>
    Then order is completed

    Examples: 
      | username                         | password | item1                       | item2                 | paymentmethod |
      | testuserautopractice@yopmail.com | test123  | Faded Short Sleeve T-shirts | Printed Chiffon Dress | bankwire      |
