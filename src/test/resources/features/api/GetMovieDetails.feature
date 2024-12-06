@test
Feature: Get movie details
  As a user of the TMDB API
  I want to retrieve movie details by ID
  So that I can verify the information about specific movies

  Scenario: Get movie details with a valid movie ID
    Given user with "valid" API key
    When the user sends a request to fetch details for the movie with ID 8587
    Then the response status code should be 200
    And the response should contain the movie title "The Lion King"

  Scenario: Get movie details with non-existing movie ID
    Given user with "valid" API key
    When the user sends a request to fetch details for the movie with ID 9999999
    Then the response status code should be 404
    And the response should contain the error message "The resource you requested could not be found."

  Scenario: Validate error response for invalid api key
    Given user with "invalid" API key
    When the user sends a request to fetch details for the movie with ID 8587
    Then the response status code should be 401
    And the response should contain the error message "Invalid API key: You must be granted a valid key."
