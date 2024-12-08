# INTRO
This test automation framework is designed for API and mobile testing of a movie database application. 
 
It includes:
- **API Testing**: Supports mock and integration tests to validate backend functionality.
- **Mobile Testing** (Android): Uses Appium for automated UI tests on emulators and real devices.
- **Technologies**: Java, Selenium, and Appium, and powered by Cucumber for BDD, the framework is easy to set up and run using Maven.
- The framework follows the Page Object Model (POM) design pattern for maintainable and scalable test code.
 ***

# API TESTS

## Running Mock API Tests
To run the mock API tests, use the following command:
```bash
 mvn test -Dtest=com.moviedb.api.runners.TestRunner -DtestMode=mock
```

## Running Integration API Tests

To run the integration API tests, use the following command:
```bash
 mvn test -Dtest=com.moviedb.api.runners.TestRunner
 ```
 
Note: For demonstration purposes, the movie service API key is stored in the properties file. This approach is not recommended due to security risks. It is intended as a temporary solution solely for demo purposes.
***

# MOBILE TESTS (Android)
Before running the mobile tests, ensure the following prerequisites are met:

## Prerequisites
- Java 11
- Appium 9.2.2
- uiautomator2
- Appium server 2.13.1
- Android Studio
- Android Virtual Device (AVD): Emulator or Real Device with API 35 or higher

## Pre-Test Setup
- ANDROID_HOME environment variable should be set to the Android SDK path.
- Emulator path should be added to the PATH environment variable.

## Starting emulator
1) Check available AVDs to get the AVD name:
  ```bash
  emulator -list-avds
  ```
  
2) Start an emulator using the following command:
```bash 
emulator -avd <avd_name>
```

3) Start Appium Server:
```bash
appium
```

## Running Android App Tests
```bash
 mvn test -Dtest=com.moviedb.mobile.runners.TestRunner
```