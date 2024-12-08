@test
Feature: Search for a movie and view its details
  As a user of the ShowCase app
  I want to search for a movie
  So that I can view its details

  Scenario: Validate home page film sections
    Given I have launched the ShowCase app
    Then I should see the Now Playing movie section

  Scenario: Search for a movie by name and view its details
    Given I have launched the ShowCase app
    When I search for a movie named "The Lion King"
    Then I should see "The Lion King" in the search results
    And I click on the movie with date of "Jun 24, 1994"
    And I should see the movie details page with:
      | Title   | The Lion King                                                             |
      | Tagline | The greatest adventure of all is finding our place in the Circle of Life. |