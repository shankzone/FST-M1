@activity4
Feature: Data driven test without Example

  Scenario: Testing with Data from Scenario
    Given User is on Activity 4 Login page
    When User enters act4 "admin" and "password"
    Then Read the act4 page title and confirmation message
    And Close the act4 Browser
