package com.wanban.service.impl;

import com.wanban.dao.PlaceMapper;
import com.wanban.pojo.Place;
import com.wanban.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/2/1.
 */
@Service
public class PlaceServiceImp implements PlaceService {
    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public List<Place> list(Map<String, Object> map) {
        return placeMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return placeMapper.getTotal(map);
    }

    @Override
    public void delete(int i) {
        placeMapper.deleteByPrimaryKey(i);
    }

    @Override
    public int addPlace(Place place) {
        return placeMapper.insertSelective(place);
    }

    @Override
    public int updatePlace(Place place) {
        return placeMapper.updateByPrimaryKeySelective(place);
    }
}
