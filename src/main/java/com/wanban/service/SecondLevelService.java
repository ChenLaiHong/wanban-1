package com.wanban.service;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/18.
 */
public interface SecondLevelService {
    int getFirstLevelById(int i);

    List<com.wanban.pojo.SecondLevel> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    int deleteSecond(int i);

    int addSecond(com.wanban.pojo.SecondLevel secondLevel);

    int updateSecond(com.wanban.pojo.SecondLevel secondLevel);

    String getImageName(Integer secondId);

    List<com.wanban.pojo.SecondLevel> getAllSecond(int firstId);

    com.wanban.pojo.SecondLevel getSecondById(int secondId);
}
