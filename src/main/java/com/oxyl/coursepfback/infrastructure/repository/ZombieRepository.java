package com.oxyl.coursepfback.infrastructure.repository;

import com.oxyl.coursepfback.core.model.ZombieModel;
import com.oxyl.coursepfback.infrastructure.dao.ZombieDAO;
import com.oxyl.coursepfback.infrastructure.entities.ZombieEntity;
import com.oxyl.coursepfback.infrastructure.mapper.ZombieEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombieRepository {

    private final ZombieDAO zombieDAO;
    private final ZombieEntityMapper zombieEntityMapper;

    public ZombieRepository(ZombieDAO zombieDAO, ZombieEntityMapper zombieEntityMapper) {
        this.zombieDAO = zombieDAO;
        this.zombieEntityMapper = zombieEntityMapper;
    }

    public List<ZombieModel> findAll() {
        return zombieEntityMapper.mapListEntityToModel(zombieDAO.findAll());
    }

    public ZombieModel findById(Integer id) {
        return zombieEntityMapper.mapEntityToModel(zombieDAO.findById(id));
    }

    public List<ZombieModel> findByMapId(Integer mapId) {
        return zombieEntityMapper.mapListEntityToModel(zombieDAO.findByMapId(mapId));
    }

    public void create(ZombieModel model) {
        zombieDAO.create(zombieEntityMapper.mapModelToEntity(model));
    }

    public void update(ZombieModel model) {
        zombieDAO.update(zombieEntityMapper.mapModelToEntity(model));
    }

    public void delete(Integer id) {
        zombieDAO.delete(id);
    }
}
