package com.moviedb.web.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtilities {
  private static Properties properties = new Properties();

  static {
    loadProperties("config.properties");
  }

  public static void loadProperties(String configFileName) {
    try (FileInputStream input =
        new FileInputStream("src/test/resources/config/" + configFileName)) {
      properties.load(input);
    } catch (IOException ex) {
      throw new RuntimeException("Failed to load the properties file: " + configFileName, ex);
    }
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }
}
