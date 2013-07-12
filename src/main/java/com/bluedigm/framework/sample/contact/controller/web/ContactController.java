/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.contact.controller.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.bluedigm.framework.sample.contact.model.Contact;
import com.bluedigm.framework.sample.contact.model.SearchContact;
import com.bluedigm.framework.sample.contact.service.ContactService;
import com.bluedigm.framework.sample.contact.validator.ContactFormValidator;
import com.bluedigm.framework.web.AbstractController;


/**
 * The Class ContactController.
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactController extends AbstractController {

	/** The contact service. */
	@Autowired
	private ContactService contactService;

	/** The validator. */
	@Autowired
	private ContactFormValidator validator;

	/** The env. */
	@Autowired
	private Environment env;
	
	/** The accessor. */
	@Resource
	private MessageSourceAccessor accessor;

	/**
	 * Inits the binder.
	 * 
	 * @param binder the binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.KOREA);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	/**
	 * Search contacts.
	 * 
	 * @param name the name
	 * @return the model and view
	 */
	@RequestMapping("/searchContacts")
	public ModelAndView searchContacts(@RequestParam(required = false, defaultValue = "")
	String name) {
		ModelAndView mav = new ModelAndView("sample/showContacts");
		List<Contact> contacts = contactService.getContacts(name.trim());
		mav.addObject("SEARCH_CONTACTS_RESULTS_KEY", contacts);
		return mav;
	}

	/**
	 * Gets the all contacts.
	 * 
	 * @param searchContact the search contact
	 * @param model the model
	 * @return the all contacts
	 */
	@RequestMapping("/showContacts")
	public ModelAndView getAllContacts(@ModelAttribute("searchContact")
	SearchContact searchContact, ModelMap model) {
		ModelAndView mav = new ModelAndView("sample/showContacts");

		// 현재 페이지 번호
//		searchContact.setCurrentPageNo(searchContact.getCurrentPageNo());
		// 한 페이지에 게시되는 게시물 건수
		searchContact.setRecordCountPerPage(Integer.parseInt(env.getProperty("property.pagination.recordcountperpage")));
		// 페이징 리스트의 사이즈
		searchContact.setPageSize(Integer.parseInt(env.getProperty("property.pagination.pagesize")));
		
		mav.addObject("firstIndex", searchContact.getFirstRecordIndex());
		mav.addObject("recordCountPerPage", searchContact.getRecordCountPerPage());

		List<Contact> contacts = contactService.getContacts(searchContact);
		mav.addObject("SEARCH_CONTACTS_RESULTS_KEY", contacts);
		int contactCount = contactService.getContactsCount(searchContact);
		// 전체 게시물 건 수
		searchContact.setTotalRecordCount(contactCount);

		mav.addObject("searchContact", searchContact);
		return mav;
	}

	/**
	 * Newuser form.
	 * 
	 * @param request the request
	 * @return the model and view
	 */
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newuserForm(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		Contact contact = new Contact();
		model.put("newContact", contact);

		// property, message Test
		log.debug("Locale = " + Locale.getDefault());
		log.debug("Current Locale = " + RequestContextUtils.getLocale(request).getLanguage() +"_"+RequestContextUtils.getLocale(request).getCountry());
		log.debug("Message = " + accessor.getMessage("sample.title.test", "Default Message!!"));
		log.debug("Property = " + env.getProperty("system.default.title"));

		// throw new RuntimeException();
		// throw new
		// ApplicationException(accessor.getMessage("error.system.unknownerror"),
		// new Exception());
		return new ModelAndView("sample/newContact", model);
	}

	/**
	 * Creates the.
	 * 
	 * @param contact the contact
	 * @param result the result
	 * @param status the status
	 * @param redirectAttrs the redirect attrs
	 * @return the string
	 */
	@RequestMapping(value = "/newContact", method = RequestMethod.POST)
	public String create(@ModelAttribute("newContact") @Valid Contact contact, BindingResult result, SessionStatus status, RedirectAttributes redirectAttrs) {

		validator.validate(contact, result);

		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();

			for (FieldError err : errors) {
				for (String code : err.getCodes()){
					log.debug("Codes - Code : " + code.toString());
				}
				
				log.debug((err.getObjectName() + " - " + err.getDefaultMessage()));

				log.debug("Code : " + err.getCode());
			}
			return "sample/newContact";
		}

		contactService.createContact(contact);

		status.setComplete();

		redirectAttrs.addFlashAttribute("message", "success!");
		return "redirect:showContacts.do";
	}

	/**
	 * Edits the.
	 * 
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value = "/updateContact", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id")
	int id) {
		ModelAndView mav = new ModelAndView("sample/updateContact");
		Contact contact = contactService.getContact(id);
		mav.addObject("updateContact", contact);
		return mav;
	}

	/**
	 * Update.
	 * 
	 * @param contact the contact
	 * @param result the result
	 * @param status the status
	 * @return the string
	 */
	@RequestMapping(value = "/updateContact", method = RequestMethod.POST)
	public String update(@ModelAttribute("updateContact")
	Contact contact, BindingResult result, SessionStatus status) {
		validator.validate(contact, result);
		if (result.hasErrors()) {
			return "sample/updateContact";
		}
		contactService.updateContact(contact);
		status.setComplete();

		// URI 호출시 redirect 같이 페이지 호출은 .do를 붙여서 사용.
		// ModelAndView의 View URI의 경우는 .do를 생략하여 ViewResolver가 처리
		return "redirect:showContacts.do";
	}

	/**
	 * Delete.
	 * 
	 * @param id the id
	 * @return the model and view
	 */
	@RequestMapping(value = "/deleteContact")
	public ModelAndView delete(@RequestParam("id")
	Integer id) {
		ModelAndView mav = new ModelAndView("redirect:showContacts.do");
		contactService.deleteContact(id);
		return mav;
	}

}
