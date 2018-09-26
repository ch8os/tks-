package com.tks.wx.userinfo.service;


import com.tks.wx.common.entity.PersonalInf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IGetUserInfoService {

	void redirect(HttpServletResponse response);

	PersonalInf getuserInfo(HttpServletRequest request, HttpServletResponse response);
}
