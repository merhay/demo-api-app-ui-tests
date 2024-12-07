package com.moviedb.api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {
      "pretty",
      "html:target/moviedb-api-html-reports.html",
      "json:target/moviedb-api-cucumber.json"
    },
    features = "src/test/resources/features/api",
    glue = "com.moviedb.api.steps",
    monochrome = true,
    tags = "@test")
public class TestRunner {}
