package com.tks.doc.login.service;

import com.tks.doc.login.pojo.LoginReq;
import com.tks.resource.common.entity.TDoctorInfo;

public interface ILoginService {

	TDoctorInfo doLogin(LoginReq loginReq) throws Exception;

	TDoctorInfo updateDocInfo(TDoctorInfo tDoctorInfo);
}
