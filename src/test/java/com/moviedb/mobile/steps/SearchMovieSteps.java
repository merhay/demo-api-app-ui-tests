package com.moviedb.mobile.steps;

import com.moviedb.mobile.pages.SearchResultsPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SearchMovieSteps {
  SearchResultsPage searchResultsPage = new SearchResultsPage();

  @When("I search for a movie named {string}")
  public void searchesForMovieName(String movieName) {
    searchResultsPage.enterMovieNameInSearch(movieName);
    searchResultsPage.waitForSearchLoadSpinner();
  }

  @Then("I should see {string} in the search results")
  public void validateSearchResults(String movieName) {
    Assert.assertTrue(searchResultsPage.isMoviePresentInSearchResults(movieName));
  }

  @Then("I click on the movie with date of {string}")
  public void clickMovieWithDate(String movieDate) {
    searchResultsPage.clickMovieWithDate(movieDate);
  }
}
