package com.tks.doc.feigns.hystric;

import java.util.List;

import com.tks.doc.feigns.IDocFeignClient;
import com.tks.resource.common.entity.TDoctorInfo;

/**
 * @ Purpose:
 * @Package Name: com.dpm.unity.web.feigns.hystric
 * @Author: liuxiaoxin
 * @Date: 2018/5/15
 */
public class DocFeignHystric implements IDocFeignClient {

	@Override
	public List<TDoctorInfo> getDocInfo(TDoctorInfo TDoctorInfo) {
		return null;
	}

	@Override
	public TDoctorInfo saveOrUpdateDocInfo(TDoctorInfo TDoctorInfo) {
		return null;
	}

}
