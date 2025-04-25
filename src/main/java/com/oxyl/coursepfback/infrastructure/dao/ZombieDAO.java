package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.ZombieEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Implémentation du DAO pour l'accès aux données des zombies.
 * Cette classe gère toutes les opérations CRUD pour les zombies en utilisant JdbcTemplate.
 */
@Repository
public class ZombieDAO implements ZombieDAOInterface {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructeur avec injection de JdbcTemplate
     * @param jdbcTemplate Template pour l'exécution des requêtes SQL
     */
    public ZombieDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Récupère tous les zombies de la base de données
     * @return Liste de tous les zombies
     */
    @Override
    public List<ZombieEntity> findAll() {
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    /**
     * Recherche un zombie par son identifiant
     * @param id Identifiant du zombie recherché
     * @return Le zombie si trouvé, null sinon
     */
    @Override
    public ZombieEntity findById(Integer id) {
        String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
        List<ZombieEntity> result = jdbcTemplate.query(sql, new ZombieRowMapper(), id);
        return result.isEmpty() ? null : result.get(0);
    }

    /**
     * Récupère tous les zombies associés à une map spécifique
     * @param mapId Identifiant de la map
     * @return Liste des zombies présents sur la map
     */
    @Override
    public List<ZombieEntity> findByMapId(Integer mapId) {
        String sql = "SELECT * FROM zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new ZombieRowMapper(), mapId);
    }

    /**
     * Crée un nouveau zombie dans la base de données
     * @param zombie Le zombie à créer
     */
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

    /**
     * Met à jour un zombie existant
     * @param zombie Le zombie avec les nouvelles données
     */
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

    /**
     * Supprime un zombie de la base de données
     * @param id Identifiant du zombie à supprimer
     */
    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM zombie WHERE id_zombie=?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * Classe interne pour mapper les résultats SQL vers des entités Zombie
     */
    private static class ZombieRowMapper implements RowMapper<ZombieEntity> {
        /**
         * Convertit une ligne de résultat SQL en entité Zombie
         * @param rs ResultSet contenant les données de la ligne
         * @param rowNum Numéro de la ligne
         * @return L'entité Zombie créée à partir des données
         */
        @Override
        public ZombieEntity mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
            ZombieEntity zombie = new ZombieEntity();
            zombie.setId_zombie(rs.getInt("id_zombie"));
            zombie.setNom(rs.getString("nom"));
            zombie.setPoint_de_vie(rs.getInt("point_de_vie"));
            zombie.setAttaque_par_seconde(rs.getDouble("attaque_par_seconde"));
            zombie.setDegat_attaque(rs.getInt("degat_attaque"));
            zombie.setVitesse_de_deplacement(rs.getDouble("vitesse_de_deplacement"));
            zombie.setChemin_image(rs.getString("chemin_image"));
            zombie.setId_map(rs.getInt("id_map"));
            return zombie;
        }
    }
}
