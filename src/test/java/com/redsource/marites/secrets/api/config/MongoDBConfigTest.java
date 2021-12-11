package com.redsource.marites.secrets.api.config;

import com.redsource.marites.secrets.api.util.TestContainerInit;
import lombok.Builder;
import lombok.Data;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.test.context.ContextConfiguration;
import reactor.test.StepVerifier;

@SpringBootTest
@ContextConfiguration(initializers = TestContainerInit.class)
class MongoDBConfigTest {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Test
    @DisplayName("Application Should be able to save and retrieve to the MongoDB")
    public void mongoDBShouldInitialize() {
        val dummyName = "Dummy Master";
        reactiveMongoTemplate.save(DummyModel.builder().id("123").name(dummyName).build()).block();

        StepVerifier.create(reactiveMongoTemplate.findAll(DummyModel.class)).assertNext(dummyModel -> {
            dummyModel.getName().equals(dummyName);
        }).expectComplete().verify();

    }

    @Document(collection = "dummy")
    @Builder
    @Data
    public static class DummyModel {
        @Id
        private String id;
        private String name;
    }

}
