package com.oxyl.coursepfback.api.mapper;

import com.oxyl.coursepfback.api.dto.ZombieDto;
import com.oxyl.coursepfback.core.model.ZombieModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ZombieDtoMapperTest {

    private ZombieDtoMapper zombieDtoMapper;

    @BeforeEach
    void setUp() {
        zombieDtoMapper = new ZombieDtoMapper();
    }

    @Test
    void shouldMapModelToDto() {
        // Given
        ZombieModel zombieModel = new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", 1);

        // When
        ZombieDto zombieDto = zombieDtoMapper.mapModelToDto(zombieModel);

        // Then
        assertThat(zombieDto).isNotNull();
        assertThat(zombieDto.getId_zombie()).isEqualTo(1);
        assertThat(zombieDto.getNom()).isEqualTo("Zombie1");
        assertThat(zombieDto.getPoint_de_vie()).isEqualTo(100);
        assertThat(zombieDto.getAttaque_par_seconde()).isEqualTo(1.0);
        assertThat(zombieDto.getDegat_attaque()).isEqualTo(20);
        assertThat(zombieDto.getVitesse_de_deplacement()).isEqualTo(0.5);
        assertThat(zombieDto.getChemin_image()).isEqualTo("zombie1.png");
        assertThat(zombieDto.getId_map()).isEqualTo(1);
    }

    @Test
    void shouldReturnNullWhenMappingNullModelToDto() {
        // When
        ZombieDto zombieDto = zombieDtoMapper.mapModelToDto(null);

        // Then
        assertThat(zombieDto).isNull();
    }

    @Test
    void shouldMapDtoToModel() {
        // Given
        ZombieDto zombieDto = new ZombieDto();
        zombieDto.setId_zombie(1);
        zombieDto.setNom("Zombie1");
        zombieDto.setPoint_de_vie(100);
        zombieDto.setAttaque_par_seconde(1.0);
        zombieDto.setDegat_attaque(20);
        zombieDto.setVitesse_de_deplacement(0.5);
        zombieDto.setChemin_image("zombie1.png");
        zombieDto.setId_map(1);

        // When
        ZombieModel zombieModel = zombieDtoMapper.mapDtoToModel(zombieDto);

        // Then
        assertThat(zombieModel).isNotNull();
        assertThat(zombieModel.getId_zombie()).isEqualTo(1);
        assertThat(zombieModel.getNom()).isEqualTo("Zombie1");
        assertThat(zombieModel.getPoint_de_vie()).isEqualTo(100);
        assertThat(zombieModel.getAttaque_par_seconde()).isEqualTo(1.0);
        assertThat(zombieModel.getDegat_attaque()).isEqualTo(20);
        assertThat(zombieModel.getVitesse_de_deplacement()).isEqualTo(0.5);
        assertThat(zombieModel.getChemin_image()).isEqualTo("zombie1.png");
        assertThat(zombieModel.getId_map()).isEqualTo(1);
    }

    @Test
    void shouldReturnNullWhenMappingNullDtoToModel() {
        // When
        ZombieModel zombieModel = zombieDtoMapper.mapDtoToModel(null);

        // Then
        assertThat(zombieModel).isNull();
    }

    @Test
    void shouldMapListModelToDto() {
        // Given
        List<ZombieModel> zombieModels = Arrays.asList(
            new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", 1),
            new ZombieModel(2, "Zombie2", 80, 1.5, 15, 1.0, "zombie2.png", 1)
        );

        // When
        List<ZombieDto> zombieDtos = zombieDtoMapper.mapListModelToDto(zombieModels);

        // Then
        assertThat(zombieDtos).hasSize(2);
        
        ZombieDto firstZombieDto = zombieDtos.get(0);
        assertThat(firstZombieDto.getId_zombie()).isEqualTo(1);
        assertThat(firstZombieDto.getNom()).isEqualTo("Zombie1");
        
        ZombieDto secondZombieDto = zombieDtos.get(1);
        assertThat(secondZombieDto.getId_zombie()).isEqualTo(2);
        assertThat(secondZombieDto.getNom()).isEqualTo("Zombie2");
    }
} 