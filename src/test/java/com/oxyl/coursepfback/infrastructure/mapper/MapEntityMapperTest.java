package com.oxyl.coursepfback.infrastructure.mapper;

import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.infrastructure.entities.MapEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MapEntityMapperTest {

    @InjectMocks
    private MapEntityMapper mapEntityMapper;

    @Test
    void mapEntityToModel_shouldReturnNull_whenEntityIsNull() {
        // When
        MapModel result = mapEntityMapper.mapEntityToModel(null);

        // Then
        assertNull(result);
    }

    @Test
    void mapEntityToModel_shouldMapAllFields_whenEntityIsNotNull() {
        // Given
        MapEntity entity = new MapEntity();
        entity.setId_map(1);
        entity.setLigne(5);
        entity.setColonne(7);
        entity.setChemin_image("/images/map/map1.png");

        // When
        MapModel result = mapEntityMapper.mapEntityToModel(entity);

        // Then
        assertNotNull(result);
        assertEquals(entity.getId_map(), result.getId_map());
        assertEquals(entity.getLigne(), result.getLigne());
        assertEquals(entity.getColonne(), result.getColonne());
        assertEquals(entity.getChemin_image(), result.getChemin_image());
    }

    @Test
    void mapModelToEntity_shouldReturnNull_whenModelIsNull() {
        // When
        MapEntity result = mapEntityMapper.mapModelToEntity(null);

        // Then
        assertNull(result);
    }

    @Test
    void mapModelToEntity_shouldMapAllFields_whenModelIsNotNull() {
        // Given
        MapModel model = new MapModel();
        model.setId_map(1);
        model.setLigne(5);
        model.setColonne(7);
        model.setChemin_image("/images/map/map1.png");

        // When
        MapEntity result = mapEntityMapper.mapModelToEntity(model);

        // Then
        assertNotNull(result);
        assertEquals(model.getId_map(), result.getId_map());
        assertEquals(model.getLigne(), result.getLigne());
        assertEquals(model.getColonne(), result.getColonne());
        assertEquals(model.getChemin_image(), result.getChemin_image());
    }

    @Test
    void mapListEntityToModel_shouldMapAllEntities() {
        // Given
        MapEntity entity1 = new MapEntity();
        entity1.setId_map(1);
        entity1.setLigne(5);
        entity1.setColonne(7);

        MapEntity entity2 = new MapEntity();
        entity2.setId_map(2);
        entity2.setLigne(6);
        entity2.setColonne(8);

        List<MapEntity> entities = Arrays.asList(entity1, entity2);

        // When
        List<MapModel> results = mapEntityMapper.mapListEntityToModel(entities);

        // Then
        assertNotNull(results);
        assertEquals(2, results.size());
        assertEquals(entity1.getId_map(), results.get(0).getId_map());
        assertEquals(entity1.getLigne(), results.get(0).getLigne());
        assertEquals(entity1.getColonne(), results.get(0).getColonne());
        assertEquals(entity2.getId_map(), results.get(1).getId_map());
        assertEquals(entity2.getLigne(), results.get(1).getLigne());
        assertEquals(entity2.getColonne(), results.get(1).getColonne());
    }
} 