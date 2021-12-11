package com.redsource.marites.secrets.api.acceptance2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@SpringBootTest
@RunWith(SpringRunner.class)
@CucumberContextConfiguration
public class AcceptanceSteps2 {

    @Given("^This is a test2$")
    public void simpleTest2() {
        System.out.println("THIS IS A GIVEN 2");
    }

    @When("^Say this message2:(.*)$")
    public void sayMessage2(final String message) {
        System.out.println("MESSAGE:" + message);
    }
}
