package com.tks.db.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tks.db.common.example.BRecordInfoExample;
import com.tks.resource.common.entity.BRecordInfo;

public interface BRecordInfoMapper {
    long countByExample(BRecordInfoExample example);

    int deleteByExample(BRecordInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(BRecordInfo record);

    int insertSelective(BRecordInfo record);

    List<BRecordInfo> selectByExample(BRecordInfoExample example);

    BRecordInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BRecordInfo record, @Param("example") BRecordInfoExample example);

    int updateByExample(@Param("record") BRecordInfo record, @Param("example") BRecordInfoExample example);

    int updateByPrimaryKeySelective(BRecordInfo record);

    int updateByPrimaryKey(BRecordInfo record);
}