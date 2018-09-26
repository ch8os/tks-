package com.tks.doc.common.token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tks.doc.login.service.impl.LoginServiceImpl;

/**
 * @ Purpose:Token拦截器，用来校验Token
 * @Package Name: com.dpm.web.common.handler
 * @Author: liuxiaoxin
 * @Date: 2018/5/4
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    JwtTokenService jwtTokenService;

    @Bean
    public LoginServiceImpl LoginServiceImpl() {
        return new LoginServiceImpl();
    }

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)

            throws Exception {

    }

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return false;
	}
}
