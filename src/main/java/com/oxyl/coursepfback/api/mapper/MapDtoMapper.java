package com.oxyl.coursepfback.api.mapper;

import com.oxyl.coursepfback.api.dto.MapDto;
import com.oxyl.coursepfback.core.model.MapModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapDtoMapper {

    public MapDto mapModelToDto(MapModel model) {
        if (model == null) return null;

        MapDto dto = new MapDto();
        dto.setId_map(model.getId_map());
        dto.setLigne(model.getLigne());
        dto.setColonne(model.getColonne());
        dto.setChemin_image(model.getChemin_image());

        return dto;
    }

    public MapModel mapDtoToModel(MapDto dto) {
        if (dto == null) return null;

        MapModel model = new MapModel();
        model.setId_map(dto.getId_map());
        model.setLigne(dto.getLigne());
        model.setColonne(dto.getColonne());
        model.setChemin_image(dto.getChemin_image());

        return model;
    }

    public List<MapDto> mapListModelToDto(List<MapModel> models) {
        return models.stream().map(this::mapModelToDto).collect(Collectors.toList());
    }
}
