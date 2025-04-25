package com.oxyl.coursepfback.infrastructure.repository;

import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.dao.ZombieDAO;
import com.oxyl.coursepfback.infrastructure.mapper.ZombieEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour la gestion des zombies dans la base de données.
 * Fait le lien entre la couche métier et la couche d'accès aux données.
 * Utilise le DAO pour les opérations de base de données et le mapper pour la conversion des objets.
 */
@Repository
public class ZombieRepository {

    private final ZombieDAO zombieDAO;
    private final ZombieEntityMapper zombieEntityMapper;

    /**
     * Constructeur avec injection des dépendances
     * @param zombieDAO DAO pour l'accès direct à la base de données
     * @param zombieEntityMapper Mapper pour la conversion entre Entity et Model
     */
    public ZombieRepository(ZombieDAO zombieDAO, ZombieEntityMapper zombieEntityMapper) {
        this.zombieDAO = zombieDAO;
        this.zombieEntityMapper = zombieEntityMapper;
    }

    /**
     * Récupère tous les zombies de la base de données
     * @return Liste de tous les zombies convertis en modèles
     */
    public List<ZombieModel> findAll() {
        return zombieEntityMapper.mapListEntityToModel(zombieDAO.findAll());
    }

    /**
     * Recherche un zombie par son identifiant
     * @param id Identifiant du zombie recherché
     * @return Le zombie converti en modèle si trouvé, null sinon
     */
    public ZombieModel findById(Integer id) {
        return zombieEntityMapper.mapEntityToModel(zombieDAO.findById(id));
    }

    /**
     * Récupère tous les zombies associés à une map spécifique
     * @param mapId Identifiant de la map
     * @return Liste des zombies présents sur la map convertis en modèles
     */
    public List<ZombieModel> findByMapId(Integer mapId) {
        return zombieEntityMapper.mapListEntityToModel(zombieDAO.findByMapId(mapId));
    }

    /**
     * Crée un nouveau zombie dans la base de données
     * @param model Le modèle du zombie à créer
     */
    public void create(ZombieModel model) {
        zombieDAO.create(zombieEntityMapper.mapModelToEntity(model));
    }

    /**
     * Met à jour un zombie existant dans la base de données
     * @param model Le modèle du zombie avec les nouvelles données
     */
    public void update(ZombieModel model) {
        zombieDAO.update(zombieEntityMapper.mapModelToEntity(model));
    }

    /**
     * Supprime un zombie de la base de données
     * @param id Identifiant du zombie à supprimer
     */
    public void delete(Integer id) {
        zombieDAO.delete(id);
    }
}
