package com.epf;

/**
 * Classe principale qui initialise l'application Spring MVC.
 * Cette classe configure le dispatcher servlet et les configurations de base.
 */
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.oxyl.coursepfback.config.DatabaseConfig;
import com.oxyl.coursepfback.config.WebConfig;
import org.springframework.lang.NonNull;

public class Main extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Configure les classes de configuration racine de l'application
     * @return Un tableau contenant les classes de configuration pour la base de données et le web
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DatabaseConfig.class, WebConfig.class};
    }

    /**
     * Configure les classes de configuration du servlet
     * @return null car nous n'avons pas de configuration spécifique pour le servlet
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    /**
     * Définit les mappings URL pour le dispatcher servlet
     * @return Un tableau contenant les patterns d'URL à gérer
     */
    @Override
    @NonNull
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
