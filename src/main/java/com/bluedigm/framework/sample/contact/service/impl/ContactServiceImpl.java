/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.contact.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluedigm.framework.sample.contact.dao.ContactDao;
import com.bluedigm.framework.sample.contact.model.Contact;
import com.bluedigm.framework.sample.contact.model.SearchContact;
import com.bluedigm.framework.sample.contact.service.ContactService;

/**
 * The Class ContactServiceImpl.
 */
@Service
public class ContactServiceImpl implements ContactService {

	/** The contact dao. */
	//@Resource
	private ContactDao contactDao;

	/**
	 * Gets the contact dao.
	 * 
	 * @return the contact dao
	 */
	public ContactDao getContactDao() {
		return contactDao;
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.service.ContactService#setContactDao(com.bluedigm.sample.contact.dao.ContactDao)
	 */
	@Autowired
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	/**
	 * Instantiates a new contact service impl.
	 */
	public ContactServiceImpl(){
		
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.service.ContactService#createContact(com.bluedigm.sample.contact.model.Contact)
	 */
	@Override
	@Transactional
	public int createContact(Contact contact) {
		return contactDao.insertContact(contact);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.service.ContactService#updateContact(com.bluedigm.sample.contact.model.Contact)
	 */
	@Override
	@Transactional
	@CacheEvict(value = "contact", key = "#contact.id")	
	public int updateContact(Contact contact) {
		return contactDao.updateContact(contact);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.service.ContactService#deleteContact(java.lang.Integer)
	 */
	@Override
	@Transactional
	@CacheEvict(value = "contact", key = "#id")	
	public int deleteContact(Integer id) {
		return contactDao.deleteContact(id);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.service.ContactService#getContact(java.lang.Integer)
	 */
	@Override
	@Cacheable(value = "contact", key = "#id")
	public Contact getContact(Integer id) {
		return contactDao.selectContact(id);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.service.ContactService#getContacts(com.bluedigm.sample.contact.model.SearchContact)
	 */
	@Override
	public List<Contact> getContacts(SearchContact searchContact) {
		return contactDao.selectContactList(searchContact);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.service.ContactService#getContactsCount(com.bluedigm.sample.contact.model.SearchContact)
	 */
	@Override
	public int getContactsCount(SearchContact searchContact) {
		return contactDao.selectContactCount(searchContact);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.service.ContactService#getContacts(java.lang.String)
	 */
	@Override
	public List<Contact> getContacts(String name) {
		return contactDao.selectContactList(name);
	}

}
