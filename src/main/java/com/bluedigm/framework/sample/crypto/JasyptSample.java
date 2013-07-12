/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.crypto;

import org.jasypt.digest.config.SimpleDigesterConfig;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimplePBEConfig;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.salt.SaltGenerator;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;


/**
 * <pre>
 * com.bluedigm.sample.crypto
 * 		|_JasyptSample.java
 * Jasypt Lib Sample
 * </pre>
 * 
 * @author Han-Woong Lee, Bluedigm
 * @date 2013. 4. 2. 오전 11:42:38
 * @version $Id$
 */
public class JasyptSample {

	/**
	 * <pre>
	 * 1. 개요       : Jasypt 암복호화
	 * 2. 처리내용 : Jasypt 라이브러리를 이용한 암복호화 예제
	 * </pre>
	 * 
	 * @Method Name : main
	 * @date : 2013. 4. 2.
	 * @autor : Han-Woong Lee, Bluedigm
	 * @history :
	 *          ----------------------------------------------------------------
	 *          ------- 변경일 작성자 변경내용
	 *          --------------------------------------------
	 *          --------------------------- 2013. 4. 2. Han-Woong Lee, Bluedigm
	 *          최초작성
	 *          ------------------------------------------------------------
	 *          -----------
	 * @param args
	 */
	public static void main(String[] args) {

		String userPassword = "helloworld";
		
		SaltGenerator saltGenerator = new RandomSaltGenerator();
	    saltGenerator.generateSalt(32);

		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(userPassword);
		if (passwordEncryptor.checkPassword(userPassword, encryptedPassword)) {
			System.out.printf("True : %s\n",encryptedPassword);
		} else {
			System.out.printf("False : %s\n",encryptedPassword);
		}

		StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
		encryptedPassword = strongPasswordEncryptor.encryptPassword(userPassword);
		if (strongPasswordEncryptor.checkPassword(userPassword, encryptedPassword)) {
			System.out.printf("True : %s\n",encryptedPassword);
		} else {
			System.out.printf("False : %s\n",encryptedPassword);
		}

		SimpleDigesterConfig simpleDigesterConfig = new SimpleDigesterConfig();
//		DIGEST ALGORITHMS:   [MD2, MD5, SHA, SHA-256, SHA-384, SHA-512]
		simpleDigesterConfig.setAlgorithm("SHA-512");
		simpleDigesterConfig.setSaltGenerator(saltGenerator);
		simpleDigesterConfig.setSaltSizeBytes(8);
		simpleDigesterConfig.setInvertPositionOfPlainSaltInEncryptionResults(false);
		
		ConfigurablePasswordEncryptor configurablePasswordEncryptor = new ConfigurablePasswordEncryptor();
		configurablePasswordEncryptor.setPlainDigest(true);
		configurablePasswordEncryptor.setConfig(simpleDigesterConfig);
		
		encryptedPassword = configurablePasswordEncryptor.encryptPassword(userPassword);
		if (configurablePasswordEncryptor.checkPassword(userPassword, encryptedPassword)) {
			System.out.printf("True : %s\n",encryptedPassword);
		} else {
			System.out.printf("False : %s\n",encryptedPassword);
		}

		String myEncryptionPassword = userPassword;
		String myText = "Encrypt Sample Text!";
		
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		textEncryptor.setPassword(myEncryptionPassword);
		String myEncryptedText = textEncryptor.encrypt(myText);
		System.out.printf("Encrypt Text : %s\n",myEncryptedText);
		String plainText = textEncryptor.decrypt(myEncryptedText);
		System.out.printf("Decrypt Text : %s\n",plainText);
		
		StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor();
		strongTextEncryptor.setPassword(myEncryptionPassword);
		myEncryptedText = strongTextEncryptor.encrypt(myText);
		System.out.printf("Encrypt Text : %s\n",myEncryptedText);
		plainText = strongTextEncryptor.decrypt(myEncryptedText);
		System.out.printf("Decrypt Text : %s\n",plainText);
		
		StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
		standardPBEStringEncryptor.setPassword(myEncryptionPassword);                     // we HAVE TO set a password
		standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndTripleDES");    // optionally set the algorithm
		myEncryptedText = standardPBEStringEncryptor.encrypt(myText);
		System.out.printf("Encrypt Text : %s\n",myEncryptedText);
		plainText = standardPBEStringEncryptor.decrypt(myEncryptedText);  // myText.equals(plainText)
		System.out.printf("Decrypt Text : %s\n",plainText);
		

		SimplePBEConfig simplePBEConfig = new SimplePBEConfig(); 
		simplePBEConfig.setSaltGenerator(saltGenerator);
//		DIGEST ALGORITHMS:   [MD2, MD5, SHA, SHA-256, SHA-384, SHA-512]
//		PBE ALGORITHMS:      [PBEWITHMD5ANDDES, PBEWITHMD5ANDTRIPLEDES, PBEWITHSHA1ANDDESEDE, PBEWITHSHA1ANDRC2_40]
		simplePBEConfig.setAlgorithm("PBEWITHMD5ANDTRIPLEDES");
		simplePBEConfig.setKeyObtentionIterations(1000);
		simplePBEConfig.setPassword(userPassword);
		
		PooledPBEStringEncryptor pooledPBEStringEncryptor = new PooledPBEStringEncryptor();
		pooledPBEStringEncryptor.setPoolSize(4);          // This would be a good value for a 4-core system
//		pooledPBEStringEncryptor.setPassword(myEncryptionPassword);
//		pooledPBEStringEncryptor.setAlgorithm("PBEWithMD5AndTripleDES");
		pooledPBEStringEncryptor.setConfig(simplePBEConfig);
		pooledPBEStringEncryptor.initialize();
			
		myEncryptedText = pooledPBEStringEncryptor.encrypt(myText);
		System.out.printf("Encrypt Text : %s\n",myEncryptedText);
		plainText = pooledPBEStringEncryptor.decrypt(myEncryptedText);
		System.out.printf("Decrypt Text : %s\n",plainText);
		
//		plainText = pooledPBEStringEncryptor.decrypt("q9g31Fl7XF5hbhEz81Tpwo+KNI7324MyLciVGMFDf+o=");
//		System.out.printf("Decrypt Text : %s\n",plainText);
//		
//		plainText = pooledPBEStringEncryptor.decrypt("zfUexffeTygTKgjWA0O21of3Zjuj+w/AIBf8gcrry3k=");
//		System.out.printf("Decrypt Text : %s\n",plainText);
	}

}
