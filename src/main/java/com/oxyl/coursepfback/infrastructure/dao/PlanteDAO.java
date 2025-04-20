package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.PlanteEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlanteDAO implements PlanteDAOInterface {

    private final JdbcTemplate jdbcTemplate;

    public PlanteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PlanteEntity> findAll() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, new PlanteRowMapper());
    }

    @Override
    public PlanteEntity findById(Integer id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        List<PlanteEntity> result = jdbcTemplate.query(sql, new PlanteRowMapper(), id);
        return result.isEmpty() ? null : result.get(0);
    }

    public void create(PlanteEntity plante) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image());
    }

    public void update(PlanteEntity plante) {
        String sql = "UPDATE plante SET nom=?, point_de_vie=?, attaque_par_seconde=?, degat_attaque=?, cout=?, soleil_par_seconde=?, effet=?, chemin_image=? WHERE id_plante=?";
        jdbcTemplate.update(sql,
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image(),
                plante.getId_plante());
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM plante WHERE id_plante=?";
        jdbcTemplate.update(sql, id);
    }

    private static class PlanteRowMapper implements RowMapper<PlanteEntity> {
        @Override
        public PlanteEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            PlanteEntity p = new PlanteEntity();
            p.setId_plante(rs.getInt("id_plante"));
            p.setNom(rs.getString("nom"));
            p.setPoint_de_vie(rs.getInt("point_de_vie"));
            p.setAttaque_par_seconde(rs.getDouble("attaque_par_seconde"));
            p.setDegat_attaque(rs.getInt("degat_attaque"));
            p.setCout(rs.getInt("cout"));
            p.setSoleil_par_seconde(rs.getDouble("soleil_par_seconde"));
            p.setEffet(rs.getString("effet"));
            p.setChemin_image(rs.getString("chemin_image"));
            return p;
        }
    }
}