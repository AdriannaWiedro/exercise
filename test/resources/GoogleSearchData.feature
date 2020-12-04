Feature: google search actual data
  As a user, I want to search Google, so that I can check the actual date

  Scenario: Search information about current date
    Given I am on the Google search page
    When I search for "data"
    Then the page title should start with "data"
    And the result page displays the text
    