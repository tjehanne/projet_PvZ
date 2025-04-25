package com.oxyl.coursepfback.api.controller;

import com.oxyl.coursepfback.api.dto.ZombieDto;
import com.oxyl.coursepfback.api.mapper.ZombieDtoMapper;
import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.core.service.ZombieService;
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
class ZombieControllerTest {

    @Mock
    private ZombieService zombieService;

    @Mock
    private ZombieDtoMapper zombieDtoMapper;

    private ZombieController zombieController;

    @BeforeEach
    void setUp() {
        zombieController = new ZombieController(zombieService, zombieDtoMapper);
    }

    @Test
    void shouldFindAllZombies() {
        // Given
        List<ZombieModel> zombieModels = Arrays.asList(
            new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "images/zombie/zombie1.png", 1),
            new ZombieModel(2, "Zombie2", 80, 1.5, 15, 1.0, "images/zombie/zombie2.png", 1)
        );
        List<ZombieDto> expectedDtos = Arrays.asList(
            new ZombieDto(1, "Zombie1", 100, 1.0, 20, 0.5, "images/zombie/zombie1.png", 1),
            new ZombieDto(2, "Zombie2", 80, 1.5, 15, 1.0, "images/zombie/zombie2.png", 1)
        );
        when(zombieService.findAllZombies()).thenReturn(zombieModels);
        when(zombieDtoMapper.mapListModelToDto(zombieModels)).thenReturn(expectedDtos);

        // When
        List<ZombieDto> actualDtos = zombieController.findAllZombies();

        // Then
        assertThat(actualDtos).isEqualTo(expectedDtos);
        verify(zombieService).findAllZombies();
        verify(zombieDtoMapper).mapListModelToDto(zombieModels);
    }

    @Test
    void shouldGetZombieById() {
        // Given
        Integer zombieId = 1;
        ZombieModel zombieModel = new ZombieModel(zombieId, "Zombie1", 100, 1.0, 20, 0.5, 
            "images/zombie/zombie1.png", 1);
        ZombieDto expectedDto = new ZombieDto(zombieId, "Zombie1", 100, 1.0, 20, 0.5, 
            "images/zombie/zombie1.png", 1);
        when(zombieService.findZombieById(zombieId)).thenReturn(zombieModel);
        when(zombieDtoMapper.mapModelToDto(zombieModel)).thenReturn(expectedDto);

        // When
        ResponseEntity<ZombieDto> response = zombieController.getZombieById(zombieId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedDto);
        verify(zombieService).findZombieById(zombieId);
        verify(zombieDtoMapper).mapModelToDto(zombieModel);
    }

    @Test
    void shouldReturnNotFoundWhenGettingNonExistentZombie() {
        // Given
        Integer zombieId = 999;
        when(zombieService.findZombieById(zombieId)).thenReturn(null);

        // When
        ResponseEntity<ZombieDto> response = zombieController.getZombieById(zombieId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNull();
        verify(zombieService).findZombieById(zombieId);
    }

    @Test
    void shouldCreateZombie() {
        // Given
        ZombieDto zombieDto = new ZombieDto(null, "Zombie1", 100, 1.0, 20, 0.5, 
            "images/zombie/zombie1.png", 1);
        ZombieModel zombieModel = new ZombieModel(null, "Zombie1", 100, 1.0, 20, 0.5, 
            "images/zombie/zombie1.png", 1);
        when(zombieDtoMapper.mapDtoToModel(zombieDto)).thenReturn(zombieModel);

        // When
        ResponseEntity<Void> response = zombieController.createZombie(zombieDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(zombieDtoMapper).mapDtoToModel(zombieDto);
        verify(zombieService).create(zombieModel);
    }

    @Test
    void shouldUpdateZombie() {
        // Given
        Integer zombieId = 1;
        ZombieDto zombieDto = new ZombieDto(zombieId, "Zombie1", 100, 1.0, 20, 0.5, 
            "images/zombie/zombie1.png", 1);
        ZombieModel existingZombie = new ZombieModel(zombieId, "Zombie1", 100, 1.0, 20, 0.5, 
            "images/zombie/zombie1.png", 1);
        ZombieModel updatedZombie = new ZombieModel(zombieId, "Zombie1", 100, 1.0, 20, 0.5, 
            "images/zombie/zombie1.png", 1);
        when(zombieService.findZombieById(zombieId)).thenReturn(existingZombie);
        when(zombieDtoMapper.mapDtoToModel(zombieDto)).thenReturn(updatedZombie);

        // When
        ResponseEntity<Void> response = zombieController.updateZombie(zombieId, zombieDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(zombieService).findZombieById(zombieId);
        verify(zombieDtoMapper).mapDtoToModel(zombieDto);
        verify(zombieService).update(updatedZombie);
    }

    @Test
    void shouldReturnNotFoundWhenUpdatingNonExistentZombie() {
        // Given
        Integer zombieId = 999;
        ZombieDto zombieDto = new ZombieDto(zombieId, "Zombie1", 100, 1.0, 20, 0.5, 
            "images/zombie/zombie1.png", 1);
        when(zombieService.findZombieById(zombieId)).thenReturn(null);

        // When
        ResponseEntity<Void> response = zombieController.updateZombie(zombieId, zombieDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldDeleteZombie() {
        // Given
        Integer zombieId = 1;
        ZombieModel existingZombie = new ZombieModel(zombieId, "Zombie1", 100, 1.0, 20, 0.5, 
            "images/zombie/zombie1.png", 1);
        when(zombieService.findZombieById(zombieId)).thenReturn(existingZombie);

        // When
        ResponseEntity<Void> response = zombieController.deleteZombie(zombieId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(zombieService).findZombieById(zombieId);
        verify(zombieService).delete(zombieId);
    }

    @Test
    void shouldReturnNotFoundWhenDeletingNonExistentZombie() {
        // Given
        Integer zombieId = 999;
        when(zombieService.findZombieById(zombieId)).thenReturn(null);

        // When
        ResponseEntity<Void> response = zombieController.deleteZombie(zombieId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        verify(zombieService).findZombieById(zombieId);
    }

    @Test
    void shouldValidateZombieStructure() {
        // When
        ResponseEntity<String> response = zombieController.validateZombieStructure();

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Structure Zombie valide");
    }
} 