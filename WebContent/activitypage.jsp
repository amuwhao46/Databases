<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>
	<body>
		<c:forEach var="users" items="${listUser}">
			<center><h1>Welcome <c:out value="${users.firstName}" />! You have been successfully logged in</h1> </center>
		</c:forEach>
<!-- Prints every name in the database. Don't want that, will fix later -->

	 	<center>
		 <a href="login.jsp"target ="_self" > logout</a><br><br> 
		 <a href="#"target ="_self" > Mint NFT</a>
		 <a href="#"target ="_self" > Buy NFT</a>
		 <a href="#"target ="_self" > Sell NFT</a>
		 <p> You can show all the transactions or other attributes here like balance, name of the user</p>
		 </center>
	</body>
</html>