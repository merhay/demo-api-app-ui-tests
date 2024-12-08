package com.moviedb.mobile.steps;

import com.moviedb.mobile.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

  @After
  public void tearDown() {
    Driver.quitDriver();
  }
}
