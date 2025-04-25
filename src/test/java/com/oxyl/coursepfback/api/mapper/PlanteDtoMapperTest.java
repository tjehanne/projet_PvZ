package com.oxyl.coursepfback.api.mapper;

import com.oxyl.coursepfback.api.dto.PlanteDto;
import com.oxyl.coursepfback.core.model.PlanteModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlanteDtoMapperTest {

    private PlanteDtoMapper planteDtoMapper;

    @BeforeEach
    void setUp() {
        planteDtoMapper = new PlanteDtoMapper();
    }

    @Test
    void shouldMapModelToDto() {
        // Given
        PlanteModel planteModel = new PlanteModel(1, "Tournesol", 50, 0.0, 0, 50, 1.0, 
            "Production de soleil", "tournesol.png");

        // When
        PlanteDto planteDto = planteDtoMapper.mapModelToDto(planteModel);

        // Then
        assertThat(planteDto).isNotNull();
        assertThat(planteDto.getId_plante()).isEqualTo(1);
        assertThat(planteDto.getNom()).isEqualTo("Tournesol");
        assertThat(planteDto.getPoint_de_vie()).isEqualTo(50);
        assertThat(planteDto.getAttaque_par_seconde()).isEqualTo(0.0);
        assertThat(planteDto.getDegat_attaque()).isEqualTo(0);
        assertThat(planteDto.getCout()).isEqualTo(50);
        assertThat(planteDto.getSoleil_par_seconde()).isEqualTo(1.0);
        assertThat(planteDto.getEffet()).isEqualTo("Production de soleil");
        assertThat(planteDto.getChemin_image()).isEqualTo("tournesol.png");
    }

    @Test
    void shouldReturnNullWhenMappingNullModelToDto() {
        // When
        PlanteDto planteDto = planteDtoMapper.mapModelToDto(null);

        // Then
        assertThat(planteDto).isNull();
    }

    @Test
    void shouldMapDtoToModel() {
        // Given
        PlanteDto planteDto = new PlanteDto();
        planteDto.setId_plante(1);
        planteDto.setNom("Tournesol");
        planteDto.setPoint_de_vie(50);
        planteDto.setAttaque_par_seconde(0.0);
        planteDto.setDegat_attaque(0);
        planteDto.setCout(50);
        planteDto.setSoleil_par_seconde(1.0);
        planteDto.setEffet("Production de soleil");
        planteDto.setChemin_image("tournesol.png");

        // When
        PlanteModel planteModel = planteDtoMapper.mapDtoToModel(planteDto);

        // Then
        assertThat(planteModel).isNotNull();
        assertThat(planteModel.getId_plante()).isEqualTo(1);
        assertThat(planteModel.getNom()).isEqualTo("Tournesol");
        assertThat(planteModel.getPoint_de_vie()).isEqualTo(50);
        assertThat(planteModel.getAttaque_par_seconde()).isEqualTo(0.0);
        assertThat(planteModel.getDegat_attaque()).isEqualTo(0);
        assertThat(planteModel.getCout()).isEqualTo(50);
        assertThat(planteModel.getSoleil_par_seconde()).isEqualTo(1.0);
        assertThat(planteModel.getEffet()).isEqualTo("Production de soleil");
        assertThat(planteModel.getChemin_image()).isEqualTo("tournesol.png");
    }

    @Test
    void shouldReturnNullWhenMappingNullDtoToModel() {
        // When
        PlanteModel planteModel = planteDtoMapper.mapDtoToModel(null);

        // Then
        assertThat(planteModel).isNull();
    }

    @Test
    void shouldMapListModelToDto() {
        // Given
        List<PlanteModel> planteModels = Arrays.asList(
            new PlanteModel(1, "Tournesol", 50, 0.0, 0, 50, 1.0, "Production de soleil", "tournesol.png"),
            new PlanteModel(2, "Pois-tireur", 75, 1.0, 20, 100, 0.0, "Tir de projectiles", "pois-tireur.png")
        );

        // When
        List<PlanteDto> planteDtos = planteDtoMapper.mapListModelToDto(planteModels);

        // Then
        assertThat(planteDtos).hasSize(2);
        
        PlanteDto firstPlanteDto = planteDtos.get(0);
        assertThat(firstPlanteDto.getId_plante()).isEqualTo(1);
        assertThat(firstPlanteDto.getNom()).isEqualTo("Tournesol");
        
        PlanteDto secondPlanteDto = planteDtos.get(1);
        assertThat(secondPlanteDto.getId_plante()).isEqualTo(2);
        assertThat(secondPlanteDto.getNom()).isEqualTo("Pois-tireur");
    }
} 