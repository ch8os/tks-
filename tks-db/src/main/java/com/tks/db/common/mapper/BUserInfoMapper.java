package com.tks.db.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tks.db.common.example.BUserInfoExample;
import com.tks.resource.common.entity.BUserInfo;
import com.tks.resource.common.entity.userInfo.UserParam;
import com.tks.resource.common.entity.userInfo.UserSearchResult;

public interface BUserInfoMapper {
    long countByExample(BUserInfoExample example);

    int deleteByExample(BUserInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(BUserInfo record);

    int insertSelective(BUserInfo record);

    List<BUserInfo> selectByExample(BUserInfoExample example);

    BUserInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BUserInfo record, @Param("example") BUserInfoExample example);

    int updateByExample(@Param("record") BUserInfo record, @Param("example") BUserInfoExample example);

    int updateByPrimaryKeySelective(BUserInfo record);

    int updateByPrimaryKey(BUserInfo record);
    
    List<UserSearchResult> getUserInfoByCondition(UserParam userParam);
}