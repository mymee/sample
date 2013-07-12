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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * The Class BookWrapper.
 */
@XmlRootElement(name = "books")
//@XmlType(name = "", propOrder = { "list" })
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName( value = "books" )
public class BookWrapper{
	
	/** The books. */
	@XmlElement(name = "book")
	@JsonSubTypes({ @Type(value = Book.class, name = "book")})
	@JsonProperty("book")
	private List<Book> books = new ArrayList<Book>();

	/**
	 * Gets the books.
	 * 
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * Sets the books.
	 * 
	 * @param books the new books
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
