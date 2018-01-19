package com.wanban.service;

import com.wanban.pojo.FirstLevel;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/18.
 */
public interface SecondLevelService {
    int getFirstLevelId(int i);

    List<FirstLevel> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);
}
