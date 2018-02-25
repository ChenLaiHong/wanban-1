package com.wanban.dao;

import com.wanban.pojo.Admire;
import com.wanban.pojo.AdmireExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmireMapper {
    long countByExample(AdmireExample example);

    int deleteByExample(AdmireExample example);

    int deleteByPrimaryKey(Integer admireId);

    int insert(Admire record);

    int insertSelective(Admire record);

    List<Admire> selectByExample(AdmireExample example);

    Admire selectByPrimaryKey(Integer admireId);

    int updateByExampleSelective(@Param("record") Admire record, @Param("example") AdmireExample example);

    int updateByExample(@Param("record") Admire record, @Param("example") AdmireExample example);

    int updateByPrimaryKeySelective(Admire record);

    int updateByPrimaryKey(Admire record);
}