<%--
**********************************************
* 기능 설명 : AJAX 예제 화면
* 기능 프로세스 : UIID-[###]
* 보안(ROLE) : ROLE_USER
**********************************************
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="-1"/>
<title>AJAX Sample</title>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(event) {
		$("#get").click(function() {
			if (!$("#bookId").val())
				return 0;
			$.ajax({
				type : 'GET',
				url : "<%=request.getContextPath()%>/books/"
						+ $("#bookId").val() + "?format=json",
				dataType : "json",
				success : function(data, textStatus, jqXHR) {
					alert('getBook successfully: ' + textStatus);
					$("#bookId").val(data.book.bookId);
					$("#title").val(data.book.title);
					$("#price").val(data.book.price);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('getBook error: ' + textStatus);
				}
			});
		});
		$("#post").click(function() {
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "<%=request.getContextPath()%>/books",
				dataType : "json",
				data : formToJSON(),
				success : function(data, textStatus, jqXHR) {
					alert('Book created successfully');
					$("#bookId").val(data.book.bookId);
					$("#title").val(data.book.title);
					$("#price").val(data.book.price);
				},
				error : function(data,jqXHR, textStatus, errorThrown) {
					alert('data : ' + data.responseText);
					alert('addBook error: ' + textStatus + ' : ' + errorThrown );
				}
			});
		});
		$("#put").click(function() {
			$.ajax({
				type : 'PUT',
				contentType : 'application/json',
				url : "<%=request.getContextPath()%>/books",
				dataType : "json",
				data : formToJSON(),
				success : function(data, textStatus, jqXHR) {
					alert('Book updated successfully');
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('updateBook error: ' + textStatus);
				}
			});
		});
		$("#delete").click(function() {
			$.ajax({
				type : 'DELETE',
				url : "<%=request.getContextPath()%>/books/"
						+ $('#bookId').val(),
				success : function(data, textStatus, jqXHR) {
					alert('Book deleted successfully');
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('deleteBook error');
				}
			});
		});
	});
	function formToJSON() {
		var bookId = $("#bookId").val();
		return JSON.stringify({
			"bookId" : bookId == "" ? null : bookId,
			"title" : $("#title").val(),
			"price" : $("#price").val()
		});
	}
</script>
</head>
<body>
	<div style="width: 400px; font-family: Arial; font-size: 9pt;">
		<table>
			<tbody>
				<tr>
					<td colspan="2" style="padding-bottom: 10px">Ajax based sum
						calculation:</td>
				</tr>
				<tr>
					<td>bookId:</td>
					<td>
						<input id="bookId" type="text" size="10"/>
					</td>
				</tr>
				<tr>
					<td>title:</td>
					<td>
						<input id="title" type="text" size="10"/>
					</td>
				</tr>
				<tr>
					<td>price:</td>
					<td>
						<input id="price" type="text" size="10"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input id="get" type=button value="GET"/>
						<input id="post" type=button value="POST"/>
						<input id="put" type=button value="PUT"/>
						<input id="delete" type=button value="DELETE"/>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>