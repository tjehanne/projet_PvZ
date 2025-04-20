package com.oxyl.coursepfback.api.controller;

import com.oxyl.coursepfback.api.dto.PlanteDto;
import com.oxyl.coursepfback.api.mapper.PlanteDtoMapper;
import com.oxyl.coursepfback.core.model.PlanteModel;
import com.oxyl.coursepfback.core.service.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteService planteService;
    private final PlanteDtoMapper planteDtoMapper;

    @Autowired
    public PlanteController(PlanteService planteService, PlanteDtoMapper planteDtoMapper) {
        this.planteService = planteService;
        this.planteDtoMapper = planteDtoMapper;
    }

    @GetMapping
    public List<PlanteDto> findAllPlantes() {
        List<PlanteModel> plantes = planteService.findAllPlantes();
        return planteDtoMapper.mapListModelToDto(plantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanteDto> getPlanteById(@PathVariable("id") Integer id){
        PlanteModel plante = planteService.findPlanteById(id);
        if (plante == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(planteDtoMapper.mapModelToDto(plante), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createPlante(@RequestBody PlanteDto planteDto) {
        PlanteModel planteModel = planteDtoMapper.mapDtoToModel(planteDto);
        planteService.create(planteModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePlante(@PathVariable("id") Integer id, @RequestBody PlanteDto planteDto) {
        PlanteModel existingPlante = planteService.findPlanteById(id);
        if (existingPlante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (planteDto.getNom() == null) {
            planteDto.setNom(existingPlante.getNom());
        }
        if (planteDto.getPoint_de_vie() == null) {
            planteDto.setPoint_de_vie(existingPlante.getPoint_de_vie());
        }
        if (planteDto.getAttaque_par_seconde() == null) {
            planteDto.setAttaque_par_seconde(existingPlante.getAttaque_par_seconde());
        }
        if (planteDto.getDegat_attaque() == null) {
            planteDto.setDegat_attaque(existingPlante.getDegat_attaque());
        }
        if (planteDto.getCout() == null) {
            planteDto.setCout(existingPlante.getCout());
        }
        if (planteDto.getSoleil_par_seconde() == null) {
            planteDto.setSoleil_par_seconde(existingPlante.getSoleil_par_seconde());
        }
        if (planteDto.getEffet() == null) {
            planteDto.setEffet(existingPlante.getEffet());
        }
        if (planteDto.getChemin_image() == null) {
            planteDto.setChemin_image(existingPlante.getChemin_image());
        }

        PlanteModel updatedPlante = planteDtoMapper.mapDtoToModel(planteDto);
        updatedPlante.setId_plante(id);
        planteService.update(updatedPlante);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlante(@PathVariable("id") Integer id) {
        PlanteModel existingPlante = planteService.findPlanteById(id);
        if (existingPlante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        planteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/validation")
    public ResponseEntity<String> validatePlanteStructure() {
        return ResponseEntity.ok("Structure Plante valide");
    }
}
