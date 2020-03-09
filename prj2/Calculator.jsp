<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>calculator</title>

</head>
<body>
	<h2>Calculator</h2>
	<br>
	<%
		if (request.getParameter("plus") != null) {
			session.setAttribute("operation", "plus");
		}
		if (request.getParameter("minus") != null) {
			session.setAttribute("operation", "minus");
		}
	%>
	<form method=post action="/Project2/calculator">
		<input type="text" name="number1" class="a" value="<%=(request.getAttribute("n1") == null) ? "" : request.getAttribute("n1")%>"><br> <br>
		<input type=text name="number2" class="b" value="<%=(request.getAttribute("n2") == null) ? "" : request.getAttribute("n2")%>"><br>
		<br> <input type=text name=result class="result"
			value="<%=(request.getAttribute("result") == null) ? "" : request.getAttribute("result")%>">
		<br>
		<br>
		<button type="submit" name="plus" value="plus">Plus</button>
		<button type="submit" name="minus" value="minus">Minus</button>
	</form>
	<p style="color: red;"><%=(request.getAttribute("error") == null) ? "" : request.getAttribute("error")%></p>
</body>
</html>