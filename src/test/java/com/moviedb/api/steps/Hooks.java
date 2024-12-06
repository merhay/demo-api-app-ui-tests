package com.moviedb.api.steps;

import com.moviedb.api.mocks.WireMockConfigurator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

  private static final Logger log = LoggerFactory.getLogger(Hooks.class);

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
      log.info("Mock server started");
    }
  }

  @After
  public void tearDownMock() {
    try {
      if (WireMockConfigurator.getWireMockServer().isRunning()) {
        WireMockConfigurator.stopWireMock();
        log.info("Mock server stopped");
      }
    } catch (Exception ignored) {
    }
  }
}
