package com.tks.db.common.mapper;

import com.tks.db.common.example.TPatientInfoExample;
import com.tks.resource.common.entity.TPatientInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientInfoMapper {
    long countByExample(TPatientInfoExample example);

    int deleteByExample(TPatientInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TPatientInfo record);

    int insertSelective(TPatientInfo record);

    List<TPatientInfo> selectByExample(TPatientInfoExample example);

    TPatientInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TPatientInfo record, @Param("example") TPatientInfoExample example);

    int updateByExample(@Param("record") TPatientInfo record, @Param("example") TPatientInfoExample example);

    int updateByPrimaryKeySelective(TPatientInfo record);

    int updateByPrimaryKey(TPatientInfo record);
}