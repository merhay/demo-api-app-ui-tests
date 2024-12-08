package com.moviedb.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  @FindBy(id = "inner_search_v4")
  public WebElement searchInput;
}
