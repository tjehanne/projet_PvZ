package com.oxyl.coursepfback.infrastructure.entities;

/**
 * Entité représentant une map dans la base de données.
 * Cette classe est utilisée pour la persistance des données des maps du jeu.
 * Elle contient les informations essentielles comme les dimensions et le chemin de l'image de fond.
 */
public class MapEntity {

    /**
     * Identifiant unique de la map dans la base de données
     */
    private Integer id_map;

    /**
     * Nombre de lignes de la map
     */
    private Integer ligne;

    /**
     * Nombre de colonnes de la map
     */
    private Integer colonne;

    /**
     * Chemin d'accès vers l'image de fond de la map
     */
    private String chemin_image;

    /**
     * Constructeur par défaut
     */
    public MapEntity() {}

    /**
     * Constructeur avec tous les paramètres
     * @param id_map Identifiant de la map
     * @param ligne Nombre de lignes
     * @param colonne Nombre de colonnes
     * @param chemin_image Chemin de l'image de fond
     */
    public MapEntity(Integer id_map, Integer ligne, Integer colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    /**
     * Récupère l'identifiant de la map
     * @return L'identifiant de la map
     */
    public Integer getId_map() { return id_map; }
    public void setId_map(Integer id_map) { this.id_map = id_map; }

    /**
     * Récupère le nombre de lignes de la map
     * @return Le nombre de lignes
     */
    public Integer getLigne() { return ligne; }
    public void setLigne(Integer ligne) { this.ligne = ligne; }

    /**
     * Récupère le nombre de colonnes de la map
     * @return Le nombre de colonnes
     */
    public Integer getColonne() { return colonne; }
    public void setColonne(Integer colonne) { this.colonne = colonne; }

    /**
     * Récupère le chemin de l'image de fond
     * @return Le chemin de l'image
     */
    public String getChemin_image() { return chemin_image; }
    public void setChemin_image(String chemin_image) { this.chemin_image = chemin_image; }
}
