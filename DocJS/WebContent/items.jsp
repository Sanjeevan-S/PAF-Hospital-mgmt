<%@page import="com.item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
<meta charset="ISO-8859-1">
<title>Items Management</title>
</head>
<body>
	<h1>Items Management</h1>
	<form id="formItem" name="formItem" method="post" action="items.jsp">
		Item code: <input id="itemCode" name="itemCode" type="text"
			class="form-control form-control-sm"> <br> Item name: <input
			id="itemName" name="itemName" type="text"
			class="form-control form-control-sm"> <br> Item price: <input
			id="itemPrice" name="itemPrice" type="text"
			class="form-control form-control-sm"> <br> Item
		description: <input id="itemDesc" name="itemDesc" type="text"
			class="form-control form-control-sm"> <br> <input
			id="btnSave" name="btnSave" type="button" value="Save"
			class="btn btn-primary"> <input type="hidden"
			id="hidItemIDSave" name="hidItemIDSave" value="">
	</form>
	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
	<br>
	<div id="divItemsGrid">
		<%
			item itemObj = new item();
			out.print(itemObj.readitems());
		%>
	</div>
	</div>
	</div>
	</div>
</body>
</html>