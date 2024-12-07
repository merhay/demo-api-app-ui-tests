package com.moviedb.api.steps;

import com.moviedb.api.services.MovieService;
import com.moviedb.api.utilities.PropertiesUtilities;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TheMovieDbSteps {

  private String baseUrl;
  private String apiKey;
  private Response response;
  private RequestSpecification request;

  public TheMovieDbSteps() {
    loadConfiguration();
  }

  private void loadConfiguration() {
    PropertiesUtilities.loadProperties("config.properties");
    baseUrl = PropertiesUtilities.getProperty("base_url");
    apiKey = PropertiesUtilities.getProperty("api_key");
  }

  private String getBaseUrl() {
    return Hooks.isMockMode() ? "http://localhost:" + Hooks.getMockServerPort() : baseUrl;
  }

  @Given("user with {string} API key")
  public void getApiKey(String keyType) {
    String apiKey = "valid".equals(keyType) ? this.apiKey : "invalid_api_key";
    request = MovieService.createRequest(getBaseUrl(), apiKey);
  }

  @When("the user sends a request to fetch details for the movie with ID {int}")
  public void getMovieDetailsWithId(int movieId) {
    response = MovieService.getMovieDetails(request, movieId);
  }

  @Then("the response status code should be {int}")
  public void validateGetMovieIdResponseStatusCode(int statusCode) {
    assertEquals(statusCode, response.getStatusCode());
  }

  @Then("the response should contain the movie title {string}")
  public void validateGetMovieIdResponseMovieTitle(String expectedTitle) {
    response.then().body("title", equalTo(expectedTitle));
  }

  @Then("the response should contain the error message {string}")
  public void validateGetMovieIdErrorResponseMessage(String expectedErrorMessage) {
    response.then().body("status_message", equalTo(expectedErrorMessage));
  }
}
