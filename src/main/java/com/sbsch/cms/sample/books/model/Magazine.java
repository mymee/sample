/*
 * Copyright (c) SBSContentsHub.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SBSContentsHub.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SBSContentsHub.
 */
package com.sbsch.cms.sample.books.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sbsch.cms.framework.model.AbstractObject;


/**
 * The Class Magazine.
 */
@XmlRootElement
@XmlType(name = "", propOrder = { "magazineId", "category", "title", "price" })
@XmlAccessorType(XmlAccessType.NONE)
public class Magazine extends AbstractObject {

	/** The magazine id. */
	@XmlElement
	private int magazineId;

	/** The category. */
	@XmlElement
	private String category;

	/** The title. */
	@XmlElement
	private String title;

	/** The price. */
	@XmlElement
	private int price;

	/**
	 * Gets the magazine id.
	 * 
	 * @return the magazine id
	 */
	public int getMagazineId() {
		return magazineId;
	}

	/**
	 * Sets the magazine id.
	 * 
	 * @param magazineId the new magazine id
	 */
	public void setMagazineId(int magazineId) {
		this.magazineId = magazineId;
	}

	/**
	 * Gets the category.
	 * 
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 * 
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price the new price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

}
