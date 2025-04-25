package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.MapEntity;
import java.util.List;

/**
 * Interface définissant les opérations de base pour l'accès aux données des maps.
 * Cette interface spécifie les méthodes CRUD (Create, Read, Update, Delete) nécessaires
 * pour manipuler les entités Map dans la base de données.
 */
public interface MapDAOInterface {
    /**
     * Récupère toutes les maps de la base de données
     * @return Liste de toutes les maps
     */
    List<MapEntity> findAll();

    /**
     * Recherche une map par son identifiant
     * @param id Identifiant de la map recherchée
     * @return La map si trouvée, null sinon
     */
    MapEntity findById(Integer id);

    /**
     * Crée une nouvelle map dans la base de données
     * @param map La map à créer
     */
    void create(MapEntity map);

    /**
     * Met à jour une map existante
     * @param map La map avec les nouvelles données
     */
    void update(MapEntity map);

    /**
     * Supprime une map de la base de données
     * @param id Identifiant de la map à supprimer
     */
    void delete(Integer id);
}
