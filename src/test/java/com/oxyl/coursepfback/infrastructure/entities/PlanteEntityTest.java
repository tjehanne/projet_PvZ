package com.oxyl.coursepfback.infrastructure.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanteEntityTest {

    @Test
    void testConstructorAndGetters() {
        // Given
        Integer id = 1;
        String nom = "Tournesol";
        Integer pointDeVie = 100;
        Double attaqueParSeconde = 0.0;
        Integer degatAttaque = 0;
        Integer cout = 50;
        Double soleilParSeconde = 25.0;
        String effet = "Production de soleil";
        String cheminImage = "images/plante/tournesol.png";

        // When
        PlanteEntity planteEntity = new PlanteEntity(id, nom, pointDeVie, attaqueParSeconde, 
            degatAttaque, cout, soleilParSeconde, effet, cheminImage);

        // Then
        assertEquals(id, planteEntity.getId_plante());
        assertEquals(nom, planteEntity.getNom());
        assertEquals(pointDeVie, planteEntity.getPoint_de_vie());
        assertEquals(attaqueParSeconde, planteEntity.getAttaque_par_seconde());
        assertEquals(degatAttaque, planteEntity.getDegat_attaque());
        assertEquals(cout, planteEntity.getCout());
        assertEquals(soleilParSeconde, planteEntity.getSoleil_par_seconde());
        assertEquals(effet, planteEntity.getEffet());
        assertEquals(cheminImage, planteEntity.getChemin_image());
    }

    @Test
    void testSetters() {
        // Given
        PlanteEntity planteEntity = new PlanteEntity();

        // When
        planteEntity.setId_plante(1);
        planteEntity.setNom("Tournesol");
        planteEntity.setPoint_de_vie(100);
        planteEntity.setAttaque_par_seconde(0.0);
        planteEntity.setDegat_attaque(0);
        planteEntity.setCout(50);
        planteEntity.setSoleil_par_seconde(25.0);
        planteEntity.setEffet("Production de soleil");
        planteEntity.setChemin_image("images/plante/tournesol.png");

        // Then
        assertEquals(1, planteEntity.getId_plante());
        assertEquals("Tournesol", planteEntity.getNom());
        assertEquals(100, planteEntity.getPoint_de_vie());
        assertEquals(0.0, planteEntity.getAttaque_par_seconde());
        assertEquals(0, planteEntity.getDegat_attaque());
        assertEquals(50, planteEntity.getCout());
        assertEquals(25.0, planteEntity.getSoleil_par_seconde());
        assertEquals("Production de soleil", planteEntity.getEffet());
        assertEquals("images/plante/tournesol.png", planteEntity.getChemin_image());
    }

    @Test
    void testDefaultConstructor() {
        // When
        PlanteEntity planteEntity = new PlanteEntity();

        // Then
        assertNull(planteEntity.getId_plante());
        assertNull(planteEntity.getNom());
        assertNull(planteEntity.getPoint_de_vie());
        assertNull(planteEntity.getAttaque_par_seconde());
        assertNull(planteEntity.getDegat_attaque());
        assertNull(planteEntity.getCout());
        assertNull(planteEntity.getSoleil_par_seconde());
        assertNull(planteEntity.getEffet());
        assertNull(planteEntity.getChemin_image());
    }
} 