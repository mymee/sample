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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<title><spring:message code="App.Title"></spring:message></title>
<script type="text/javascript">
	window.onload = function() {
	}
</script>
</head>
<body>
	<h1>File Upload Form</h1>
	<br />
	<form:form commandName="FORM" enctype="multipart/form-data" method="POST">
		<table>
			<tr>
				<td colspan="2" style="color: red;">
					<form:errors path="*" cssStyle="color : red;" />
					${errors}
				</td>
			</tr>
			<tr>
				<td>Name :</td>
				<td>
					<form:input type="file" path="file" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Upload File" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>