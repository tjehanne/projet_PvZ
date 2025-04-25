package com.oxyl.coursepfback.infrastructure.repository;

import com.oxyl.coursepfback.core.model.PlanteModel;
import com.oxyl.coursepfback.infrastructure.dao.PlanteDAO;
import com.oxyl.coursepfback.infrastructure.entities.PlanteEntity;
import com.oxyl.coursepfback.infrastructure.mapper.PlanteEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlanteRepositoryTest {

    @Mock
    private PlanteDAO planteDAO;

    @Mock
    private PlanteEntityMapper planteEntityMapper;

    private PlanteRepository planteRepository;

    @BeforeEach
    void setUp() {
        planteRepository = new PlanteRepository(planteDAO, planteEntityMapper);
    }

    @Test
    void shouldFindAllPlantes() {
        // Given
        List<PlanteEntity> planteEntities = Arrays.asList(
            new PlanteEntity(),
            new PlanteEntity()
        );
        List<PlanteModel> expectedPlantes = Arrays.asList(
            new PlanteModel(1, "Tournesol", 50, 0.0, 0, 50, 1.0, "Production de soleil", "tournesol.png"),
            new PlanteModel(2, "Pois-tireur", 75, 1.0, 20, 100, 0.0, "Tir de projectiles", "pois-tireur.png")
        );
        when(planteDAO.findAll()).thenReturn(planteEntities);
        when(planteEntityMapper.mapListEntityToListModel(planteEntities)).thenReturn(expectedPlantes);

        // When
        List<PlanteModel> actualPlantes = planteRepository.findAll();

        // Then
        assertThat(actualPlantes).isEqualTo(expectedPlantes);
        verify(planteDAO).findAll();
        verify(planteEntityMapper).mapListEntityToListModel(planteEntities);
    }

    @Test
    void shouldFindPlanteById() {
        // Given
        int planteId = 1;
        PlanteEntity planteEntity = new PlanteEntity();
        PlanteModel expectedPlante = new PlanteModel(planteId, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "tournesol.png");
        when(planteDAO.findById(planteId)).thenReturn(planteEntity);
        when(planteEntityMapper.mapEntityToModel(planteEntity)).thenReturn(expectedPlante);

        // When
        PlanteModel actualPlante = planteRepository.findById(planteId);

        // Then
        assertThat(actualPlante).isEqualTo(expectedPlante);
        verify(planteDAO).findById(planteId);
        verify(planteEntityMapper).mapEntityToModel(planteEntity);
    }

    @Test
    void shouldCreatePlante() {
        // Given
        PlanteModel planteModel = new PlanteModel(null, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "tournesol.png");
        PlanteEntity planteEntity = new PlanteEntity();
        when(planteEntityMapper.mapModelToEntity(planteModel)).thenReturn(planteEntity);

        // When
        planteRepository.create(planteModel);

        // Then
        verify(planteEntityMapper).mapModelToEntity(planteModel);
        verify(planteDAO).create(planteEntity);
    }

    @Test
    void shouldUpdatePlante() {
        // Given
        PlanteModel planteModel = new PlanteModel(1, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "tournesol.png");
        PlanteEntity planteEntity = new PlanteEntity();
        when(planteEntityMapper.mapModelToEntity(planteModel)).thenReturn(planteEntity);

        // When
        planteRepository.update(planteModel);

        // Then
        verify(planteEntityMapper).mapModelToEntity(planteModel);
        verify(planteDAO).update(planteEntity);
    }

    @Test
    void shouldDeletePlante() {
        // Given
        int planteId = 1;

        // When
        planteRepository.delete(planteId);

        // Then
        verify(planteDAO).delete(planteId);
    }
} 