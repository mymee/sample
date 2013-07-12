/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.books.dao;

import java.math.BigInteger;
import java.util.List;

import com.bluedigm.framework.sample.books.model.Book;
import com.bluedigm.framework.dao.GenericDao;


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
