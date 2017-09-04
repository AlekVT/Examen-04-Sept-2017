<%@ page import="ap.student.BolResource"
import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bol products management</title>
</head>
<body>
	<%
		BolResource res = new BolResource();
		List<String[]> prods = res.getProducts();
		for (String[] s : prods) {
			%><div><b>Naam: </b><%= s[0] %><br /><b>Producent: </b>
			<%= s[1] %><br /><b>Prijs: </b><%= s[2] %>"></div>
	<%
		}
	%>
</body>
</html>