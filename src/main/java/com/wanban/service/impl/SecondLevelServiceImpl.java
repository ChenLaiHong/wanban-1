package com.wanban.service.impl;

import com.wanban.dao.SecondLevelMapper;
import com.wanban.pojo.FirstLevel;
import com.wanban.pojo.SecondLevel;
import com.wanban.service.SecondLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/18.
 */
@Service
public class SecondLevelServiceImpl implements SecondLevelService{
    @Autowired
    private SecondLevelMapper secondLevelMapper;

    @Override
    public int getFirstLevelById(int i) {
        return secondLevelMapper.getFirstLevelById(i);
    }

    @Override
    public List<SecondLevel> list(Map<String, Object> map) {
        return secondLevelMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return secondLevelMapper.getTotal(map);
    }

    @Override
    public int deleteSecond(int i) {
        return secondLevelMapper.deleteByPrimaryKey(i);
    }

    @Override
    public int addSecond(SecondLevel secondLevel) {
        return secondLevelMapper.insertSelective(secondLevel);
    }

    @Override
    public int updateSecond(SecondLevel secondLevel) {
        return secondLevelMapper.updateByPrimaryKeySelective(secondLevel);
    }

    @Override
    public String getImageName(Integer secondId) {
        return secondLevelMapper.selectByPrimaryKey(secondId).getSecondImageName();
    }

    @Override
    public List<SecondLevel> getAllSecond() {
        return secondLevelMapper.selectByExample(null);
    }


}
