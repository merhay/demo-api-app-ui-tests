package com.moviedb.mobile.utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
  private Driver() {}

  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("appium:automationName", "UiAutomator2");
      capabilities.setCapability("appium:app", "src/test/resources/app/showcase.apk");
      capabilities.setCapability("autoGrantPermissions", true);

      try {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
      } catch (MalformedURLException e) {
        throw new RuntimeException(e);
      }
    }
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
