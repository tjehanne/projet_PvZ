package com.oxyl.coursepfback.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

/**
 * Configuration web de l'application.
 * Cette classe gère la configuration MVC Spring, notamment :
 * - La configuration CORS pour les requêtes cross-origin
 * - La gestion des ressources statiques
 * - Le scan des composants Spring
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.oxyl.coursepfback")
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configure les règles CORS (Cross-Origin Resource Sharing) pour l'application.
     * Permet les requêtes depuis le frontend en développement (localhost:5173)
     * avec les méthodes HTTP standard et les en-têtes nécessaires.
     * @param registry Registre des configurations CORS
     */
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    /**
     * Configure les gestionnaires de ressources statiques.
     * Permet d'accéder aux images stockées dans le dossier /images/
     * via l'URL /images/** de l'application.
     * @param registry Registre des gestionnaires de ressources
     */
    @Override
    public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {        
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/images/");
    }
}