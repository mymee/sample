/*
 * Copyright (c) SBSContentsHub.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SBSContentsHub.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SBSContentsHub.
 */
package com.sbsch.cms.sample.contact.service;

import java.util.List;

import com.sbsch.cms.sample.contact.dao.ContactDao;
import com.sbsch.cms.sample.contact.model.Contact;
import com.sbsch.cms.sample.contact.model.SearchContact;

/**
 * The Interface ContactService.
 */
public interface ContactService {

	/**
	 * Creates the contact.
	 * 
	 * @param contact the contact
	 * @return the int
	 */
	public int createContact(Contact contact);
	
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
	 * Gets the contact.
	 * 
	 * @param id the id
	 * @return the contact
	 */
	public Contact getContact(Integer id);
	
	/**
	 * Gets the contacts.
	 * 
	 * @param searchContact the search contact
	 * @return the contacts
	 */
	public List<Contact> getContacts(SearchContact searchContact);
	
	/**
	 * Gets the contacts count.
	 * 
	 * @param searchContact the search contact
	 * @return the contacts count
	 */
	public int getContactsCount(SearchContact searchContact);
	
	/**
	 * Gets the contacts.
	 * 
	 * @param name the name
	 * @return the contacts
	 */
	public List<Contact> getContacts(String name);
	
	/**
	 * Sets the contact dao.
	 * 
	 * @param contactDao the new contact dao
	 */
	public void setContactDao(ContactDao contactDao);
	
}
