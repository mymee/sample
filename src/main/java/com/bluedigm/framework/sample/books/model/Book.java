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

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//import org.eclipse.persistence.oxm.annotations.XmlCDATA;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.bluedigm.framework.model.AbstractObject;
import com.bluedigm.framework.support.CDATAXMLAdapter;


/**
 * The Class Book.
 */
@XmlRootElement(name = "book")
@XmlType(name = "", propOrder = { "bookId", "title", "price", "email" })
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("book")
public class Book extends AbstractObject implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6445895589066749994L;

	/** The book id. */
	@XmlElement(name = "bookId")
	private long bookId;

	/** The title. */
	@NotNull
	@Length(max=10,message="{Length.book.title}")
	@XmlElement(name = "title")
	@XmlJavaTypeAdapter(value=CDATAXMLAdapter.class)  
	private String title;

	/** The price. */
	@NotNull
	@XmlElement(name = "price")
	private Integer price;

	/** The email. */
	@XmlElement(name = "email")
	private String email;
	
	/**
	 * Instantiates a new book.
	 * 
	 * @param bookId the book id
	 * @param price the price
	 */
	public Book(long bookId, Integer price) {
		this.bookId = bookId;
		this.price = price;
	}

	/**
	 * Instantiates a new book.
	 */
	public Book() {
		super();
	}

	/**
	 * Sets the book id.
	 * 
	 * @param bookId the new book id
	 */
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price the new price
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title the new title
	 */

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the book id.
	 * 
	 * @return the book id
	 */
	public long getBookId() {
		return bookId;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.framework.model.AbstractObject#toString()
	 */
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", price=" + price + ", title=" + title + "]";
	}

}
