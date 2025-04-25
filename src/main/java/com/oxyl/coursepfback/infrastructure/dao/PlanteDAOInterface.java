package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.PlanteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface définissant les opérations de base pour l'accès aux données des plantes.
 * Cette interface spécifie les méthodes de lecture nécessaires pour récupérer
 * les informations des plantes dans la base de données.
 */
@Repository
public interface PlanteDAOInterface {
    /**
     * Recherche une plante par son identifiant
     * @param id Identifiant de la plante recherchée
     * @return La plante si trouvée, null sinon
     */
    PlanteEntity findById(Integer id);

    /**
     * Récupère toutes les plantes de la base de données
     * @return Liste de toutes les plantes disponibles
     */
    List<PlanteEntity> findAll();
}
