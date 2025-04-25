package com.oxyl.coursepfback.api.mapper;

import com.oxyl.coursepfback.api.dto.ZombieDto;
import com.oxyl.coursepfback.core.model.ZombieModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe de mapping pour convertir les objets Zombie entre DTO et Model.
 * Permet d'assurer la conversion des données entre la couche API et la couche métier.
 * Gère la transformation des attributs spécifiques aux zombies.
 */
@Component
public class ZombieDtoMapper {

    /**
     * Convertit un modèle de zombie en DTO
     * @param zombieModel Le modèle de zombie à convertir
     * @return Le DTO correspondant, ou null si le modèle est null
     */
    public ZombieDto mapModelToDto(ZombieModel zombieModel) {
        if (zombieModel == null) {
            return null;
        }

        ZombieDto zombieDto = new ZombieDto();
        zombieDto.setId_zombie(zombieModel.getId_zombie());
        zombieDto.setNom(zombieModel.getNom());
        zombieDto.setPoint_de_vie(zombieModel.getPoint_de_vie());
        zombieDto.setAttaque_par_seconde(zombieModel.getAttaque_par_seconde());
        zombieDto.setDegat_attaque(zombieModel.getDegat_attaque());
        zombieDto.setVitesse_de_deplacement(zombieModel.getVitesse_de_deplacement());
        zombieDto.setChemin_image(zombieModel.getChemin_image());
        zombieDto.setId_map(zombieModel.getId_map());
        return zombieDto;
    }

    /**
     * Convertit un DTO de zombie en modèle
     * @param zombieDto Le DTO à convertir
     * @return Le modèle correspondant, ou null si le DTO est null
     */
    public ZombieModel mapDtoToModel(ZombieDto zombieDto) {
        if (zombieDto == null) {
            return null;
        }

        ZombieModel zombieModel = new ZombieModel();
        zombieModel.setId_zombie(zombieDto.getId_zombie());
        zombieModel.setNom(zombieDto.getNom());
        zombieModel.setPoint_de_vie(zombieDto.getPoint_de_vie());
        zombieModel.setAttaque_par_seconde(zombieDto.getAttaque_par_seconde());
        zombieModel.setDegat_attaque(zombieDto.getDegat_attaque());
        zombieModel.setVitesse_de_deplacement(zombieDto.getVitesse_de_deplacement());
        zombieModel.setChemin_image(zombieDto.getChemin_image());
        zombieModel.setId_map(zombieDto.getId_map());
        return zombieModel;
    }

    /**
     * Convertit une liste de modèles en liste de DTOs
     * @param zombieModels La liste de modèles à convertir
     * @return La liste des DTOs correspondants
     */
    public List<ZombieDto> mapListModelToDto(List<ZombieModel> zombieModels) {
        return zombieModels.stream()
                .map(this::mapModelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Convertit une liste de DTOs en liste de modèles
     * @param zombieDtos La liste de DTOs à convertir
     * @return La liste des modèles correspondants
     */
    public List<ZombieModel> mapListDtoToModel(List<ZombieDto> zombieDtos) {
        return zombieDtos.stream()
                .map(this::mapDtoToModel)
                .collect(Collectors.toList());
    }
}
