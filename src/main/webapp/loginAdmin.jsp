<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="nav.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login here!!!</title>
<script>
	
	let email;
	let pwd;
	function validate(e) {
		e.preventDefault();
		let name = e.target.name;
		let value = e.target.value;
		switch (name) {
		case "email":
			if (value == '') {
				email = false;
			} else {
				email = true;
			}
			break;
		case "pwd":
			if (value == '') {
				pwd = false;
			} else {
				pwd = true;
			}
			break;
		default:
			break;
		}
		if (email && pwd) {
			document.getElementById("loginBtn").disabled = false;
		}
	}
</script>
</head>
<body style="background: rgb(224,250,143);
background: linear-gradient(72deg, rgba(224,250,143,0.7906512946975666) 0%, rgba(221,254,151,1) 77%);">
	<div class="container">

		<h1 class="text-center ">Login to our WebSite here!!!
		</h1>
		<div class="row">
			<div class="col-md-9 offset-1">
				<form method="post" action="admin">
					<div class="form-group">
						<label for="email">Email ID :</label> <input type="email"
							id="email" name="email" required class="form-control" onkeyup="validate(event)"/>
					</div>
					<div class="form-group">
						<label for="pwd">Password :</label> <input type="password"
							id="pwd" name="pwd" required class="form-control" onkeyup="validate(event)"/>
					</div>
					<div>
						<button id="loginBtn" disabled class="btn btn-block btn-success">Login</button>
					</div>
				</form>
			</div>
			<a class="text-center col-6 offset-3 h3 mt-5 jumbotron"
				href="userRegister.jsp">Not a registered user? Click here to
				register</a>
		</div>
	</div>
</body>
</html>