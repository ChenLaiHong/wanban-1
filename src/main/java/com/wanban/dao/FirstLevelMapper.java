package com.wanban.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstLevelMapper {
    long countByExample(com.wanban.pojo.FirstLevelExample example);

    int deleteByExample(com.wanban.pojo.FirstLevelExample example);

    int deleteByPrimaryKey(Integer firstId);

    int insert(com.wanban.pojo.FirstLevel record);

    int insertSelective(com.wanban.pojo.FirstLevel record);

    List<com.wanban.pojo.FirstLevel> selectByExample(com.wanban.pojo.FirstLevelExample example);

    com.wanban.pojo.FirstLevel selectByPrimaryKey(Integer firstId);

    int updateByExampleSelective(@Param("record") com.wanban.pojo.FirstLevel record, @Param("example") com.wanban.pojo.FirstLevelExample example);

    int updateByExample(@Param("record") com.wanban.pojo.FirstLevel record, @Param("example") com.wanban.pojo.FirstLevelExample example);

    int updateByPrimaryKeySelective(com.wanban.pojo.FirstLevel record);

    int updateByPrimaryKey(com.wanban.pojo.FirstLevel record);

    List<com.wanban.pojo.FirstLevel> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    List<com.wanban.pojo.FirstLevel> countList();
}