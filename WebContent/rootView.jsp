<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Root page</title>
		<style>
			body {
				background-color: yellow;
			}
			table {
				margin-bottom: 3rem;
			}
		</style>
	</head>
	<body>
	
		<div align = "center">
			
			<form action = "initialize">
				<input type = "submit" value = "Initialize the Database"/>
			</form>
			<a href="login.jsp"target ="_self" > logout</a><br><br> 
		
			<h1>List all users</h1>
		    <div align="center">
		        <table border="1" cellpadding="6">
		            <caption><h2>List of Users</h2></caption>
		            <tr>
		                <th>Email</th>
		                <th>First name</th>
		                <th>Last name</th>
		                <th>Address</th>
		                <th>Password</th>
		                <th>Birthday</th>
		                <th>init_bal($)</th>
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
			
			<h1>List all NFTs</h1>
		    <div align="center">
		        <table border="1" cellpadding="6">
		            <caption><h2>List of NFTs</h2></caption>
		            <tr>
		                <th>NFTid</th>
		                <th>Creator</th>
		                <th>Name</th>
		                <th>Description</th>
		                <th>Date created</th>
		                <th>Image</th>
	
		            </tr>
		            <c:forEach var="nfts" items="${listNft}">
		                <tr style="text-align:center">
		                    <td><c:out value="${nfts.nftid}" /></td>
		                    <td><c:out value="${users.userid}" /></td>
		                    <td><c:out value="${nfts.unique_name}" /></td>
		                    <td><c:out value="${nfts.description}" /></td>
		                    <td><c:out value="${nfts.created_date}" /></td>
		                    <td><c:out value="${nfts.nft_image}" /></td>
		            </c:forEach>
		        </table>
			</div>
		</div>
	</body>
</html>