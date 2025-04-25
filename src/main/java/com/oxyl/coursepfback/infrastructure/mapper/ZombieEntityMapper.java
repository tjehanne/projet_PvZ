package com.oxyl.coursepfback.infrastructure.mapper;

import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.entities.ZombieEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper pour la conversion entre les entités Zombie et les modèles Zombie.
 * Cette classe assure la transformation des objets entre la couche infrastructure et la couche métier.
 */
@Component
public class ZombieEntityMapper {

    /**
     * Convertit une entité Zombie en modèle Zombie
     * @param entity L'entité à convertir
     * @return Le modèle Zombie correspondant, null si l'entité est null
     */
    public ZombieModel mapEntityToModel(ZombieEntity entity) {
        if (entity == null) return null;

        ZombieModel model = new ZombieModel();
        model.setId_zombie(entity.getId_zombie());
        model.setNom(entity.getNom());
        model.setPoint_de_vie(entity.getPoint_de_vie());
        model.setAttaque_par_seconde(entity.getAttaque_par_seconde());
        model.setDegat_attaque(entity.getDegat_attaque());
        model.setVitesse_de_deplacement(entity.getVitesse_de_deplacement());
        model.setChemin_image(entity.getChemin_image());
        model.setId_map(entity.getId_map());

        return model;
    }

    /**
     * Convertit un modèle Zombie en entité Zombie
     * @param model Le modèle à convertir
     * @return L'entité Zombie correspondante, null si le modèle est null
     */
    public ZombieEntity mapModelToEntity(ZombieModel model) {
        if (model == null) return null;

        ZombieEntity entity = new ZombieEntity();
        entity.setId_zombie(model.getId_zombie());
        entity.setNom(model.getNom());
        entity.setPoint_de_vie(model.getPoint_de_vie());
        entity.setAttaque_par_seconde(model.getAttaque_par_seconde());
        entity.setDegat_attaque(model.getDegat_attaque());
        entity.setVitesse_de_deplacement(model.getVitesse_de_deplacement());
        entity.setChemin_image(model.getChemin_image());
        entity.setId_map(model.getId_map());

        return entity;
    }

    /**
     * Convertit une liste d'entités Zombie en liste de modèles Zombie
     * @param entities La liste d'entités à convertir
     * @return La liste des modèles Zombie correspondants
     */
    public List<ZombieModel> mapListEntityToModel(List<ZombieEntity> entities) {
        return entities.stream().map(this::mapEntityToModel).toList();
    }
}
