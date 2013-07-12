/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.books.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.bluedigm.framework.model.AbstractObject;

/**
 * The Class ErrorMessage.
 */
@XmlRootElement(name = "error")
@XmlType(name = "", propOrder = { "code", "message", "link", "resource" })
@XmlAccessorType(XmlAccessType.NONE)
public class ErrorMessage extends AbstractObject {

	/** The code. */
	@XmlElement(name = "code")
	private String code;
	
	/** The message. */
	@XmlElement(name = "message")
	private String message;
	
	/** The link. */
	@XmlElement(name = "link")
	private String link;
	
	/** The resource. */
	@XmlElement(name = "resource")
	private String resource;

	/**
	 * Instantiates a new error message.
	 */
	public ErrorMessage() {
		super();
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 * 
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Sets the link.
	 * 
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Gets the resource.
	 * 
	 * @return the resource
	 */
	public String getResource() {
		return resource;
	}

	/**
	 * Sets the resource.
	 * 
	 * @param resource the new resource
	 */
	public void setResource(String resource) {
		this.resource = resource;
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.framework.model.AbstractObject#toString()
	 */
	@Override
	public String toString() {
		return "Error [code=" + code + ", message=" + message + ", link=" + link + ", resource="+ resource +"]";
	}
	
}
