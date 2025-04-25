package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.MapEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO (Data Access Object) pour l'accès aux données des maps dans la base de données.
 * Gère toutes les opérations CRUD (Create, Read, Update, Delete) pour les maps.
 * Utilise JdbcTemplate pour l'exécution des requêtes SQL.
 */
@Repository
public class MapDAO implements MapDAOInterface {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Constructeur avec injection de JdbcTemplate
     * @param jdbcTemplate Template pour l'exécution des requêtes SQL
     */
    public MapDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Récupère toutes les maps de la base de données
     * @return Liste de toutes les maps sous forme d'entités
     */
    @Override
    public List<MapEntity> findAll() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    /**
     * Recherche une map par son identifiant
     * @param id Identifiant de la map recherchée
     * @return L'entité map si trouvée, null sinon
     */
    @Override
    public MapEntity findById(Integer id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        List<MapEntity> result = jdbcTemplate.query(sql, new MapRowMapper(), id);
        return result.isEmpty() ? null : result.get(0);
    }

    /**
     * Crée une nouvelle map dans la base de données
     * @param map L'entité map à créer
     */
    @Override
    public void create(MapEntity map) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image());
    }

    /**
     * Met à jour une map existante dans la base de données
     * @param map L'entité map avec les nouvelles données
     */
    @Override
    public void update(MapEntity map) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql,
                map.getLigne(),
                map.getColonne(),
                map.getChemin_image(),
                map.getId_map());
    }

    /**
     * Supprime une map de la base de données
     * @param id Identifiant de la map à supprimer
     */
    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM map WHERE id_map = ?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * Classe interne pour mapper les résultats SQL vers des entités Map
     */
    private static class MapRowMapper implements RowMapper<MapEntity> {
        /**
         * Convertit une ligne de résultat SQL en entité Map
         * @param rs ResultSet contenant les données de la ligne
         * @param rowNum Numéro de la ligne
         * @return L'entité Map créée à partir des données
         */
        @Override
        public MapEntity mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
            MapEntity m = new MapEntity();
            m.setId_map(rs.getInt("id_map"));
            m.setLigne(rs.getInt("ligne"));
            m.setColonne(rs.getInt("colonne"));
            m.setChemin_image(rs.getString("chemin_image"));
            return m;
        }
    }
}
