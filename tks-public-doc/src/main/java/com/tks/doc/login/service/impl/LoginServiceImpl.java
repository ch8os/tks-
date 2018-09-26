package com.tks.doc.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.tks.doc.feigns.IDocFeignClient;
import com.tks.doc.login.pojo.LoginReq;
import com.tks.doc.login.service.ILoginService;
import com.tks.resource.common.entity.TDoctorInfo;
import com.tks.resource.freamwork.BusinessException;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.login.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/18
 */
@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	IDocFeignClient docFeignClient;

	@Override
	public TDoctorInfo doLogin(LoginReq loginReq) throws Exception {
		if (ObjectUtils.isEmpty(loginReq) || StringUtils.isEmpty(loginReq.getMobile())
				|| StringUtils.isEmpty(loginReq.getOpenid())) {
			throw new BusinessException("数据有误，手机号或openid不能为空");
		}
		TDoctorInfo TDoctorInfo = new TDoctorInfo();
		TDoctorInfo.setMobilephone(Integer.parseInt(loginReq.getMobile()));
		TDoctorInfo.setOpenid(loginReq.getOpenid());

		// 获取用户登录信息
		List<TDoctorInfo> tPatientInfoList = docFeignClient.getDocInfo(TDoctorInfo);
		if (!ObjectUtils.isEmpty(tPatientInfoList)) {
			TDoctorInfo = tPatientInfoList.get(0);
		}
		return docFeignClient.saveOrUpdateDocInfo(TDoctorInfo);
	}

	@Override
	public TDoctorInfo updateDocInfo(TDoctorInfo tDoctorInfo) {
		if (StringUtils.isEmpty(tDoctorInfo.getId())) {
			throw new BusinessException("更新医生数据有误，id不能为空");
		}
		return docFeignClient.saveOrUpdateDocInfo(tDoctorInfo);
	}

}
