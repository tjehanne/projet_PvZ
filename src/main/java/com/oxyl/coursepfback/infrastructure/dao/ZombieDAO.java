package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.ZombieEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ZombieDAO implements ZombieDAOInterface {

    private final JdbcTemplate jdbcTemplate;

    public ZombieDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ZombieEntity> findAll() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    @Override
    public ZombieEntity findById(Integer id) {
        String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
        List<ZombieEntity> result = jdbcTemplate.query(sql, new ZombieRowMapper(), id);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<ZombieEntity> findByMapId(Integer mapId) {
        String sql = "SELECT * FROM zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new ZombieRowMapper(), mapId);
    }

    @Override
    public void create(ZombieEntity zombie) {
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map());
    }

    @Override
    public void update(ZombieEntity zombie) {
        String sql = "UPDATE zombie SET nom=?, point_de_vie=?, attaque_par_seconde=?, degat_attaque=?, vitesse_de_deplacement=?, chemin_image=?, id_map=? WHERE id_zombie=?";
        jdbcTemplate.update(sql,
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map(),
                zombie.getId_zombie());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM zombie WHERE id_zombie=?";
        jdbcTemplate.update(sql, id);
    }

    private static class ZombieRowMapper implements RowMapper<ZombieEntity> {
        @Override
        public ZombieEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            ZombieEntity z = new ZombieEntity();
            z.setId_zombie(rs.getInt("id_zombie"));
            z.setNom(rs.getString("nom"));
            z.setPoint_de_vie(rs.getInt("point_de_vie"));
            z.setAttaque_par_seconde(rs.getDouble("attaque_par_seconde"));
            z.setDegat_attaque(rs.getInt("degat_attaque"));
            z.setVitesse_de_deplacement(rs.getDouble("vitesse_de_deplacement"));
            z.setChemin_image(rs.getString("chemin_image"));
            z.setId_map(rs.getObject("id_map") != null ? rs.getInt("id_map") : null);
            return z;
        }
    }
}
