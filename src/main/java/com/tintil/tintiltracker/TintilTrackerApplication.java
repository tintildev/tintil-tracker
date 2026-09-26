package com.tintil.tintiltracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of the Spring Boot application “Tintil Tracker”.
 * Starts the application context and the embedded web server.
 */
@SpringBootApplication
public class TintilTrackerApplication {

    /**
     * The main method for starting the Spring Boot application.
     *
     * @param args Kommandozeilenargumente, die beim Anwendungsstart übergeben werden.
     */
    public static void main(String[] args) {
        SpringApplication.run(TintilTrackerApplication.class, args);
    }

}

