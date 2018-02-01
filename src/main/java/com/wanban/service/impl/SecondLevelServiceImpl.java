package com.wanban.service.impl;

import com.wanban.dao.SecondLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/18.
 */
@Service
public class SecondLevelServiceImpl implements com.wanban.service.SecondLevelService {
    @Autowired
    private SecondLevelMapper secondLevelMapper;

    @Override
    public int getFirstLevelById(int i) {
        return secondLevelMapper.getFirstLevelById(i);
    }

    @Override
    public List<com.wanban.pojo.SecondLevel> list(Map<String, Object> map) {
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
    public int addSecond(com.wanban.pojo.SecondLevel secondLevel) {
        return secondLevelMapper.insertSelective(secondLevel);
    }

    @Override
    public int updateSecond(com.wanban.pojo.SecondLevel secondLevel) {
        return secondLevelMapper.updateByPrimaryKeySelective(secondLevel);
    }

    @Override
    public String getImageName(Integer secondId) {
        return secondLevelMapper.selectByPrimaryKey(secondId).getSecondImageName();
    }

    @Override
    public List<com.wanban.pojo.SecondLevel> getAllSecond(int firstId) {
        com.wanban.pojo.SecondLevelExample secondLevelExample = new com.wanban.pojo.SecondLevelExample();
        com.wanban.pojo.SecondLevelExample.Criteria criteria = secondLevelExample.createCriteria();
        criteria.andFirstIdEqualTo(firstId);
        return secondLevelMapper.selectByExample(secondLevelExample);
    }

    @Override
    public com.wanban.pojo.SecondLevel getSecondById(int secondId) {
        return secondLevelMapper.selectByPrimaryKey(secondId);
    }


}
