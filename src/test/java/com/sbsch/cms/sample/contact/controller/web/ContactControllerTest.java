package com.sbsch.cms.sample.contact.controller.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbsch.cms.framework.testing.WebBaseTestCase;
import com.sbsch.cms.sample.contact.model.Contact;


/**
 * Contact Controller TestUnit
 *
 * @author Han-Woong Lee, Bluedigm
 * @date 2012. 3. 27. 오후 2:36:17
 * @version $Id: ContactControllerTest.java 3156 2012-06-07 02:48:53Z mymee $
 */
@Ignore
public class ContactControllerTest extends WebBaseTestCase {

	ObjectMapper mapper = new ObjectMapper();

	@Ignore
	public void test() throws Exception {
		Contact contact = new Contact();
		contact.setId(999999);
		contact.setName("TEST");
		contact.setGender("F");
		contact.setDob(new Date());
		contact.setPhone("123123123");
		contact.setMobile("321321321");
		contact.setEmail("test@test.com");
		contact.setAddress("테스트시 테스트동");

		mockMvc.perform(
				post("/contact/newContact")
					.param("id", Integer.toString(contact.getId()))
					.param("Name", contact.getName())
					.param("Gender", contact.getGender())
					.param("Dob", new SimpleDateFormat("dd-MM-yyyy").format(contact.getDob()))
					.param("Phone", contact.getPhone())
					.param("Mobile", contact.getMobile())
					.param("Email", contact.getEmail())
					.param("Address", contact.getAddress())
					.characterEncoding("UTF-8"))
				.andExpect(status().isOk()).andExpect(view().name("redirect:showContacts.do"));
		
//		mockMvc.perform(get("/contact/showContacts").characterEncoding("UTF-8")).andExpect(status().isOk())
//				.andExpect(view().name("sample/showContacts"));
		
		contact.setName("TEST UPDATE");
		contact.setMobile("99999999");
		contact.setAddress("테스트시 업데이트");
		
		mockMvc.perform(
				post("/contact/updateContact")
					.param("id", Integer.toString(contact.getId()))
					.param("Name", contact.getName())
					.param("Gender", contact.getGender())
					.param("Dob", new SimpleDateFormat("dd-MM-yyyy").format(contact.getDob()))
					.param("Phone", contact.getPhone())
					.param("Mobile", contact.getMobile())
					.param("Email", contact.getEmail())
					.param("Address", contact.getAddress())
					.characterEncoding("UTF-8"))
				.andExpect(status().isOk()).andExpect(view().name("redirect:showContacts.do"));

//		mockMvc.perform(get("/contact/showContacts").characterEncoding("UTF-8")).andExpect(status().isOk())
//		.andExpect(view().name("sample/showContacts"));
//		
//		mockMvc.perform(get("/contact/deleteContact").param("id", Integer.toString(contact.getId())).characterEncoding("UTF-8")).andExpect(status().isOk())
//		.andExpect(view().name("redirect:showContacts.do"));
//		
//		mockMvc.perform(get("/contact/showContacts").characterEncoding("UTF-8")).andExpect(status().isOk())
//		.andExpect(view().name("sample/showContacts"));
		
	}

}
