package com.oxyl.coursepfback.infrastructure.repository;

import com.oxyl.coursepfback.core.model.MapModel;
import com.oxyl.coursepfback.infrastructure.dao.MapDAO;
import com.oxyl.coursepfback.infrastructure.mapper.MapEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapRepository {

    private final MapDAO mapDAO;
    private final MapEntityMapper mapEntityMapper;

    public MapRepository(MapDAO mapDAO, MapEntityMapper mapEntityMapper) {
        this.mapDAO = mapDAO;
        this.mapEntityMapper = mapEntityMapper;
    }

    public List<MapModel> findAll() {
        return mapEntityMapper.mapListEntityToModel(mapDAO.findAll());
    }

    public MapModel findById(Integer id) {
        return mapEntityMapper.mapEntityToModel(mapDAO.findById(id));
    }

    public void create(MapModel model) {
        mapDAO.create(mapEntityMapper.mapModelToEntity(model));
    }

    public void update(MapModel model) {
        mapDAO.update(mapEntityMapper.mapModelToEntity(model));
    }

    public void delete(Integer id) {
        mapDAO.delete(id);
    }
}
