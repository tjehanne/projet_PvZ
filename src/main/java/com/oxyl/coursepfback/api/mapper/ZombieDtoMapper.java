package com.oxyl.coursepfback.api.mapper;

import com.oxyl.coursepfback.api.dto.ZombieDto;
import com.oxyl.coursepfback.core.model.ZombieModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ZombieDtoMapper {

    public ZombieDto mapModelToDto(ZombieModel model) {
        if (model == null) return null;

        ZombieDto dto = new ZombieDto();
        dto.setId_zombie(model.getId_zombie());
        dto.setNom(model.getNom());
        dto.setPoint_de_vie(model.getPoint_de_vie());
        dto.setAttaque_par_seconde(model.getAttaque_par_seconde());
        dto.setDegat_attaque(model.getDegat_attaque());
        dto.setVitesse_de_deplacement(model.getVitesse_de_deplacement());
        dto.setChemin_image(model.getChemin_image());
        dto.setId_map(model.getId_map());

        return dto;
    }

    public ZombieModel mapDtoToModel(ZombieDto dto) {
        if (dto == null) return null;

        ZombieModel model = new ZombieModel();
        model.setId_zombie(dto.getId_zombie());
        model.setNom(dto.getNom());
        model.setPoint_de_vie(dto.getPoint_de_vie());
        model.setAttaque_par_seconde(dto.getAttaque_par_seconde());
        model.setDegat_attaque(dto.getDegat_attaque());
        model.setVitesse_de_deplacement(dto.getVitesse_de_deplacement());
        model.setChemin_image(dto.getChemin_image());
        model.setId_map(dto.getId_map());

        return model;
    }

    public List<ZombieDto> mapListModelToDto(List<ZombieModel> models) {
        return models.stream()
                .map(this::mapModelToDto)
                .toList();
    }
}
