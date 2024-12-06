package com.moviedb.api.mocks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class WireMockConfigurator {
  private static WireMockServer wireMockServer;

  public static WireMockServer startWireMock() {
    wireMockServer = new WireMockServer(WireMockConfiguration.options().dynamicPort());
    wireMockServer.start();
    WireMock.configureFor("localhost", wireMockServer.port());
    return wireMockServer;
  }

  public static void stopWireMock() {
    if (wireMockServer != null && wireMockServer.isRunning()) {
      wireMockServer.stop();
    }
  }

  public static WireMockServer getWireMockServer() {
    return wireMockServer;
  }

  public static void configureMockResponses() {
    WireMock.stubFor(
        WireMock.get(WireMock.urlPathEqualTo("/movie/8587"))
            .willReturn(
                WireMock.aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody("{\"title\": \"The Lion King\"}")));

    WireMock.stubFor(
        WireMock.get(WireMock.urlPathEqualTo("/movie/9999999"))
            .willReturn(
                WireMock.aResponse()
                    .withStatus(404)
                    .withHeader("Content-Type", "application/json")
                    .withBody(
                        "{\"status_message\": \"The resource you requested could not be found.\"}")));

    WireMock.stubFor(
        WireMock.get(WireMock.urlPathEqualTo("/movie/8587"))
            .withQueryParam("api_key", WireMock.equalTo("invalid_api_key"))
            .willReturn(
                WireMock.aResponse()
                    .withStatus(401)
                    .withHeader("Content-Type", "application/json")
                    .withBody(
                        "{\"status_message\": \"Invalid API key: You must be granted a valid key.\"}")));
  }
}
