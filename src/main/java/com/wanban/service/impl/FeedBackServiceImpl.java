package com.wanban.service.impl;

import com.wanban.dao.FeedBackMapper;
import com.wanban.pojo.FeedBack;
import com.wanban.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/1/22.
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {

   @Autowired
   private FeedBackMapper feedBackMapper;

    @Override
    public List<FeedBack> list(Map<String, Object> map) {
        return feedBackMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return feedBackMapper.getTotal(map);
    }

    @Override
    public void update(FeedBack feedBack) {
        feedBackMapper.updateByPrimaryKeySelective(feedBack);
    }

    @Override
    public void delete(int i) {
        feedBackMapper.deleteByPrimaryKey(i);
    }

    @Override
    public int add(FeedBack feedBack) {
        return feedBackMapper.insert(feedBack);
    }
}
