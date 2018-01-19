package com.wanban.service.impl;

import com.wanban.dao.SecondLevelMapper;
import com.wanban.service.SecondLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CHLaih on 2018/1/18.
 */
@Service
public class SecondLevelServiceImpl implements SecondLevelService{
    @Autowired
    private SecondLevelMapper secondLevelMapper;

    @Override
    public int getFirstLevelId(int i) {
        return secondLevelMapper.getFirstLevelId(i);
    }
}
