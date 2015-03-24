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
<!-- <script src="http://vk.com/js/api/openapi.js" type="text/javascript"></script> -->
<head>
<title>Voting</title>
</head>
<body>
	<%
		out.println("<input type='hidden' name='token' id='tokenKey' value='"
				+ session.getAttribute("token") + "' />");
	%>

	<script src="http://vk.com/js/api/xd_connection.js?2"
		type="text/javascript"></script>
	<script type="text/javascript">
		VK.init(function() {
			VK.callMethod("setTitle", 'DemoApp');
			VK.api('users.get', {
				uids : '15547040'
			}, function(data) {
				if (data.error) {
					alert('error!' + data.error);
				}
				if (data.response) {
					alert('good!' + data.response);
				}
			});
		});

		function pravadostupa() {
			VK.callMethod("showSettingsBox", 8707);
		}

		function friendaddf() {
			VK.callMethod("showInviteBox");
		}
	</script>

	<!-- <div id="login_button" onclick="VK.Auth.login(authInfo);"></div>

	<script language="javascript">
		VK.init({
			apiId : 4840782
		});
		function authInfo(response) {
			if (response.session) {
				alert('user: ' + response.session.mid);
			} else {
				alert('not auth');
			}
		}
		debugger;
		VK.Auth.login((function(response) {
			debugger;
			if (response.session) {
				/* Пользователь успешно авторизовался */
				if (response.settings) {
					/* Выбранные настройки доступа пользователя, если они были запрошены */
				}
			} else {
				/* Пользователь нажал кнопку Отмена в окне авторизации */
			}
		}));
		var status = VK.Auth.getLoginStatus(authInfo);
		alert(status);
		VK.Api.call('users.get', {
			uids : 6492
		}, function(r) {
			if (r.response) {
				alert('Привет, ' + r.response[0].first_name);
			}
		}); 
	</script> -->
</body>
</html>