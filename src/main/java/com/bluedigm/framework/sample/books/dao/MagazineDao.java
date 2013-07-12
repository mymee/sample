/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.books.dao;

import java.util.HashMap;

import com.bluedigm.framework.sample.books.model.Magazine;
import com.bluedigm.framework.dao.GenericDao;


/**
 * The Interface MagazineDao.
 */
public interface MagazineDao extends GenericDao<Magazine, HashMap<String, Object>> {

	/**
	 * Select magazine.
	 * 
	 * @param privaryKey the privary key
	 * @param category the category
	 * @return the magazine
	 */
	public Magazine selectMagazine(Integer privaryKey, String category);

}
