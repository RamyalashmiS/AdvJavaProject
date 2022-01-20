<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file='nav.jsp'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Products</title>
<script>
	let prodname;
	let desc;
	let cost;
	function validate(e) {
		e.preventDefault();
		let name = e.target.name;
		let value = e.target.value;
		switch (name) {
		case "prodname":
			if (value == '') {
				prodname = false;
			} else {
				prodname = true;
			}
			break;
		case "desc":
			if (value == '') {
				desc = false;
			} else {
				desc = true;
			}
			break;
		case "cost":
			if (value == '') {
				cost = false;
			} else {
				cost = true;
			}
			break;
		default:
			break;
		}
		if (prodname && desc && cost) {
			document.getElementById("addProducts").disabled = false;
		}
	}
</script>
</head>
<body
	style="background: rgb(224, 250, 143); background: linear-gradient(72deg, rgba(224, 250, 143, 0.7906512946975666) 0%, rgba(221, 254, 151, 1) 77%);">
	<div class="container">

		<h1 class="text-center ">Add Products!!!</h1>
		<div class="row">
			<div class="col-md-9 offset-1">
				<form method="post" action="addProducts">
					<div class="form-group">
						<label for="prodname">Product Name :</label> <input type="text"
							id="prodname" name="prodname" required class="form-control"
							onkeyup="validate(event)" />
					</div>
					<div class="form-group">
						<label for="desc">Description :</label> <input type="text"
							id="desc" name="desc" required class="form-control"
							onkeyup="validate(event)" />
					</div>
					<div class="form-group">
						<label for="cost">Cost :</label> <input type="number"
							id="cost" name="cost" required class="form-control"
							onkeyup="validate(event)" />
					</div>
					<div>
						<button id="addProducts" disabled class="btn btn-block btn-success">Add</button>
					</div>
				</form>
			</div>
			
		</div>
	</div>
</body>
</html>