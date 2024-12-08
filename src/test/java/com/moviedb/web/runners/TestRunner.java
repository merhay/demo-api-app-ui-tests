package com.moviedb.web.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/web-html-reports.html", "json:target/web-cucumber.json"},
    features = "src/test/resources/features/web",
    glue = "com.moviedb.web.steps",
    monochrome = true,
    tags = "@test")
public class TestRunner {}
