package com.oxyl.coursepfback.api.mapper;

import com.oxyl.coursepfback.api.dto.MapDto;
import com.oxyl.coursepfback.core.model.MapModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MapDtoMapperTest {

    private MapDtoMapper mapDtoMapper;

    @BeforeEach
    void setUp() {
        mapDtoMapper = new MapDtoMapper();
    }

    @Test
    void shouldMapModelToDto() {
        // Given
        MapModel mapModel = new MapModel(1, 5, 3, "images/map/map1.png");

        // When
        MapDto mapDto = mapDtoMapper.mapModelToDto(mapModel);

        // Then
        assertThat(mapDto).isNotNull();
        assertThat(mapDto.getId_map()).isEqualTo(1);
        assertThat(mapDto.getLigne()).isEqualTo(5);
        assertThat(mapDto.getColonne()).isEqualTo(3);
        assertThat(mapDto.getChemin_image()).isEqualTo("/CoursEpfBack/images/map/map1.png");
    }

    @Test
    void shouldNotModifyImagePathWhenItStartsWithSlash() {
        // Given
        MapModel mapModel = new MapModel(1, 5, 3, "/images/map/map1.png");

        // When
        MapDto mapDto = mapDtoMapper.mapModelToDto(mapModel);

        // Then
        assertThat(mapDto.getChemin_image()).isEqualTo("/images/map/map1.png");
    }

    @Test
    void shouldReturnNullWhenMappingNullModelToDto() {
        // When
        MapDto mapDto = mapDtoMapper.mapModelToDto(null);

        // Then
        assertThat(mapDto).isNull();
    }

    @Test
    void shouldMapDtoToModel() {
        // Given
        MapDto mapDto = new MapDto();
        mapDto.setId_map(1);
        mapDto.setLigne(5);
        mapDto.setColonne(3);
        mapDto.setChemin_image("/CoursEpfBack/images/map/map1.png");

        // When
        MapModel mapModel = mapDtoMapper.mapDtoToModel(mapDto);

        // Then
        assertThat(mapModel).isNotNull();
        assertThat(mapModel.getId_map()).isEqualTo(1);
        assertThat(mapModel.getLigne()).isEqualTo(5);
        assertThat(mapModel.getColonne()).isEqualTo(3);
        assertThat(mapModel.getChemin_image()).isEqualTo("images/map/map1.png");
    }

    @Test
    void shouldNotModifyImagePathWhenItDoesNotStartWithCoursEpfBack() {
        // Given
        MapDto mapDto = new MapDto();
        mapDto.setId_map(1);
        mapDto.setLigne(5);
        mapDto.setColonne(3);
        mapDto.setChemin_image("/other/path/map1.png");

        // When
        MapModel mapModel = mapDtoMapper.mapDtoToModel(mapDto);

        // Then
        assertThat(mapModel.getChemin_image()).isEqualTo("/other/path/map1.png");
    }

    @Test
    void shouldReturnNullWhenMappingNullDtoToModel() {
        // When
        MapModel mapModel = mapDtoMapper.mapDtoToModel(null);

        // Then
        assertThat(mapModel).isNull();
    }

    @Test
    void shouldMapListModelToDto() {
        // Given
        List<MapModel> mapModels = Arrays.asList(
            new MapModel(1, 5, 3, "images/map/map1.png"),
            new MapModel(2, 6, 4, "images/map/map2.png")
        );

        // When
        List<MapDto> mapDtos = mapDtoMapper.mapListModelToDto(mapModels);

        // Then
        assertThat(mapDtos).hasSize(2);
        
        MapDto firstMapDto = mapDtos.get(0);
        assertThat(firstMapDto.getId_map()).isEqualTo(1);
        assertThat(firstMapDto.getLigne()).isEqualTo(5);
        assertThat(firstMapDto.getColonne()).isEqualTo(3);
        assertThat(firstMapDto.getChemin_image()).isEqualTo("/CoursEpfBack/images/map/map1.png");
        
        MapDto secondMapDto = mapDtos.get(1);
        assertThat(secondMapDto.getId_map()).isEqualTo(2);
        assertThat(secondMapDto.getLigne()).isEqualTo(6);
        assertThat(secondMapDto.getColonne()).isEqualTo(4);
        assertThat(secondMapDto.getChemin_image()).isEqualTo("/CoursEpfBack/images/map/map2.png");
    }
} 