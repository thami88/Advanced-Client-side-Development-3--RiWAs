<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.Item"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items Management</title>

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/css/mdb.min.css"
	rel="stylesheet">

<script src="Components/jquery-3.5.0.min.js"></script>
<script src="Components/items.js"></script>
</head>
<body>

	<!--Navbar-->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark special-color-dark">
		<!-- Collapse button -->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#basicExampleNav" aria-controls="basicExampleNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- Collapsible content -->
		<div class="collapse navbar-collapse" id="basicExampleNav">

			<!-- Links -->
			<ul class="navbar-nav mr-auto">
				<li class="nav-item "><a class="nav-link" href="#">Home </a></li>
				<li class="nav-item active"><a class="nav-link" href="#">Item
						Management<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">About</a></li>
			</ul>
			<!-- Links -->
		</div>
		<!-- Collapsible content -->
	</nav>

	<!-- ---------------------------- End of Nav ----------------------------- -->

	<br>
	<div class="container-fluid">

		<div class="row">
			<div class="col">
				<!-- ---------------------------- Start of Jumborone ----------------------------- -->

				<div class="jumbotron card card-image mt-5"
					style="background-image: url(https://mdbootstrap.com/img/Photos/Others/gradient1.jpg);">
					<div class="text-white text-center py-5 px-4">
						<div>
							<h2 class="card-title h1-responsive pt-3 mb-5 font-bold">
								<strong>Items Management</strong>
							</h2>
						</div>
					</div>
				</div>

				<!-- ---------------------------- End of Jumborone ----------------------------- -->
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col">

					<form id="formItem" name="formItem"
						class="text-center border border-light p-5">

						<p class="h4 mb-4">Add / Update Items</p>

						<input id="itemCode" name="itemCode" type="text"
							class="form-control mb-4" placeholder="Item Code:"><br>
						<input id="itemName" name="itemName" type="text"
							class="form-control mb-4" placeholder="Item Name:"><br>
						<input id="itemPrice" name="itemPrice" type="text"
							class="form-control mb-4" placeholder="Item Price:"><br>
						<input id="itemDesc" name="itemDesc" type="text"
							class="form-control mb-4" placeholder="Item Description:"><br>

						<input id="btnSave" name="btnSave" type="button" value="Save"
							class="btn btn-primary"> <input type="hidden"
							id="hidItemIDSave" name="hidItemIDSave" value="">

					</form>

					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br>

				</div>
				<!-- End of Column -->
			</div>
			<!-- End of 1st Row -->
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col">

				<p class="h4 text-center mb-4">Manage Items</p>

				<div id="divItemsGrid">
					<%
						Item itemObj = new Item();
					out.print(itemObj.readItems());
					%>
				</div>
			</div>

		</div>
		<!-- End of 2nd Row  -->

	</div>
	<!-- End of Container -->

	<footer class="page-footer font-small special-color-dark pt-4">

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">Items Management</div>
		<!-- Copyright -->

	</footer>

</body>
</html>