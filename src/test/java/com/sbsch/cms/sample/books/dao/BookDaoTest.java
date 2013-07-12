package com.sbsch.cms.sample.books.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluedigm.framework.sample.books.dao.BookDao;
import com.bluedigm.framework.sample.books.model.Book;
import com.bluedigm.framework.testing.RestBaseTestCase;

/**
 * Book Dao TestUnit
 *
 * @author Han-Woong Lee, Bluedigm
 * @date 2012. 3. 27. 오후 2:35:51
 * @version $Id: BookDaoTest.java 3853 2012-06-18 01:45:45Z mymee $
 */
public class BookDaoTest extends RestBaseTestCase{

	@Autowired
	private BookDao bookDao;
	
	private Book book;
	
	@Before
	public void setUp(){
		book = new Book();
		book.setBookId(-999);
		book.setPrice(12000);
		book.setTitle("Test");
	}
	
	@Test
	public void insertAndSelectTest(){
		
		bookDao.insertBook(book);
		
		assertThat( bookDao.selectBook(book.getBookId()).getBookId(),  is(book.getBookId()) );
	}
	
	@Test
	public void updateTest(){
		bookDao.insertBook(book);
		
		book.setTitle("UpdateTest");
		bookDao.updateBook(book);
		
		assertThat( bookDao.selectBook(book.getBookId()).getTitle(),  is(book.getTitle()) );
	}
	
//	@Test
//	public void selectListTest(){
//		
//		List<Book> list = bookDao.selectBookList();
//		
//		assertNotNull( list );
//	}
	
	@Test
	public void deleteTest(){
		bookDao.deleteBook(book.getBookId());
		
		assertNull( bookDao.selectBook(book.getBookId()) );
	}
}
