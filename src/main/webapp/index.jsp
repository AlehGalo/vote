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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Voting</title>
</head>
<body>
	<form action="/vote/vote" method="post">
		<p>
			<input type="text" name="login" value="" placeholder="Your name">
		</p>
		<p>
			<input type="color" name="favcolor" value="#ff0000">
		</p>
		<p class="remember_me">
			<label> <input type="checkbox" name="remember_me"
				id="remember_me"> CheckBox
			</label>
		</p>
		<p>
			<input type="month" name="bdaymonth">
		</p>
		<p class="submit">
			<input type="submit" name="commit" value="submit">
		</p>
		<input type="hidden" name="token"> <br /> <b><%=request.getParameter("api_url")%></b>

		<br /> <b><%=request.getParameter("api_id")%></b> <br /> <b><%=request.getParameter("api_settings")%></b>

		<br /> <b><%=request.getParameter("viewer_id")%></b> <input
			type="hidden" name="viewer_id"
			value="<%=request.getParameter("viewer_id")%>" /> <br /> <b><%=request.getParameter("sid")%></b>

		<br /> <b><%=request.getParameter("secret")%></b> <br /> <b><%=request.getParameter("access_token")%></b>
		<br /> <b><%=request.getParameter("user_id")%></b> <br /> <b><%=request.getParameter("group_id")%></b>
		<br /> <b><%=request.getParameter("is_app_user")%></b> <br /> <b><%=request.getParameter("auth_key")%></b>
		<br /> <b><%=request.getParameter("language")%></b> <br /> <b><%=request.getParameter("parent_language")%></b>
		<br /> <b><%=request.getParameter("ad_info")%></b> <br /> <b><%=request.getParameter("is_secure")%></b>
		<br /> <b><%=request.getParameter("ads_app_id")%></b> <br /> <b><%=request.getParameter("referrer")%></b>
		<br /> <b><%=request.getParameter("lc_name")%></b>

	</form>
</body>
</html>