package com.wanban.service;

import com.wanban.pojo.Place;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/2/1.
 */
public interface PlaceService {


    List<Place> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    void delete(int i);

    int addPlace(Place place);

    int updatePlace(Place place);

    Place getPlace(double longitude, double latitude);
}
