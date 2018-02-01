package com.wanban.service;

import java.util.List;
import java.util.Map;

/**
 * Created by 赖红 on 2018/1/18.
 */
public interface FirstLevelService {
    List<com.wanban.pojo.FirstLevel> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    int add(com.wanban.pojo.FirstLevel firstLevel);

    int update(com.wanban.pojo.FirstLevel firstLevel);

    int delete(int i);

    List<com.wanban.pojo.FirstLevel> getAllFirstLevel();

    String getImageName(int firstId);

    com.wanban.pojo.FirstLevel getFirstLevelId(int i);


}
