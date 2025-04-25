package com.oxyl.coursepfback.api.mapper;

import com.oxyl.coursepfback.api.dto.MapDto;
import com.oxyl.coursepfback.core.model.MapModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe de mapping pour convertir les objets Map entre DTO et Model.
 * Permet d'assurer la conversion des données entre la couche API et la couche métier.
 */
@Component
public class MapDtoMapper {

    private static final String IMAGE_PREFIX = "/CoursEpfBack/";

    /**
     * Convertit un modèle de map en DTO
     * @param mapModel Le modèle de map à convertir
     * @return Le DTO correspondant, ou null si le modèle est null
     */
    public MapDto mapModelToDto(MapModel mapModel) {
        if (mapModel == null) {
            return null;
        }

        MapDto mapDto = new MapDto();
        mapDto.setId_map(mapModel.getId_map());
        mapDto.setLigne(mapModel.getLigne());
        mapDto.setColonne(mapModel.getColonne());
        
        // Ajoute le préfixe au chemin d'image s'il n'est pas déjà présent
        String imagePath = mapModel.getChemin_image();
        if (imagePath != null && !imagePath.startsWith("/")) {
            imagePath = IMAGE_PREFIX + imagePath;
        }
        mapDto.setChemin_image(imagePath);
        
        return mapDto;
    }

    /**
     * Convertit un DTO de map en modèle
     * @param mapDto Le DTO à convertir
     * @return Le modèle correspondant, ou null si le DTO est null
     */
    public MapModel mapDtoToModel(MapDto mapDto) {
        if (mapDto == null) {
            return null;
        }

        MapModel mapModel = new MapModel();
        mapModel.setId_map(mapDto.getId_map());
        mapModel.setLigne(mapDto.getLigne());
        mapModel.setColonne(mapDto.getColonne());
        
        // Retire le préfixe du chemin d'image s'il est présent
        String imagePath = mapDto.getChemin_image();
        if (imagePath != null && imagePath.startsWith(IMAGE_PREFIX)) {
            imagePath = imagePath.substring(IMAGE_PREFIX.length());
        }
        mapModel.setChemin_image(imagePath);
        
        return mapModel;
    }

    /**
     * Convertit une liste de modèles en liste de DTOs
     * @param mapModels La liste de modèles à convertir
     * @return La liste des DTOs correspondants
     */
    public List<MapDto> mapListModelToDto(List<MapModel> mapModels) {
        return mapModels.stream()
                .map(this::mapModelToDto)
                .collect(Collectors.toList());
    }

    /**
     * Convertit une liste de DTOs en liste de modèles
     * @param mapDtos La liste de DTOs à convertir
     * @return La liste des modèles correspondants
     */
    public List<MapModel> mapListDtoToModel(List<MapDto> mapDtos) {
        return mapDtos.stream()
                .map(this::mapDtoToModel)
                .collect(Collectors.toList());
    }
}
