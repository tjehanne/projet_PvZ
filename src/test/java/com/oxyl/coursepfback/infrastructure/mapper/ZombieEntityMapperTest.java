package com.oxyl.coursepfback.infrastructure.mapper;

import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.entities.ZombieEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ZombieEntityMapperTest {

    @InjectMocks
    private ZombieEntityMapper zombieEntityMapper;

    @Test
    void mapEntityToModel_shouldReturnNull_whenEntityIsNull() {
        // When
        ZombieModel result = zombieEntityMapper.mapEntityToModel(null);

        // Then
        assertNull(result);
    }

    @Test
    void mapEntityToModel_shouldMapAllFields_whenEntityIsNotNull() {
        // Given
        ZombieEntity entity = new ZombieEntity();
        entity.setId_zombie(1);
        entity.setNom("Zombie de base");
        entity.setPoint_de_vie(100);
        entity.setAttaque_par_seconde(1.0);
        entity.setDegat_attaque(20);
        entity.setVitesse_de_deplacement(1.5);
        entity.setChemin_image("/images/zombie/basic.png");
        entity.setId_map(1);

        // When
        ZombieModel result = zombieEntityMapper.mapEntityToModel(entity);

        // Then
        assertNotNull(result);
        assertEquals(entity.getId_zombie(), result.getId_zombie());
        assertEquals(entity.getNom(), result.getNom());
        assertEquals(entity.getPoint_de_vie(), result.getPoint_de_vie());
        assertEquals(entity.getAttaque_par_seconde(), result.getAttaque_par_seconde());
        assertEquals(entity.getDegat_attaque(), result.getDegat_attaque());
        assertEquals(entity.getVitesse_de_deplacement(), result.getVitesse_de_deplacement());
        assertEquals(entity.getChemin_image(), result.getChemin_image());
        assertEquals(entity.getId_map(), result.getId_map());
    }

    @Test
    void mapModelToEntity_shouldReturnNull_whenModelIsNull() {
        // When
        ZombieEntity result = zombieEntityMapper.mapModelToEntity(null);

        // Then
        assertNull(result);
    }

    @Test
    void mapModelToEntity_shouldMapAllFields_whenModelIsNotNull() {
        // Given
        ZombieModel model = new ZombieModel();
        model.setId_zombie(1);
        model.setNom("Zombie de base");
        model.setPoint_de_vie(100);
        model.setAttaque_par_seconde(1.0);
        model.setDegat_attaque(20);
        model.setVitesse_de_deplacement(1.5);
        model.setChemin_image("/images/zombie/basic.png");
        model.setId_map(1);

        // When
        ZombieEntity result = zombieEntityMapper.mapModelToEntity(model);

        // Then
        assertNotNull(result);
        assertEquals(model.getId_zombie(), result.getId_zombie());
        assertEquals(model.getNom(), result.getNom());
        assertEquals(model.getPoint_de_vie(), result.getPoint_de_vie());
        assertEquals(model.getAttaque_par_seconde(), result.getAttaque_par_seconde());
        assertEquals(model.getDegat_attaque(), result.getDegat_attaque());
        assertEquals(model.getVitesse_de_deplacement(), result.getVitesse_de_deplacement());
        assertEquals(model.getChemin_image(), result.getChemin_image());
        assertEquals(model.getId_map(), result.getId_map());
    }

    @Test
    void mapListEntityToModel_shouldMapAllEntities() {
        // Given
        ZombieEntity entity1 = new ZombieEntity();
        entity1.setId_zombie(1);
        entity1.setNom("Zombie de base");

        ZombieEntity entity2 = new ZombieEntity();
        entity2.setId_zombie(2);
        entity2.setNom("Zombie rapide");

        List<ZombieEntity> entities = Arrays.asList(entity1, entity2);

        // When
        List<ZombieModel> results = zombieEntityMapper.mapListEntityToModel(entities);

        // Then
        assertNotNull(results);
        assertEquals(2, results.size());
        assertEquals(entity1.getId_zombie(), results.get(0).getId_zombie());
        assertEquals(entity1.getNom(), results.get(0).getNom());
        assertEquals(entity2.getId_zombie(), results.get(1).getId_zombie());
        assertEquals(entity2.getNom(), results.get(1).getNom());
    }
} 