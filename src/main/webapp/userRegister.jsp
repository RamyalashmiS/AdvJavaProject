<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file='nav.jsp'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<script>
	let username;
	let email;
	let pwd;
	function validate(e) {
		e.preventDefault();
		let name = e.target.name;
		let value = e.target.value;
		switch (name) {
		case "username":
			if (value == '') {
				document.getElementById("usernameError").innerText = "Field required!!!"
			} else if (!value.match(/^[A-Z][a-z]{2,}[ ][A-z]+/)) {
				document.getElementById("usernameError").innerText = "Should start with uppercase and must have 2 names!!!";
			} else {
				document.getElementById("usernameError").innerText = "";
				username = true;
			}
			break;
		case "email":
			if (value == '') {
				document.getElementById("emailError").innerText = "Field required!!!"
			} else if (!value.match(/^[a-z._*$]{5,}[0-9]*(\@)[a-z]{5,8}(.com)/)) {
				document.getElementById("emailError").innerText = "Should have alphabets minimum 5 chars., can have numbers, ending with domain name";
			} else {
				document.getElementById("emailError").innerText = "";
				email = true;
			}
			break;
		case "pwd":
			if (value == '') {
				document.getElementById("pwdError").innerText = "Field required!!!"
			} else if (!value.match(/^[A-z]+[._*$][a-z|0-9]+/)) {
				document.getElementById("pwdError").innerText = "Password should contain characters, numbers and special characters also";
			} else {
				document.getElementById("pwdError").innerText = "";
				pwd = true;
			}
			break;
		default:
			break;

		}
		if (username && email && pwd) {
			document.getElementById("registerBtn").disabled = false;
		}
	}
</script>
</head>
<body style="background: rgb(250,197,158);
background: linear-gradient(72deg, rgba(250,197,158,0.7906512946975666) 0%, rgba(235,220,197,1) 77%);">

	<div class="container">
		<h1 class="text-center">Fill your details in the below given form
			to get access to all the features of our Website</h1>
		<div class="row">
			<div class="col-md-9 offset-1">
				<form name="register" action="register" method="post">
					<%!String username;
	String password;
	String emailId;%>
					<div class="form-group">
						<label for="username">User Name :</label> <input type="text"
							id="username" name="username" class="form-control"
							onkeyup="validate(event)" /> <span id="usernameError"
							class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="email">Email ID :</label> <input type="email"
							id="email" name="email" class="form-control"
							onkeyup="validate(event)" /> <span id="emailError"
							class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="pwd">Password :</label> <input type="password"
							id="pwd" name="pwd" class="form-control"
							onkeyup="validate(event)" /> <span id="pwdError"
							class="text-danger"></span>
					</div>

					<div>
						<button class="btn btn-block btn-success" id="registerBtn"
							disabled>Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>