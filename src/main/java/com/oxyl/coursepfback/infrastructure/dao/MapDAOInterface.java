package com.oxyl.coursepfback.infrastructure.dao;

import com.oxyl.coursepfback.infrastructure.entities.MapEntity;
import java.util.List;

public interface MapDAOInterface {
    List<MapEntity> findAll();
    MapEntity findById(Integer id);
    void create(MapEntity map);
    void update(MapEntity map);
    void delete(Integer id);
}
