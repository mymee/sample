/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */

package com.bluedigm.framework.sample.books.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bluedigm.framework.sample.books.dao.BookDao;
import com.bluedigm.framework.sample.books.model.Book;
import com.bluedigm.framework.dao.impl.GenericDaoImpl;


/**
 * The Class BookDaoImpl.
 */
@Repository
public class BookDaoImpl extends GenericDaoImpl<Book, BigInteger> implements BookDao {

	/* (non-Javadoc)
	 * @see com.sbsch.cms.sample.books.dao.BookDao#selectBook(long)
	 */
	@Override
	public Book selectBook(long key) {

		// return (Book) super.getSqlSession().selectOne("BookDAO.selectBook",
		// key);
		return (Book) selectOne("common.sample.dao.Book.selectBook", (Object) key);
	}

	/* (non-Javadoc)
	 * @see com.sbsch.cms.sample.books.dao.BookDao#selectBook(com.sbsch.cms.sample.books.model.Book)
	 */
	@Override
	public List<Book> selectBook(Book book){
		
		//return (Book) selectOne("common.sample.dao.Book.selectBookEmail",book);
		return (List<Book>)selectList("common.sample.dao.Book.selectBookEmail",book);
	}

	/* (non-Javadoc)
	 * @see com.sbsch.cms.sample.books.dao.BookDao#selectBookList()
	 */
	@Override
	public List<Book> selectBookList() {
		// return (List<Book>)
		// super.getSqlSession().selectList("BookDAO.selectBookList");
		return selectList("common.sample.dao.Book.selectBookList");
	}

	/* (non-Javadoc)
	 * @see com.sbsch.cms.sample.books.dao.BookDao#insertBook(com.sbsch.cms.sample.books.model.Book)
	 */
	@Override
	public void insertBook(Book book) {
		// super.getSqlSession().insert("BookDAO.insertBook", book);
		insert("common.sample.dao.Book.insertBook", book);
	}

	/* (non-Javadoc)
	 * @see com.sbsch.cms.sample.books.dao.BookDao#deleteBook(long)
	 */
	@Override
	public void deleteBook(long key) {
		// super.getSqlSession().delete("BookDAO.deleteBook", key);
		delete("common.sample.dao.Book.deleteBook", BigInteger.valueOf(key));
	}

	/* (non-Javadoc)
	 * @see com.sbsch.cms.sample.books.dao.BookDao#updateBook(com.sbsch.cms.sample.books.model.Book)
	 */
	@Override
	public void updateBook(Book book) {
		// super.getSqlSession().update("BookDAO.updateBook", book);
		update("common.sample.dao.Book.updateBook", book);
	}

}
