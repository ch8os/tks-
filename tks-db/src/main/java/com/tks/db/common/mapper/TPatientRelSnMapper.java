package com.tks.db.common.mapper;

import com.tks.db.common.example.TPatientRelSnExample;
import com.tks.resource.common.entity.TPatientRelSn;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPatientRelSnMapper {
    long countByExample(TPatientRelSnExample example);

    int deleteByExample(TPatientRelSnExample example);

    int insert(TPatientRelSn record);

    int insertSelective(TPatientRelSn record);

    List<TPatientRelSn> selectByExample(TPatientRelSnExample example);

    int updateByExampleSelective(@Param("record") TPatientRelSn record, @Param("example") TPatientRelSnExample example);

    int updateByExample(@Param("record") TPatientRelSn record, @Param("example") TPatientRelSnExample example);
}