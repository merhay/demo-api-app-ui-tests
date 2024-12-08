@test
Feature: User should be able to search a movie and see its details

  Scenario: Searching a movie and seeing its details
    Given user is on the home page
    When user clicks on the search field
    And user types "The Lion King" into the search field and presses Enter
    Then user sees the search results page for "The Lion King"
    And user clicks on the movie with release date "7 October 1994"
    And user sees the movie details containing:
      | Title        | The Lion King                                                             |
      | Release Date | 1994                                                                      |
      | Tagline      | The greatest adventure of all is finding our place in the Circle of Life. |
