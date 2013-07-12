/*
 * Copyright (c) SBSContentsHub.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SBSContentsHub.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SBSContentsHub.
 */
package com.sbsch.cms.sample.fileupload.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sbsch.cms.framework.model.AbstractObject;


/**
 * The Class Upload.
 */
public class Upload  extends AbstractObject {

	/** The name. */
	private String name = null;
    
    /** The file. */
    private CommonsMultipartFile file = null;

    /**
	 * Gets the name.
	 * 
	 * @return the name
	 */
    public String getName() {
        return name;
    }
    
    /**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
    public void setName(String name) {
        this.name = name;
    }
    
    
    /**
	 * Sets the file.
	 * 
	 * @param file the new file
	 */
    public void setFile(CommonsMultipartFile file) {
        this.file = file;
        this.name = file.getOriginalFilename();
    }

	/**
	 * Gets the file.
	 * 
	 * @return the file
	 */
	public CommonsMultipartFile getFile() {
        return file;
	}
}


