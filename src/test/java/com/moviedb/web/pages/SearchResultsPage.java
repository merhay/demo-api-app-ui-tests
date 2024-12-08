package com.moviedb.web.pages;

import com.moviedb.web.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {
  @FindBy(css = ".title > :first-child")
  public WebElement title;

  @FindBy(css = ".search_results.movie")
  public List<WebElement> searchResults;

  public void clickOnMovieWithReleaseDate(String date) {
    WebElement element =
        Driver.get().findElement(By.xpath("//*[contains(text(), '" + date + "')]/../div"));
    element.click();
  }
}
