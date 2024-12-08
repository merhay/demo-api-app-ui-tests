package com.moviedb.mobile.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MovieDetailsPage extends BasePage {
  public By movieTitle = AppiumBy.id("movieTitle");
  public By tagline = AppiumBy.id("tagline");

  public void waitForMovieDetailsPageToLoad() {
    waitForElementToBeVisible(movieTitle);
  }

  public String getMovieTitle() {
    return driver.findElement(movieTitle).getText().trim();
  }

  public String getMovieTagline() {
    return driver.findElement(tagline).getText().trim();
  }
}
