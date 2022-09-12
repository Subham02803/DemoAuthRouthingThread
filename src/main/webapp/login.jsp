<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css'>
<style type="text/css">
body, html {
	height: 100%;
	background-repeat: no-repeat;
	/*background-image: linear-gradient(rgb(12, 97, 33),rgb(104, 145, 162));*/
	background: black;
	position: relative;
}

#login-box {
	position: absolute;
	top: 0px;
	left: 50%;
	transform: translateX(-50%);
	min-width: 350px;
	margin: 0 auto;
	border: 1px solid black;
	background: rgba(48, 46, 45, 1);
	min-height: 250px;
	padding: 20px;
	z-index: 9999;
}

#login-box .logo .logo-caption {
	font-family: 'Poiret One', cursive;
	color: white;
	text-align: center;
	margin-bottom: 0px;
}

#login-box .logo .tweak {
	color: #b1c900;
}

#login-box .controls {
	padding-top: 30px;
}

#login-box .controls input {
	border-radius: 0px;
	background: rgb(98, 96, 96);
	border: 0px;
	color: white;
}

#login-box .controls input:focus {
	box-shadow: none;
}

#login-box .controls input:first-child {
	border-top-left-radius: 2px;
	border-top-right-radius: 2px;
}

#login-box .controls input:last-child {
	border-bottom-left-radius: 2px;
	border-bottom-right-radius: 2px;
}

#login-box button.btn-custom {
	border-radius: 2px;
	margin-top: 8px;
	background: #b1c900;
	border-color: rgba(48, 46, 45, 1);
	color: white;
}

#login-box button.btn-custom:hover {
	-webkit-transition: all 500ms ease;
	-moz-transition: all 500ms ease;
	-ms-transition: all 500ms ease;
	-o-transition: all 500ms ease;
	transition: all 500ms ease;
	background: rgba(48, 46, 45, 1);
	border-color: #b1c900;
}

#particles-js {
	width: 100%;
	height: 100%;
	background-size: cover;
	background-position: 50% 50%;
	position: fixed;
	top: 0px;
	z-index: 1;
}
#bad-cred {
	color:red;
}
</style>
</head>
<body>
	<div class="container">
		<div id="login-box">
			<div class="logo">
				<p style="color:red;">${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
				<h1 class="logo-caption">
					<span class="tweak">Login</span>
				</h1>
			</div>
			<div class="controls">
				<form action="login" method="POST">
					<input type="text" name="username" placeholder="Username"
						class="form-control" /> <input type="password" name="password"
						placeholder="Password" class="form-control" />
					<button type="submit" class="btn btn-default btn-block btn-custom">Login</button>
				</form>
			</div>

		</div>
	</div>
</body>
</html>