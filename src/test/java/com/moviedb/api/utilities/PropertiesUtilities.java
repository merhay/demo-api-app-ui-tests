package com.moviedb.api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtilities {
  private static Properties properties;

  public static void loadProperties(String configFileName) {
    properties = new Properties();
    try {
      String filePath = "src/test/resources/config/" + configFileName;
      properties.load(new FileInputStream(filePath));
    } catch (IOException ex) {
      throw new RuntimeException("Failed to load the properties file: " + configFileName);
    }
  }

  public static String getProperty(String property) {
    return properties.getProperty(property);
  }
}
