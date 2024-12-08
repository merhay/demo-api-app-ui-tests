package com.moviedb.mobile.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
  private By searchBar = AppiumBy.id("searchbar");
  private By nowPlayingMovies = AppiumBy.id("nowPlayingRecyclerView");

  public void waitForAppToLoad() {
    waitForElementToBeVisible(driver.findElement(searchBar));
  }

  public boolean isHomePageDisplayed() {
    return driver.findElement(nowPlayingMovies).isDisplayed();
  }
}
