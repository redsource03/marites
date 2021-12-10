package com.redsource.marites.secrets.api.integration;

import com.redsource.marites.secrets.api.util.TestContainerInit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = TestContainerInit.class)
public class MongoDBIntegrationTest {

    @Test
    void simpleTest() {

    }


}
