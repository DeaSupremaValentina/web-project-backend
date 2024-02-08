package com.example.webprojectbackend.controller.servlet;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("CORS partito");
        registry.addMapping("/login") // Specifica il percorso a cui applicare le politiche CORS (Cross-Origin Resource Sharing)
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE","HEAD","OPTIONS") // Specifica i metodi HTTP consentiti
                .allowedHeaders("*");
        registry.addMapping("/tipoUtente") // Specifica il percorso a cui applicare le politiche CORS (Cross-Origin Resource Sharing)
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE","HEAD","OPTIONS") // Specifica i metodi HTTP consentiti
                .allowedHeaders("*");
        registry.addMapping("/logout")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE","HEAD","OPTIONS") // Specifica i metodi HTTP consentiti
                .allowedHeaders("*");
        registry.addMapping("/salvaRicetta")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE","HEAD","OPTIONS") // Specifica i metodi HTTP consentiti
                .allowedHeaders("*");
        registry.addMapping("/rimuoviRicetta")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE","HEAD","OPTIONS") // Specifica i metodi HTTP consentiti
                .allowedHeaders("*");
        registry.addMapping("/ricetteSalvate")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE","HEAD","OPTIONS") // Specifica i metodi HTTP consentiti
                .allowedHeaders("*");
}
}