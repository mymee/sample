package com.sbsch.cms.sample.books.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluedigm.framework.sample.books.model.Book;
import com.bluedigm.framework.sample.books.service.BookService;
import com.bluedigm.framework.testing.RestBaseTestCase;

/**
 * Book Service TestUnit
 *
 * @author Han-Woong Lee, Bluedigm
 * @date 2012. 3. 27. 오후 2:36:04
 * @version $Id: BookServiceTest.java 3802 2012-06-15 07:36:27Z mymee $
 */
public class BookServiceTest extends RestBaseTestCase{

	@Autowired
	private BookService bookService;
	//private BookDao mockedDao;
	
	private Book book;
		
	@Before
	public void setUp(){
		
		book = new Book();
		book.setBookId(-999);
		book.setPrice(12000);
		book.setTitle("Test");
		
		//mockedDao = new BookDaoImpl(); // mock(BookDao.class);
	}
	
	@Test
	public void test(){
		
		//bookService = new BookServiceImpl();
		//bookService.setBookDao(mockedDao);
		
		//doNothing().when( mockedDao ).insertBook(book);
		bookService.createBook(book);
		
		//when( mockedDao.selectBook(book.getBookId()) ).thenReturn(book);
		assertThat( bookService.getBook(book.getBookId()).getBookId(), is(book.getBookId()) );
		
		String newTitle = "UpdateTest";
		book.setTitle(newTitle);
		//doNothing().when( mockedDao ).updateBook(book);
		
		bookService.modifyBook(book);
		assertThat( bookService.getBook(book.getBookId()).getTitle(), is(newTitle) );
		
		bookService.removeBook(book.getBookId());
		//doNothing().when( mockedDao ).deleteBook(book.getBookId());
		//when( mockedDao.selectBook(book.getBookId()) ).thenReturn(null);
		
		assertNull( bookService.getBook(book.getBookId()) );
		
		
	}
}
