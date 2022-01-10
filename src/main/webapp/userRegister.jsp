<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@include file='nav.jsp'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center">Fill your details in the below given form to get access to all the features of our Website </h1>
		<div class="row">
			<div class="col-md-9 offset-1">
				<form action="register" method="post" >
					<div class="form-group">
						<label for="username">User Name :</label>
						<input type="text" id="username" name="username" class="form-control" />
					</div>
					<div class="form-group">
						<label for="email">Email ID :</label>
						<input type="email" id="email" name="email" class="form-control" />
					</div>
					<div class="form-group">
						<label for="pwd">Password :</label>
						<input type="password" id="pwd" name="pwd" class="form-control" />
					</div>
					
					<div>
						<button class="btn btn-block btn-success" >Register</button>
					</div>					
				</form>
			</div>
		</div>
	</div>
</body>
</html>