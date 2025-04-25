package com.oxyl.coursepfback.infrastructure.repository;

import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.infrastructure.dao.MapDAO;
import com.oxyl.coursepfback.infrastructure.entities.MapEntity;
import com.oxyl.coursepfback.infrastructure.mapper.MapEntityMapper;
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
class MapRepositoryTest {

    @Mock
    private MapDAO mapDAO;

    @Mock
    private MapEntityMapper mapEntityMapper;

    private MapRepository mapRepository;

    @BeforeEach
    void setUp() {
        mapRepository = new MapRepository(mapDAO, mapEntityMapper);
    }

    @Test
    void shouldFindAllMaps() {
        // Given
        List<MapEntity> mapEntities = Arrays.asList(
            new MapEntity(),
            new MapEntity()
        );
        List<MapModel> expectedMaps = Arrays.asList(
            new MapModel(1, 10, 15, "images/map/map1.png"),
            new MapModel(2, 12, 18, "images/map/map2.png")
        );
        when(mapDAO.findAll()).thenReturn(mapEntities);
        when(mapEntityMapper.mapListEntityToModel(mapEntities)).thenReturn(expectedMaps);

        // When
        List<MapModel> actualMaps = mapRepository.findAll();

        // Then
        assertThat(actualMaps).isEqualTo(expectedMaps);
        verify(mapDAO).findAll();
        verify(mapEntityMapper).mapListEntityToModel(mapEntities);
    }

    @Test
    void shouldFindMapById() {
        // Given
        Integer mapId = 1;
        MapEntity mapEntity = new MapEntity();
        MapModel expectedMap = new MapModel(mapId, 10, 15, "images/map/map1.png");
        when(mapDAO.findById(mapId)).thenReturn(mapEntity);
        when(mapEntityMapper.mapEntityToModel(mapEntity)).thenReturn(expectedMap);

        // When
        MapModel actualMap = mapRepository.findById(mapId);

        // Then
        assertThat(actualMap).isEqualTo(expectedMap);
        verify(mapDAO).findById(mapId);
        verify(mapEntityMapper).mapEntityToModel(mapEntity);
    }

    @Test
    void shouldCreateMap() {
        // Given
        MapModel mapModel = new MapModel(null, 10, 15, "images/map/map1.png");
        MapEntity mapEntity = new MapEntity();
        when(mapEntityMapper.mapModelToEntity(mapModel)).thenReturn(mapEntity);

        // When
        mapRepository.create(mapModel);

        // Then
        verify(mapEntityMapper).mapModelToEntity(mapModel);
        verify(mapDAO).create(mapEntity);
    }

    @Test
    void shouldUpdateMap() {
        // Given
        MapModel mapModel = new MapModel(1, 10, 15, "images/map/map1.png");
        MapEntity mapEntity = new MapEntity();
        when(mapEntityMapper.mapModelToEntity(mapModel)).thenReturn(mapEntity);

        // When
        mapRepository.update(mapModel);

        // Then
        verify(mapEntityMapper).mapModelToEntity(mapModel);
        verify(mapDAO).update(mapEntity);
    }

    @Test
    void shouldDeleteMap() {
        // Given
        Integer mapId = 1;

        // When
        mapRepository.delete(mapId);

        // Then
        verify(mapDAO).delete(mapId);
    }
} 