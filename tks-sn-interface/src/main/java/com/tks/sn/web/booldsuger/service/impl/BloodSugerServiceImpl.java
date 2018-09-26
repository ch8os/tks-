package com.tks.sn.web.booldsuger.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.tks.sn.common.BaseConstants.DataSource;
import com.tks.sn.common.SNResult;
import com.tks.sn.common.SNResult.ResultCode;
import com.tks.sn.common.entity.SnUserBloodsuger;
import com.tks.sn.common.example.SnUserBloodsugerExample;
import com.tks.sn.common.mapper.SnUserBloodsugerMapper;
import com.tks.sn.common.utils.SNUtils;
import com.tks.sn.web.booldsuger.entity.SnUserBloodsugerDTO;
import com.tks.sn.web.booldsuger.service.IBloodSugerService;

@Service
public class BloodSugerServiceImpl implements IBloodSugerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BloodSugerServiceImpl.class);

	@Autowired
	SnUserBloodsugerMapper snUserBloodsugerMapper;

	@Override
	public SNResult receiveBSData(SnUserBloodsugerDTO dto) {
		if (ObjectUtils.isEmpty(dto)) {
			return SNResult.ret(ResultCode.DATAERROR);
		}

		SnUserBloodsugerExample example = new SnUserBloodsugerExample();
		SnUserBloodsugerExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(dto.getCode());
		List<SnUserBloodsuger> list = snUserBloodsugerMapper.selectByExample(example);
		if (!ObjectUtils.isEmpty(list)) {
			return SNResult.ret(ResultCode.REPEAT);
		}
		String testtime = dto.getTesttime();
		SnUserBloodsuger snUserBloodsuger = new SnUserBloodsuger();
		BeanUtils.copyProperties(dto, snUserBloodsuger);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			snUserBloodsuger.setTesttime(sf.parse(testtime));
		} catch (ParseException e) {
			LOGGER.error("时间格式异常 testtime=" + testtime, e);
		}
		snUserBloodsuger.setId(SNUtils.getUUID());
		snUserBloodsuger.setCreateTime(new Date());
		snUserBloodsuger.setSource(DataSource.SN.getType());
		snUserBloodsugerMapper.insert(snUserBloodsuger);
		return SNResult.ret(ResultCode.SUCCESS);
	}

}
