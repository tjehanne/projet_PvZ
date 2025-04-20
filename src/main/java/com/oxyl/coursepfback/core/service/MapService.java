package com.oxyl.coursepfback.core.service;

import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.repository.MapRepository;
import com.oxyl.coursepfback.infrastructure.repository.ZombieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    private final MapRepository mapRepository;
    private final ZombieRepository zombieRepository;

    @Autowired
    public MapService(MapRepository mapRepository, ZombieRepository zombieRepository) {
        this.mapRepository = mapRepository;
        this.zombieRepository = zombieRepository;
    }

    public List<MapModel> findAllMaps() {
        return mapRepository.findAll();
    }

    public MapModel findMapById(Integer id) {
        return mapRepository.findById(id);
    }

    public void create(MapModel model) {
        mapRepository.create(model);
    }

    public void update(MapModel model) {
        mapRepository.update(model);
    }

    public void delete(Integer id) {
        List<ZombieModel> zombies = zombieRepository.findByMapId(id);
        
        for (ZombieModel zombie : zombies) {
            zombie.setId_map(null);
            zombieRepository.update(zombie);
        }

        mapRepository.delete(id);
    }
}
