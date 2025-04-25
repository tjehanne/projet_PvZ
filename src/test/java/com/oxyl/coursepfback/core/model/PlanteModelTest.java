package com.oxyl.coursepfback.core.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PlanteModelTest {

    @Test
    void shouldCreatePlanteModel() {
        // Given
        Integer id = 1;
        String nom = "Tournesol";
        Integer pointDeVie = 50;
        Double attaqueParSeconde = 0.0;
        Integer degatAttaque = 0;
        Integer cout = 50;
        Double soleilParSeconde = 1.0;
        String effet = "Production de soleil";
        String cheminImage = "images/plante/tournesol.png";

        // When
        PlanteModel plante = new PlanteModel(id, nom, pointDeVie, attaqueParSeconde,
                degatAttaque, cout, soleilParSeconde, effet, cheminImage);

        // Then
        assertThat(plante.getId_plante()).isEqualTo(id);
        assertThat(plante.getNom()).isEqualTo(nom);
        assertThat(plante.getPoint_de_vie()).isEqualTo(pointDeVie);
        assertThat(plante.getAttaque_par_seconde()).isEqualTo(attaqueParSeconde);
        assertThat(plante.getDegat_attaque()).isEqualTo(degatAttaque);
        assertThat(plante.getCout()).isEqualTo(cout);
        assertThat(plante.getSoleil_par_seconde()).isEqualTo(soleilParSeconde);
        assertThat(plante.getEffet()).isEqualTo(effet);
        assertThat(plante.getChemin_image()).isEqualTo(cheminImage);
    }

    @Test
    void shouldSetPlanteProperties() {
        // Given
        PlanteModel plante = new PlanteModel();

        // When
        plante.setId_plante(2);
        plante.setNom("Pois-tireur");
        plante.setPoint_de_vie(75);
        plante.setAttaque_par_seconde(1.0);
        plante.setDegat_attaque(20);
        plante.setCout(100);
        plante.setSoleil_par_seconde(0.0);
        plante.setEffet("Tir de projectiles");
        plante.setChemin_image("images/plante/pois-tireur.png");

        // Then
        assertThat(plante.getId_plante()).isEqualTo(2);
        assertThat(plante.getNom()).isEqualTo("Pois-tireur");
        assertThat(plante.getPoint_de_vie()).isEqualTo(75);
        assertThat(plante.getAttaque_par_seconde()).isEqualTo(1.0);
        assertThat(plante.getDegat_attaque()).isEqualTo(20);
        assertThat(plante.getCout()).isEqualTo(100);
        assertThat(plante.getSoleil_par_seconde()).isEqualTo(0.0);
        assertThat(plante.getEffet()).isEqualTo("Tir de projectiles");
        assertThat(plante.getChemin_image()).isEqualTo("images/plante/pois-tireur.png");
    }
} 