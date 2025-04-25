package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.ZombieEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ZombieDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ZombieDAO zombieDAO;

    private ZombieEntity zombie1;
    private ZombieEntity zombie2;

    @BeforeEach
    void setUp() {
        zombie1 = new ZombieEntity();
        zombie1.setId_zombie(1);
        zombie1.setNom("Zombie de base");
        zombie1.setPoint_de_vie(100);
        zombie1.setAttaque_par_seconde(1.0);
        zombie1.setDegat_attaque(20);
        zombie1.setVitesse_de_deplacement(1.5);
        zombie1.setChemin_image("/images/zombie/basic.png");
        zombie1.setId_map(1);

        zombie2 = new ZombieEntity();
        zombie2.setId_zombie(2);
        zombie2.setNom("Zombie rapide");
        zombie2.setPoint_de_vie(75);
        zombie2.setAttaque_par_seconde(2.0);
        zombie2.setDegat_attaque(15);
        zombie2.setVitesse_de_deplacement(3.0);
        zombie2.setChemin_image("/images/zombie/fast.png");
        zombie2.setId_map(1);
    }

    @Test
    @SuppressWarnings("unchecked")
    void findAll_shouldReturnAllZombies() {
        // Given
        when(jdbcTemplate.<ZombieEntity>query(
            anyString(), 
            any(RowMapper.class)))
                .thenReturn(Arrays.asList(zombie1, zombie2));

        // When
        List<ZombieEntity> result = zombieDAO.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(zombie1.getId_zombie(), result.get(0).getId_zombie());
        assertEquals(zombie2.getId_zombie(), result.get(1).getId_zombie());
        verify(jdbcTemplate).query(
            anyString(), 
            any(RowMapper.class));
    }

    @Test
    @SuppressWarnings("unchecked")
    void findById_shouldReturnZombie_whenZombieExists() {
        // Given
        when(jdbcTemplate.<ZombieEntity>query(
            anyString(), 
            any(RowMapper.class), 
            eq(1)))
                .thenReturn(Arrays.asList(zombie1));

        // When
        ZombieEntity result = zombieDAO.findById(1);

        // Then
        assertNotNull(result);
        assertEquals(zombie1.getId_zombie(), result.getId_zombie());
        assertEquals(zombie1.getNom(), result.getNom());
        verify(jdbcTemplate).query(
            anyString(), 
            any(RowMapper.class), 
            eq(1));
    }

    @Test
    void create_shouldExecuteInsertQuery() {
        // Given
        when(jdbcTemplate.update(anyString(), 
            eq(zombie1.getNom()),
            eq(zombie1.getPoint_de_vie()),
            eq(zombie1.getAttaque_par_seconde()),
            eq(zombie1.getDegat_attaque()),
            eq(zombie1.getVitesse_de_deplacement()),
            eq(zombie1.getChemin_image()),
            eq(zombie1.getId_map())
        )).thenReturn(1);

        // When
        zombieDAO.create(zombie1);

        // Then
        verify(jdbcTemplate).update(anyString(), 
            eq(zombie1.getNom()),
            eq(zombie1.getPoint_de_vie()),
            eq(zombie1.getAttaque_par_seconde()),
            eq(zombie1.getDegat_attaque()),
            eq(zombie1.getVitesse_de_deplacement()),
            eq(zombie1.getChemin_image()),
            eq(zombie1.getId_map())
        );
    }

    @Test
    void update_shouldExecuteUpdateQuery() {
        // Given
        when(jdbcTemplate.update(anyString(), 
            eq(zombie1.getNom()),
            eq(zombie1.getPoint_de_vie()),
            eq(zombie1.getAttaque_par_seconde()),
            eq(zombie1.getDegat_attaque()),
            eq(zombie1.getVitesse_de_deplacement()),
            eq(zombie1.getChemin_image()),
            eq(zombie1.getId_map()),
            eq(zombie1.getId_zombie())
        )).thenReturn(1);

        // When
        zombieDAO.update(zombie1);

        // Then
        verify(jdbcTemplate).update(anyString(), 
            eq(zombie1.getNom()),
            eq(zombie1.getPoint_de_vie()),
            eq(zombie1.getAttaque_par_seconde()),
            eq(zombie1.getDegat_attaque()),
            eq(zombie1.getVitesse_de_deplacement()),
            eq(zombie1.getChemin_image()),
            eq(zombie1.getId_map()),
            eq(zombie1.getId_zombie())
        );
    }

    @Test
    void delete_shouldExecuteDeleteQuery() {
        // Given
        when(jdbcTemplate.update(anyString(), eq(1))).thenReturn(1);

        // When
        zombieDAO.delete(1);

        // Then
        verify(jdbcTemplate).update(anyString(), eq(1));
    }
} 