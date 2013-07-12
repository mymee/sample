/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.books.controller.rest;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bluedigm.framework.sample.books.model.Book;
import com.bluedigm.framework.sample.books.model.Books;
import com.bluedigm.framework.sample.books.model.ErrorMessage;
import com.bluedigm.framework.sample.books.model.Magazine;
import com.bluedigm.framework.sample.books.service.BookService;
import com.bluedigm.framework.web.AbstractController;


/**
 * The Class BookRestController.
 */
@Controller
@RequestMapping(value = "/books")
@PropertySource("classpath:conf/property/system.properties")
public class BookRestController extends AbstractController {

	/** The book service. */
	@Autowired
	private BookService bookService;

	/** The env. */
	@Autowired
	private Environment env;

	/** The validator. */
	@Autowired
	Validator validator;

	/** The accessor. */
	@Resource
	private MessageSourceAccessor accessor;

	/**
	 * Handle exception.
	 * 
	 * @param exception the exception
	 * @param request the request
	 * @return the string
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(Exception exception, HttpServletRequest request) {

		return ClassUtils.getShortName(exception.getClass());
	}

	/**
	 * Handle method argument not valid exception.
	 * 
	 * @param error the error
	 * @return the error message
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException error) {

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setCode("1000");
		errorMessage.setMessage(accessor.getMessage("handle.system.unknownerror"));
		errorMessage.setLink("발생한 오류에 대한 참조 링크");
		errorMessage.setResource(error.getBindingResult().getNestedPath());
		
		List<FieldError> errors = error.getBindingResult().getFieldErrors();

		for (FieldError err : errors) {
			for (String code : err.getCodes()){
				log.debug(code.toString());
			}
			
			log.debug((err.getObjectName() + " - " + err.getDefaultMessage()));

			log.debug(err.getCode());
		}
		return errorMessage;
	}

	/**
	 * Gets the books.
	 * 
	 * @return the books
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Books getBooks() {

		log.debug("Non Param");

		log.debug("Locale = " + Locale.getDefault());
		log.debug("Message = " + accessor.getMessage("sample.title.test", "Default Message!!"));
		log.debug("Property = " + env.getProperty("system.default.title"));

		return new Books(bookService.getBookList());
	}

	/**
	 * Gets the books1.
	 * 
	 * @param model the model
	 * @return the books1
	 */
	@RequestMapping(params = { "format=xml", "version=1.0" }, method = RequestMethod.GET)
	public void getBooks1(ModelMap model) {
		Books books = new Books(bookService.getBookList());
		model.addAttribute(books);
		log.debug("format=xml&version=1.0");
		// property, message Test

		log.debug("Locale = " + Locale.getDefault());
		log.debug("Message = " + accessor.getMessage("sample.title.test", "Default Message!!"));
		log.debug("Property = " + env.getProperty("system.default.title"));

	}

	/**
	 * Gets the books2.
	 * 
	 * @param model the model
	 * @param format the format
	 * @return the books2
	 */
	@RequestMapping(params = { "format" }, method = RequestMethod.GET)
	public void getBooks2(ModelMap model, @RequestParam(value = "format", required = true)
	String format) {
		Books books = new Books(bookService.getBookList());
		model.addAttribute(books);
		log.debug("format = " + format);
		// property, message Test
		log.debug("Locale = " + Locale.getDefault());
		log.debug("Message = " + accessor.getMessage("sample.title.test", "Default Message!!"));
		log.debug("Property = " + env.getProperty("system.default.title"));
	}

	/**
	 * Gets the books3.
	 * 
	 * @param model the model
	 * @return the books3
	 */
	@RequestMapping(params = { "format=json", "version=1.0" }, method = RequestMethod.GET)
	public void getBooks3(ModelMap model) {
		Books books = new Books(bookService.getBookList());
		model.addAttribute(books);

		log.debug("format=json&version=1.0");
		// property, message Test

		log.debug("Locale = " + Locale.getDefault());
		log.debug("Message = " + accessor.getMessage("sample.title.test", "Default Message!!"));
		log.debug("Property = " + env.getProperty("system.default.title"));

	}

	/**
	 * Gets the book.
	 * 
	 * @param mav the mav
	 * @return the book
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView getBook(ModelAndView mav) {
		mav.setViewName("sample/ajaxSample");
		return mav;
	}

	/**
	 * Gets the book.
	 * 
	 * @param bookId the book id
	 * @return the book
	 */
	@RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
	public Book getBook(@PathVariable(value = "bookId")
	long bookId) {
		log.debug(String.valueOf(bookId));
		Book book = bookService.getBook(bookId);
		return book;
	}

	/**
	 * Gets the book.
	 * 
	 * @param email the email
	 * @return the book
	 */
	@RequestMapping(value = "/email/{email:.+}", method = RequestMethod.GET)
	public Books getBook(@PathVariable(value = "email")
	String email) {
		log.debug(email);
		Book book = new Book(12345,1000);
		book.setEmail(email);
		return new Books(bookService.getBook(book));
	}
	
	/**
	 * Creates the book.
	 * 
	 * @param response the response
	 * @param books the books
	 * @return the books
	 */

	/**
	 * Creates the book.
	 * 
	 * @param book the book
	 * @return the book
	 * @throws Exception the exception
	 */
	@RequestMapping(value="/multi", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Books createBooks(HttpServletResponse response, @RequestBody
			Books books) {
		log.debug("POST Create");
		
//        Set<ConstraintViolation<Book>> violations = validator.validate(book);
//        for(ConstraintViolation<Book> violation : violations) {
//            log.debug(("Custom Message:- " + violation.getMessage()));
//        }
		
		for ( Iterator<Book> iterator = books.getBookList().iterator(); iterator.hasNext(); ) {
			bookService.createBook((Book)iterator.next());
		}

		return books; // new Books(book);
	}
	/**
	 * Creates the book.
	 * 
	 * @param book the book
	 * @return the book
	 * @throws Exception the exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Book createBook(HttpServletResponse response, @RequestBody
			Book book) {
		log.debug("POST Create");
		
		bookService.createBook(book);
		return book; // new Books(book);
	}
	/**
	 * Modify book.
	 * 
	 * @param book the book
	 * @return the book
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Book modifyBook(@RequestBody
	Book book) {
		bookService.modifyBook(book);
		return book;
	}

	/**
	 * Removes the book.
	 * 
	 * @param bookId the book id
	 * @return the book
	 */
	@RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public Book removeBook(@PathVariable(value = "bookId")
	long bookId) {
		bookService.removeBook(bookId);
		return new Book(bookId, 0);
	}

	/**
	 * Gets the magazine.
	 * 
	 * @param magazineId the magazine id
	 * @param category the category
	 * @return the magazine
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/magazine/{magazineId}/{category}", method = RequestMethod.GET)
	public Magazine getMagazine(@PathVariable(value = "magazineId")
	Integer magazineId, @PathVariable(value = "category")
	String category) throws Exception {
		return bookService.getMagazine(magazineId, category);
	}

	/**
	 * Gets the magazine.
	 * 
	 * @return the magazine
	 */
	@RequestMapping(value = "/magazine", method = RequestMethod.GET)
	public Magazine getMagazine() {
		return bookService.getMagazine(1, "sports");
	}

	/**
	 * Gets the test.
	 * 
	 * @param map the map
	 * @return the test
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void getTest(ModelMap map) {
		log.debug("aa");
	}
}
