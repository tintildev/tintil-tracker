package com.tintil.tintiltracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Global Web and CORS configuration for tintil-tracker.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                // Allows requests from the local Vite-Dev server
                .allowedOrigins("http://localhost:5173", "http://localhost:3000")
                // Allows all common HTTP methods for our CRUD endpoints
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                // Allows standard headers (e.g., Content-Type)
                .allowedHeaders("*")
                // Allow cookies / auth headers in case we need them later
                .allowCredentials(true);
    }
}
