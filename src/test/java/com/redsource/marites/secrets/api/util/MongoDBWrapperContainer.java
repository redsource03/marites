package com.redsource.marites.secrets.api.util;

import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.Properties;

@Slf4j
public class MongoDBWrapperContainer extends MongoDBContainer {
    private static final String DOCKER_IMAGE_NAME = "mongo:4.0.10";

    public MongoDBWrapperContainer() {
        super(DockerImageName.parse(DOCKER_IMAGE_NAME));
    }

    @Override
    public void start() {
        log.info("Starting MongoDB Test Container");
        super.start();
    }

    @Override
    public void stop() {
        log.info("Stopping MongoDB Test Container");
    }

    public void setupProperties (Properties properties) {
        log.info("Overriding mongoDB properties");
        properties.setProperty("mongo.client", this.getReplicaSetUrl());
    }

}
