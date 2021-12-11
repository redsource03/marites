package com.redsource.marites.secrets.api.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.redsource.marites.secrets.api.property.MongoDBProps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import java.util.stream.Collectors;



@Configuration
@Slf4j
@RequiredArgsConstructor
public class MongoDBConfig {

    private final MongoDBProps mongoDBProps;

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(buildMongoClient(), mongoDBProps.getDatabaseName());
    }


    private MongoClient buildMongoClient() {

        return MongoClients.create(
                MongoClientSettings.builder()
                        .retryWrites(true)
                        .applyToClusterSettings(b -> b.hosts(
                                mongoDBProps.getClusters()
                                        .stream()
                                        .map(ServerAddress::new)
                                        .collect(Collectors.toList())))
                        .applicationName(applicationName)
                        .build()
        );
    }

}
