/*
 * Copyright (c) SBSContentsHub.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SBSContentsHub.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SBSContentsHub.
 */
package com.sbsch.cms.sample.contact.dao;

import java.util.List;

import com.sbsch.cms.framework.dao.GenericDao;
import com.sbsch.cms.sample.contact.model.Contact;
import com.sbsch.cms.sample.contact.model.SearchContact;

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
