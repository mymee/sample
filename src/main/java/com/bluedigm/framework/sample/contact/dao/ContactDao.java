/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.contact.dao;

import java.util.List;

import com.bluedigm.framework.sample.contact.model.Contact;
import com.bluedigm.framework.sample.contact.model.SearchContact;
import com.bluedigm.framework.dao.GenericDao;

/**
 * The Interface ContactDao.
 */
public interface ContactDao extends GenericDao<Contact, Integer> {

	/**
	 * Insert contact.
	 * 
	 * @param contact the contact
	 * @return the int
	 */
	public int insertContact(Contact contact);
	
	/**
	 * Update contact.
	 * 
	 * @param contact the contact
	 * @return the int
	 */
	public int updateContact(Contact contact);
	
	/**
	 * Delete contact.
	 * 
	 * @param id the id
	 * @return the int
	 */
	public int deleteContact(Integer id);
	
	/**
	 * Select contact.
	 * 
	 * @param id the id
	 * @return the contact
	 */
	public Contact selectContact(Integer id);
	
	/**
	 * Select contact list.
	 * 
	 * @param searchContact the search contact
	 * @return the list
	 */
	public List<Contact> selectContactList(SearchContact searchContact);
	
	/**
	 * Select contact count.
	 * 
	 * @param searchContact the search contact
	 * @return the int
	 */
	public int selectContactCount(SearchContact searchContact);
	
	/**
	 * Select contact list.
	 * 
	 * @param name the name
	 * @return the list
	 */
	public List<Contact> selectContactList(String name);
	
}
