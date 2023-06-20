@activity5
Feature: Data driven test with Example

Scenario Outline: Testing with Data from Scenario
    Given User is on act5 Login page
    When User enters act5 "<Usernames>" and "<Passwords>"
    Then Read the act5 page title and confirmation message
    And Close the Act5 Browser

Examples:
    | Usernames | Passwords |
    | admin     | password  |
    | adminUser | Password  |