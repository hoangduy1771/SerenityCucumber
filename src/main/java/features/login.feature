@Smoke
Feature: Feature to test login function

  @SmokeTest @test
  Scenario Outline: Check login is successful with valid credentials
    Given User navigate to "https://example.testproject.io/web/"
    When User enters <username> and <password>
    And User clicks on "login" button
    Then User can navigate to the homepage
    Examples:
      | username | password |
      | example  | 12345    |
      | HoangDuy | 12345    |