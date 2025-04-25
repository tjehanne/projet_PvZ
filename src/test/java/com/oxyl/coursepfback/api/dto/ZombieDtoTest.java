package com.oxyl.coursepfback.api.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZombieDtoTest {

    @Test
    void testConstructorAndGetters() {
        // Given
        Integer id = 1;
        String nom = "Zombie de base";
        Integer pointDeVie = 100;
        Double attaqueParSeconde = 0.8;
        Integer degatAttaque = 10;
        Double vitesseDeplacement = 0.5;
        String cheminImage = "images/zombie/zombie.png";
        Integer idMap = 1;

        // When
        ZombieDto zombieDto = new ZombieDto(id, nom, pointDeVie, attaqueParSeconde,
            degatAttaque, vitesseDeplacement, cheminImage, idMap);

        // Then
        assertEquals(id, zombieDto.getId_zombie());
        assertEquals(nom, zombieDto.getNom());
        assertEquals(pointDeVie, zombieDto.getPoint_de_vie());
        assertEquals(attaqueParSeconde, zombieDto.getAttaque_par_seconde());
        assertEquals(degatAttaque, zombieDto.getDegat_attaque());
        assertEquals(vitesseDeplacement, zombieDto.getVitesse_de_deplacement());
        assertEquals(cheminImage, zombieDto.getChemin_image());
        assertEquals(idMap, zombieDto.getId_map());
    }

    @Test
    void testSetters() {
        // Given
        ZombieDto zombieDto = new ZombieDto();

        // When
        zombieDto.setId_zombie(1);
        zombieDto.setNom("Zombie de base");
        zombieDto.setPoint_de_vie(100);
        zombieDto.setAttaque_par_seconde(0.8);
        zombieDto.setDegat_attaque(10);
        zombieDto.setVitesse_de_deplacement(0.5);
        zombieDto.setChemin_image("images/zombie/zombie.png");
        zombieDto.setId_map(1);

        // Then
        assertEquals(1, zombieDto.getId_zombie());
        assertEquals("Zombie de base", zombieDto.getNom());
        assertEquals(100, zombieDto.getPoint_de_vie());
        assertEquals(0.8, zombieDto.getAttaque_par_seconde());
        assertEquals(10, zombieDto.getDegat_attaque());
        assertEquals(0.5, zombieDto.getVitesse_de_deplacement());
        assertEquals("images/zombie/zombie.png", zombieDto.getChemin_image());
        assertEquals(1, zombieDto.getId_map());
    }

    @Test
    void testDefaultConstructor() {
        // When
        ZombieDto zombieDto = new ZombieDto();

        // Then
        assertNull(zombieDto.getId_zombie());
        assertNull(zombieDto.getNom());
        assertNull(zombieDto.getPoint_de_vie());
        assertNull(zombieDto.getAttaque_par_seconde());
        assertNull(zombieDto.getDegat_attaque());
        assertNull(zombieDto.getVitesse_de_deplacement());
        assertNull(zombieDto.getChemin_image());
        assertNull(zombieDto.getId_map());
    }
} 