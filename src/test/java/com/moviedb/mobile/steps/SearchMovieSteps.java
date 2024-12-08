package com.moviedb.mobile.steps;

import com.moviedb.mobile.pages.HomePage;
import com.moviedb.mobile.pages.SearchResultsPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SearchMovieSteps {
  HomePage homePage = new HomePage();
  SearchResultsPage searchResultsPage = new SearchResultsPage();

  @Given("I have launched the ShowCase app")
  public void loadsAppSuccessfully() {
    homePage.waitForAppToLoad();
  }

  @When("I search for a movie named {string}")
  public void searchesForMovieName(String movieName) {
    searchResultsPage.enterMovieNameInSearch(movieName);
    searchResultsPage.waitForSearchLoadSpinner();
  }

  @Then("I should see {string} in the search results")
  public void validateSearchResults(String movieName) {
    Assert.assertTrue(searchResultsPage.isMoviePresentInSearchResults(movieName));
  }

  @Then("I go back to home page by clicking back button")
  public void clicksBackButtonFromToolbar() {
    searchResultsPage.clickBackButton();
  }

  @Then("I should see app home page")
  public void validateHomepage() {
    Assert.assertTrue(homePage.isHomePageDisplayed());
  }
}
