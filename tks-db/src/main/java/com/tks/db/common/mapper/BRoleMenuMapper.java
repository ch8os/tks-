package com.tks.db.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tks.db.common.example.BRoleMenuExample;
import com.tks.resource.common.entity.BRoleMenu;

public interface BRoleMenuMapper {
    long countByExample(BRoleMenuExample example);

    int deleteByExample(BRoleMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(BRoleMenu record);

    int insertSelective(BRoleMenu record);

    List<BRoleMenu> selectByExample(BRoleMenuExample example);

    BRoleMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BRoleMenu record, @Param("example") BRoleMenuExample example);

    int updateByExample(@Param("record") BRoleMenu record, @Param("example") BRoleMenuExample example);

    int updateByPrimaryKeySelective(BRoleMenu record);

    int updateByPrimaryKey(BRoleMenu record);
}