package com.oxyl.coursepfback.infrastructure.mapper;

import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.entities.ZombieEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ZombieEntityMapper {

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

    public List<ZombieModel> mapListEntityToModel(List<ZombieEntity> entities) {
        return entities.stream().map(this::mapEntityToModel).toList();
    }
}
