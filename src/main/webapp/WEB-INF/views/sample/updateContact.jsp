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
<title><spring:message code="App.Title"></spring:message></title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
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
	$(document).ready(function() {
		$("#contactForm").validate();
		$("#dob").datepicker({
			dateFormat : 'dd-mm-yy'
		});
	});
</script>
</head>
<body style="font-family: Arial; font-size: smaller;">
	<table style="border-collapse: collapse;" bgcolor="lightblue"
		border="1" bordercolor="#006699">
		<tbody>
			<tr>
				<td align="center">
					<h3>Edit Contact Form</h3>
				</td>
			</tr>
			<tr valign="top" align="center">
				<td align="center"><form:form action="updateContact.do"
						method="post" modelAttribute="updateContact" id="contactForm">
						<form:errors path="*" cssClass="errorblock" element="div" />
						<table style="border-collapse: collapse;" width="500" border="0"
							bordercolor="#006699" cellpadding="2" cellspacing="2">
							<tbody>
								<tr>
									<td width="100" align="right">Id</td>
									<td width="150"><form:input path="id" readonly="true"></form:input>
									</td>
									<td align="left"><form:errors path="id" cssClass="error"></form:errors>
									</td>
								</tr>
								<tr>
									<td width="100" align="right">Name</td>
									<td><form:input path="name" cssClass="required"
											minlength="2"></form:input></td>
									<td align="left"><form:errors path="name" cssClass="error"></form:errors>
									</td>
								</tr>
								<tr>
									<td width="100" align="right">Date</td>
									<td><form:input path="dob"></form:input></td>
									<td align="left"><form:errors path="dob" cssClass="error"></form:errors>
									</td>
								</tr>
								<tr>
									<td width="100" align="right">Gender</td>
									<td><form:select path="gender">
											<form:option value="M" label="Male"></form:option>
											<form:option value="F" label="Female"></form:option>

										</form:select></td>
									<td></td>
								</tr>
								<tr>
									<td width="100" align="right">Address</td>
									<td><form:input path="address"></form:input></td>
									<td align="left"><form:errors path="address"
											cssClass="error"></form:errors></td>
								</tr>
								<tr>
									<td width="100" align="right">Email</td>
									<td><form:input path="email" cssClass="required email"></form:input>
									</td>
									<td align="left"><form:errors path="email"
											cssClass="error"></form:errors></td>
								</tr>
								<tr>
									<td width="100" align="right">Mobile</td>
									<td><form:input path="mobile" cssClass="number"></form:input>
									</td>
									<td align="left"><form:errors path="mobile"
											cssClass="error"></form:errors></td>
								</tr>
								<tr valign="bottom">
									<td colspan="3" align="center"><input value="Delete"
										onclick="javascript:deleteContact('deleteContact.do?id=${updateContact.id}');"
										type="button"/> <input name="" value="Save"
											type="submit"/> <input value="Back"
												onclick="javascript:go('showContacts.do');" type="button"/></td>
								</tr>
							</tbody>
						</table>
					</form:form></td>
			</tr>
		</tbody>
	</table>
</body>
</html>