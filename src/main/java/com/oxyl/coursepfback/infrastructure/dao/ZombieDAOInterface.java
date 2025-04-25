package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.ZombieEntity;
import java.util.List;

/**
 * Interface définissant les opérations de base pour l'accès aux données des zombies.
 * Cette interface spécifie les méthodes CRUD (Create, Read, Update, Delete) nécessaires
 * pour manipuler les entités Zombie dans la base de données.
 */
public interface ZombieDAOInterface {
    /**
     * Récupère tous les zombies de la base de données
     * @return Liste de tous les zombies
     */
    List<ZombieEntity> findAll();

    /**
     * Recherche un zombie par son identifiant
     * @param id Identifiant du zombie recherché
     * @return Le zombie si trouvé, null sinon
     */
    ZombieEntity findById(Integer id);

    /**
     * Récupère tous les zombies associés à une map spécifique
     * @param mapId Identifiant de la map
     * @return Liste des zombies présents sur la map
     */
    List<ZombieEntity> findByMapId(Integer mapId);

    /**
     * Crée un nouveau zombie dans la base de données
     * @param zombie Le zombie à créer
     */
    void create(ZombieEntity zombie);

    /**
     * Met à jour un zombie existant
     * @param zombie Le zombie avec les nouvelles données
     */
    void update(ZombieEntity zombie);

    /**
     * Supprime un zombie de la base de données
     * @param id Identifiant du zombie à supprimer
     */
    void delete(Integer id);
}
