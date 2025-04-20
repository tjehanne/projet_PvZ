package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.MapEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MapDAO implements MapDAOInterface {

    private final JdbcTemplate jdbcTemplate;

    public MapDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MapEntity> findAll() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    @Override
    public MapEntity findById(Integer id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        List<MapEntity> result = jdbcTemplate.query(sql, new MapRowMapper(), id);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public void create(MapEntity map) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image());
    }

    @Override
    public void update(MapEntity map) {
        String sql = "UPDATE map SET ligne=?, colonne=?, chemin_image=? WHERE id_map=?";
        jdbcTemplate.update(sql,
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image(),
                map.getId_map());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM map WHERE id_map=?";
        jdbcTemplate.update(sql, id);
    }

    private static class MapRowMapper implements RowMapper<MapEntity> {
        @Override
        public MapEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            MapEntity m = new MapEntity();
            m.setId_map(rs.getInt("id_map"));
            m.setLigne(rs.getInt("ligne"));
            m.setColonne(rs.getInt("colonne"));
            m.setChemin_image(rs.getString("chemin_image"));
            return m;
        }
    }
}
