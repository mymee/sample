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

import java.text.MessageFormat;

import com.bluedigm.framework.web.ui.pagination.PaginationInfo;
import com.bluedigm.framework.web.ui.pagination.PaginationRenderer;

/**
 * <pre>
 * com.sbsch.cms.sample.support.pagination
 * 		|_AbstractPaginationRenderer.java
 * 리스트화면 페이지 네비게이션 처리
 * </pre>
 *
 * @author Hanwoong Lee, Bluedigm
 * @date 2013. 4. 24. 오전 9:52:37
 * @version $Id$
 */
public class AbstractPaginationRenderer implements PaginationRenderer {

	/** The first page label. */
	public String firstPageLabel;
	
	/** The previous page label. */
	public String previousPageLabel;
	
	/** The current page label. */
	public String currentPageLabel;
	
	/** The other page label. */
	public String otherPageLabel;
	
	/** The next page label. */
	public String nextPageLabel;
	
	/** The last page label. */
	public String lastPageLabel;

	/* (non-Javadoc)
	 * @see com.bluedigm.framework.web.ui.pagination.PaginationRenderer#renderPagination(com.bluedigm.framework.web.ui.pagination.PaginationInfo, java.lang.String)
	 */
	public String renderPagination(PaginationInfo paginationInfo,String jsFunction){
		
		StringBuffer strBuff = new StringBuffer();
        
		String servletContextRoot = paginationInfo.getServletContextRoot();
        int firstPageNo = paginationInfo.getFirstPageNo();
        int firstPageNoOnPageList = paginationInfo.getFirstPageNoOnPageList();
        int totalPageCount = paginationInfo.getTotalPageCount();
		int pageSize = paginationInfo.getPageSize();
		int lastPageNoOnPageList = paginationInfo.getLastPageNoOnPageList();
		int currentPageNo = paginationInfo.getCurrentPageNo();
		int lastPageNo = paginationInfo.getLastPageNo();
		
		//if(totalPageCount > pageSize){
			if(firstPageNoOnPageList > pageSize){
				strBuff.append(MessageFormat.format(firstPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNo),servletContextRoot}));
				strBuff.append(MessageFormat.format(previousPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNoOnPageList-1),servletContextRoot}));
	        }else{
	        	strBuff.append(MessageFormat.format(firstPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNo),servletContextRoot}));
				strBuff.append(MessageFormat.format(previousPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNo),servletContextRoot}));
	        }
		//}
		
		for(int i=firstPageNoOnPageList;i<=lastPageNoOnPageList;i++){
			if(i==currentPageNo){
        		strBuff.append(MessageFormat.format(currentPageLabel,new Object[]{Integer.toString(i)}));
        	}else{
        		strBuff.append(MessageFormat.format(otherPageLabel,new Object[]{jsFunction,Integer.toString(i),Integer.toString(i)}));
        	}
        }
        
		//if(totalPageCount > pageSize){
			if(lastPageNoOnPageList < totalPageCount){
	        	strBuff.append(MessageFormat.format(nextPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNoOnPageList+pageSize),servletContextRoot}));
	        	strBuff.append(MessageFormat.format(lastPageLabel,new Object[]{jsFunction,Integer.toString(lastPageNo),servletContextRoot}));
	        }else{
	        	strBuff.append(MessageFormat.format(nextPageLabel,new Object[]{jsFunction,Integer.toString(lastPageNo),servletContextRoot}));
	        	strBuff.append(MessageFormat.format(lastPageLabel,new Object[]{jsFunction,Integer.toString(lastPageNo),servletContextRoot}));
	        }
		//}
		return strBuff.toString();
	}

}
