package com.oxyl.coursepfback.infrastructure.repository;

import com.oxyl.coursepfback.core.model.PlanteModel;
import com.oxyl.coursepfback.infrastructure.dao.PlanteDAO;
import com.oxyl.coursepfback.infrastructure.entities.PlanteEntity;
import com.oxyl.coursepfback.infrastructure.mapper.PlanteEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour la gestion des plantes dans la base de données.
 * Fait le lien entre la couche métier et la couche d'accès aux données.
 * Utilise le DAO pour les opérations de base de données et le mapper pour la conversion des objets.
 */
@Repository
public class PlanteRepository {
    private final PlanteDAO planteDAO;
    private final PlanteEntityMapper planteEntityMapper;

    /**
     * Constructeur avec injection des dépendances
     * @param planteDAO DAO pour l'accès direct à la base de données
     * @param planteEntityMapper Mapper pour la conversion entre Entity et Model
     */
    public PlanteRepository(PlanteDAO planteDAO, PlanteEntityMapper planteEntityMapper) {
        this.planteDAO = planteDAO;
        this.planteEntityMapper = planteEntityMapper;
    }

    /**
     * Récupère toutes les plantes de la base de données
     * @return Liste de toutes les plantes converties en modèles
     */
    public List<PlanteModel> findAll() {
        return planteEntityMapper.mapListEntityToListModel(planteDAO.findAll());
    }

    /**
     * Recherche une plante par son identifiant
     * @param id Identifiant de la plante recherchée
     * @return La plante convertie en modèle si trouvée, null sinon
     */
    public PlanteModel findById(int id) {
        return planteEntityMapper.mapEntityToModel(planteDAO.findById(id));
    }

    /**
     * Crée une nouvelle plante dans la base de données
     * @param plante Le modèle de la plante à créer
     */
    public void create(PlanteModel plante) {
        PlanteEntity planteEntity = planteEntityMapper.mapModelToEntity(plante);
        planteDAO.create(planteEntity);
    }

    /**
     * Met à jour une plante existante dans la base de données
     * @param plante Le modèle de la plante avec les nouvelles données
     */
    public void update(PlanteModel plante) {
        PlanteEntity planteEntity = planteEntityMapper.mapModelToEntity(plante);
        planteDAO.update(planteEntity);
    }

    /**
     * Supprime une plante de la base de données
     * @param id Identifiant de la plante à supprimer
     */
    public void delete(int id) {
        planteDAO.delete(id);
    }
}
