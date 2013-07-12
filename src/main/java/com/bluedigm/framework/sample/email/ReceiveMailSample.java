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

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;


/**
 * The Class ReceiveMailSample.
 */
public class ReceiveMailSample {
	
	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 * @throws Exception the exception
	 */

	public static void main(String args[]) throws Exception {
		String host = "pop.sina.com";
		String username = "hugservice@sina.com";// 您的邮箱用户名
		String password = "abc123";// 您的邮箱密码
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("pop3");
		store.connect(host, username, password);
		Folder folder = store.getDefaultFolder();// .getFolder("INBOX");
		@SuppressWarnings("unused")
		Folder[] folderList = folder.list();
		folder.open(Folder.READ_ONLY);
		Message message[] = folder.getMessages();
		System.out.println("Messages's length: " + message.length);
		// ReceiveMail pmm = null;
		// for (int i = 0; i < message.length; i++) {
		// pmm = new ReceiveMail((MimeMessage) message[i]);
		// System.out.println("Message " + i + " subject: " +
		// pmm.getSubject());//邮件主题
		// System.out.println("Message " + i + " sentdate: " +
		// pmm.getSentDate());//邮件发送日期
		// System.out.println("Message " + i + " replysign: " +
		// pmm.getReplySign());//是否需要回执
		// System.out.println("Message " + i + " hasRead: " +
		// pmm.isNew());//邮件是否已读
		// System.out.println("Message " + i + "  containAttachment: " +
		// pmm.isContainAttach((Part) message[i]));//邮件是否包含附件
		// System.out.println("Message " + i + " form: " +
		// pmm.getFrom());//发件人的地址和姓名
		// System.out.println("Message " + i + " to: " +
		// pmm.getMailAddress("to"));//邮件的收件人，抄送，和密送的地址和姓名
		// System.out.println("Message " + i + " cc: " +
		// pmm.getMailAddress("cc"));
		// System.out.println("Message " + i + " bcc: " +
		// pmm.getMailAddress("bcc"));
		// pmm.setDateFormat("yy年MM月dd日 HH:mm");
		// System.out.println("Message " + i + " sentdate: " +
		// pmm.getSentDate());
		// System.out.println("Message " + i + " Message-ID: " +
		// pmm.getMessageId());
		// pmm.getMailContent((Part) message[i]);
		// System.out.println("Message " + i + " bodycontent: \r\n" +
		// pmm.getBodyText());//获得邮件正文内容
		//
		// // pmm.setAttachPath("c:\\tmp\\coffeecat1124");
		// pmm.saveAttachMent((Part) message[i]);
		// }
		folder.close(false);
		store.close();
	}
}
