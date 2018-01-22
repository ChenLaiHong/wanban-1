package com.wanban.dao;

import com.wanban.pojo.FirstLevel;
import com.wanban.pojo.FirstLevelExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstLevelMapper {
    long countByExample(FirstLevelExample example);

    int deleteByExample(FirstLevelExample example);

    int deleteByPrimaryKey(Integer firstId);

    int insert(FirstLevel record);

    int insertSelective(FirstLevel record);

    List<FirstLevel> selectByExample(FirstLevelExample example);

    FirstLevel selectByPrimaryKey(Integer firstId);

    int updateByExampleSelective(@Param("record") FirstLevel record, @Param("example") FirstLevelExample example);

    int updateByExample(@Param("record") FirstLevel record, @Param("example") FirstLevelExample example);

    int updateByPrimaryKeySelective(FirstLevel record);

    int updateByPrimaryKey(FirstLevel record);

    List<FirstLevel> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    List<FirstLevel> countList();
}