package com.oxyl.coursepfback.core.service;

import com.oxyl.coursepfback.core.model.PlanteModel;
import com.oxyl.coursepfback.infrastructure.repository.PlanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service gérant la logique métier des plantes.
 * Fait le lien entre les contrôleurs et le repository.
 */
@Service
public class PlanteService {

    private final PlanteRepository planteRepository;

    /**
     * Constructeur avec injection des dépendances
     * @param planteRepository Repository pour l'accès aux données des plantes
     */
    @Autowired
    public PlanteService(PlanteRepository planteRepository) {
        this.planteRepository = planteRepository;
    }

    /**
     * Récupère toutes les plantes de la base de données
     * @return Liste de toutes les plantes
     */
    public List<PlanteModel> findAllPlantes() {
        return planteRepository.findAll();
    }

    /**
     * Recherche une plante par son identifiant
     * @param id Identifiant de la plante
     * @return La plante si trouvée, null sinon
     */
    public PlanteModel findPlanteById(int id) {
        return planteRepository.findById(id);
    }

    /**
     * Crée une nouvelle plante dans la base de données
     * @param plante Modèle de la plante à créer
     */
    public void create(PlanteModel plante) {
        planteRepository.create(plante);
    }

    /**
     * Met à jour une plante existante
     * @param plante Modèle de la plante avec les nouvelles données
     */
    public void update(PlanteModel plante) {
        planteRepository.update(plante);
    }

    /**
     * Supprime une plante de la base de données
     * @param id Identifiant de la plante à supprimer
     */
    public void delete(int id) {
        planteRepository.delete(id);
    }
}
