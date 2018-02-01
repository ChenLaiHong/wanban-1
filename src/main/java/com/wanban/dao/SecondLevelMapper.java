package com.wanban.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondLevelMapper {
    long countByExample(com.wanban.pojo.SecondLevelExample example);

    int deleteByExample(com.wanban.pojo.SecondLevelExample example);

    int deleteByPrimaryKey(Integer secondId);

    int insert(com.wanban.pojo.SecondLevel record);

    int insertSelective(com.wanban.pojo.SecondLevel record);

    List<com.wanban.pojo.SecondLevel> selectByExample(com.wanban.pojo.SecondLevelExample example);

    com.wanban.pojo.SecondLevel selectByPrimaryKey(Integer secondId);

    int updateByExampleSelective(@Param("record") com.wanban.pojo.SecondLevel record, @Param("example") com.wanban.pojo.SecondLevelExample example);

    int updateByExample(@Param("record") com.wanban.pojo.SecondLevel record, @Param("example") com.wanban.pojo.SecondLevelExample example);

    int updateByPrimaryKeySelective(com.wanban.pojo.SecondLevel record);

    int updateByPrimaryKey(com.wanban.pojo.SecondLevel record);

    int getFirstLevelById(int firstId);

    List<com.wanban.pojo.SecondLevel> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);
}