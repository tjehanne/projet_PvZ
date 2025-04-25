package com.oxyl.coursepfback.infrastructure.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapEntityTest {

    @Test
    void testConstructorAndGetters() {
        // Given
        Integer id = 1;
        Integer ligne = 10;
        Integer colonne = 15;
        String cheminImage = "images/map/map1.png";

        // When
        MapEntity mapEntity = new MapEntity(id, ligne, colonne, cheminImage);

        // Then
        assertEquals(id, mapEntity.getId_map());
        assertEquals(ligne, mapEntity.getLigne());
        assertEquals(colonne, mapEntity.getColonne());
        assertEquals(cheminImage, mapEntity.getChemin_image());
    }

    @Test
    void testSetters() {
        // Given
        MapEntity mapEntity = new MapEntity();

        // When
        mapEntity.setId_map(1);
        mapEntity.setLigne(10);
        mapEntity.setColonne(15);
        mapEntity.setChemin_image("images/map/map1.png");

        // Then
        assertEquals(1, mapEntity.getId_map());
        assertEquals(10, mapEntity.getLigne());
        assertEquals(15, mapEntity.getColonne());
        assertEquals("images/map/map1.png", mapEntity.getChemin_image());
    }

    @Test
    void testDefaultConstructor() {
        // When
        MapEntity mapEntity = new MapEntity();

        // Then
        assertNull(mapEntity.getId_map());
        assertNull(mapEntity.getLigne());
        assertNull(mapEntity.getColonne());
        assertNull(mapEntity.getChemin_image());
    }
} 