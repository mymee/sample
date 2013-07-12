/*
 * Copyright (c) SBSContentsHub.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SBSContentsHub.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SBSContentsHub.
 */
package com.sbsch.cms.sample.books.dao.impl;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.sbsch.cms.framework.dao.impl.GenericDaoImpl;
import com.sbsch.cms.sample.books.dao.MagazineDao;
import com.sbsch.cms.sample.books.model.Magazine;


/**
 * The Class MagazineDaoImpl.
 */
@Repository
public class MagazineDaoImpl extends GenericDaoImpl<Magazine, HashMap<String, Object>> implements MagazineDao {

	/* (non-Javadoc)
	 * @see com.sbsch.cms.sample.books.dao.MagazineDao#selectMagazine(java.lang.Integer, java.lang.String)
	 */
	@Override
	public Magazine selectMagazine(Integer primaryKey, String category) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("magazineId", primaryKey);
		map.put("category", category);

		return (Magazine) selectOne("common.sample.dao.Book.selectMagazine", (Object) map);
	}

}
