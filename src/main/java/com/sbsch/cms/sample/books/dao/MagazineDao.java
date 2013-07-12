/*
 * Copyright (c) SBSContentsHub.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SBSContentsHub.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SBSContentsHub.
 */
package com.sbsch.cms.sample.books.dao;

import java.util.HashMap;

import com.sbsch.cms.framework.dao.GenericDao;
import com.sbsch.cms.sample.books.model.Magazine;


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
