@test
Feature: Search for a movie
  As a user of the ShowCase app
  I want to search for a movie
  So that I can view its details

  Scenario: Search for a movie by name
    Given I have launched the ShowCase app
    When I search for a movie named "Inception"
    Then I should see "Inception" in the search results
    And I go back to home page by clicking back button
    And I should see app home page