package com.sbsch.cms.sample.contact.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import com.sbsch.cms.framework.testing.WebBaseTestCase;
import com.sbsch.cms.sample.contact.dao.ContactDao;
import com.sbsch.cms.sample.contact.model.Contact;
import com.sbsch.cms.sample.contact.model.SearchContact;
import com.sbsch.cms.sample.contact.service.ContactService;
import com.sbsch.cms.sample.contact.service.impl.ContactServiceImpl;


/**
 * Contact Service TestUnit
 *
 * @author Han-Woong Lee, Bluedigm
 * @date 2012. 3. 27. 오후 2:36:46
 * @version $Id: ContactServiceTest.java 533 2012-03-27 05:40:48Z giljae $
 */
public class ContactServiceTest extends WebBaseTestCase {

	//@Autowired
	private ContactService contactService;
	private ContactDao mockedDao;

	
	private Contact contact;
	private Contact contact2;

	private SearchContact searchContact;

	@Before
	public void setUp() throws Exception {
		contact = new Contact();
		contact.setId(9999);
		contact.setName("TestUser");
		contact.setDob(new Date());
		contact.setGender("M");
		contact.setEmail("test@test.com");
		contact.setPhone("1231231234");
		contact.setMobile("123345453");
		contact.setAddress("서울");
		
		contact2 = new Contact();
		contact2.setId(1234);
		contact2.setName("NewUser");
		contact2.setDob(new Date());
		contact2.setGender("M");
		contact2.setEmail("test@test.com");
		contact2.setPhone("78907890");
		contact2.setMobile("78907890");
		contact2.setAddress("제주도");
		

		searchContact = new SearchContact();
		
		mockedDao = mock(ContactDao.class);
	}

	@After
	public void tearDown() throws Exception {
		// After
	}

	@Test(expected=EmptyResultDataAccessException.class)
	public void test() {
		
		contactService = new ContactServiceImpl();
		contactService.setContactDao(mockedDao);
		
		List<Contact> list = new ArrayList<Contact>();
		list.add(contact);
		
		when(mockedDao.selectContactList(searchContact)).thenReturn(list);						
		assertThat( contactService.getContacts(searchContact).get(0), is(contact) );
		
		when(mockedDao.insertContact(contact2)).thenReturn(1);		
		assertThat( contactService.createContact(contact2), is(1) );

		when(mockedDao.selectContact(contact2.getId())).thenReturn(contact2);
		assertThat( contactService.getContact(contact2.getId()), is(contact2) );

		contact2.setName("UPDATE");
		contact2.setPhone("999999999");
		contact2.setAddress("업데이트");
		
		when(mockedDao.updateContact(contact2)).thenReturn(1);
		assertThat( contactService.updateContact(contact2), is(1) );		
		assertThat( contactService.getContact(contact2.getId()).getName(), is(contact2.getName()) );
		

		when(mockedDao.deleteContact(contact2.getId())).thenReturn(1);
		assertTrue(contactService.deleteContact(contact2.getId()) > 0);
		
		doThrow( new EmptyResultDataAccessException(1) ).when(mockedDao).selectContact(contact2.getId());
		assertNull( contactService.getContact(contact2.getId()) );
		
	}

}
