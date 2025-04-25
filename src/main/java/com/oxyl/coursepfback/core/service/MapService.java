package com.oxyl.coursepfback.core.service;

import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.repository.MapRepository;
import com.oxyl.coursepfback.infrastructure.repository.ZombieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service gérant la logique métier des maps du jeu.
 * Cette classe fait le lien entre les contrôleurs et le repository pour les opérations sur les maps.
 * Elle permet de gérer les niveaux du jeu, leurs dimensions et leurs images.
 */
@Service
public class MapService {

    private final MapRepository mapRepository;
    private final ZombieRepository zombieRepository;

    /**
     * Constructeur avec injection des dépendances
     * @param mapRepository Repository pour l'accès aux données des maps
     * @param zombieRepository Repository pour l'accès aux données des zombies
     */
    @Autowired
    public MapService(MapRepository mapRepository, ZombieRepository zombieRepository) {
        this.mapRepository = mapRepository;
        this.zombieRepository = zombieRepository;
    }

    /**
     * Récupère toutes les maps disponibles dans le jeu
     * @return Liste de toutes les maps existantes
     */
    public List<MapModel> findAllMaps() {
        return mapRepository.findAll();
    }

    /**
     * Recherche une map spécifique par son identifiant
     * @param id Identifiant de la map recherchée
     * @return La map si trouvée, null sinon
     */
    public MapModel findMapById(Integer id) {
        return mapRepository.findById(id);
    }

    /**
     * Crée une nouvelle map dans le jeu
     * @param map Les données de la nouvelle map à créer
     */
    public void create(MapModel map) {
        mapRepository.create(map);
    }

    /**
     * Met à jour les informations d'une map existante
     * @param map Les nouvelles données de la map
     */
    public void update(MapModel map) {
        mapRepository.update(map);
    }

    /**
     * Supprime une map du jeu
     * @param id Identifiant de la map à supprimer
     */
    public void delete(Integer id) {
        List<ZombieModel> zombies = zombieRepository.findByMapId(id);
        
        for (ZombieModel zombie : zombies) {
            zombie.setId_map(null);
            zombieRepository.update(zombie);
        }

        mapRepository.delete(id);
    }
}
