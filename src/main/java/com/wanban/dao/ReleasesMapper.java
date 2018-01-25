package com.wanban.dao;

import com.wanban.pojo.Releases;
import com.wanban.pojo.ReleasesExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleasesMapper {
    long countByExample(ReleasesExample example);

    int deleteByExample(ReleasesExample example);

    int deleteByPrimaryKey(Integer releaseId);

    int insert(Releases record);

    int insertSelective(Releases record);

    List<Releases> selectByExample(ReleasesExample example);

    Releases selectByPrimaryKey(Integer releaseId);

    int updateByExampleSelective(@Param("record") Releases record, @Param("example") ReleasesExample example);

    int updateByExample(@Param("record") Releases record, @Param("example") ReleasesExample example);

    int updateByPrimaryKeySelective(Releases record);

    int updateByPrimaryKey(Releases record);

    List<Releases> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

}