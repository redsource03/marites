package com.redsource.marites.secrets.api.acceptance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
plugin = {"pretty", "html:build/cucumber"},
publish = false,
glue = "com.redsource.marites.secrets.api.acceptance")
public class AcceptanceTest {
}
