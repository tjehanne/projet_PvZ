package com.oxyl.coursepfback.infrastructure.mapper;

import com.oxyl.coursepfback.core.model.PlanteModel;
import com.oxyl.coursepfback.infrastructure.entities.PlanteEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanteEntityMapper {

    public PlanteModel mapEntityToModel(PlanteEntity entity) {
        if (entity == null) {
            return null;
        }
        PlanteModel planteModel = new PlanteModel();
        planteModel.setId_plante(entity.getId_plante());
        planteModel.setNom(entity.getNom());
        planteModel.setPoint_de_vie(entity.getPoint_de_vie());
        planteModel.setAttaque_par_seconde(entity.getAttaque_par_seconde());
        planteModel.setDegat_attaque(entity.getDegat_attaque());
        planteModel.setCout(entity.getCout());
        planteModel.setSoleil_par_seconde(entity.getSoleil_par_seconde());
        planteModel.setEffet(entity.getEffet());
        planteModel.setChemin_image(entity.getChemin_image());
        return planteModel;
    }

    public PlanteEntity mapModelToEntity(PlanteModel planteModel) {
        if (planteModel == null) {
            return null;
        }
        PlanteEntity planteEntity = new PlanteEntity();
        planteEntity.setId_plante(planteModel.getId_plante());
        planteEntity.setNom(planteModel.getNom());
        planteEntity.setPoint_de_vie(planteModel.getPoint_de_vie());
        planteEntity.setAttaque_par_seconde(planteModel.getAttaque_par_seconde());
        planteEntity.setDegat_attaque(planteModel.getDegat_attaque());
        planteEntity.setCout(planteModel.getCout());
        planteEntity.setSoleil_par_seconde(planteModel.getSoleil_par_seconde());
        planteEntity.setEffet(planteModel.getEffet());
        planteEntity.setChemin_image(planteModel.getChemin_image());
        return planteEntity;
    }

    public List<PlanteModel> mapListEntityToListModel(List<PlanteEntity> entities) {
        return entities.stream()
                .map(this::mapEntityToModel)
                .toList();
    }

}
