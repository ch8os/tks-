package com.tks.sn.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tks.sn.common.entity.SnUserBloodsuger;
import com.tks.sn.common.example.SnUserBloodsugerExample;

public interface SnUserBloodsugerMapper {
    long countByExample(SnUserBloodsugerExample example);

	int deleteByExample(SnUserBloodsugerExample example);

	int deleteByPrimaryKey(String id);

	int insert(SnUserBloodsuger record);

	int insertSelective(SnUserBloodsuger record);

	List<SnUserBloodsuger> selectByExample(SnUserBloodsugerExample example);

	SnUserBloodsuger selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") SnUserBloodsuger record,
			@Param("example") SnUserBloodsugerExample example);

	int updateByExample(@Param("record") SnUserBloodsuger record, @Param("example") SnUserBloodsugerExample example);

	int updateByPrimaryKeySelective(SnUserBloodsuger record);

	int updateByPrimaryKey(SnUserBloodsuger record);
}