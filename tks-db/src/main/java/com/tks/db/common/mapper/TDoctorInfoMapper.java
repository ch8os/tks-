package com.tks.db.common.mapper;

import com.tks.db.common.example.TDoctorInfoExample;
import com.tks.resource.common.entity.TDoctorInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDoctorInfoMapper {
    long countByExample(TDoctorInfoExample example);

    int deleteByExample(TDoctorInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TDoctorInfo record);

    int insertSelective(TDoctorInfo record);

    List<TDoctorInfo> selectByExample(TDoctorInfoExample example);

    TDoctorInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TDoctorInfo record, @Param("example") TDoctorInfoExample example);

    int updateByExample(@Param("record") TDoctorInfo record, @Param("example") TDoctorInfoExample example);

    int updateByPrimaryKeySelective(TDoctorInfo record);

    int updateByPrimaryKey(TDoctorInfo record);
}