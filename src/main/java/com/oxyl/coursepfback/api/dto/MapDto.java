package com.oxyl.coursepfback.api.dto;

/**
 * DTO (Data Transfer Object) pour la map.
 * Cette classe est utilisée pour transférer les données de map entre le client et le serveur.
 * Elle représente une map de jeu avec ses dimensions et son image.
 */
public class MapDto {
    /** Identifiant unique de la map */
    private Integer id_map;
    /** Nombre de lignes de la map */
    private Integer ligne;
    /** Nombre de colonnes de la map */
    private Integer colonne;
    /** Chemin vers l'image de fond de la map */
    private String chemin_image;

    /** Constructeur par défaut */
    public MapDto() {}

    /**
     * Constructeur avec tous les paramètres
     * @param id_map Identifiant de la map
     * @param ligne Nombre de lignes
     * @param colonne Nombre de colonnes
     * @param chemin_image Chemin de l'image de fond
     */
    public MapDto(Integer id_map, Integer ligne, Integer colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    public Integer getId_map() { return id_map; }
    public void setId_map(Integer id_map) { this.id_map = id_map; }

    public Integer getLigne() { return ligne; }
    public void setLigne(Integer ligne) { this.ligne = ligne; }

    public Integer getColonne() { return colonne; }
    public void setColonne(Integer colonne) { this.colonne = colonne; }

    public String getChemin_image() { return chemin_image; }
    public void setChemin_image(String chemin_image) { this.chemin_image = chemin_image; }
}
