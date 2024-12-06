package com.moviedb.api.steps;

import com.moviedb.api.mocks.WireMockConfigurator;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
  static boolean isMockMode() {
    return "mock".equals(System.getProperty("testMode"));
  }

  public static int getMockServerPort() {
    return WireMockConfigurator.getWireMockServer().port();
  }

  @Before
  public void setUpMock() {
    if (isMockMode()) {
      WireMockConfigurator.startWireMock();
      WireMockConfigurator.configureMockResponses();
    }
  }

  @After
  public void tearDownMock() {
    try {
      if (WireMockConfigurator.getWireMockServer().isRunning()) {
        WireMockConfigurator.stopWireMock();
      }
    } catch (Exception ignored) {
    }
  }
}
