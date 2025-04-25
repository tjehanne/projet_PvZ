package com.oxyl.coursepfback.api.dto;

/**
 * DTO (Data Transfer Object) pour les zombies.
 * Cette classe est utilisée pour transférer les données de zombies entre le client et le serveur.
 * Elle contient toutes les caractéristiques d'un zombie nécessaires pour le jeu.
 */
public class ZombieDto {
    /** Identifiant unique du zombie */
    private Integer id_zombie;
    /** Nom du zombie */
    private String nom;
    /** Points de vie du zombie */
    private Integer point_de_vie;
    /** Fréquence d'attaque en attaques par seconde */
    private Double attaque_par_seconde;
    /** Dégâts infligés par attaque */
    private Integer degat_attaque;
    /** Vitesse de déplacement du zombie */
    private Double vitesse_de_deplacement;
    /** Chemin vers l'image du zombie */
    private String chemin_image;
    /** Identifiant de la map où se trouve le zombie */
    private Integer id_map;

    /** Constructeur par défaut */
    public ZombieDto() {}

    /**
     * Constructeur avec tous les paramètres
     * @param id_zombie Identifiant du zombie
     * @param nom Nom du zombie
     * @param point_de_vie Points de vie initiaux
     * @param attaque_par_seconde Fréquence d'attaque
     * @param degat_attaque Dégâts par attaque
     * @param vitesse_de_deplacement Vitesse de déplacement
     * @param chemin_image Chemin de l'image
     * @param id_map Identifiant de la map
     */
    public ZombieDto(Integer id_zombie, String nom, Integer point_de_vie, Double attaque_par_seconde,
                     Integer degat_attaque, Double vitesse_de_deplacement, String chemin_image, Integer id_map) {
        this.id_zombie = id_zombie;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.chemin_image = chemin_image;
        this.id_map = id_map;
    }

    public Integer getId_zombie() { return id_zombie; }
    public void setId_zombie(Integer id_zombie) { this.id_zombie = id_zombie; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Integer getPoint_de_vie() { return point_de_vie; }
    public void setPoint_de_vie(Integer point_de_vie) { this.point_de_vie = point_de_vie; }

    public Double getAttaque_par_seconde() { return attaque_par_seconde; }
    public void setAttaque_par_seconde(Double attaque_par_seconde) { this.attaque_par_seconde = attaque_par_seconde; }

    public Integer getDegat_attaque() { return degat_attaque; }
    public void setDegat_attaque(Integer degat_attaque) { this.degat_attaque = degat_attaque; }

    public Double getVitesse_de_deplacement() { return vitesse_de_deplacement; }
    public void setVitesse_de_deplacement(Double vitesse_de_deplacement) { this.vitesse_de_deplacement = vitesse_de_deplacement; }

    public String getChemin_image() { return chemin_image; }
    public void setChemin_image(String chemin_image) { this.chemin_image = chemin_image; }

    public Integer getId_map() { return id_map; }
    public void setId_map(Integer id_map) { this.id_map = id_map; }
}
