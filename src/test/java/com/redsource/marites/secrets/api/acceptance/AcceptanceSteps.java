package com.redsource.marites.secrets.api.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@CucumberContextConfiguration
@SpringBootTest
@RunWith(SpringRunner.class)
public class AcceptanceSteps {

    @Given("^This is a test$")
    public void simpleTest() {
        System.out.println("THIS IS A GIVEN");
    }

    @When("^Say this message:(.*)$")
    public void sayMessage(final String message) {
        System.out.println("MESSAGE:" + message);
    }
}
