package com.wanban.service;

import com.wanban.pojo.SecondLevel;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/18.
 */
public interface SecondLevelService {
    int getFirstLevelById(int i);

    List<SecondLevel> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    int deleteSecond(int i);

    int addSecond(SecondLevel secondLevel);

    int updateSecond(SecondLevel secondLevel);

    String getImageName(Integer secondId);

    List<SecondLevel> getAllSecond();
}
