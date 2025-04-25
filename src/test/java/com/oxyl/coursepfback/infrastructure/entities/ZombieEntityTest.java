package com.oxyl.coursepfback.infrastructure.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZombieEntityTest {

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
        ZombieEntity zombieEntity = new ZombieEntity(id, nom, pointDeVie, attaqueParSeconde,
            degatAttaque, vitesseDeplacement, cheminImage, idMap);

        // Then
        assertEquals(id, zombieEntity.getId_zombie());
        assertEquals(nom, zombieEntity.getNom());
        assertEquals(pointDeVie, zombieEntity.getPoint_de_vie());
        assertEquals(attaqueParSeconde, zombieEntity.getAttaque_par_seconde());
        assertEquals(degatAttaque, zombieEntity.getDegat_attaque());
        assertEquals(vitesseDeplacement, zombieEntity.getVitesse_de_deplacement());
        assertEquals(cheminImage, zombieEntity.getChemin_image());
        assertEquals(idMap, zombieEntity.getId_map());
    }

    @Test
    void testSetters() {
        // Given
        ZombieEntity zombieEntity = new ZombieEntity();

        // When
        zombieEntity.setId_zombie(1);
        zombieEntity.setNom("Zombie de base");
        zombieEntity.setPoint_de_vie(100);
        zombieEntity.setAttaque_par_seconde(0.8);
        zombieEntity.setDegat_attaque(10);
        zombieEntity.setVitesse_de_deplacement(0.5);
        zombieEntity.setChemin_image("images/zombie/zombie.png");
        zombieEntity.setId_map(1);

        // Then
        assertEquals(1, zombieEntity.getId_zombie());
        assertEquals("Zombie de base", zombieEntity.getNom());
        assertEquals(100, zombieEntity.getPoint_de_vie());
        assertEquals(0.8, zombieEntity.getAttaque_par_seconde());
        assertEquals(10, zombieEntity.getDegat_attaque());
        assertEquals(0.5, zombieEntity.getVitesse_de_deplacement());
        assertEquals("images/zombie/zombie.png", zombieEntity.getChemin_image());
        assertEquals(1, zombieEntity.getId_map());
    }

    @Test
    void testDefaultConstructor() {
        // When
        ZombieEntity zombieEntity = new ZombieEntity();

        // Then
        assertNull(zombieEntity.getId_zombie());
        assertNull(zombieEntity.getNom());
        assertNull(zombieEntity.getPoint_de_vie());
        assertNull(zombieEntity.getAttaque_par_seconde());
        assertNull(zombieEntity.getDegat_attaque());
        assertNull(zombieEntity.getVitesse_de_deplacement());
        assertNull(zombieEntity.getChemin_image());
        assertNull(zombieEntity.getId_map());
    }
} 