package com.brihaspathee.artemis.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, April 2025
 * Time: 13:58
 * Project: artemis
 * Package Name: com.brihaspathee.artemis.config
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
public class StartupLogger {

    /**
     * Logs a message indicating that the Account Management Service has successfully started
     * and is ready for use. This method is triggered automatically when the application
     * is fully initialized and ready to serve requests.
     *
     * The method listens for the {@link ApplicationReadyEvent} which is published by the
     * Spring Framework when the application context has completed its startup process.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void logStartupComplete() {
        log.info("✅ Account Management Service is UP and ready!");
    }

    /**
     * Logs the environment variables related to the Neo4j database configuration.
     *
     * This method is executed automatically after the bean's properties have been set
     * and the application context has been fully instantiated. It retrieves and logs
     * the values of the following environment variables:
     *
     * - NEO4J_URI: The URI used to connect to the Neo4j database.
     * - NEO4J_USERNAME: The username for authentication with the Neo4j database.
     * - NEO4J_PASSWORD: The password for authentication with the Neo4j database.
     */
    @PostConstruct
    public void logEnv() {
        log.info("NEO4J_URI = {}",  System.getenv("NEO4J_URI"));
        log.info("NEO4J_USERNAME = {}", System.getenv("NEO4J_USERNAME"));
        log.info("NEO4J_PASSWORD = {}",  System.getenv("NEO4J_PASSWORD"));
    }
}
