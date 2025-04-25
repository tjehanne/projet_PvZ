package com.oxyl.coursepfback.core.service;

import com.oxyl.coursepfback.core.model.PlanteModel;
import com.oxyl.coursepfback.infrastructure.repository.PlanteRepository;
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
class PlanteServiceTest {

    @Mock
    private PlanteRepository planteRepository;

    private PlanteService planteService;

    @BeforeEach
    void setUp() {
        planteService = new PlanteService(planteRepository);
    }

    @Test
    void shouldFindAllPlantes() {
        // Given
        List<PlanteModel> expectedPlantes = Arrays.asList(
            new PlanteModel(1, "Tournesol", 50, 0.0, 0, 50, 1.0, "Production de soleil", "tournesol.png"),
            new PlanteModel(2, "Pois-tireur", 75, 1.0, 20, 100, 0.0, "Tir de projectiles", "pois-tireur.png")
        );
        when(planteRepository.findAll()).thenReturn(expectedPlantes);

        // When
        List<PlanteModel> actualPlantes = planteService.findAllPlantes();

        // Then
        assertThat(actualPlantes).isEqualTo(expectedPlantes);
        verify(planteRepository).findAll();
    }

    @Test
    void shouldFindPlanteById() {
        // Given
        int planteId = 1;
        PlanteModel expectedPlante = new PlanteModel(planteId, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "tournesol.png");
        when(planteRepository.findById(planteId)).thenReturn(expectedPlante);

        // When
        PlanteModel actualPlante = planteService.findPlanteById(planteId);

        // Then
        assertThat(actualPlante).isEqualTo(expectedPlante);
        verify(planteRepository).findById(planteId);
    }

    @Test
    void shouldCreatePlante() {
        // Given
        PlanteModel plante = new PlanteModel(null, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "tournesol.png");

        // When
        planteService.create(plante);

        // Then
        verify(planteRepository).create(plante);
    }

    @Test
    void shouldUpdatePlante() {
        // Given
        PlanteModel plante = new PlanteModel(1, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "tournesol.png");

        // When
        planteService.update(plante);

        // Then
        verify(planteRepository).update(plante);
    }

    @Test
    void shouldDeletePlante() {
        // Given
        int planteId = 1;

        // When
        planteService.delete(planteId);

        // Then
        verify(planteRepository).delete(planteId);
    }
} 