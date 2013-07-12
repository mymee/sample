/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */

package com.bluedigm.framework.sample.books.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bluedigm.framework.sample.books.dao.BookDao;
import com.bluedigm.framework.sample.books.dao.MagazineDao;
import com.bluedigm.framework.sample.books.model.Book;
import com.bluedigm.framework.sample.books.model.Magazine;
import com.bluedigm.framework.sample.books.service.BookService;
import com.bluedigm.framework.database.DataSource;
import com.bluedigm.framework.database.DataSourceType;


/**
 * The Class BookServiceImpl.
 */
@Service
public class BookServiceImpl implements BookService {

	/** The book dao. */
	@Autowired
	private BookDao bookDao;

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.books.service.BookService#setBookDao(com.bluedigm.sample.books.dao.BookDao)
	 */
	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	/** The magazine dao. */
	@Autowired
	private MagazineDao magazineDao;

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.books.service.BookService#createBook(com.bluedigm.sample.books.model.Book)
	 */
	@Override
	public void createBook(Book book) {
		bookDao.insertBook(book);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.books.service.BookService#modifyBook(com.bluedigm.sample.books.model.Book)
	 */
	@Override
	@CachePut(value = "books", key = "#book.bookId")
	public void modifyBook(Book book) {
		bookDao.updateBook(book);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.books.service.BookService#removeBook(long)
	 */
	@Override
	@CacheEvict(value = "books", key = "#key")	
	public void removeBook(long key) {
		bookDao.deleteBook(key);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.books.service.BookService#getBook(long)
	 */
	@Override
	@Cacheable(value = "books", key = "#key")
	@DataSource(DataSourceType.FIRST)
	public Book getBook(long key) {
		return bookDao.selectBook(key);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.books.service.BookService#getBook(com.bluedigm.sample.books.model.Book)
	 */
	@Override
	public List<Book> getBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.selectBook(book);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.books.service.BookService#getBookList()
	 */
	@Override
	public List<Book> getBookList() {
		return bookDao.selectBookList();
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.books.service.BookService#getMagazine(java.lang.Integer, java.lang.String)
	 */
	@Override
	public Magazine getMagazine(Integer magazineId, String category) {
		return magazineDao.selectMagazine(magazineId, category);
	}

}
