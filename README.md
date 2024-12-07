*API TESTS*

***Running Mock API Tests***
```bash
 mvn test -Dtest=com.moviedb.api.runner.TestRunner -DtestMode=mock
```

***Running Integration API Tests***
```bash
 mvn test -Dtest=com.moviedb.api.runner.TestRunner
 ```
 
***Note: For demonstration purposes, the movie service API key is stored in the properties file. This approach is not recommended due to security risks. It is intended as a temporary solution solely for demo purposes.***
***

Running Android App Tests
```bash
 mvn test -Dtest=com.moviedb.app.runner.TestRunner
```

## Prerequisites
- Java 11
- Appium 9.2.2
- Appium server 2.13.1
- Android Studio
- Android Virtual Device (AVD): Emulator or Real Device with API 35 or higher