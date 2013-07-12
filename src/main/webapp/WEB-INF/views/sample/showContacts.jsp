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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<title><spring:message code="sample.title.test"></spring:message></title>
<script type="text/javascript">
	function go(url) {
		window.location = url;
	}

	function deleteContact(url) {
		var isOK = confirm("Are you sure to delete?");
		if (isOK) {
			go(url);
		}
	}
	function linkPage(pageNo) {
		$("#currentPageNo").val(pageNo);
		$("#listForm").attr({
			action : "showContacts.do",
			method : "post"
		}).submit();
	}
	$(document).ready(function() {
		$("#search").click(function() {
			$("#currentPageNo").val(1);
			$("#listForm").attr({
				action : "showContacts.do",
				method : "post"
			}).submit();
		});
	});
</script>
</head>
<body style="font-family: Arial; font-size: smaller;">
	<center>
		<form:form modelAttribute="searchContact" id="listForm" method="post">
			<table style="border-collapse: collapse;" width="500" border="0"
				bordercolor="#006699">
				<tbody>
					<tr>
						<td>Enter Contact Name</td>
						<td>
							<form:input path="searchKeyword" />
							<input type=button id="search" value="Search"/>
							<input value="New Contact" onclick="javascript:go('newContact.do');"
								type="button"/>
						</td>
					</tr>
				</tbody>
			</table>
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
					<c:if test="${empty SEARCH_CONTACTS_RESULTS_KEY}">
						<tr>
							<td colspan="4">No Results found</td>
						</tr>
					</c:if>
					<c:if test="${! empty SEARCH_CONTACTS_RESULTS_KEY}">
						<c:forEach var="contact" items="${SEARCH_CONTACTS_RESULTS_KEY}">
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
									<a href="updateContact.do?id=${contact.id}">Edit</a> <a
										href="deleteContact.do?id=${contact.id}">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<div id="paging">
				<ui:pagination paginationInfo="${searchContact}" type="image"
					jsFunction="linkPage" />
				<form:hidden path="currentPageNo" />
			</div>
	</center>
	</form:form>
</body>
</html>