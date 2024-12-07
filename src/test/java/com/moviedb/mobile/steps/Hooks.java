package com.moviedb.mobile.steps;

import com.moviedb.mobile.utilities.AppiumConfig;
import io.cucumber.java.After;

public class Hooks {

  @After
  public void tearDown() {
    AppiumConfig.quitDriver();
  }
}
