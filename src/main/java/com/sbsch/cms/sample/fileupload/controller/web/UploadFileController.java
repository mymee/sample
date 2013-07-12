/*
 * Copyright (c) SBSContentsHub.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SBSContentsHub.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SBSContentsHub.
 */
package com.sbsch.cms.sample.fileupload.controller.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sbsch.cms.framework.web.AbstractController;
import com.sbsch.cms.sample.fileupload.model.Upload;


/**
 * The Class UploadFileController.
 */
@Controller
@RequestMapping(value = "/uploadFile")
@PropertySource(name = "property", value = {"classpath:conf/property/system.properties","classpath:conf/property/application.properties"})
public class UploadFileController extends AbstractController {

	/** The env. */
	@Autowired
	private Environment env;

	/**
	 * Show form.
	 * 
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		Upload form = new Upload();
		model.addAttribute("FORM", form);
		return "sample/uploadForm";
	}

	/**
	 * Plupload form.
	 * 
	 * @return the string
	 */
	@RequestMapping(value = "/plupload", method = RequestMethod.GET)
	public String pluploadForm() {

		return "sample/upload";
	}

	/**
	 * Upload.
	 * 
	 * @param request the request
	 * @param response the response
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/plupload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultiValueMap<String, MultipartFile> map = multipartRequest.getMultiFileMap();
		if (map != null) {
			Iterator<String> iter = map.keySet().iterator();
			while (iter.hasNext()) {
				String str = (String) iter.next();
				List<MultipartFile> fileList = map.get(str);
				for (MultipartFile mpf : fileList) {
					File localFile = new File(env.getProperty("multipart.fileupload.path") + mpf.getOriginalFilename());
					OutputStream out = new FileOutputStream(localFile);
					out.write(mpf.getBytes());
					out.close();
				}
			}
		}
		return "sample/upload";
	}

	/**
	 * Process form.
	 * 
	 * @param form the form
	 * @param result the result
	 * @return the string
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@ModelAttribute(value = "FORM")
	Upload form, BindingResult result) {
		if (!result.hasErrors()) {
			FileOutputStream outputStream = null;
			String filePath = env.getProperty("multipart.fileupload.path") + form.getFile().getOriginalFilename();
			try {
				outputStream = new FileOutputStream(new File(filePath));
				outputStream.write(form.getFile().getFileItem().get());
				outputStream.close();
			} catch (Exception e) {
				return "sample/uploadForm";
			}
			return "sample/uploadForm";
		} else {
			return "sample/uploadForm";
		}
	}

}