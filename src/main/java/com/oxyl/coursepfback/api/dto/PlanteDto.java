package com.oxyl.coursepfback.api.dto;

/**
 * DTO (Data Transfer Object) pour les plantes.
 * Cette classe est utilisée pour transférer les données de plantes entre le client et le serveur.
 * Elle contient toutes les caractéristiques d'une plante nécessaires pour le jeu.
 */
public class PlanteDto {
    /** Identifiant unique de la plante */
    private Integer id_plante;
    /** Nom de la plante */
    private String nom;
    /** Points de vie de la plante */
    private Integer point_de_vie;
    /** Fréquence d'attaque en attaques par seconde */
    private Double attaque_par_seconde;
    /** Dégâts infligés par attaque */
    private Integer degat_attaque;
    /** Coût en soleil pour planter la plante */
    private Integer cout;
    /** Production de soleil par seconde */
    private Double soleil_par_seconde;
    /** Effet spécial de la plante */
    private String effet;
    /** Chemin vers l'image de la plante */
    private String chemin_image;

    /** Constructeur par défaut */
    public PlanteDto() {}

    /**
     * Constructeur avec tous les paramètres
     * @param id_plante Identifiant de la plante
     * @param nom Nom de la plante
     * @param point_de_vie Points de vie initiaux
     * @param attaque_par_seconde Fréquence d'attaque
     * @param degat_attaque Dégâts par attaque
     * @param cout Coût en soleil
     * @param soleil_par_seconde Production de soleil
     * @param effet Effet spécial
     * @param chemin_image Chemin de l'image
     */
    public PlanteDto(Integer id_plante, String nom, Integer point_de_vie, Double attaque_par_seconde,
                     Integer degat_attaque, Integer cout, Double soleil_par_seconde,
                     String effet, String chemin_image) {
        this.id_plante = id_plante;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.cout = cout;
        this.soleil_par_seconde = soleil_par_seconde;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }

    // Getters et Setters
    public Integer getId_plante() { return id_plante; }
    public void setId_plante(Integer id_plante) { this.id_plante = id_plante; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Integer getPoint_de_vie() { return point_de_vie; }
    public void setPoint_de_vie(Integer point_de_vie) { this.point_de_vie = point_de_vie; }

    public Double getAttaque_par_seconde() { return attaque_par_seconde; }
    public void setAttaque_par_seconde(Double attaque_par_seconde) { this.attaque_par_seconde = attaque_par_seconde; }

    public Integer getDegat_attaque() { return degat_attaque; }
    public void setDegat_attaque(Integer degat_attaque) { this.degat_attaque = degat_attaque; }

    public Integer getCout() { return cout; }
    public void setCout(Integer cout) { this.cout = cout; }

    public Double getSoleil_par_seconde() { return soleil_par_seconde; }
    public void setSoleil_par_seconde(Double soleil_par_seconde) { this.soleil_par_seconde = soleil_par_seconde; }

    public String getEffet() { return effet; }
    public void setEffet(String effet) { this.effet = effet; }

    public String getChemin_image() { return chemin_image; }
    public void setChemin_image(String chemin_image) { this.chemin_image = chemin_image; }
}
