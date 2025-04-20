package com.oxyl.coursepfback.infrastructure.repository;

import com.oxyl.coursepfback.core.model.PlanteModel;
import com.oxyl.coursepfback.infrastructure.dao.PlanteDAO;
import com.oxyl.coursepfback.infrastructure.entities.PlanteEntity;
import com.oxyl.coursepfback.infrastructure.mapper.PlanteEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteRepository {
    private final PlanteDAO planteDAO;
    private final PlanteEntityMapper planteEntityMapper;

    public PlanteRepository(PlanteDAO planteDAO, PlanteEntityMapper planteEntityMapper) {
        this.planteDAO = planteDAO;
        this.planteEntityMapper = planteEntityMapper;
    }

    public List<PlanteModel> findAll() {
        return planteEntityMapper.mapListEntityToListModel(planteDAO.findAll());
    }
    public PlanteModel findById(int id) {
        return planteEntityMapper.mapEntityToModel(planteDAO.findById(id));
    }
    public void create(PlanteModel plante) {
        PlanteEntity planteEntity = planteEntityMapper.mapModelToEntity(plante);
        planteDAO.create(planteEntity);
    }

    public void update(PlanteModel plante) {
        PlanteEntity planteEntity = planteEntityMapper.mapModelToEntity(plante);
        planteDAO.update(planteEntity);
    }

    public void delete(int id) {
        planteDAO.delete(id);
    }
}
