/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */

package com.bluedigm.framework.sample.books.service;

import java.util.List;

import com.bluedigm.framework.sample.books.dao.BookDao;
import com.bluedigm.framework.sample.books.model.Book;
import com.bluedigm.framework.sample.books.model.Magazine;


/**
 * The Interface BookService.
 */
public interface BookService {

	/**
	 * Creates the book.
	 * 
	 * @param book the book
	 */
	public void createBook(Book book);

	/**
	 * Modify book.
	 * 
	 * @param book the book
	 */
	public void modifyBook(Book book);

	/**
	 * Removes the book.
	 * 
	 * @param key the key
	 */
	public void removeBook(long key);

	/**
	 * Gets the book.
	 * 
	 * @param key the key
	 * @return the book
	 */
	public Book getBook(long key);

	/**
	 * Gets the book.
	 * 
	 * @param book the book
	 * @return the book
	 */
	public List<Book> getBook(Book book);

	/**
	 * Gets the book list.
	 * 
	 * @return the book list
	 */
	public List<Book> getBookList();

	/**
	 * Gets the magazine.
	 * 
	 * @param magazineId the magazine id
	 * @param category the category
	 * @return the magazine
	 */
	public Magazine getMagazine(Integer magazineId, String category);

	/**
	 * Sets the book dao.
	 * 
	 * @param bookDao the new book dao
	 */

	public void setBookDao(BookDao bookDao);

}
