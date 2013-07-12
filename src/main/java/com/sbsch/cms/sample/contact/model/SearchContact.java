/*
 * Copyright (c) SBSContentsHub.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SBSContentsHub.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SBSContentsHub.
 */
package com.sbsch.cms.sample.contact.model;


import com.sbsch.cms.framework.web.ui.pagination.PaginationInfo;

/**
 * The Class SearchContact.
 */

public class SearchContact extends PaginationInfo {
	
	/** The search condition. */
	private String searchCondition;

	/** The search keyword. */
	private String searchKeyword;

	/** The search use yn. */
	private String searchUseYn;
	
	/**
	 * Gets the 검색조건.
	 * 
	 * @return the 검색조건
	 */
	public String getSearchCondition() {
		return searchCondition;
	}

	/**
	 * Sets the 검색조건.
	 * 
	 * @param searchCondition the new 검색조건
	 */
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	/**
	 * Gets the 검색Keyword.
	 * 
	 * @return the 검색Keyword
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}

	/**
	 * Sets the 검색Keyword.
	 * 
	 * @param searchKeyword the new 검색Keyword
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	/**
	 * Gets the 검색사용여부.
	 * 
	 * @return the 검색사용여부
	 */
	public String getSearchUseYn() {
		return searchUseYn;
	}

	/**
	 * Sets the 검색사용여부.
	 * 
	 * @param searchUseYn the new 검색사용여부
	 */
	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	/**
	 * Instantiates a new search contact.
	 */
	public SearchContact() {
		super();
		
//		super.setPageIndex(Integer.parseInt(env.getProperty("property.pagination.pageindex")));
//		super.setPageUnit(Integer.parseInt(env.getProperty("property.pagination.pageunit")));
//		super.setPageSize(Integer.parseInt(env.getProperty("property.pagination.pagesize")));
//		super.setFirstIndex(Integer.parseInt(env.getProperty("property.pagination.firstindex")));
//		super.setLastIndex(Integer.parseInt(env.getProperty("property.pagination.lastindex")));
//		super.setRecordCountPerPage(Integer.parseInt(env.getProperty("property.pagination.recordcountperpage")));			
	}
}
