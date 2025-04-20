package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.ZombieEntity;
import java.util.List;

public interface ZombieDAOInterface {
    List<ZombieEntity> findAll();
    ZombieEntity findById(Integer id);
    List<ZombieEntity> findByMapId(Integer mapId);
    void create(ZombieEntity zombie);
    void update(ZombieEntity zombie);
    void delete(Integer id);
}
