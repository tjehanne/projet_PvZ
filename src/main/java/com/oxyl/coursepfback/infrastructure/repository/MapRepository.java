package com.oxyl.coursepfback.infrastructure.repository;

import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.infrastructure.dao.MapDAO;
import com.oxyl.coursepfback.infrastructure.mapper.MapEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour la gestion des maps dans la base de données.
 * Fait le lien entre la couche métier et la couche d'accès aux données.
 * Utilise le DAO pour les opérations de base de données et le mapper pour la conversion des objets.
 */
@Repository
public class MapRepository {

    private final MapDAO mapDAO;
    private final MapEntityMapper mapEntityMapper;

    /**
     * Constructeur avec injection des dépendances
     * @param mapDAO DAO pour l'accès direct à la base de données
     * @param mapEntityMapper Mapper pour la conversion entre Entity et Model
     */
    public MapRepository(MapDAO mapDAO, MapEntityMapper mapEntityMapper) {
        this.mapDAO = mapDAO;
        this.mapEntityMapper = mapEntityMapper;
    }

    /**
     * Récupère toutes les maps de la base de données
     * @return Liste de toutes les maps converties en modèles
     */
    public List<MapModel> findAll() {
        return mapEntityMapper.mapListEntityToModel(mapDAO.findAll());
    }

    /**
     * Recherche une map par son identifiant
     * @param id Identifiant de la map recherchée
     * @return La map convertie en modèle si trouvée, null sinon
     */
    public MapModel findById(Integer id) {
        return mapEntityMapper.mapEntityToModel(mapDAO.findById(id));
    }

    /**
     * Crée une nouvelle map dans la base de données
     * @param model Le modèle de la map à créer
     */
    public void create(MapModel model) {
        mapDAO.create(mapEntityMapper.mapModelToEntity(model));
    }

    /**
     * Met à jour une map existante dans la base de données
     * @param model Le modèle de la map avec les nouvelles données
     */
    public void update(MapModel model) {
        mapDAO.update(mapEntityMapper.mapModelToEntity(model));
    }

    /**
     * Supprime une map de la base de données
     * @param id Identifiant de la map à supprimer
     */
    public void delete(Integer id) {
        mapDAO.delete(id);
    }
}
