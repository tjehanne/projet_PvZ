package com.oxyl.coursepfback.core.service;

import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.repository.ZombieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

/**
 * Service gérant la logique métier des zombies.
 * Fait le lien entre les contrôleurs et le repository.
 * Gère également la validation des images des zombies.
 */
@Service
public class ZombieService {

    private final ZombieRepository zombieRepository;
    /** Chemin par défaut pour l'image d'un zombie */
    protected static final String DEFAULT_ZOMBIE_IMAGE = "images/zombie/default.png";

    /**
     * Constructeur avec injection des dépendances
     * @param zombieRepository Repository pour l'accès aux données des zombies
     */
    @Autowired
    public ZombieService(ZombieRepository zombieRepository) {
        this.zombieRepository = zombieRepository;
    }

    /**
     * Récupère tous les zombies de la base de données
     * @return Liste de tous les zombies
     */
    public List<ZombieModel> findAllZombies() {
        return zombieRepository.findAll();
    }

    /**
     * Recherche un zombie par son identifiant
     * @param id Identifiant du zombie
     * @return Le zombie si trouvé, null sinon
     */
    public ZombieModel findZombieById(Integer id) {
        return zombieRepository.findById(id);
    }

    /**
     * Recherche tous les zombies associés à une map
     * @param mapId Identifiant de la map
     * @return Liste des zombies présents sur la map
     */
    public List<ZombieModel> findZombiesByMapId(Integer mapId) {
        return zombieRepository.findByMapId(mapId);
    }

    /**
     * Vérifie si le chemin d'image fourni est valide
     * @param imagePath Chemin de l'image à vérifier
     * @return true si l'image existe, false sinon
     */
    protected boolean isValidImagePath(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            return false;
        }

        try {
            ClassPathResource resource = new ClassPathResource("webapp/" + imagePath);
            resource.getInputStream(); 
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Valide le chemin d'image et retourne le chemin par défaut si invalide
     * @param imagePath Chemin de l'image à valider
     * @return Le chemin validé ou le chemin par défaut
     */
    private String validateAndGetImagePath(String imagePath) {
        return isValidImagePath(imagePath) ? imagePath : DEFAULT_ZOMBIE_IMAGE;
    }

    /**
     * Crée un nouveau zombie dans la base de données
     * @param model Modèle du zombie à créer
     */
    public void create(ZombieModel model) {
        model.setChemin_image(validateAndGetImagePath(model.getChemin_image()));
        zombieRepository.create(model);
    }

    /**
     * Met à jour un zombie existant
     * @param model Modèle du zombie avec les nouvelles données
     */
    public void update(ZombieModel model) {
        model.setChemin_image(validateAndGetImagePath(model.getChemin_image()));
        zombieRepository.update(model);
    }

    /**
     * Supprime un zombie de la base de données
     * @param id Identifiant du zombie à supprimer
     */
    public void delete(Integer id) {
        zombieRepository.delete(id);
    }
}
