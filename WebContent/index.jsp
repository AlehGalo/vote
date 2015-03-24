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
<script type="text/javascript">
/* 	$(function() {
		$
				.ajax({
					dataType :"jsonp",
				    jsonp: false,
				    jsonpCallback: "myJsonMethod",
					type : 'GET',
					url : 'https://oauth.vk.com/access_token?client_id=4840782&client_secret=kzSjX0MNswoxZfgEiI6s&v=5.29&grant_type=client_credentials',
					success : function(data) {
						debugger;
					},
					error : function() {
						alert("Sorry, I can't get the feed");
					}
				});
	}); */
</script>

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
		<input type="hidden" name="token">
	</form>
</body>
</html>