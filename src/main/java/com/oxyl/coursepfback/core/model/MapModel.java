package com.oxyl.coursepfback.core.model;

/**
 * Classe modèle représentant une map (niveau) dans le jeu.
 * Contient les informations sur la taille de la map et son image de fond.
 * Une map est une grille sur laquelle les plantes peuvent être placées et les zombies se déplacent.
 */
public class MapModel {
    /** Identifiant unique de la map */
    private Integer id_map;
    /** Nombre de lignes de la grille de jeu */
    private Integer ligne;
    /** Nombre de colonnes de la grille de jeu */
    private Integer colonne;
    /** Chemin vers l'image de fond de la map */
    private String chemin_image;

    /** Constructeur par défaut */
    public MapModel() {}

    /**
     * Constructeur avec tous les paramètres
     * @param id_map Identifiant unique de la map
     * @param ligne Nombre de lignes de la grille
     * @param colonne Nombre de colonnes de la grille
     * @param chemin_image Chemin vers l'image de fond
     */
    public MapModel(Integer id_map, Integer ligne, Integer colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    /**
     * Récupère l'identifiant de la map
     * @return L'identifiant unique de la map
     */
    public Integer getId_map() { return id_map; }

    /**
     * Définit l'identifiant de la map
     * @param id_map Le nouvel identifiant de la map
     */
    public void setId_map(Integer id_map) { this.id_map = id_map; }

    /**
     * Récupère le nombre de lignes de la grille
     * @return Le nombre de lignes
     */
    public Integer getLigne() { return ligne; }

    /**
     * Définit le nombre de lignes de la grille
     * @param ligne Le nouveau nombre de lignes
     */
    public void setLigne(Integer ligne) { this.ligne = ligne; }

    /**
     * Récupère le nombre de colonnes de la grille
     * @return Le nombre de colonnes
     */
    public Integer getColonne() { return colonne; }

    /**
     * Définit le nombre de colonnes de la grille
     * @param colonne Le nouveau nombre de colonnes
     */
    public void setColonne(Integer colonne) { this.colonne = colonne; }

    /**
     * Récupère le chemin de l'image de fond
     * @return Le chemin vers l'image de fond
     */
    public String getChemin_image() { return chemin_image; }

    /**
     * Définit le chemin de l'image de fond
     * @param chemin_image Le nouveau chemin vers l'image
     */
    public void setChemin_image(String chemin_image) { this.chemin_image = chemin_image; }
}
