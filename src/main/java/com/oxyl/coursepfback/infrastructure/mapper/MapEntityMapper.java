package com.oxyl.coursepfback.infrastructure.mapper;

import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.infrastructure.entities.MapEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper pour la conversion entre les entités Map et les modèles Map.
 * Cette classe assure la transformation des objets entre la couche infrastructure et la couche métier.
 */
@Component
public class MapEntityMapper {

    /**
     * Convertit une entité Map en modèle Map
     * @param entity L'entité à convertir
     * @return Le modèle Map correspondant, null si l'entité est null
     */
    public MapModel mapEntityToModel(MapEntity entity) {
        if (entity == null) return null;

        MapModel model = new MapModel();
        model.setId_map(entity.getId_map());
        model.setLigne(entity.getLigne());
        model.setColonne(entity.getColonne());
        model.setChemin_image(entity.getChemin_image());

        return model;
    }

    /**
     * Convertit un modèle Map en entité Map
     * @param model Le modèle à convertir
     * @return L'entité Map correspondante, null si le modèle est null
     */
    public MapEntity mapModelToEntity(MapModel model) {
        if (model == null) return null;

        MapEntity entity = new MapEntity();
        entity.setId_map(model.getId_map());
        entity.setLigne(model.getLigne());
        entity.setColonne(model.getColonne());
        entity.setChemin_image(model.getChemin_image());

        return entity;
    }

    /**
     * Convertit une liste d'entités Map en liste de modèles Map
     * @param entities La liste d'entités à convertir
     * @return La liste des modèles Map correspondants
     */
    public List<MapModel> mapListEntityToModel(List<MapEntity> entities) {
        return entities.stream().map(this::mapEntityToModel).toList();
    }
}
