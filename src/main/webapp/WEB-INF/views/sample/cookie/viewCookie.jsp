<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요청과 함께 쿠키가 전송되는지 확인</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 1) {
		int length = cookies.length;
		for (int i = 0; i < length; i++) {
%>
			<%=cookies[i].getName() %>=<%=URLDecoder.decode(cookies[i].getValue(), "UTF-8") %><br />
<%			
		}
	}
%>
<a href="<%=request.getContextPath()%>/cookie/createCookie.do">쿠키생성</a><br />
<a href="<%=request.getContextPath()%>/cookie/deleteCookie.do">쿠키삭제</a><br />
<a href="<%=request.getContextPath()%>/cookie/viewCookie.do">쿠키보기</a>
</body>
</html>