package com.tks.pat.login.service;

import com.tks.pat.login.pojo.LoginReq;
import com.tks.resource.common.entity.TPatientInfo;

/**
 * 
 * @author gl
 *
 */
public interface ILoginService {

	TPatientInfo doLogin(LoginReq loginReq) throws Exception;

	TPatientInfo updatePatInfo(TPatientInfo tPatientInfo);
	
	String sendVerifyCode(String mobile);
}
