package com.oxyl.coursepfback.api.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanteDtoTest {

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
        PlanteDto planteDto = new PlanteDto(id, nom, pointDeVie, attaqueParSeconde, 
            degatAttaque, cout, soleilParSeconde, effet, cheminImage);

        // Then
        assertEquals(id, planteDto.getId_plante());
        assertEquals(nom, planteDto.getNom());
        assertEquals(pointDeVie, planteDto.getPoint_de_vie());
        assertEquals(attaqueParSeconde, planteDto.getAttaque_par_seconde());
        assertEquals(degatAttaque, planteDto.getDegat_attaque());
        assertEquals(cout, planteDto.getCout());
        assertEquals(soleilParSeconde, planteDto.getSoleil_par_seconde());
        assertEquals(effet, planteDto.getEffet());
        assertEquals(cheminImage, planteDto.getChemin_image());
    }

    @Test
    void testSetters() {
        // Given
        PlanteDto planteDto = new PlanteDto();

        // When
        planteDto.setId_plante(1);
        planteDto.setNom("Tournesol");
        planteDto.setPoint_de_vie(100);
        planteDto.setAttaque_par_seconde(0.0);
        planteDto.setDegat_attaque(0);
        planteDto.setCout(50);
        planteDto.setSoleil_par_seconde(25.0);
        planteDto.setEffet("Production de soleil");
        planteDto.setChemin_image("images/plante/tournesol.png");

        // Then
        assertEquals(1, planteDto.getId_plante());
        assertEquals("Tournesol", planteDto.getNom());
        assertEquals(100, planteDto.getPoint_de_vie());
        assertEquals(0.0, planteDto.getAttaque_par_seconde());
        assertEquals(0, planteDto.getDegat_attaque());
        assertEquals(50, planteDto.getCout());
        assertEquals(25.0, planteDto.getSoleil_par_seconde());
        assertEquals("Production de soleil", planteDto.getEffet());
        assertEquals("images/plante/tournesol.png", planteDto.getChemin_image());
    }

    @Test
    void testDefaultConstructor() {
        // When
        PlanteDto planteDto = new PlanteDto();

        // Then
        assertNull(planteDto.getId_plante());
        assertNull(planteDto.getNom());
        assertNull(planteDto.getPoint_de_vie());
        assertNull(planteDto.getAttaque_par_seconde());
        assertNull(planteDto.getDegat_attaque());
        assertNull(planteDto.getCout());
        assertNull(planteDto.getSoleil_par_seconde());
        assertNull(planteDto.getEffet());
        assertNull(planteDto.getChemin_image());
    }
} 