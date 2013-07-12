package com.sbsch.cms.sample.contact.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Date;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;


import com.sbsch.cms.framework.testing.WebBaseTestCase;
import com.sbsch.cms.sample.contact.dao.ContactDao;
import com.sbsch.cms.sample.contact.model.Contact;
import com.sbsch.cms.sample.contact.model.SearchContact;


/**
 * Contact Dao TestUnit
 *
 * @author Han-Woong Lee, Bluedigm
 * @date 2012. 3. 27. 오후 2:36:32
 * @version $Id: ContactDaoTest.java 1410 2012-05-09 07:59:08Z ksy $
 */
public class ContactDaoTest extends WebBaseTestCase{

	@Autowired
	private ContactDao contactDao;
	
	private Contact contact;
	private Contact updatedContact;
	private SearchContact searchContact;
	
	@Before
	public void setUp(){
		contact = new Contact();
		contact.setId(9999);
		contact.setName("TestUser");
		contact.setDob(new Date());
		contact.setGender("M");
		contact.setEmail("test@test.com");
		contact.setPhone("1231231234");
		contact.setMobile("123345453");
		contact.setAddress("서울");
		
		updatedContact = new Contact();
		updatedContact.setId(9999);
		updatedContact.setName("TestUser");
		updatedContact.setDob(new Date());
		updatedContact.setGender("M");
		updatedContact.setEmail("test@test.com");
		updatedContact.setPhone("1231231234");
		updatedContact.setMobile("123345453");
		updatedContact.setAddress("서울");
		
		searchContact = new SearchContact();
		searchContact.setRecordCountPerPage(10);
		searchContact.setPageSize(10);
	}
	
	@Test
	public void insertAndSelectTest(){
		
		int result = contactDao.insertContact(contact);
		
		assertThat( result, is(1) );
		
		Contact newContact = contactDao.selectContact(contact.getId());
		
		assertThat( newContact.getId(), is(contact.getId()) );	
				
	}
	
	@Test
	public void selectListTest(){
		
//		List<Contact> list = contactDao.selectContactList(searchContact);
//		
//		assertTrue( list.size() > 0 );
//		
//		list = contactDao.selectContactList("test");
//		
//		assertTrue( list.size() > 0 );
	}
	
	@Test
	public void updateTest(){
		
		int result = contactDao.insertContact(contact);		
		assertThat( result, is(1) );
				
		updatedContact.setName("UpdateUser");
		updatedContact.setDob( new Date(System.currentTimeMillis()) );
				
		result = contactDao.updateContact(updatedContact);
		
		assertThat( result, is(1) );
		
		contact = contactDao.selectContact(updatedContact.getId());
		
		assertThat( updatedContact.getId(), is(contact.getId()) );
		assertThat( updatedContact.getName(), is(contact.getName()) );
				
	}
	
	@Test(expected=EmptyResultDataAccessException.class)	
	public void deleteTest(){
		int result = contactDao.insertContact(contact);		
		assertThat( result, is(1) );
		
		result = contactDao.deleteContact( contact.getId() );
		assertThat( result, is(1) );
		
		contact = contactDao.selectContact( contact.getId() );		
	}
	
	@Test
	public void selectCountTest(){
		
		int count = contactDao.selectContactCount(searchContact);
		
		int result = contactDao.insertContact(contact);		
		assertThat( result, is(1) );
		
		assertThat( contactDao.selectContactCount(searchContact), is(count+1) );
		
	}
}
