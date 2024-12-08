package com.moviedb.mobile.pages;

import com.moviedb.mobile.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public BasePage() {
    this.driver = Driver.getDriver();
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void waitForElementToBeVisible(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void waitForElementToDisappear(List<WebElement> element) {
    if (!element.isEmpty()) {
      wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
  }
}
