package com.tks.pat.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.tks.pat.feigns.IPatFeignClient;
import com.tks.pat.feigns.IThirdFeignClient;
import com.tks.pat.login.pojo.LoginReq;
import com.tks.pat.login.service.ILoginService;
import com.tks.resource.common.entity.TPatientInfo;
import com.tks.resource.freamwork.BusinessException;

/**
 * 
 * @author gl
 *
 */
@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	IPatFeignClient patFeignClient;
	
	@Autowired
    IThirdFeignClient thirdFeignClient;

	@Override
	public TPatientInfo doLogin(LoginReq loginReq) throws Exception {
		if (ObjectUtils.isEmpty(loginReq) || StringUtils.isEmpty(loginReq.getMobile())
				|| StringUtils.isEmpty(loginReq.getOpenid())) {
			throw new BusinessException("数据有误，手机号或openid不能为空");
		}
		TPatientInfo tPatientInfo = new TPatientInfo();
		tPatientInfo.setMobilephone(Integer.parseInt(loginReq.getMobile()));
		tPatientInfo.setOpenid(loginReq.getOpenid());

		// 获取用户登录信息
		List<TPatientInfo> tPatientInfoList = patFeignClient.getPatInfo(tPatientInfo);
		if (!ObjectUtils.isEmpty(tPatientInfoList)) {
			tPatientInfo = tPatientInfoList.get(0);
		}else {
			patFeignClient.saveOrUpdatePatInfo(tPatientInfo);
		}
		return tPatientInfo;
	}

	@Override
	public TPatientInfo updatePatInfo(TPatientInfo tPatientInfo) {
		if (StringUtils.isEmpty(tPatientInfo.getId())) {
			throw new BusinessException("更新患者数据有误，id不能为空");
		}
		return patFeignClient.saveOrUpdatePatInfo(tPatientInfo);
	}

	@Override
	public String sendVerifyCode(String mobile) {
		return thirdFeignClient.singleSend(mobile);
	}

}
