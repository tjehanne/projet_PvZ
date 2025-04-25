package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.MapEntity;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MapDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private MapDAO mapDAO;

    private MapEntity map1;
    private MapEntity map2;

    @BeforeEach
    void setUp() {
        map1 = new MapEntity();
        map1.setId_map(1);
        map1.setLigne(5);
        map1.setColonne(7);
        map1.setChemin_image("/images/map/map1.png");

        map2 = new MapEntity();
        map2.setId_map(2);
        map2.setLigne(6);
        map2.setColonne(8);
        map2.setChemin_image("/images/map/map2.png");
    }

    @Test
    @SuppressWarnings("unchecked")
    void findAll_shouldReturnAllMaps() {
        // Given
        when(jdbcTemplate.<MapEntity>query(
            anyString(), 
            any(RowMapper.class)))
                .thenReturn(Arrays.asList(map1, map2));

        // When
        List<MapEntity> result = mapDAO.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(map1.getId_map(), result.get(0).getId_map());
        assertEquals(map2.getId_map(), result.get(1).getId_map());
        verify(jdbcTemplate).query(
            anyString(), 
            any(RowMapper.class));
    }

    @Test
    @SuppressWarnings("unchecked")
    void findById_shouldReturnMap_whenMapExists() {
        // Given
        when(jdbcTemplate.<MapEntity>query(
            anyString(), 
            any(RowMapper.class), 
            eq(1)))
                .thenReturn(Arrays.asList(map1));

        // When
        MapEntity result = mapDAO.findById(1);

        // Then
        assertNotNull(result);
        assertEquals(map1.getId_map(), result.getId_map());
        assertEquals(map1.getLigne(), result.getLigne());
        verify(jdbcTemplate).query(
            anyString(), 
            any(RowMapper.class), 
            eq(1));
    }

    @Test
    void create_shouldExecuteInsertQuery() {
        // Given
        when(jdbcTemplate.update(anyString(), 
            eq(map1.getLigne()),
            eq(map1.getColonne()),
            eq(map1.getChemin_image())
        )).thenReturn(1);

        // When
        mapDAO.create(map1);

        // Then
        verify(jdbcTemplate).update(anyString(), 
            eq(map1.getLigne()),
            eq(map1.getColonne()),
            eq(map1.getChemin_image())
        );
    }

    @Test
    void update_shouldExecuteUpdateQuery() {
        // Given
        when(jdbcTemplate.update(anyString(), 
            eq(map1.getLigne()),
            eq(map1.getColonne()),
            eq(map1.getChemin_image()),
            eq(map1.getId_map())
        )).thenReturn(1);

        // When
        mapDAO.update(map1);

        // Then
        verify(jdbcTemplate).update(anyString(), 
            eq(map1.getLigne()),
            eq(map1.getColonne()),
            eq(map1.getChemin_image()),
            eq(map1.getId_map())
        );
    }

    @Test
    void delete_shouldExecuteDeleteQuery() {
        // Given
        when(jdbcTemplate.update(anyString(), eq(1))).thenReturn(1);

        // When
        mapDAO.delete(1);

        // Then
        verify(jdbcTemplate).update(anyString(), eq(1));
    }
} 