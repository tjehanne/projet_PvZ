package com.oxyl.coursepfback.infrastructure.repository;

import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.dao.ZombieDAO;
import com.oxyl.coursepfback.infrastructure.entities.ZombieEntity;
import com.oxyl.coursepfback.infrastructure.mapper.ZombieEntityMapper;
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
class ZombieRepositoryTest {

    @Mock
    private ZombieDAO zombieDAO;

    @Mock
    private ZombieEntityMapper zombieEntityMapper;

    private ZombieRepository zombieRepository;

    @BeforeEach
    void setUp() {
        zombieRepository = new ZombieRepository(zombieDAO, zombieEntityMapper);
    }

    @Test
    void shouldFindAllZombies() {
        // Given
        List<ZombieEntity> zombieEntities = Arrays.asList(
            new ZombieEntity(),
            new ZombieEntity()
        );
        List<ZombieModel> expectedZombies = Arrays.asList(
            new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", 1),
            new ZombieModel(2, "Zombie2", 80, 1.5, 15, 1.0, "zombie2.png", 1)
        );
        when(zombieDAO.findAll()).thenReturn(zombieEntities);
        when(zombieEntityMapper.mapListEntityToModel(zombieEntities)).thenReturn(expectedZombies);

        // When
        List<ZombieModel> actualZombies = zombieRepository.findAll();

        // Then
        assertThat(actualZombies).isEqualTo(expectedZombies);
        verify(zombieDAO).findAll();
        verify(zombieEntityMapper).mapListEntityToModel(zombieEntities);
    }

    @Test
    void shouldFindZombieById() {
        // Given
        Integer zombieId = 1;
        ZombieEntity zombieEntity = new ZombieEntity();
        ZombieModel expectedZombie = new ZombieModel(zombieId, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", 1);
        when(zombieDAO.findById(zombieId)).thenReturn(zombieEntity);
        when(zombieEntityMapper.mapEntityToModel(zombieEntity)).thenReturn(expectedZombie);

        // When
        ZombieModel actualZombie = zombieRepository.findById(zombieId);

        // Then
        assertThat(actualZombie).isEqualTo(expectedZombie);
        verify(zombieDAO).findById(zombieId);
        verify(zombieEntityMapper).mapEntityToModel(zombieEntity);
    }

    @Test
    void shouldFindZombiesByMapId() {
        // Given
        Integer mapId = 1;
        List<ZombieEntity> zombieEntities = Arrays.asList(
            new ZombieEntity(),
            new ZombieEntity()
        );
        List<ZombieModel> expectedZombies = Arrays.asList(
            new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", mapId),
            new ZombieModel(2, "Zombie2", 80, 1.5, 15, 1.0, "zombie2.png", mapId)
        );
        when(zombieDAO.findByMapId(mapId)).thenReturn(zombieEntities);
        when(zombieEntityMapper.mapListEntityToModel(zombieEntities)).thenReturn(expectedZombies);

        // When
        List<ZombieModel> actualZombies = zombieRepository.findByMapId(mapId);

        // Then
        assertThat(actualZombies).isEqualTo(expectedZombies);
        verify(zombieDAO).findByMapId(mapId);
        verify(zombieEntityMapper).mapListEntityToModel(zombieEntities);
    }

    @Test
    void shouldCreateZombie() {
        // Given
        ZombieModel zombieModel = new ZombieModel(null, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", 1);
        ZombieEntity zombieEntity = new ZombieEntity();
        when(zombieEntityMapper.mapModelToEntity(zombieModel)).thenReturn(zombieEntity);

        // When
        zombieRepository.create(zombieModel);

        // Then
        verify(zombieEntityMapper).mapModelToEntity(zombieModel);
        verify(zombieDAO).create(zombieEntity);
    }

    @Test
    void shouldUpdateZombie() {
        // Given
        ZombieModel zombieModel = new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", 1);
        ZombieEntity zombieEntity = new ZombieEntity();
        when(zombieEntityMapper.mapModelToEntity(zombieModel)).thenReturn(zombieEntity);

        // When
        zombieRepository.update(zombieModel);

        // Then
        verify(zombieEntityMapper).mapModelToEntity(zombieModel);
        verify(zombieDAO).update(zombieEntity);
    }

    @Test
    void shouldDeleteZombie() {
        // Given
        Integer zombieId = 1;

        // When
        zombieRepository.delete(zombieId);

        // Then
        verify(zombieDAO).delete(zombieId);
    }
} 