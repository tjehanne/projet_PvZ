package com.oxyl.coursepfback.core.service;

import com.oxyl.coursepfback.core.model.PlanteModel;
import com.oxyl.coursepfback.infrastructure.repository.PlanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanteService {

    private final PlanteRepository planteRepository;

    @Autowired
    public PlanteService(PlanteRepository planteRepository) {
        this.planteRepository = planteRepository;
    }

    public List<PlanteModel> findAllPlantes() {
        return planteRepository.findAll();
    }

    public PlanteModel findPlanteById(int id) {
        return planteRepository.findById(id);
    }

    public void create(PlanteModel plante) {
        planteRepository.create(plante);
    }

    public void update(PlanteModel plante) {
        planteRepository.update(plante);
    }
    public void delete(int id) {
        planteRepository.delete(id);
    }
}
