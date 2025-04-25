package com.oxyl.coursepfback.api.mapper;

import com.oxyl.coursepfback.api.dto.PlanteDto;
import com.oxyl.coursepfback.core.model.PlanteModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe de mapping pour convertir les objets Plante entre DTO et Model.
 * Permet d'assurer la conversion des données entre la couche API et la couche métier.
 * Gère la transformation des attributs spécifiques aux plantes.
 */
@Component
public class PlanteDtoMapper {

    /**
     * Convertit un modèle de plante en DTO
     * @param planteModel Le modèle de plante à convertir
     * @return Le DTO correspondant, ou null si le modèle est null
     */
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

    /**
     * Convertit un DTO de plante en modèle
     * @param planteDto Le DTO à convertir
     * @return Le modèle correspondant, ou null si le DTO est null
     */
    public PlanteModel mapDtoToModel(PlanteDto planteDto) {
        if (planteDto == null) {
            return null;
        }

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

    /**
     * Convertit une liste de modèles en liste de DTOs
     * @param planteModels La liste de modèles à convertir
     * @return La liste des DTOs correspondants
     */
    public List<PlanteDto> mapListModelToDto(List<PlanteModel> planteModels) {
        return planteModels.stream()
                .map(this::mapModelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Convertit une liste de DTOs en liste de modèles
     * @param planteDtos La liste de DTOs à convertir
     * @return La liste des modèles correspondants
     */
    public List<PlanteModel> mapListDtoToModel(List<PlanteDto> planteDtos) {
        return planteDtos.stream()
                .map(this::mapDtoToModel)
                .collect(Collectors.toList());
    }
}
