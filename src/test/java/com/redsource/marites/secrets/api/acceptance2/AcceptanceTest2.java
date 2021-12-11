package com.redsource.marites.secrets.api.acceptance2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features =
        {"src/test/resources/features2/cucumber-test2.feature"},
plugin = {"pretty", "html:build/cucumber"},
publish = false,
glue = "com.redsource.marites.secrets.api.acceptance2")
public class AcceptanceTest2 {
}
