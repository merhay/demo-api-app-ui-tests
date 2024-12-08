package com.moviedb.mobile.pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SearchResultsPage extends BasePage {
  private By searchInputBox = AppiumBy.id("toolbar");
  private By searchLoadSpinner = AppiumBy.id("search_progress_bar");
  private By searchResultMovieTitles = AppiumBy.id("title");
  private By searchResultMovieDates = AppiumBy.id("date");

  public boolean isMoviePresentInSearchResults(String movieName) {
    List<WebElement> searchResults = driver.findElements(searchResultMovieTitles);
    if (!searchResults.isEmpty()) {
      String firstResultText = searchResults.get(0).getText();
      return firstResultText.contains(movieName);
    }
    return false;
  }

  public void waitForSearchBarVisibility() {
    waitForElementToBeVisible(searchInputBox);
  }

  public void waitForSearchLoadSpinner() {
    waitForElementToDisappear(searchLoadSpinner);
  }

  public void enterMovieNameInSearch(String movieName) {
    driver.findElement(searchBar).click();
    waitForSearchBarVisibility();
    Actions action = new Actions(driver);
    action.sendKeys(movieName).perform();
  }

  public void clickMovieWithDate(String movieDate) {
    List<WebElement> dateElements = driver.findElements(searchResultMovieDates);
    for (WebElement dateElement : dateElements) {
      if (dateElement.getText().trim().equals(movieDate)) {
        dateElement.click();
        break;
      }
    }
  }
}
