package com.moviedb.mobile.pages;

import com.moviedb.mobile.utilities.Driver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public By searchBar = AppiumBy.id("searchbar");

  public BasePage() {
    this.driver = Driver.getDriver();
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void waitForElementToBeVisible(By element) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
  }

  public void waitForElementToDisappear(By element) {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
  }
}
