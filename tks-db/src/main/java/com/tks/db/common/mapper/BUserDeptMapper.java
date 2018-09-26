package com.tks.db.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tks.db.common.example.BUserDeptExample;
import com.tks.resource.common.entity.BUserDept;

public interface BUserDeptMapper {
    long countByExample(BUserDeptExample example);

    int deleteByExample(BUserDeptExample example);

    int deleteByPrimaryKey(String id);

    int insert(BUserDept record);

    int insertSelective(BUserDept record);

    List<BUserDept> selectByExample(BUserDeptExample example);

    BUserDept selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BUserDept record, @Param("example") BUserDeptExample example);

    int updateByExample(@Param("record") BUserDept record, @Param("example") BUserDeptExample example);

    int updateByPrimaryKeySelective(BUserDept record);

    int updateByPrimaryKey(BUserDept record);
}