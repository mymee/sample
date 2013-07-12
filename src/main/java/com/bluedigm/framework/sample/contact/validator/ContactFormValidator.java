/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.contact.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bluedigm.framework.sample.contact.model.Contact;


/**
 * The Class ContactFormValidator.
 */
@Component("contactFormValidator")
public class ContactFormValidator implements Validator {
	
	/** The log. */
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(@SuppressWarnings("rawtypes")
	Class clazz) {
		return Contact.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object model, Errors errors) {
		//호출 스택을 확인하여 validate가 호출된 메소드 확인
		// 스택[0] : StackTrace 자신
		// 스택[1] : validate Method (현재 Method)
		// 스택[2] : validate를 호출한 상위 Class Method
		log.debug( Thread.currentThread().getStackTrace()[2].getClassName());
		log.debug( Thread.currentThread().getStackTrace()[2].getMethodName());
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "sample.validation.required.name", "Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "sample.validation.required.email", "email is required.");
/*
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		ValidationUtils.rejectIfEmpty(errors, "gender", "gender.required");
		ValidationUtils.rejectIfEmpty(errors, "country", "country.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aboutYou", "aboutYou.required");
*/
		Contact contact = (Contact) model;
		if (contact.getMobile().length() == 0) {
			errors.rejectValue("mobile", "sample.validation.required.mobile");
		}
	}
}