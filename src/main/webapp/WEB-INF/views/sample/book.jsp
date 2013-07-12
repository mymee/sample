<%--
**********************************************
* 기능 설명 : MVC 예제 페이지
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="-1"/>
<title><spring:message code="App.Title"></spring:message></title>
</head>
<body style="font-family: Arial; font-size: smaller;">
	<center>
		<form action="searchContacts.do" method="post">
			<table style="border-collapse: collapse;" width="500" border="0"
				bordercolor="#006699">
				<tbody>
					<tr>
						<td>Enter Contact Name</td>
						<td>
							<input name="name" type="text"/>
							<input value="Search" type="submit"/>
							<input value="New Contact" onclick="javascript:go('saveContact.do');"
								type="button"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<c:if test="${empty SEARCH_CONTACTS_RESULTS_KEY}">
		</c:if>
		<c:if test="${! empty SEARCH_CONTACTS_RESULTS_KEY}">
			<c:foreach var="contact" items="${SEARCH_CONTACTS_RESULTS_KEY}">
			</c:foreach>
		</c:if>
		<table style="border-collapse: collapse;" width="500" border="1"
			bordercolor="#006699">
			<tbody>
				<tr bgcolor="lightblue">
					<th>Id</th>
					<th>Name</th>
					<th>Address</th>
					<th>Mobile</th>
					<th></th>
				</tr>
				<tr>
					<td colspan="4">No Results found</td>
				</tr>
				<tr>
					<td>
						<c:out value="${contact.id}"></c:out>
					</td>
					<td>
						<c:out value="${contact.name}"></c:out>
					</td>
					<td>
						<c:out value="${contact.address}"></c:out>
					</td>
					<td>
						<c:out value="${contact.mobile}"></c:out>
					</td>
					<td>
						<a href="updateContact.do?id=$%7Bcontact.id%7D">Edit</a> <a
							href="javascript:deleteContact('deleteContact.do?id=${contact.id}');">Delete</a>
					</td>
				</tr>
			</tbody>
		</table>
	</center>
</body>
</html>