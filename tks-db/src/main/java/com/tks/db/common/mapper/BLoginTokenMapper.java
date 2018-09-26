package com.tks.db.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tks.db.common.example.BLoginTokenExample;
import com.tks.resource.common.entity.BLoginToken;

public interface BLoginTokenMapper {
    long countByExample(BLoginTokenExample example);

    int deleteByExample(BLoginTokenExample example);

    int deleteByPrimaryKey(String id);

    int insert(BLoginToken record);

    int insertSelective(BLoginToken record);

    List<BLoginToken> selectByExample(BLoginTokenExample example);

    BLoginToken selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BLoginToken record, @Param("example") BLoginTokenExample example);

    int updateByExample(@Param("record") BLoginToken record, @Param("example") BLoginTokenExample example);

    int updateByPrimaryKeySelective(BLoginToken record);

    int updateByPrimaryKey(BLoginToken record);
}