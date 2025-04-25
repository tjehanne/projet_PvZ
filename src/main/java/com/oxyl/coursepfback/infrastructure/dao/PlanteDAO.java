package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.PlanteEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Implémentation du DAO pour l'accès aux données des plantes.
 * Cette classe gère toutes les opérations CRUD pour les plantes en utilisant JdbcTemplate.
 */
@Repository
public class PlanteDAO implements PlanteDAOInterface {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructeur avec injection de JdbcTemplate
     * @param jdbcTemplate Template pour l'exécution des requêtes SQL
     */
    public PlanteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Récupère toutes les plantes de la base de données
     * @return Liste de toutes les plantes
     */
    @Override
    public List<PlanteEntity> findAll() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, new PlanteRowMapper());
    }

    /**
     * Recherche une plante par son identifiant
     * @param id Identifiant de la plante recherchée
     * @return La plante si trouvée, null sinon
     */
    @Override
    public PlanteEntity findById(Integer id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        List<PlanteEntity> result = jdbcTemplate.query(sql, new PlanteRowMapper(), id);
        return result.isEmpty() ? null : result.get(0);
    }

    /**
     * Crée une nouvelle plante dans la base de données
     * @param plante La plante à créer
     */
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

    /**
     * Met à jour une plante existante
     * @param plante La plante avec les nouvelles données
     */
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

    /**
     * Supprime une plante de la base de données
     * @param id Identifiant de la plante à supprimer
     */
    public void delete(Integer id) {
        String sql = "DELETE FROM plante WHERE id_plante=?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * Classe interne pour mapper les résultats SQL vers des entités Plante
     */
    private static class PlanteRowMapper implements RowMapper<PlanteEntity> {
        /**
         * Convertit une ligne de résultat SQL en entité Plante
         * @param rs ResultSet contenant les données de la ligne
         * @param rowNum Numéro de la ligne
         * @return L'entité Plante créée à partir des données
         */
        @Override
        public PlanteEntity mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
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