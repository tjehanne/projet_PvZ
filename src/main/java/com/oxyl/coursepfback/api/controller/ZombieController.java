package com.oxyl.coursepfback.api.controller;

import com.oxyl.coursepfback.api.dto.ZombieDto;
import com.oxyl.coursepfback.api.mapper.ZombieDtoMapper;
import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.core.service.ZombieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;
    private final ZombieDtoMapper zombieDtoMapper;

    @Autowired
    public ZombieController(ZombieService zombieService, ZombieDtoMapper zombieDtoMapper) {
        this.zombieService = zombieService;
        this.zombieDtoMapper = zombieDtoMapper;
    }

    @GetMapping
    public List<ZombieDto> findAllZombies() {
        List<ZombieModel> zombies = zombieService.findAllZombies();
        return zombieDtoMapper.mapListModelToDto(zombies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZombieDto> getZombieById(@PathVariable("id") Integer id){
        ZombieModel zombie = zombieService.findZombieById(id);
        if (zombie == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(zombieDtoMapper.mapModelToDto(zombie), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createZombie(@RequestBody ZombieDto zombieDto) {
        ZombieModel zombieModel = zombieDtoMapper.mapDtoToModel(zombieDto);
        zombieService.create(zombieModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateZombie(@PathVariable("id") Integer id, @RequestBody ZombieDto zombieDto) {
        ZombieModel existingZombie = zombieService.findZombieById(id);
        if (existingZombie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        if (zombieDto.getNom() == null) {
            zombieDto.setNom(existingZombie.getNom());
        }
        if (zombieDto.getPoint_de_vie() == null) {
            zombieDto.setPoint_de_vie(existingZombie.getPoint_de_vie());
        }
        if (zombieDto.getAttaque_par_seconde() == null) {
            zombieDto.setAttaque_par_seconde(existingZombie.getAttaque_par_seconde());
        }
        if (zombieDto.getDegat_attaque() == null) {
            zombieDto.setDegat_attaque(existingZombie.getDegat_attaque());
        }
        if (zombieDto.getVitesse_de_deplacement() == null) {
            zombieDto.setVitesse_de_deplacement(existingZombie.getVitesse_de_deplacement());
        }
        if (zombieDto.getChemin_image() == null) {
            zombieDto.setChemin_image(existingZombie.getChemin_image());
        }
        if (zombieDto.getId_map() == null) {
            zombieDto.setId_map(existingZombie.getId_map());
        }

        ZombieModel updatedZombie = zombieDtoMapper.mapDtoToModel(zombieDto);
        updatedZombie.setId_zombie(id);
        zombieService.update(updatedZombie);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZombie(@PathVariable("id") Integer id) {
        ZombieModel existingZombie = zombieService.findZombieById(id);
        if (existingZombie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        zombieService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/validation")
    public ResponseEntity<String> validateZombieStructure() {
        return ResponseEntity.ok("Structure Zombie valide");
    }
}
