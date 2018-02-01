package com.wanban.service.impl;

import com.wanban.dao.FirstLevelMapper;
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
    public List<com.wanban.pojo.FirstLevel> list(Map<String, Object> map) {
        return firstLevelMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return firstLevelMapper.getTotal(map);
    }

    @Override
    public int add(com.wanban.pojo.FirstLevel firstLevel) {

        return firstLevelMapper.insertSelective(firstLevel);
    }

    @Override
    public int update(com.wanban.pojo.FirstLevel firstLevel) {
        return firstLevelMapper.updateByPrimaryKeySelective(firstLevel);
    }

    @Override
    public int delete(int i) {
      return  firstLevelMapper.deleteByPrimaryKey(i);
    }

    @Override
    public List<com.wanban.pojo.FirstLevel> getAllFirstLevel() {
        List<com.wanban.pojo.FirstLevel> list = firstLevelMapper.selectByExample(null);
        return  list;
    }

    @Override
    public String getImageName(int firstId) {
        return firstLevelMapper.selectByPrimaryKey(firstId).getFirstImageName();
    }

    @Override
    public com.wanban.pojo.FirstLevel getFirstLevelId(int i) {
        return firstLevelMapper.selectByPrimaryKey(i);
    }


}
