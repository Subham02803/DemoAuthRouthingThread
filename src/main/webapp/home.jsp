<%@page import="java.util.Collections"%>
<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.example.DemoAuthRouthingThread.threadtest.dto.CSVParseDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
h1 {
	color: blue;
	display: flex;
	justify-content: center;
}

.mainDiv {
	justify-content: center;
	position: relative;
}

.uploadDiv {
	display: flex;
	justify-content: left;
	border: solid;
	position: relative;
}

.tableDiv {
	display: flex;
	justify-content: center;
	margin-top: 7px;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

button {
	line-height: 22px;
	width: 68px;
	font-size: 8pt;
	font-family: tahoma;
	margin-top: 7px;
	margin-right: 10px;
	position: absolute;
	top: 0;
	right: 0;
	border-color: #b1d708;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
</style>
</head>
<h1>Stocks</h1>
<a href="/logout"><button>Logout</button></a>
<div class="mainDiv">
	<%
	Boolean hasAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
			.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ADMIN"));
	if (hasAdmin) {
	%>
	<div class="uploadDiv">
		<form method="POST" action="/saveStockData"
			enctype="multipart/form-data">
			<input type="file" name="file" /> <input type="submit"
				value="Submit" />
		</form>
	</div>
	<%
	}
	%>
	<div class="tableDiv">
		<%
		List<CSVParseDto> list = (List<CSVParseDto>) request.getAttribute("data");
		%>
		<table>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Credit Card</th>
				<th>Credit Card Type</th>
				<th>Stock Industry</th>
				<th>Stock Market</th>
				<th>Amount</th>
			</tr>
			<%
			for (CSVParseDto dto : list) {
			%>
			<tr>
				<td><%=dto.getName()%></td>
				<td><%=dto.getEmail()%></td>
				<td><%=dto.getCreditCard()%></td>
				<td><%=dto.getCreditCardType()%></td>
				<td><%=dto.getStockIndustry()%></td>
				<td><%=dto.getStockMarket()%></td>
				<td><%=dto.getAmount()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</div>
</html>