package com.oxyl.coursepfback.api.controller;

import com.oxyl.coursepfback.api.dto.PlanteDto;
import com.oxyl.coursepfback.api.mapper.PlanteDtoMapper;
import com.oxyl.coursepfback.core.model.PlanteModel;
import com.oxyl.coursepfback.core.service.PlanteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlanteControllerTest {

    @Mock
    private PlanteService planteService;

    @Mock
    private PlanteDtoMapper planteDtoMapper;

    private PlanteController planteController;

    @BeforeEach
    void setUp() {
        planteController = new PlanteController(planteService, planteDtoMapper);
    }

    @Test
    void shouldFindAllPlantes() {
        // Given
        List<PlanteModel> planteModels = Arrays.asList(
            new PlanteModel(1, "Tournesol", 50, 0.0, 0, 50, 1.0, "Production de soleil", "images/plante/tournesol.png"),
            new PlanteModel(2, "Pois-tireur", 75, 1.0, 20, 100, 0.0, "Tir de projectiles", "images/plante/pois-tireur.png")
        );
        List<PlanteDto> expectedDtos = Arrays.asList(
            new PlanteDto(1, "Tournesol", 50, 0.0, 0, 50, 1.0, "Production de soleil", "images/plante/tournesol.png"),
            new PlanteDto(2, "Pois-tireur", 75, 1.0, 20, 100, 0.0, "Tir de projectiles", "images/plante/pois-tireur.png")
        );
        when(planteService.findAllPlantes()).thenReturn(planteModels);
        when(planteDtoMapper.mapListModelToDto(planteModels)).thenReturn(expectedDtos);

        // When
        List<PlanteDto> actualDtos = planteController.findAllPlantes();

        // Then
        assertThat(actualDtos).isEqualTo(expectedDtos);
        verify(planteService).findAllPlantes();
        verify(planteDtoMapper).mapListModelToDto(planteModels);
    }

    @Test
    void shouldGetPlanteById() {
        // Given
        Integer planteId = 1;
        PlanteModel planteModel = new PlanteModel(planteId, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "images/plante/tournesol.png");
        PlanteDto expectedDto = new PlanteDto(planteId, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "images/plante/tournesol.png");
        when(planteService.findPlanteById(planteId)).thenReturn(planteModel);
        when(planteDtoMapper.mapModelToDto(planteModel)).thenReturn(expectedDto);

        // When
        ResponseEntity<PlanteDto> response = planteController.getPlanteById(planteId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedDto);
        verify(planteService).findPlanteById(planteId);
        verify(planteDtoMapper).mapModelToDto(planteModel);
    }

    @Test
    void shouldReturnNotFoundWhenGettingNonExistentPlante() {
        // Given
        Integer planteId = 999;
        when(planteService.findPlanteById(planteId)).thenReturn(null);

        // When
        ResponseEntity<PlanteDto> response = planteController.getPlanteById(planteId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNull();
        verify(planteService).findPlanteById(planteId);
    }

    @Test
    void shouldCreatePlante() {
        // Given
        PlanteDto planteDto = new PlanteDto(null, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "images/plante/tournesol.png");
        PlanteModel planteModel = new PlanteModel(null, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "images/plante/tournesol.png");
        when(planteDtoMapper.mapDtoToModel(planteDto)).thenReturn(planteModel);

        // When
        ResponseEntity<Void> response = planteController.createPlante(planteDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(planteDtoMapper).mapDtoToModel(planteDto);
        verify(planteService).create(planteModel);
    }

    @Test
    void shouldUpdatePlante() {
        // Given
        Integer planteId = 1;
        PlanteDto planteDto = new PlanteDto(planteId, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "images/plante/tournesol.png");
        PlanteModel existingPlante = new PlanteModel(planteId, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "images/plante/tournesol.png");
        PlanteModel updatedPlante = new PlanteModel(planteId, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "images/plante/tournesol.png");
        when(planteService.findPlanteById(planteId)).thenReturn(existingPlante);
        when(planteDtoMapper.mapDtoToModel(planteDto)).thenReturn(updatedPlante);

        // When
        ResponseEntity<Void> response = planteController.updatePlante(planteId, planteDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(planteService).findPlanteById(planteId);
        verify(planteDtoMapper).mapDtoToModel(planteDto);
        verify(planteService).update(updatedPlante);
    }

    @Test
    void shouldReturnNotFoundWhenUpdatingNonExistentPlante() {
        // Given
        Integer planteId = 999;
        PlanteDto planteDto = new PlanteDto(planteId, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "images/plante/tournesol.png");
        when(planteService.findPlanteById(planteId)).thenReturn(null);

        // When
        ResponseEntity<Void> response = planteController.updatePlante(planteId, planteDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldDeletePlante() {
        // Given
        Integer planteId = 1;
        PlanteModel existingPlante = new PlanteModel(planteId, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "images/plante/tournesol.png");
        when(planteService.findPlanteById(planteId)).thenReturn(existingPlante);

        // When
        ResponseEntity<Void> response = planteController.deletePlante(planteId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(planteService).findPlanteById(planteId);
        verify(planteService).delete(planteId);
    }

    @Test
    void shouldReturnNotFoundWhenDeletingNonExistentPlante() {
        // Given
        Integer planteId = 999;
        when(planteService.findPlanteById(planteId)).thenReturn(null);

        // When
        ResponseEntity<Void> response = planteController.deletePlante(planteId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        verify(planteService).findPlanteById(planteId);
    }

    @Test
    void shouldValidatePlanteStructure() {
        // When
        ResponseEntity<String> response = planteController.validatePlanteStructure();

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Structure Plante valide");
    }
} 