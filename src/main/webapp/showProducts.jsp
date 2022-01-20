<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file='nav.jsp'%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body
	style="background: rgb(156, 241, 241); background: linear-gradient(72deg, rgba(156, 241, 241, 0.7906512946975666) 0%, rgba(223, 245, 231, 1) 77%);">
	<div class="container mt-4">
		<c:choose>
			<c:when test="${user == true || admin == true}">
				<div class="card">
					<c:choose>
						<c:when test="${products == null}">
							<div class="card-header">
								<h1>No products found</h1>
							</div>
							<p class="card-body">Unfortunately there are no product
								available for purchase right now. Please visit our shop later.</p>
						</c:when>
						<c:otherwise>
							<div class="text-center"
								style="background: rgb(156, 241, 241); background: linear-gradient(72deg, rgba(156, 241, 241, 0.7906512946975666) 0%, rgba(223, 245, 231, 1) 100%);">
								<h1 class="card-header">eMart Catalog</h1>
							</div>
							<div class="row card-body">
								<div class="col-10 offset-1"
									style="background: rgb(156, 241, 241); background: linear-gradient(72deg, rgba(156, 241, 241, 0.7906512946975666) 0%, rgba(223, 245, 231, 1) 77%);">
									<table class="table table-hover table-border">
										<tr>
											<th>Product Name</th>
											<th>Description</th>
											<th>Cost</th>
										</tr>
										<c:forEach var="product" items="${products}">
											<tr>
												<td>${product.productName}</td>
												<td>${product.description}</td>
												<td>INR Rs.${product.cost}.00</td>
												<td><a class="btn btn-info" href="contact.jsp">Buy</a></td>
											</tr>
										</c:forEach>
									</table>
								</div>

							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="card mt-3">
					<c:choose>
						<c:when test="${admin==true}">
							<a class="h5 text-center" href="addProducts.jsp">Click here to add products!!!</a>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</div>
			</c:when>
			<c:otherwise>
			<div class="card-header">
								<h1>Only Registered users are allowed to access this page</h1>
							</div>
							<p class="card-body">Please click on <a class="h5 text-center" href="login.jsp">here</a> to login/register and access this page</p>
			</c:otherwise>

		</c:choose>
	</div>
</body>