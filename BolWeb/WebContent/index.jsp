<%@ page import="ap.student.BolResource"
import="entities.Product" 
import="java.util.List"
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bol products management</title>
</head>
<body>
	<form method="post" action="AddProduct">
		<label for="name">Naam: </label>
		<input type="text" id="name" name="name">
		<label for="producer">Producent: </label>
		<input type="text" id="Producer" name="Producer">
		<label for="price">Prijs: </label>
		<input type="number" id="price" name="price">
		<input type="submit" value="opslaan">
	</form>
	<%
		BolResource res = new BolResource();
		List<Product> prods = res.getProducts();
		for (Product p : prods) {
			%><div><b>Naam: </b><%= p.getName() %><br /><b>Producent: </b>
			<%= p.getProducer() %><br /><b>Prijs: </b><%= p.getPrice() %>"></div>
	<%
		}
	%>
</body>
</html>