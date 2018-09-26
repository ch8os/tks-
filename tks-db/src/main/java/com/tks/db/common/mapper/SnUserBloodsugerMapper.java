package com.tks.db.common.mapper;

import com.tks.db.common.example.SnUserBloodsugerExample;
import com.tks.resource.common.entity.SnUserBloodsuger;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SnUserBloodsugerMapper {
    long countByExample(SnUserBloodsugerExample example);

    int deleteByExample(SnUserBloodsugerExample example);

    int deleteByPrimaryKey(String id);

    int insert(SnUserBloodsuger record);

    int insertSelective(SnUserBloodsuger record);

    List<SnUserBloodsuger> selectByExample(SnUserBloodsugerExample example);

    SnUserBloodsuger selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SnUserBloodsuger record, @Param("example") SnUserBloodsugerExample example);

    int updateByExample(@Param("record") SnUserBloodsuger record, @Param("example") SnUserBloodsugerExample example);

    int updateByPrimaryKeySelective(SnUserBloodsuger record);

    int updateByPrimaryKey(SnUserBloodsuger record);

    List<SnUserBloodsuger> getBloodSugarCondition(Map<String,String> map);
}