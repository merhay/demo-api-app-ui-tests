package com.moviedb.mobile.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/mobile-html-reports.html", "json:target/mobile-cucumber.json"},
    features = "src/test/resources/features/mobile",
    glue = "com.moviedb.mobile.steps",
    monochrome = true,
    tags = "@test")
public class TestRunner {}
