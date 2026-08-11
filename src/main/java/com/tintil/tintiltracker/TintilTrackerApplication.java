package com.tintil.tintiltracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hauptklasse der Spring Boot Anwendung "Tintil Tracker".
 * Startet den Anwendungskontext und den eingebetteten Webserver.
 */
@SpringBootApplication
public class TintilTrackerApplication {

    /**
     * Hauptmethode zum Starten der Spring Boot Anwendung.
     *
     * @param args Kommandozeilenargumente, die beim Anwendungsstart übergeben werden.
     */
    public static void main(String[] args) {
        SpringApplication.run(TintilTrackerApplication.class, args);
    }

}

