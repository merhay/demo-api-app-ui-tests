package com.moviedb.web.steps;

import com.moviedb.web.pages.*;
import com.moviedb.web.utilities.PropertiesUtilities;
import com.moviedb.web.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.*;

public class MovieSearchSteps {

  HomePage homePage = new HomePage();
  SearchResultsPage results = new SearchResultsPage();
  MovieDetailsPage movieDetailsPage = new MovieDetailsPage();

  @Given("user is on the home page")
  public void loadWebPageSuccessfully() {
    String url = PropertiesUtilities.getProperty("web_url");
    Driver.get().get(url);
  }

  @When("user clicks on the search field")
  public void userClicksOnSearchField() {
    homePage.searchInput.click();
  }

  @When("user types {string} into the search field and presses Enter")
  public void userTypesSearchItem(String searchItem) {
    homePage.searchInput.sendKeys(searchItem);
    homePage.searchInput.sendKeys(Keys.ENTER);
  }

  @Then("user sees the search results page for {string}")
  public void validateSearchResults(String searchItem) {
    results.waitForElementToBeVisible(results.searchResults.get(0));

    Assert.assertTrue(results.title.getText().contains(searchItem));
  }

  @When("user clicks on the movie with release date {string}")
  public void userClicksTheMovie(String date) {
    results.clickOnMovieWithReleaseDate(date);
  }

  @Then("user sees the movie details containing:")
  public void userSeesMovieDetails(DataTable dataTable) {
    Map<String, String> movieDetails = dataTable.asMap(String.class, String.class);
    Assert.assertEquals(movieDetails.get("Title"), movieDetailsPage.movieTitle.getText().trim());

    String releaseYear = movieDetailsPage.releaseYear.getText().trim();
    Assert.assertEquals(
        movieDetails.get("Release Date"),
        movieDetailsPage.releaseYear.getText().trim().substring(1, releaseYear.length() - 1));

    Assert.assertEquals(movieDetails.get("Tagline"), movieDetailsPage.tagline.getText().trim());
  }
}
