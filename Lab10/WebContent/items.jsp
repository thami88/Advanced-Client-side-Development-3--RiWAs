<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.Item"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items Management</title>

<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/css/mdb.min.css" rel="stylesheet">

<script src="Components/jquery-3.5.0.min.js"></script>
<script src="Components/items.js"></script>
</head>
<body>

	<div class="container">
	<div class="row">
	<div class="col-6">
		<h1>Items Management</h1>
		
		<form id="formItem" name="formItem">
		
			Item Code: <input id="itemCode" name="itemCode" type="text" class="form-control form-control-sm"><br>
			Item Name: <input id="itemName" name="itemName" type="text" class="form-control form-control-sm"><br>
			Item Price: <input id="itemPrice" name="itemPrice" type="text" class="form-control form-control-sm"><br>
			Item Description: <input id="itemDesc" name="itemDesc" type="text" class="form-control form-control-sm"><br>
		
			<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
			<input type="hidden" id="hidItemIDSave" name="hidItemIDSave"  value="">
		
		</form>
		
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div><br>
		
		<div id="divItemsGrid">
			<%
				Item itemObj = new Item();
				out.print(itemObj.readItems()); 
			%>
		</div>
		
	</div>
	</div>
	</div>
	
	<footer class="page-footer font-small special-color-dark pt-4">
	
	  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">Items Management</div>
  <!-- Copyright -->
	
	</footer>

</body>
</html>