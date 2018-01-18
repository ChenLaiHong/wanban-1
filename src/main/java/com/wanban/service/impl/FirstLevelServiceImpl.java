package com.wanban.service.impl;

import com.wanban.dao.FirstLevelMapper;
import com.wanban.pojo.FirstLevel;
import com.wanban.service.FirstLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 赖红 on 2018/1/18.
 */
@Service
public class FirstLevelServiceImpl implements FirstLevelService {
    @Autowired
    private FirstLevelMapper firstLevelMapper;

    @Override
    public List<FirstLevel> list(Map<String, Object> map) {
        return firstLevelMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return firstLevelMapper.getTotal(map);
    }

    @Override
    public int add(FirstLevel firstLevel) {
        return 0;
    }

    @Override
    public int update(FirstLevel firstLevel) {
        return 0;
    }
}
