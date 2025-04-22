package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.PlanteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanteDAOInterface {
    PlanteEntity findById(Integer id);
    List<PlanteEntity> findAll();
}
