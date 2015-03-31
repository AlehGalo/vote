<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en">
<!--<![endif]-->
<script type="text/javascript" src="jquery-2.1.3.min.js"></script>
<head>
<style type="text/css">
.imagesDivClass {
	height: 450px;
	width: 600px;
	overflow: scroll;
}

.imageSelectedDivClass {
	border: 2px;
	border-color: gray;
}
</style>
<title>Voting</title>
</head>
<body>
	<form action="/vote/selectImage" method="post">
		<%
			out.println("<input type='hidden' name='viewer_id' id='viewer_id' value='"
					+ session.getAttribute("viewer_id") + "' />");
		%>
		<div id='imagesDiv' class="imagesDivClass"></div>
		<script src="http://vk.com/js/api/xd_connection.js?2"
			type="text/javascript"></script>

		<script type="text/javascript">
			VK
					.init(function() {
						VK.callMethod("setTitle", 'DemoApp');
						var viewerIdVar = $('#viewer_id').val();
						VK
								.api(
										'photos.get',
										{
											uids : viewerIdVar,
											album_id : 'wall'
										},
										function(data) {
											if (data.error) {
												alert(data.error);
											}
											if (data.response) {
												$.each(data.response,
																function(key,
																		srcObject) {
																	$('#imagesDiv').append("<div class='imageSelectedDivClass'></div>");
																	$('.imageSelectedDivClass').last().append('<input type="checkbox" name="imageCheckBoxName" value="' + srcObject.src + '">')
																			.append('<img id="theImg" src="' + srcObject.src + '" />');
																});
											}
										});
					});
		</script>
		<input type="submit">
	</form>
</body>
</html>