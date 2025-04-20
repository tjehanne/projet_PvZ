package com.oxyl.coursepfback.api.mapper;

import com.oxyl.coursepfback.api.dto.PlanteDto;
import com.oxyl.coursepfback.core.model.PlanteModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanteDtoMapper {

    public PlanteDto mapModelToDto(PlanteModel planteModel) {
        if (planteModel == null) {
            return null;
        }

        PlanteDto planteDto = new PlanteDto();
        planteDto.setId_plante(planteModel.getId_plante());
        planteDto.setNom(planteModel.getNom());
        planteDto.setPoint_de_vie(planteModel.getPoint_de_vie());
        planteDto.setAttaque_par_seconde(planteModel.getAttaque_par_seconde());
        planteDto.setDegat_attaque(planteModel.getDegat_attaque());
        planteDto.setCout(planteModel.getCout());
        planteDto.setSoleil_par_seconde(planteModel.getSoleil_par_seconde());
        planteDto.setEffet(planteModel.getEffet());
        planteDto.setChemin_image(planteModel.getChemin_image());
        return planteDto;
    }

    public PlanteModel mapDtoToModel(PlanteDto planteDto) {
        PlanteModel planteModel = new PlanteModel();
        planteModel.setId_plante(planteDto.getId_plante());
        planteModel.setNom(planteDto.getNom());
        planteModel.setPoint_de_vie(planteDto.getPoint_de_vie());
        planteModel.setAttaque_par_seconde(planteDto.getAttaque_par_seconde());
        planteModel.setDegat_attaque(planteDto.getDegat_attaque());
        planteModel.setCout(planteDto.getCout());
        planteModel.setSoleil_par_seconde(planteDto.getSoleil_par_seconde());
        planteModel.setEffet(planteDto.getEffet());
        planteModel.setChemin_image(planteDto.getChemin_image());
        return planteModel;
    }

    public List<PlanteDto> mapListModelToDto(List<PlanteModel> plantes) {
        return plantes.stream()
                .map(this::mapModelToDto)
                .collect(Collectors.toList());
    }
}
