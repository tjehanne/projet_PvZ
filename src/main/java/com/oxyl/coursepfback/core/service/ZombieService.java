package com.oxyl.coursepfback.core.service;

import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.repository.ZombieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

@Service
public class ZombieService {

    private final ZombieRepository zombieRepository;
    protected static final String DEFAULT_ZOMBIE_IMAGE = "images/zombie/default.png";

    @Autowired
    public ZombieService(ZombieRepository zombieRepository) {
        this.zombieRepository = zombieRepository;
    }

    public List<ZombieModel> findAllZombies() {
        return zombieRepository.findAll();
    }

    public ZombieModel findZombieById(Integer id) {
        return zombieRepository.findById(id);
    }

    public List<ZombieModel> findZombiesByMapId(Integer mapId) {
        return zombieRepository.findByMapId(mapId);
    }

    protected boolean isValidImagePath(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            return false;
        }

        try {
            ClassPathResource resource = new ClassPathResource("webapp/" + imagePath);
            resource.getInputStream(); 
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String validateAndGetImagePath(String imagePath) {
        return isValidImagePath(imagePath) ? imagePath : DEFAULT_ZOMBIE_IMAGE;
    }

    public void create(ZombieModel model) {
        model.setChemin_image(validateAndGetImagePath(model.getChemin_image()));
        zombieRepository.create(model);
    }

    public void update(ZombieModel model) {
        model.setChemin_image(validateAndGetImagePath(model.getChemin_image()));
        zombieRepository.update(model);
    }

    public void delete(Integer id) {
        zombieRepository.delete(id);
    }
}
