package com.wanban.service;

import com.wanban.pojo.Releases;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/24.
 */
public interface ReleasesService {
    List<Releases> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    int add(Releases releases);

    void update(Releases releases);
}
