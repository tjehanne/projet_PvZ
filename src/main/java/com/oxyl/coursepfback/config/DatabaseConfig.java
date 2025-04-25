package com.oxyl.coursepfback.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Configuration de la base de données de l'application.
 * Cette classe gère la connexion à la base de données en utilisant les propriétés
 * définies dans le fichier application.properties.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig {

    /** URL de connexion à la base de données */
    @Value("${datasource.url}")
    private String dbUrl;

    /** Nom d'utilisateur pour la connexion */
    @Value("${datasource.username}")
    private String dbUsername;

    /** Mot de passe pour la connexion */
    @Value("${datasource.password}")
    private String dbPassword;

    /** Classe du driver JDBC */
    @Value("${datasource.driver-class-name}")
    private String dbDriver;

    /**
     * Configure la source de données pour la connexion à la base
     * @return DataSource configurée avec les paramètres de connexion
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    /**
     * Configure le template JDBC pour les opérations sur la base de données
     * @param dataSource Source de données configurée
     * @return JdbcTemplate configuré avec la source de données
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
