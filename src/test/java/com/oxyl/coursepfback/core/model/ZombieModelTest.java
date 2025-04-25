package com.oxyl.coursepfback.core.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ZombieModelTest {

    @Test
    void shouldCreateZombieModel() {
        // Given
        Integer id = 1;
        String nom = "Zombie Standard";
        Integer pointDeVie = 100;
        Double attaqueParSeconde = 1.0;
        Integer degatAttaque = 20;
        Double vitesseDeplacement = 0.5;
        String cheminImage = "images/zombie/zombie1.png";
        Integer idMap = 1;

        // When
        ZombieModel zombie = new ZombieModel(id, nom, pointDeVie, attaqueParSeconde,
                degatAttaque, vitesseDeplacement, cheminImage, idMap);

        // Then
        assertThat(zombie.getId_zombie()).isEqualTo(id);
        assertThat(zombie.getNom()).isEqualTo(nom);
        assertThat(zombie.getPoint_de_vie()).isEqualTo(pointDeVie);
        assertThat(zombie.getAttaque_par_seconde()).isEqualTo(attaqueParSeconde);
        assertThat(zombie.getDegat_attaque()).isEqualTo(degatAttaque);
        assertThat(zombie.getVitesse_de_deplacement()).isEqualTo(vitesseDeplacement);
        assertThat(zombie.getChemin_image()).isEqualTo(cheminImage);
        assertThat(zombie.getId_map()).isEqualTo(idMap);
    }

    @Test
    void shouldSetZombieProperties() {
        // Given
        ZombieModel zombie = new ZombieModel();

        // When
        zombie.setId_zombie(2);
        zombie.setNom("Zombie Rapide");
        zombie.setPoint_de_vie(80);
        zombie.setAttaque_par_seconde(1.5);
        zombie.setDegat_attaque(15);
        zombie.setVitesse_de_deplacement(1.0);
        zombie.setChemin_image("images/zombie/zombie2.png");
        zombie.setId_map(2);

        // Then
        assertThat(zombie.getId_zombie()).isEqualTo(2);
        assertThat(zombie.getNom()).isEqualTo("Zombie Rapide");
        assertThat(zombie.getPoint_de_vie()).isEqualTo(80);
        assertThat(zombie.getAttaque_par_seconde()).isEqualTo(1.5);
        assertThat(zombie.getDegat_attaque()).isEqualTo(15);
        assertThat(zombie.getVitesse_de_deplacement()).isEqualTo(1.0);
        assertThat(zombie.getChemin_image()).isEqualTo("images/zombie/zombie2.png");
        assertThat(zombie.getId_map()).isEqualTo(2);
    }
} 