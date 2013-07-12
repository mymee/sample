/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * The Class AuthCheckInterceptor.
 */
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	
	/** The log. */
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//Controller 접근 전 권한 로그인 등의 체크를 함.
		// return false 이면 Controller 접근을 하지 않음.
		log.debug("AuthCheckInterceptor preHandler------------------------------------------------");
		return super.preHandle(request, response, handler);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//Controoler 로직 처리 이후에 호출이 되며 Controller 에러 발생시 호출 안됨. Response 데이터 가공 시 이용
		log.debug("AuthCheckInterceptor postHandler------------------------------------------------");
		super.postHandle(request, response, handler, modelAndView);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//Controller 로직 처리 이후 호출이 되며  Controller 에서 에러 발생시에도 호출이 됨. 예외적인 에러 처리를 주로 함.
		log.debug("AuthCheckInterceptor afterCompletion------------------------------------------------");
		super.afterCompletion(request, response, handler, ex);
	}

}
