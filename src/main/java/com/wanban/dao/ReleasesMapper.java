package com.wanban.dao;

import com.wanban.pojo.Releases;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReleasesMapper {
    long countByExample(com.wanban.pojo.ReleasesExample example);

    int deleteByExample(com.wanban.pojo.ReleasesExample example);

    int deleteByPrimaryKey(Integer releaseId);

    int insert(Releases record);

    int insertSelective(Releases record);

    List<Releases> selectByExample(com.wanban.pojo.ReleasesExample example);

    Releases selectByPrimaryKey(Integer releaseId);

    int updateByExampleSelective(@Param("record") Releases record, @Param("example") com.wanban.pojo.ReleasesExample example);

    int updateByExample(@Param("record") Releases record, @Param("example") com.wanban.pojo.ReleasesExample example);

    int updateByPrimaryKeySelective(Releases record);

    int updateByPrimaryKey(Releases record);

    List<Releases> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

}