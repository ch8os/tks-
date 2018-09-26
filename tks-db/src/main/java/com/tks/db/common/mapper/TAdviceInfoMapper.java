package com.tks.db.common.mapper;

import com.tks.db.common.example.TAdviceInfoExample;
import com.tks.resource.common.entity.TAdviceInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAdviceInfoMapper {
    long countByExample(TAdviceInfoExample example);

    int deleteByExample(TAdviceInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TAdviceInfo record);

    int insertSelective(TAdviceInfo record);

    List<TAdviceInfo> selectByExample(TAdviceInfoExample example);

    TAdviceInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TAdviceInfo record, @Param("example") TAdviceInfoExample example);

    int updateByExample(@Param("record") TAdviceInfo record, @Param("example") TAdviceInfoExample example);

    int updateByPrimaryKeySelective(TAdviceInfo record);

    int updateByPrimaryKey(TAdviceInfo record);
}