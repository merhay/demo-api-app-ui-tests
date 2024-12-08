package com.moviedb.web.pages;

import com.moviedb.web.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

  public BasePage() {
    PageFactory.initElements(Driver.get(), this);
  }

  WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

  public void waitForElementToBeVisible(WebElement locator) {
    wait.until(ExpectedConditions.visibilityOf(locator));
  }
}
