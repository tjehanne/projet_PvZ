package com.oxyl.coursepfback.infrastructure.mapper;

import com.oxyl.coursepfback.core.model.PlanteModel;
import com.oxyl.coursepfback.infrastructure.entities.PlanteEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlanteEntityMapperTest {

    @InjectMocks
    private PlanteEntityMapper planteEntityMapper;

    @Test
    void mapEntityToModel_shouldReturnNull_whenEntityIsNull() {
        // When
        PlanteModel result = planteEntityMapper.mapEntityToModel(null);

        // Then
        assertNull(result);
    }

    @Test
    void mapEntityToModel_shouldMapAllFields_whenEntityIsNotNull() {
        // Given
        PlanteEntity entity = new PlanteEntity();
        entity.setId_plante(1);
        entity.setNom("Tournesol");
        entity.setPoint_de_vie(100);
        entity.setAttaque_par_seconde(1.5);
        entity.setDegat_attaque(25);
        entity.setCout(50);
        entity.setSoleil_par_seconde(10.0);
        entity.setEffet("Produit du soleil");
        entity.setChemin_image("/images/plante/tournesol.png");

        // When
        PlanteModel result = planteEntityMapper.mapEntityToModel(entity);

        // Then
        assertNotNull(result);
        assertEquals(entity.getId_plante(), result.getId_plante());
        assertEquals(entity.getNom(), result.getNom());
        assertEquals(entity.getPoint_de_vie(), result.getPoint_de_vie());
        assertEquals(entity.getAttaque_par_seconde(), result.getAttaque_par_seconde());
        assertEquals(entity.getDegat_attaque(), result.getDegat_attaque());
        assertEquals(entity.getCout(), result.getCout());
        assertEquals(entity.getSoleil_par_seconde(), result.getSoleil_par_seconde());
        assertEquals(entity.getEffet(), result.getEffet());
        assertEquals(entity.getChemin_image(), result.getChemin_image());
    }

    @Test
    void mapModelToEntity_shouldReturnNull_whenModelIsNull() {
        // When
        PlanteEntity result = planteEntityMapper.mapModelToEntity(null);

        // Then
        assertNull(result);
    }

    @Test
    void mapModelToEntity_shouldMapAllFields_whenModelIsNotNull() {
        // Given
        PlanteModel model = new PlanteModel();
        model.setId_plante(1);
        model.setNom("Tournesol");
        model.setPoint_de_vie(100);
        model.setAttaque_par_seconde(1.5);
        model.setDegat_attaque(25);
        model.setCout(50);
        model.setSoleil_par_seconde(10.0);
        model.setEffet("Produit du soleil");
        model.setChemin_image("/images/plante/tournesol.png");

        // When
        PlanteEntity result = planteEntityMapper.mapModelToEntity(model);

        // Then
        assertNotNull(result);
        assertEquals(model.getId_plante(), result.getId_plante());
        assertEquals(model.getNom(), result.getNom());
        assertEquals(model.getPoint_de_vie(), result.getPoint_de_vie());
        assertEquals(model.getAttaque_par_seconde(), result.getAttaque_par_seconde());
        assertEquals(model.getDegat_attaque(), result.getDegat_attaque());
        assertEquals(model.getCout(), result.getCout());
        assertEquals(model.getSoleil_par_seconde(), result.getSoleil_par_seconde());
        assertEquals(model.getEffet(), result.getEffet());
        assertEquals(model.getChemin_image(), result.getChemin_image());
    }

    @Test
    void mapListEntityToListModel_shouldMapAllEntities() {
        // Given
        PlanteEntity entity1 = new PlanteEntity();
        entity1.setId_plante(1);
        entity1.setNom("Tournesol");

        PlanteEntity entity2 = new PlanteEntity();
        entity2.setId_plante(2);
        entity2.setNom("Pois");

        List<PlanteEntity> entities = Arrays.asList(entity1, entity2);

        // When
        List<PlanteModel> results = planteEntityMapper.mapListEntityToListModel(entities);

        // Then
        assertNotNull(results);
        assertEquals(2, results.size());
        assertEquals(entity1.getId_plante(), results.get(0).getId_plante());
        assertEquals(entity1.getNom(), results.get(0).getNom());
        assertEquals(entity2.getId_plante(), results.get(1).getId_plante());
        assertEquals(entity2.getNom(), results.get(1).getNom());
    }
} 