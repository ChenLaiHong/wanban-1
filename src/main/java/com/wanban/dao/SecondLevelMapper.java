package com.wanban.dao;

import com.wanban.pojo.SecondLevel;
import com.wanban.pojo.SecondLevelExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondLevelMapper {
    long countByExample(SecondLevelExample example);

    int deleteByExample(SecondLevelExample example);

    int deleteByPrimaryKey(Integer secondId);

    int insert(SecondLevel record);

    int insertSelective(SecondLevel record);

    List<SecondLevel> selectByExample(SecondLevelExample example);

    SecondLevel selectByPrimaryKey(Integer secondId);

    int updateByExampleSelective(@Param("record") SecondLevel record, @Param("example") SecondLevelExample example);

    int updateByExample(@Param("record") SecondLevel record, @Param("example") SecondLevelExample example);

    int updateByPrimaryKeySelective(SecondLevel record);

    int updateByPrimaryKey(SecondLevel record);

    int getFirstLevelById(int firstId);

    List<SecondLevel> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);
}