package com.wanban.service.impl;

import com.wanban.dao.ReleasesMapper;
import com.wanban.pojo.Releases;
import com.wanban.service.ReleasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/24.
 */
@Service
public class ReleasesServiceImpl implements ReleasesService {
    @Autowired
    private ReleasesMapper releasesMapper;


    @Override
    public List<Releases> list(Map<String, Object> map) {
        return releasesMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return releasesMapper.getTotal(map);
    }

    @Override
    public int add(Releases releases) {
        return releasesMapper.insert(releases);
    }

    @Override
    public void update(Releases releases) {
        releasesMapper.updateByPrimaryKey(releases);
    }
}
