<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customer Directory</title>
</head>

<body>

	<div class="container">

		<h3>Customer Directory</h3>
		<hr>

		<!-- Add a search form -->





		<form action="/CRMProject/customers/search" class="form-inline">

			<!-- Add a button -->
			<a href="/CRMProject/customers/showNewCustomerForm"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a> <input
				type="search" name="firstName" placeholder="FirstName"
				class="form-control-sm ml-5 mr-2 mb-3" /> <input type="search"
				name="lastName" placeholder="lastName" class="form-control-sm mr-2 mb-3" />

			<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>
			<a href="/CRMProject/logout"
				class="btn btn-primary btn-sm mb-3 mx-auto"> Logout </a>

		</form>


		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>

					<th>Action</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Customer}" var="tempBook">
					<tr>
						<td><c:out value="${tempBook.firstName}" /></td>
						<td><c:out value="${tempBook.lastName}" /></td>
						<td><c:out value="${tempBook.email}" /></td>


						<td>
							<!-- Add "update" button/link --> <a
							href="/CRMProject/customers/showFormForUpdate?id=${tempBook.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/CRMProject/customers/delete?id=${tempBook.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
								Delete </a>

						</td>


					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>