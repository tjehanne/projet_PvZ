package com.oxyl.coursepfback.api.controller;

import com.oxyl.coursepfback.api.dto.MapDto;
import com.oxyl.coursepfback.api.mapper.MapDtoMapper;
import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.core.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Contrôleur REST gérant les endpoints relatifs aux maps du jeu.
 * Permet de créer, lire, mettre à jour et supprimer des maps.
 * Une map représente un niveau de jeu avec ses dimensions et son image.
 */
@RestController
@RequestMapping("/maps")
public class MapController {

    private final MapService mapService;
    private final MapDtoMapper mapDtoMapper;

    /**
     * Constructeur avec injection des dépendances
     * @param mapService Service gérant la logique métier des maps
     * @param mapDtoMapper Mapper pour la conversion entre DTO et modèle
     */
    @Autowired
    public MapController(MapService mapService, MapDtoMapper mapDtoMapper) {
        this.mapService = mapService;
        this.mapDtoMapper = mapDtoMapper;
    }

    /**
     * Récupère toutes les maps disponibles
     * @return Liste de toutes les maps du jeu
     */
    @GetMapping
    public List<MapDto> findAllMaps() {
        List<MapModel> maps = mapService.findAllMaps();
        return mapDtoMapper.mapListModelToDto(maps);
    }

    /**
     * Récupère une map par son identifiant
     * @param id Identifiant de la map
     * @return La map si trouvée, sinon retourne une erreur 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<MapDto> getMapById(@PathVariable("id") Integer id) {
        MapModel map = mapService.findMapById(id);
        if (map == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mapDtoMapper.mapModelToDto(map), HttpStatus.OK);
    }

    /**
     * Crée une nouvelle map
     * @param mapDto DTO contenant les informations de la map à créer
     * @return Code 201 si la création est réussie
     */
    @PostMapping
    public ResponseEntity<Void> createMap(@RequestBody MapDto mapDto) {
        MapModel mapModel = mapDtoMapper.mapDtoToModel(mapDto);
        mapService.create(mapModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMap(@PathVariable("id") Integer id, @RequestBody MapDto mapDto) {
        MapModel existingMap = mapService.findMapById(id);
        if (existingMap == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (mapDto.getLigne() == null) {
            mapDto.setLigne(existingMap.getLigne());
        }
        if (mapDto.getColonne() == null) {
            mapDto.setColonne(existingMap.getColonne());
        }
        if (mapDto.getChemin_image() == null) {
            mapDto.setChemin_image(existingMap.getChemin_image());
        }

        MapModel updatedMap = mapDtoMapper.mapDtoToModel(mapDto);
        updatedMap.setId_map(id);
        mapService.update(updatedMap);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable("id") Integer id) {
        MapModel existingMap = mapService.findMapById(id);
        if (existingMap == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        mapService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/validation")
    public ResponseEntity<String> validateMapStructure() {
        return ResponseEntity.ok("Structure Map valide");
    }
}
