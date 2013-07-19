/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.email;

import com.bluedigm.framework.util.email.MailInfo;
import com.bluedigm.framework.util.email.SendMail;
import com.bluedigm.framework.util.email.util.MailConts;


/**
 * The Class SendMailSample.
 */
public class SendMailSample {
	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		MailInfo mailInfo = new MailInfo();
		//mailInfo.setHost("192.168.10.52");
		//mailInfo.setUserName("test");
		//mailInfo.setPassword("test");				
		mailInfo.setHost("211.33.172.34");
		//mailInfo.setUserName("webmaster");
		//mailInfo.setPassword("webmaster");
		//mailInfo.setUserName("test");
		//mailInfo.setPassword("test");		
		
	
		mailInfo.setFrom("webmaster@devcenter.com");
		String[] to = new String[] { "test@test.com","test1@test.com" };
		mailInfo.setTo(to);
		mailInfo.setSubject("Mail Test Subject !!");
		mailInfo.setContent("메일 발송 테스트입니다. !!!12345 1111");
		mailInfo.addAttachFile("Z:/TestReport/11st/Running_Vusers.csv");
		mailInfo.setContentType(MailConts.CONTENT_TYPE_TEXT);
		// mailInfo.addAttachFile("D:/HUG.C/SQL/Oracle10g/40.Create_Procedure/9A.SPSP/jsys.spsp_gc.sql");
		SendMail sendmail = new SendMail(mailInfo);
		sendmail.sendMail();
	}

	// 쓰레드를 통한 대량 발송 예제
	// public static void main(String[] args) {
	//
	// SendMailUtil email = new SendMailUtil("192.168.10.52",
	// "administrator@mail.test.co.kr", "Mail Test!!", "Mail Test !!");
	// //email.setCc("test@gmail.com; test@mail.test.co.kr ");
	// email.sendMail();
	//
	// Thread.sleep(1000);
	// }

}// end
