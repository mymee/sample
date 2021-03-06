/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.contact.dao.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.bluedigm.framework.sample.contact.dao.ContactDao;
import com.bluedigm.framework.sample.contact.model.Contact;
import com.bluedigm.framework.sample.contact.model.SearchContact;
import com.bluedigm.framework.dao.impl.GenericDaoImpl;


/**
 * The Class ContactDaoImpl.
 */
@Repository
public class ContactDaoImpl extends GenericDaoImpl<Contact, Integer> implements ContactDao {


	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.dao.ContactDao#insertContact(com.bluedigm.sample.contact.model.Contact)
	 */
	@Override
	public int insertContact(Contact contact) {
		// return super.getSqlSession().insert("Contact.insertContact",contact);
		return insert("common.sample.book.dao.Contact.insertContact", contact);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.dao.ContactDao#updateContact(com.bluedigm.sample.contact.model.Contact)
	 */
	@Override
	public int updateContact(Contact contact) {
		// return super.getSqlSession().update("Contact.updateContact",
		// contact);
		return update("common.sample.book.dao.Contact.updateContact", contact);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.dao.ContactDao#deleteContact(java.lang.Integer)
	 */
	@Override
	public int deleteContact(Integer id) {
		// return super.getSqlSession().update("Contact.deleteContact", id);
		return delete("common.sample.book.dao.Contact.deleteContact", id);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.dao.ContactDao#selectContact(java.lang.Integer)
	 */
	@Override
	public Contact selectContact(Integer id) {
		// return
		// (Contact)super.getSqlSession().selectOne("Contact.selectContact",
		// id);
		Contact contact = (Contact)selectOne("common.sample.book.dao.Contact.selectContact", (Object) id);
		if( contact == null )throw new EmptyResultDataAccessException(1);
		return contact;
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.dao.ContactDao#selectContactList(com.bluedigm.sample.contact.model.SearchContact)
	 */
	@Override
	public List<Contact> selectContactList(SearchContact searchContact) {
		// return (List<Contact>)
		// super.getSqlSession().selectList("Contact.selectContactList",
		// searchContact);
		return selectList("common.sample.book.dao.Contact.selectContactList", (Object) searchContact);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.dao.ContactDao#selectContactCount(com.bluedigm.sample.contact.model.SearchContact)
	 */
	@Override
	public int selectContactCount(SearchContact searchContact) {
		// return
		// (Integer)super.getSqlSession().selectOne("Contact.selectContactCount",
		// searchContact);
		return (Integer) selectOne("common.sample.book.dao.Contact.selectContactCount", (Object) searchContact);
	}

	/* (non-Javadoc)
	 * @see com.bluedigm.sample.contact.dao.ContactDao#selectContactList(java.lang.String)
	 */
	@Override
	public List<Contact> selectContactList(String name) {
		// return (List<Contact>)
		// super.getSqlSession().selectList("Contact.selectContactList",
		// name);
		SearchContact searchContact = new SearchContact();
		searchContact.setSearchKeyword(name);
		searchContact.setRecordCountPerPage(10);
		searchContact.setPageSize(10);		
		return selectList("common.sample.book.dao.Contact.selectContactList", (Object) searchContact);
	}

}
