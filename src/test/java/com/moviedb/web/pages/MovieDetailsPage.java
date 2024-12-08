package com.moviedb.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovieDetailsPage extends BasePage {
  @FindBy(css = ".title.ott_true > :first-child > :first-child")
  public WebElement movieTitle;

  @FindBy(css = ".tag.release_date")
  public WebElement releaseYear;

  @FindBy(css = ".tagline")
  public WebElement tagline;
}
