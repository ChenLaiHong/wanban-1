package com.wanban.dao;

import com.wanban.pojo.FeedBack;
import com.wanban.pojo.FeedBackExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackMapper {
    long countByExample(FeedBackExample example);

    int deleteByExample(FeedBackExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    List<FeedBack> selectByExample(FeedBackExample example);

    FeedBack selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") FeedBack record, @Param("example") FeedBackExample example);

    int updateByExample(@Param("record") FeedBack record, @Param("example") FeedBackExample example);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);

    List<FeedBack> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);
}