package com.tks.pat.feigns.hystric;

import java.util.List;

import com.tks.pat.feigns.IPatFeignClient;
import com.tks.resource.common.entity.TPatientInfo;

/**
 * @ Purpose:
 * @Package Name: com.dpm.unity.web.feigns.hystric
 * @Author: liuxiaoxin
 * @Date: 2018/5/15
 */
public class PatFeignHystric implements IPatFeignClient {

	@Override
	public List<TPatientInfo> getPatInfo(TPatientInfo tPatientInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TPatientInfo saveOrUpdatePatInfo(TPatientInfo tPatientInfo) {
		// TODO Auto-generated method stub
		return null;
	}
}
