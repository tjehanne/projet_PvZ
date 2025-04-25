package com.oxyl.coursepfback.core.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MapModelTest {

    @Test
    void shouldCreateMapModel() {
        // Given
        Integer id = 1;
        Integer ligne = 5;
        Integer colonne = 3;
        String cheminImage = "images/map/map1.png";

        // When
        MapModel map = new MapModel(id, ligne, colonne, cheminImage);

        // Then
        assertThat(map.getId_map()).isEqualTo(id);
        assertThat(map.getLigne()).isEqualTo(ligne);
        assertThat(map.getColonne()).isEqualTo(colonne);
        assertThat(map.getChemin_image()).isEqualTo(cheminImage);
    }

    @Test
    void shouldSetMapProperties() {
        // Given
        MapModel map = new MapModel();

        // When
        map.setId_map(2);
        map.setLigne(6);
        map.setColonne(4);
        map.setChemin_image("images/map/map2.png");

        // Then
        assertThat(map.getId_map()).isEqualTo(2);
        assertThat(map.getLigne()).isEqualTo(6);
        assertThat(map.getColonne()).isEqualTo(4);
        assertThat(map.getChemin_image()).isEqualTo("images/map/map2.png");
    }
} 