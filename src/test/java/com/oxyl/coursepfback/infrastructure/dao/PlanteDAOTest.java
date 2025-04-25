package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.PlanteEntity;
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
class PlanteDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PlanteDAO planteDAO;

    private PlanteEntity plante1;
    private PlanteEntity plante2;

    @BeforeEach
    void setUp() {
        plante1 = new PlanteEntity();
        plante1.setId_plante(1);
        plante1.setNom("Tournesol");
        plante1.setPoint_de_vie(100);
        plante1.setAttaque_par_seconde(1.5);
        plante1.setDegat_attaque(25);
        plante1.setCout(50);
        plante1.setSoleil_par_seconde(10.0);
        plante1.setEffet("Produit du soleil");
        plante1.setChemin_image("/images/plante/tournesol.png");

        plante2 = new PlanteEntity();
        plante2.setId_plante(2);
        plante2.setNom("Pois");
        plante2.setPoint_de_vie(150);
        plante2.setAttaque_par_seconde(2.0);
        plante2.setDegat_attaque(35);
        plante2.setCout(100);
        plante2.setSoleil_par_seconde(0.0);
        plante2.setEffet("Tire des pois");
        plante2.setChemin_image("/images/plante/pois.png");
    }

    @Test
    @SuppressWarnings("unchecked")
    void findAll_shouldReturnAllPlantes() {
        // Given
        when(jdbcTemplate.<PlanteEntity>query(
            anyString(), 
            any(RowMapper.class)))
                .thenReturn(Arrays.asList(plante1, plante2));

        // When
        List<PlanteEntity> result = planteDAO.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(plante1.getId_plante(), result.get(0).getId_plante());
        assertEquals(plante2.getId_plante(), result.get(1).getId_plante());
        verify(jdbcTemplate).query(
            anyString(), 
            any(RowMapper.class));
    }

    @Test
    @SuppressWarnings("unchecked")
    void findById_shouldReturnPlante_whenPlanteExists() {
        // Given
        when(jdbcTemplate.<PlanteEntity>query(
            anyString(), 
            any(RowMapper.class), 
            eq(1)))
                .thenReturn(Arrays.asList(plante1));

        // When
        PlanteEntity result = planteDAO.findById(1);

        // Then
        assertNotNull(result);
        assertEquals(plante1.getId_plante(), result.getId_plante());
        assertEquals(plante1.getNom(), result.getNom());
        verify(jdbcTemplate).query(
            anyString(), 
            any(RowMapper.class), 
            eq(1));
    }

    @Test
    void create_shouldExecuteInsertQuery() {
        // Given
        when(jdbcTemplate.update(anyString(), 
            eq(plante1.getNom()),
            eq(plante1.getPoint_de_vie()),
            eq(plante1.getAttaque_par_seconde()),
            eq(plante1.getDegat_attaque()),
            eq(plante1.getCout()),
            eq(plante1.getSoleil_par_seconde()),
            eq(plante1.getEffet()),
            eq(plante1.getChemin_image())
        )).thenReturn(1);

        // When
        planteDAO.create(plante1);

        // Then
        verify(jdbcTemplate).update(anyString(), 
            eq(plante1.getNom()),
            eq(plante1.getPoint_de_vie()),
            eq(plante1.getAttaque_par_seconde()),
            eq(plante1.getDegat_attaque()),
            eq(plante1.getCout()),
            eq(plante1.getSoleil_par_seconde()),
            eq(plante1.getEffet()),
            eq(plante1.getChemin_image())
        );
    }

    @Test
    void update_shouldExecuteUpdateQuery() {
        // Given
        when(jdbcTemplate.update(anyString(), 
            eq(plante1.getNom()),
            eq(plante1.getPoint_de_vie()),
            eq(plante1.getAttaque_par_seconde()),
            eq(plante1.getDegat_attaque()),
            eq(plante1.getCout()),
            eq(plante1.getSoleil_par_seconde()),
            eq(plante1.getEffet()),
            eq(plante1.getChemin_image()),
            eq(plante1.getId_plante())
        )).thenReturn(1);

        // When
        planteDAO.update(plante1);

        // Then
        verify(jdbcTemplate).update(anyString(), 
            eq(plante1.getNom()),
            eq(plante1.getPoint_de_vie()),
            eq(plante1.getAttaque_par_seconde()),
            eq(plante1.getDegat_attaque()),
            eq(plante1.getCout()),
            eq(plante1.getSoleil_par_seconde()),
            eq(plante1.getEffet()),
            eq(plante1.getChemin_image()),
            eq(plante1.getId_plante())
        );
    }

    @Test
    void delete_shouldExecuteDeleteQuery() {
        // Given
        when(jdbcTemplate.update(anyString(), eq(1))).thenReturn(1);

        // When
        planteDAO.delete(1);

        // Then
        verify(jdbcTemplate).update(anyString(), eq(1));
    }
} 