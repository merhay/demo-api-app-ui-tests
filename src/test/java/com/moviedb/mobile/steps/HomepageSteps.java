package com.moviedb.mobile.steps;

import com.moviedb.mobile.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomepageSteps {
  HomePage homePage = new HomePage();

  @Given("I have launched the ShowCase app")
  public void loadsAppSuccessfully() {
    homePage.waitForAppToLoad();
  }

  @Then("I should see the Now Playing movie section")
  public void validateHomepageSections() {
    Assert.assertTrue(homePage.isNowPlayingSectionDisplayed());
  }

  @Then("I should see app home page")
  public void validateHomepage() {
    Assert.assertTrue(homePage.isNowPlayingSectionDisplayed());
  }
}
