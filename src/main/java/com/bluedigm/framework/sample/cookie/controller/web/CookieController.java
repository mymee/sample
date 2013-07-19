/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.cookie.controller.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.framework.util.web.SessionCookieUtil;
import com.bluedigm.framework.web.AbstractController;


/**
 * <pre>
 * com.bluedigm.framework.sample.cookie.controller.web
 * 		|_CookieController.java
 * TODO Javadoc주석작성
 * </pre>
 * 
 * @author Hanwoong Lee, Bluedigm
 * @date 2013. 7. 19. 오후 11:52:42
 * @version $Id$
 */
@Controller
@RequestMapping(value = "/cookie")
public class CookieController extends AbstractController {

	@RequestMapping("/createCookie")
	private ModelAndView createCookie(HttpServletResponse response) throws UnsupportedEncodingException {
		SessionCookieUtil.setCookie(response, "ABC-Cookie", "The cookie value",60*24,"/",".devcenter.com",false,true);
		return new ModelAndView("sample/cookie/viewCookie");
	}
	
	@RequestMapping("/deleteCookie")
	private ModelAndView deleteCookie(HttpServletResponse response) throws UnsupportedEncodingException {
		SessionCookieUtil.setCookie(response, "ABC-Cookie");
		return new ModelAndView("sample/cookie/viewCookie");
	}
	
	@RequestMapping("/viewCookie")
	private ModelAndView viewCookie(HttpServletRequest request) throws Exception {
		log.debug(SessionCookieUtil.getCookie(request, "ABC-Cookie"));
		return new ModelAndView("sample/cookie/viewCookie");
	}
}
