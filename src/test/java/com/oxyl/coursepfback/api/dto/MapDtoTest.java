package com.oxyl.coursepfback.api.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapDtoTest {

    @Test
    void testConstructorAndGetters() {
        // Given
        Integer id = 1;
        Integer ligne = 10;
        Integer colonne = 15;
        String cheminImage = "images/map/map1.png";

        // When
        MapDto mapDto = new MapDto(id, ligne, colonne, cheminImage);

        // Then
        assertEquals(id, mapDto.getId_map());
        assertEquals(ligne, mapDto.getLigne());
        assertEquals(colonne, mapDto.getColonne());
        assertEquals(cheminImage, mapDto.getChemin_image());
    }

    @Test
    void testSetters() {
        // Given
        MapDto mapDto = new MapDto();

        // When
        mapDto.setId_map(1);
        mapDto.setLigne(10);
        mapDto.setColonne(15);
        mapDto.setChemin_image("images/map/map1.png");

        // Then
        assertEquals(1, mapDto.getId_map());
        assertEquals(10, mapDto.getLigne());
        assertEquals(15, mapDto.getColonne());
        assertEquals("images/map/map1.png", mapDto.getChemin_image());
    }

    @Test
    void testDefaultConstructor() {
        // When
        MapDto mapDto = new MapDto();

        // Then
        assertNull(mapDto.getId_map());
        assertNull(mapDto.getLigne());
        assertNull(mapDto.getColonne());
        assertNull(mapDto.getChemin_image());
    }
} 