package com.tks.db.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tks.db.common.example.BMenuInfoExample;
import com.tks.resource.common.entity.BMenuInfo;

public interface BMenuInfoMapper {
    long countByExample(BMenuInfoExample example);

    int deleteByExample(BMenuInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(BMenuInfo record);

    int insertSelective(BMenuInfo record);

    List<BMenuInfo> selectByExample(BMenuInfoExample example);

    BMenuInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BMenuInfo record, @Param("example") BMenuInfoExample example);

    int updateByExample(@Param("record") BMenuInfo record, @Param("example") BMenuInfoExample example);

    int updateByPrimaryKeySelective(BMenuInfo record);

    int updateByPrimaryKey(BMenuInfo record);
}