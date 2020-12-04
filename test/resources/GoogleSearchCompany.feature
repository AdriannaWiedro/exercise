Feature: google search news about company
  As candidate for an internship, I want to search Google, so that I can check interesting facts about the company

  Scenario: Search information about company

    Given I am on the Google search page
    When I search for "Staples Gdansk"
    Then the page title should start with "Staples"
    And the result page displays the related links
    Then I choose the link at the top
    And the necessary information is displayed