package com.tks.db.common.mapper;

import com.tks.db.common.example.TScanRecordExample;
import com.tks.resource.common.entity.TScanRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TScanRecordMapper {
    long countByExample(TScanRecordExample example);

    int deleteByExample(TScanRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TScanRecord record);

    int insertSelective(TScanRecord record);

    List<TScanRecord> selectByExample(TScanRecordExample example);

    TScanRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TScanRecord record, @Param("example") TScanRecordExample example);

    int updateByExample(@Param("record") TScanRecord record, @Param("example") TScanRecordExample example);

    int updateByPrimaryKeySelective(TScanRecord record);

    int updateByPrimaryKey(TScanRecord record);
}