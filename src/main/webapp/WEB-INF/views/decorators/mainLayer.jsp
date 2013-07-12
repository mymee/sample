<%--
**********************************************
* 기능 설명 : 파일업로드 예제 페이지
* 기능 프로세스 : UIID-[###]
* 보안(ROLE) : ROLE_USER
**********************************************
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<title><decorator:title default="SBSContentsHub" /></title>
<!-- Common CSS -->
<link href="<%=request.getContextPath()%>/resources/css/common.css"	rel="stylesheet" type="text/css"/>
<!-- jQuery CSS -->
<link href="<%=request.getContextPath()%>/resources/css/jquery-theme/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css"/>
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<!-- jQuery Validate -->
<script src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"	type="text/javascript" ></script>
<script src="<%=request.getContextPath()%>/resources/js/additional-methods.js" type="text/javascript" ></script>
<!-- jQuery datePicker -->
<script	src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.10.2.custom.min.js"	type="text/javascript" ></script>
<decorator:head />
<!-- page script -->
</head>
<body onload="<decorator:getProperty property="body.onload" />">
	<div id="wrapbox">
		<div id="top">
			<!-- START:TOP Area -->
			<page:applyDecorator name="_top" />
			<!-- END:TOP Area -->
		</div>
		<div id="menu">
			<!-- START:LEFT Area -->
			<page:applyDecorator name="_left" />
			<!-- END:LEFT Area -->
		</div>
		<div id="content">
			<!-- START:MAIN Area -->
			<decorator:body />
			<!-- END:MAIN Area -->
		</div>
		<div id="footer">
			<!-- START:BOTTOM Area -->
			<page:applyDecorator name="_bottom" />
			<!-- END:BOTTOM Area -->
		</div>
	</div>
</body>
</html>