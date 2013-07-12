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
<!-- Load Queue widget CSS and jQuery -->
<style type="text/css">@import url(<%=request.getContextPath()%>/resources/js/plupload/jquery.plupload.queue/css/jquery.plupload.queue.css);</style>
<!-- jQuery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.7.1.js"></script>
<!-- Third party script for BrowserPlus runtime (Google Gears included in Gears runtime now) -->
<script type="text/javascript" src="http://bp.yahooapis.com/2.4.21/browserplus-min.js"></script>

<!-- Load plupload and all it's runtimes and finally the jQuery queue widget -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/plupload/plupload.full.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/plupload/jquery.plupload.queue/jquery.plupload.queue.js"></script>
<script type="text/javascript">
	// Convert divs to queue widgets when the DOM is ready
	$(function() {
		$("#uploader").pluploadQueue({
			// General settings
			runtimes : 'gears,flash,silverlight,browserplus,html5',
			url : 'plupload.do',
			max_file_size : '10mb',
			chunk_size : '1mb',
			unique_names : true,

			// Resize images on clientside if we can
			resize : {
				width : 320,
				height : 240,
				quality : 90
			},

			// Specify what files to browse for
			filters : [ {
				title : "All files",
				extensions : "*"
			}, {
				title : "Image files",
				extensions : "jpg,gif,png"
			}, {
				title : "Zip files",
				extensions : "zip"
			} ],

			// Flash settings
			flash_swf_url : '/resources/js/plupload/plupload.flash.swf',

			// Silverlight settings
			silverlight_xap_url : '/resources/js/plupload/plupload.silverlight.xap'
		});

		// Client side form validation
		$('form').submit(function(e) {
	        var uploader = $('#uploader').pluploadQueue();

	        // Files in queue upload them first
	        if (uploader.files.length > 0) {
	            // When all files are uploaded submit form
	            uploader.bind('StateChanged', function() {
	                if (uploader.files.length === (uploader.total.uploaded + uploader.total.failed)) {
	                    $('form')[0].submit();
	                }
	            });
	                
	            uploader.start();
	        } else {
	            alert('You must queue at least one file.');
	        }

	        return false;
	    });
	});
</script>
</head>
<body>
	<form method="post" action="plupload.do">
		<h4>Upload form</h4>
		<div id="uploader">
			<p>You browser doesn't have Flash, Silverlight, Gears, BrowserPlus or
				HTML5 support.</p>
		</div>
		<br style="clear: both" />
		<input type="submit" value="Send" />
	</form>
</body>
</html>