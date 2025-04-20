# API Backend - Plantes vs Zombies

Ce projet est une API REST développée avec Spring MVC pour gérer un jeu de type "Plantes vs Zombies". L'API permet de gérer les cartes, les plantes et les zombies du jeu.

## Prérequis

- Java 21
- Maven
- MySQL
- Un serveur d'application compatible avec Jakarta EE (comme Tomcat)

## Installation

1. Clonez le repository
2. Configurez votre base de données MySQL
3. Compilez le projet avec Maven :
```bash
mvn clean install
```
4. Déployez le fichier WAR généré (`target/CoursEpfBack.war`) sur votre serveur d'application

## Structure du Projet

Le projet suit une architecture en couches :
- `api/controller` : Les contrôleurs REST
- `api/dto` : Les objets de transfert de données
- `api/mapper` : Les convertisseurs DTO <-> Model
- `core/model` : Les modèles métier
- `core/service` : La logique métier
- `infrastructure` : La couche d'accès aux données

## Points d'Entrée de l'API

### Gestion des Cartes (/maps)
- `GET /maps` : Liste toutes les cartes
- `GET /maps/{id}` : Récupère une carte par son ID
- `POST /maps` : Crée une nouvelle carte
- `PUT /maps/{id}` : Met à jour une carte
- `DELETE /maps/{id}` : Supprime une carte

### Gestion des Plantes (/plantes)
- `GET /plantes` : Liste toutes les plantes
- `GET /plantes/{id}` : Récupère une plante par son ID
- `POST /plantes` : Crée une nouvelle plante
- `PUT /plantes/{id}` : Met à jour une plante
- `DELETE /plantes/{id}` : Supprime une plante

### Gestion des Zombies (/zombies)
- `GET /zombies` : Liste tous les zombies
- `GET /zombies/{id}` : Récupère un zombie par son ID
- `POST /zombies` : Crée un nouveau zombie
- `PUT /zombies/{id}` : Met à jour un zombie
- `DELETE /zombies/{id}` : Supprime un zombie

## Modèles de Données

### Plante
- nom
- point_de_vie
- attaque_par_seconde
- degat_attaque
- cout
- soleil_par_seconde
- effet
- chemin_image

### Zombie
- nom
- point_de_vie
- attaque_par_seconde
- degat_attaque
- vitesse_de_deplacement
- chemin_image
- id_map

### Map
- ligne
- colonne
- chemin_image

## Technologies Utilisées

- Spring MVC 6.2.2
- Spring JDBC 6.1.13
- MySQL Connector 8.0.33
- Jackson 2.18.2
- Jakarta Servlet 6.1.0
- Logback Classic 1.5.16

## Support

Pour toute question ou problème, veuillez créer une issue dans le repository du projet. 