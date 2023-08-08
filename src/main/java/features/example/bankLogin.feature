@test
Feature: Application login
  Scenario: Admin Page default login
    Given User is on Banking landing page
    When User login to application
    Then User verify Home Page displayed
    And User click on "Cards" tab
    Then User verify Cards displayed








