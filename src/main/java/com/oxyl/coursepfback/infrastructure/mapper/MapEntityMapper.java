package com.oxyl.coursepfback.infrastructure.mapper;

import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.infrastructure.entities.MapEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapEntityMapper {

    public MapModel mapEntityToModel(MapEntity entity) {
        if (entity == null) return null;

        MapModel model = new MapModel();
        model.setId_map(entity.getId_map());
        model.setLigne(entity.getLigne());
        model.setColonne(entity.getColonne());
        model.setChemin_image(entity.getChemin_image());

        return model;
    }

    public MapEntity mapModelToEntity(MapModel model) {
        if (model == null) return null;

        MapEntity entity = new MapEntity();
        entity.setId_map(model.getId_map());
        entity.setLigne(model.getLigne());
        entity.setColonne(model.getColonne());
        entity.setChemin_image(model.getChemin_image());

        return entity;
    }

    public List<MapModel> mapListEntityToModel(List<MapEntity> entities) {
        return entities.stream().map(this::mapEntityToModel).toList();
    }
}
