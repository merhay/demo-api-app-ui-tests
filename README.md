**Running Mock API Tests**
```bash
 mvn test -Dtest=com.moviedb.api.runners.TestRunner -DtestMode=mock
```

**Running Integration API Tests**
```bash
 mvn test -Dtest=com.moviedb.api.runners.TestRunner
 ```
 
Note: For demonstration purposes, the movie service API key is stored in the properties file. This approach is not recommended due to security risks. It is intended as a temporary solution solely for demo purposes.
