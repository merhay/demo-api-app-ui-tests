package com.moviedb.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage {
  private WebDriver driver;

  private By searchInput = By.id("com.showcaseapp:id/search_input");
  private By searchButton = By.id("com.showcaseapp:id/search_button");

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void waitForAppToLoad() {
    new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(searchInput));
  }

  public void enterMovieNameInSearch(String movieName) {
    driver.findElement(searchInput).sendKeys(movieName);
  }

  public void clickSearchButton() {
    driver.findElement(searchButton).click();
  }
}
