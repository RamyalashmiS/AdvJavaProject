<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="nav.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login here!!!</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center text-success">Login to our WebSite here!!! </h1>
		<div class="row">
			<div class="col-md-9 offset-1">
				<form method="post" action="validate.jsp">					
					<div class="form-group">
						<label for="email">Email ID :</label>
						<input type="email" id="email" name="email" class="form-control" />
					</div>
					<div class="form-group">
						<label for="pwd">Password :</label>
						<input type="password" id="pwd" name="pwd" class="form-control" />
					</div>	
					<div>
						<button class="btn btn-block btn-success">Login</button>
					</div>								
				</form>			
			</div>
				<a class="text-center col-6 offset-3 h3 mt-5 jumbotron" href="userRegister.jsp">Not a registered user? Click here to register</a>
		</div>
	</div>
</body>
</html>