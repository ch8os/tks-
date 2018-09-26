package com.tks.wx.userinfo.controller;

import com.tks.wx.common.entity.PersonalInf;
import com.tks.wx.userinfo.service.IGetUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/wx")
public class GetUserInfoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetUserInfoController.class);

	 @Autowired
	 IGetUserInfoService infoService;

	@RequestMapping(value="/getCode",method= RequestMethod.GET)
	public void redirectToMyPage(HttpServletRequest request, HttpServletResponse response){
		//引导关注者打开 用户同意授权，获取code页面url
		infoService.redirect(response);
	}

	@RequestMapping(value="/getUserInfo",method= RequestMethod.GET)
	public boolean toMyPage(HttpServletRequest request, HttpServletResponse response) {
		PersonalInf personalInf= infoService.getuserInfo( request,response);
		return true;
	}

}
