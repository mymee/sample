/*
 * Copyright (c) SBSContentsHub.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SBSContentsHub.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SBSContentsHub.
 */
package com.sbsch.cms.sample.books.dao;

import java.math.BigInteger;
import java.util.List;

import com.sbsch.cms.framework.dao.GenericDao;
import com.sbsch.cms.sample.books.model.Book;


/**
 * The Interface BookDao.
 */
public interface BookDao extends GenericDao<Book, BigInteger> {

	/**
	 * Select book.
	 * 
	 * @param key the key
	 * @return the book
	 */
	public Book selectBook(long key);

	/**
	 * Select book.
	 * 
	 * @param book the book
	 * @return the list
	 */
	public List<Book> selectBook(Book book);
	
	/**
	 * Select book list.
	 * 
	 * @return the list
	 */
	public List<Book> selectBookList();

	/**
	 * Insert book.
	 * 
	 * @param book the book
	 */
	public void insertBook(Book book);

	/**
	 * Delete book.
	 * 
	 * @param key the key
	 */
	public void deleteBook(long key);

	/**
	 * Update book.
	 * 
	 * @param book the book
	 */
	public void updateBook(Book book);

}
