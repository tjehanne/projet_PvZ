package com.oxyl.coursepfback.core.service;

import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.repository.MapRepository;
import com.oxyl.coursepfback.infrastructure.repository.ZombieRepository;
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
class MapServiceTest {

    @Mock
    private MapRepository mapRepository;

    @Mock
    private ZombieRepository zombieRepository;

    private MapService mapService;

    @BeforeEach
    void setUp() {
        mapService = new MapService(mapRepository, zombieRepository);
    }

    @Test
    void shouldFindAllMaps() {
        // Given
        List<MapModel> expectedMaps = Arrays.asList(
            new MapModel(1, 5, 3, "map1.png"),
            new MapModel(2, 6, 4, "map2.png")
        );
        when(mapRepository.findAll()).thenReturn(expectedMaps);

        // When
        List<MapModel> actualMaps = mapService.findAllMaps();

        // Then
        assertThat(actualMaps).isEqualTo(expectedMaps);
        verify(mapRepository).findAll();
    }

    @Test
    void shouldFindMapById() {
        // Given
        Integer mapId = 1;
        MapModel expectedMap = new MapModel(mapId, 5, 3, "map1.png");
        when(mapRepository.findById(mapId)).thenReturn(expectedMap);

        // When
        MapModel actualMap = mapService.findMapById(mapId);

        // Then
        assertThat(actualMap).isEqualTo(expectedMap);
        verify(mapRepository).findById(mapId);
    }

    @Test
    void shouldCreateMap() {
        // Given
        MapModel map = new MapModel(null, 5, 3, "map1.png");

        // When
        mapService.create(map);

        // Then
        verify(mapRepository).create(map);
    }

    @Test
    void shouldUpdateMap() {
        // Given
        MapModel map = new MapModel(1, 5, 3, "map1.png");

        // When
        mapService.update(map);

        // Then
        verify(mapRepository).update(map);
    }

    @Test
    void shouldDeleteMapAndUpdateAssociatedZombies() {
        // Given
        Integer mapId = 1;
        List<ZombieModel> zombies = Arrays.asList(
            new ZombieModel(1, "Zombie1", 100, 1.0, 20, 0.5, "zombie1.png", mapId),
            new ZombieModel(2, "Zombie2", 80, 1.5, 15, 1.0, "zombie2.png", mapId)
        );
        when(zombieRepository.findByMapId(mapId)).thenReturn(zombies);

        // When
        mapService.delete(mapId);

        // Then
        verify(zombieRepository).findByMapId(mapId);
        
        // Verify that each zombie was updated with null map ID
        zombies.forEach(zombie -> {
            zombie.setId_map(null);
            verify(zombieRepository).update(zombie);
        });
        
        verify(mapRepository).delete(mapId);
    }
} 