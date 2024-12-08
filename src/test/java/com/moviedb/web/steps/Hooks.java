package com.moviedb.web.steps;

import com.moviedb.web.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.time.Duration;

public class Hooks {

  @Before
  public void setUp() {
    Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @After
  public void tearDown() {
    Driver.closeDriver();
  }
}
