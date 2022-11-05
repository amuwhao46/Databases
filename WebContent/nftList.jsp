<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>NFT</title>
</head>
	<body>
		<div align = "center">
			<h1>List all NFTs</h1>
		    <div align="center">
		        <table border="1" cellpadding="6">
		            <caption><h2>List of NFTs</h2></caption>
		            <tr>
		                <th>NFTid</th>
		                <th>Name</th>
		                <th>Description</th>
		                <th>Date created</th>
		                <th>Image</th>
	
		            </tr>
		            <c:forEach var="users" items="${listUser}">
		                <tr style="text-align:center">
		                    <td><c:out value="${users.userid}" /></td>
		                    <td><c:out value="${users.firstName}" /></td>
		                    <td><c:out value="${users.lastName}" /></td>
		                    <td><c:out value= "${users.address_street_num} ${users.address_street} ${users.address_city} ${users.address_state} ${users.address_zip_code}" /></td>
		                    <td><c:out value="${users.password}" /></td>
		                    <td><c:out value="${users.birthday}" /></td>
		                    <td><c:out value="${users.init_bal}"/></td>
		            </c:forEach>
		        </table>
			</div>
		</div>
	</body>
</html>