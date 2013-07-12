/*
 * Copyright (c) SBSContentsHub.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SBSContentsHub.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SBSContentsHub.
 */
package com.sbsch.cms.sample.books.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.sbsch.cms.framework.model.AbstractObject;


/**
 * The Class Books.
 */
@XmlRootElement(name = "storebooks")
//@XmlType(name = "", propOrder = { "list" })
@XmlAccessorType(XmlAccessType.NONE)
//@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.WRAPPER_OBJECT, property="storebooks")
@JsonRootName("storebooks")
public class Books extends AbstractObject implements Serializable {

	/** The Constant serialVersionUID. */
	@JsonIgnore
	private static final long serialVersionUID = 1453890509652681362L;

	/** The store name. */
	@XmlElement(name = "storeName")
	private String storeName;
	
	/** The store code. */
	@XmlElement(name = "storeCode")
	private String storeCode;
	
	/** The books. */
	@XmlElement(name = "books")
	@JsonProperty("books")
	private BookWrapper books = new BookWrapper();

	/**
	 * Instantiates a new books.
	 * 
	 * @param books the books
	 */
	public Books(List<Book> books) {
		super();
		this.storeCode = "Unknown";
		this.storeName = "Unknown";
		this.books.setBooks(books);
	}

	/**
	 * Instantiates a new books.
	 */
	public Books() {
		super();
	}

	/**
	 * Gets the store name.
	 * 
	 * @return the store name
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * Sets the store name.
	 * 
	 * @param storeName the new store name
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * Gets the store code.
	 * 
	 * @return the store code
	 */
	public String getStoreCode() {
		return storeCode;
	}

	/**
	 * Sets the store code.
	 * 
	 * @param storeCode the new store code
	 */
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	/**
	 * Gets the list.
	 * 
	 * @return the list
	 */
	public BookWrapper getBooks() {
		return books;
	}

	/**
	 * Sets the list.
	 * 
	 * @param books the new list
	 */
	public void setBooks(BookWrapper books) {
		this.books = books;
	}
	
	/**
	 * Gets the book list.
	 * 
	 * @return the book list
	 */
	@JsonIgnore
	public List<Book> getBookList(){
		
		return this.books.getBooks();
	}
}
