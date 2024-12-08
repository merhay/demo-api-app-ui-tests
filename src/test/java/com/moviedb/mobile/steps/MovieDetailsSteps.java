package com.moviedb.mobile.steps;

import com.moviedb.mobile.pages.MovieDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import java.util.Map;
import org.junit.Assert;

public class MovieDetailsSteps {
  MovieDetailsPage movieDetailsPage = new MovieDetailsPage();

  @Then("I should see the movie details page with:")
  public void verifyMovieDetails(DataTable dataTable) {
    movieDetailsPage.waitForMovieDetailsPageToLoad();

    Map<String, String> movieDetails = dataTable.asMap(String.class, String.class);

    String expectedTitle = movieDetails.get("Title");
    String expectedTagline = movieDetails.get("Tagline");

    Assert.assertEquals(expectedTitle, movieDetailsPage.getMovieTitle());
    Assert.assertEquals(expectedTagline, movieDetailsPage.getMovieTagline());
  }
}
