/*
 * Copyright (c) 2011 SK planet.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SK planet.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SK planet.
 */
package com.bluedigm.framework.sample.books.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.bluedigm.framework.sample.books.model.Book;
import com.bluedigm.framework.sample.books.model.Books;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bluedigm.framework.testing.RestBaseTestCase;

/**
 * Book Rest TestUnit
 *
 * @author Han-Woong Lee, Bluedigm
 * @date 2012. 3. 27. 오후 2:35:38
 * @version $Id: BookRestControllerTest.java 3853 2012-06-18 01:45:45Z mymee $
 */
@Ignore
public class BookRestControllerTest extends RestBaseTestCase{

	ObjectMapper mapper = new ObjectMapper();
	
	MvcResult result;
	
	@Test
	public void test() throws Exception {
		Book book = new Book();
		book.setBookId(-1);
		book.setTitle("TEST !");
		book.setPrice(1000);
		book.setEmail("test@test.co.kr");

		
		@SuppressWarnings("unused")
		String requestBody = mapper.writeValueAsString(book);
		log.debug("GET  -> SELECT------------------------------");
		
		mockMvc.perform(get("/books").characterEncoding("UTF-8"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("books"));
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(book);
		
		Books books = new Books(bookList);	
//		mapper.configure(DeserializationFeature.Feature.UNWRAP_ROOT_VALUE, true);
//		mapper.configure(SerializationFeature.Feature.WRAP_ROOT_VALUE, true);
		
		requestBody = mapper.writeValueAsString(books);
		
		log.debug("POST -> INSERT------------------------------");
		mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
		
		log.debug("GET  -> SELECT------------------------------");
		result = mockMvc.perform(get("/books/" + book.getBookId()).characterEncoding("UTF-8"))
						.andExpect(status().isOk())
						.andExpect(model().attributeExists("book"))
						.andReturn();
		
		log.debug(result.getModelAndView().getModelMap().toString());
		
		//mockMvc.perform(get("/books").param("format", "json").characterEncoding("UTF-8")).andExpect(status().isOk());
		
		book.setTitle("TEST Update !");
		book.setPrice(9999);
		requestBody = mapper.writeValueAsString(book);
		
		log.debug("PUT  -> UPDATE------------------------------");
		mockMvc.perform(put("/books").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		log.debug("GET  -> SELECT------------------------------");
		result = mockMvc.perform(get("/books/" + book.getBookId()).characterEncoding("UTF-8")).andExpect(status().isOk()).andReturn();
		
		log.debug(result.getModelAndView().getModelMap().toString());
		
		log.debug("DELETE-> DELETE------------------------------");
		mockMvc.perform(delete("/books/" + book.getBookId()).characterEncoding("UTF-8")).andExpect(status().isOk());
		//this.mockMvc.perform(get("/books").characterEncoding("UTF-8")).andExpect(status().isOk());

	}
}

