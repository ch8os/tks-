package com.tks.db.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tks.db.common.example.BDeptInfoExample;
import com.tks.resource.common.entity.BDeptInfo;

public interface BDeptInfoMapper {
    long countByExample(BDeptInfoExample example);

    int deleteByExample(BDeptInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(BDeptInfo record);

    int insertSelective(BDeptInfo record);

    List<BDeptInfo> selectByExample(BDeptInfoExample example);

    BDeptInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BDeptInfo record, @Param("example") BDeptInfoExample example);

    int updateByExample(@Param("record") BDeptInfo record, @Param("example") BDeptInfoExample example);

    int updateByPrimaryKeySelective(BDeptInfo record);

    int updateByPrimaryKey(BDeptInfo record);
    
    List<BDeptInfo> getDeptListByUserId(@Param("userId") String userId);

    String getMaxDeptCode(@Param("hosCode") String hosCode);
}