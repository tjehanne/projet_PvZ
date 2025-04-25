package com.oxyl.coursepfback.api.controller;

import com.oxyl.coursepfback.api.dto.MapDto;
import com.oxyl.coursepfback.api.mapper.MapDtoMapper;
import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.core.service.MapService;
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
class MapControllerTest {

    @Mock
    private MapService mapService;

    @Mock
    private MapDtoMapper mapDtoMapper;

    private MapController mapController;

    @BeforeEach
    void setUp() {
        mapController = new MapController(mapService, mapDtoMapper);
    }

    @Test
    void shouldFindAllMaps() {
        // Given
        List<MapModel> mapModels = Arrays.asList(
            new MapModel(1, 10, 15, "images/map/map1.png"),
            new MapModel(2, 12, 18, "images/map/map2.png")
        );
        List<MapDto> expectedDtos = Arrays.asList(
            new MapDto(1, 10, 15, "images/map/map1.png"),
            new MapDto(2, 12, 18, "images/map/map2.png")
        );
        when(mapService.findAllMaps()).thenReturn(mapModels);
        when(mapDtoMapper.mapListModelToDto(mapModels)).thenReturn(expectedDtos);

        // When
        List<MapDto> actualDtos = mapController.findAllMaps();

        // Then
        assertThat(actualDtos).isEqualTo(expectedDtos);
        verify(mapService).findAllMaps();
        verify(mapDtoMapper).mapListModelToDto(mapModels);
    }

    @Test
    void shouldGetMapById() {
        // Given
        Integer mapId = 1;
        MapModel mapModel = new MapModel(mapId, 10, 15, "images/map/map1.png");
        MapDto expectedDto = new MapDto(mapId, 10, 15, "images/map/map1.png");
        when(mapService.findMapById(mapId)).thenReturn(mapModel);
        when(mapDtoMapper.mapModelToDto(mapModel)).thenReturn(expectedDto);

        // When
        ResponseEntity<MapDto> response = mapController.getMapById(mapId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedDto);
        verify(mapService).findMapById(mapId);
        verify(mapDtoMapper).mapModelToDto(mapModel);
    }

    @Test
    void shouldReturnNotFoundWhenGettingNonExistentMap() {
        // Given
        Integer mapId = 999;
        when(mapService.findMapById(mapId)).thenReturn(null);

        // When
        ResponseEntity<MapDto> response = mapController.getMapById(mapId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNull();
        verify(mapService).findMapById(mapId);
    }

    @Test
    void shouldCreateMap() {
        // Given
        MapDto mapDto = new MapDto(null, 10, 15, "images/map/map1.png");
        MapModel mapModel = new MapModel(null, 10, 15, "images/map/map1.png");
        when(mapDtoMapper.mapDtoToModel(mapDto)).thenReturn(mapModel);

        // When
        ResponseEntity<Void> response = mapController.createMap(mapDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(mapDtoMapper).mapDtoToModel(mapDto);
        verify(mapService).create(mapModel);
    }

    @Test
    void shouldUpdateMap() {
        // Given
        Integer mapId = 1;
        MapDto mapDto = new MapDto(mapId, 10, 15, "images/map/map1.png");
        MapModel existingMap = new MapModel(mapId, 10, 15, "images/map/map1.png");
        MapModel updatedMap = new MapModel(mapId, 10, 15, "images/map/map1.png");
        when(mapService.findMapById(mapId)).thenReturn(existingMap);
        when(mapDtoMapper.mapDtoToModel(mapDto)).thenReturn(updatedMap);

        // When
        ResponseEntity<Void> response = mapController.updateMap(mapId, mapDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(mapService).findMapById(mapId);
        verify(mapDtoMapper).mapDtoToModel(mapDto);
        verify(mapService).update(updatedMap);
    }

    @Test
    void shouldReturnNotFoundWhenUpdatingNonExistentMap() {
        // Given
        Integer mapId = 999;
        MapDto mapDto = new MapDto(mapId, 10, 15, "images/map/map1.png");
        when(mapService.findMapById(mapId)).thenReturn(null);

        // When
        ResponseEntity<Void> response = mapController.updateMap(mapId, mapDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldDeleteMap() {
        // Given
        Integer mapId = 1;
        MapModel existingMap = new MapModel(mapId, 10, 15, "images/map/map1.png");
        when(mapService.findMapById(mapId)).thenReturn(existingMap);

        // When
        ResponseEntity<Void> response = mapController.deleteMap(mapId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(mapService).findMapById(mapId);
        verify(mapService).delete(mapId);
    }

    @Test
    void shouldReturnNotFoundWhenDeletingNonExistentMap() {
        // Given
        Integer mapId = 999;
        when(mapService.findMapById(mapId)).thenReturn(null);

        // When
        ResponseEntity<Void> response = mapController.deleteMap(mapId);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        verify(mapService).findMapById(mapId);
    }

    @Test
    void shouldValidateMapStructure() {
        // When
        ResponseEntity<String> response = mapController.validateMapStructure();

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Structure Map valide");
    }
} 