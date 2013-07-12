/*
 * Copyright (c) Bluedigm.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Bluedigm.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Bluedigm.
 */
package com.bluedigm.framework.sample.support.pagination;

/**
 * <pre>
 * com.bluedigm.sample.support.pagination
 * 		|_ImagePaginationRenderer.java
 * TODO Javadoc주석작성
 * </pre>
 * 
 * @author Hanwoong Lee, Bluedigm
 * @date 2013. 4. 24. 오전 9:41:09
 * @version $Id$
 */
public class ImagePaginationRenderer extends AbstractPaginationRenderer {

	/**
	 * Instantiates a new image pagination renderer.
	 */
	public ImagePaginationRenderer() {
		firstPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">{2}... </a>&#160;";
		previousPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\"><img src=\"{2}/resources/images/common/btn_paging_pre.gif\" border=\"0\" alt=\"Prev\"/></a>&#160;";
		currentPageLabel = "<strong>{0}</strong>&#160;";
		otherPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\">{2}</a>&#160;";
		nextPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\"><img src=\"{2}/resources/images/common/btn_paging_next.gif\" border=\"0\" alt=\"Next\"/></a>&#160;";
		lastPageLabel = "<a href=\"#\" onclick=\"{0}({1}); return false;\"> ...{2}</a>&#160;";
	}

	/**
	 * <pre>
	 * 1. 개요       :
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : main
	 * @date : 2013. 4. 24.
	 * @autor : Hanwoong Lee, Bluedigm
	 * @history :
	 *          ----------------------------------------------------------------
	 *          ------- 변경일 작성자 변경내용
	 *          --------------------------------------------
	 *          --------------------------- 2013. 4. 24. Hanwoong Lee, Bluedigm
	 *          최초작성
	 *          ------------------------------------------------------------
	 *          -----------
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
