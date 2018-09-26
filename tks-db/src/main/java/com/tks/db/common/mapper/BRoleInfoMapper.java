package com.tks.db.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tks.db.common.example.BRoleInfoExample;
import com.tks.resource.common.entity.BRoleInfo;

public interface BRoleInfoMapper {
    long countByExample(BRoleInfoExample example);

    int deleteByExample(BRoleInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(BRoleInfo record);

    int insertSelective(BRoleInfo record);

    List<BRoleInfo> selectByExample(BRoleInfoExample example);

    BRoleInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BRoleInfo record, @Param("example") BRoleInfoExample example);

    int updateByExample(@Param("record") BRoleInfo record, @Param("example") BRoleInfoExample example);

    int updateByPrimaryKeySelective(BRoleInfo record);

    int updateByPrimaryKey(BRoleInfo record);
}