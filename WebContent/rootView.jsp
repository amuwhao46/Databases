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
				font-family: 'Roboto', sans-serif;
				background-color: rgb(255, 153, 153);
				text-align: center;
				margin-left: auto;
				margin-right: auto;
				padding: 10px;
			}
			table {
				margin-bottom: 3rem;
			}
			.table-container {
				margin-left: auto;
				margin-right: auto;
			}
		</style>
	</head>
	<body>
		
		<form action = "initialize">
			<input type = "submit" value = "Initialize the Database"/>
		</form>
		<a href="login.jsp"target ="_self" > logout</a><br><br> 
		
		<h1>List all users</h1>
	    <table class="table-container" border="1" cellpadding="6">
		    <tr>
		        <th>Email</th>
		        <th>First name</th>
		        <th>Last name</th>
		        <th>Address</th>
		        <th>Password</th>
		        <th>Birthday</th>
		        <th>init_bal(ETH)</th>
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
		
		<h1>List all NFTs</h1>
  		<table class="table-container" border="1" cellpadding="6">
	        <tr>
	            <th>NFTid</th>
	            <th>Name</th>
	            <th>Description</th>
	            <th>Image</th>
	            <th>Owner</th>
	            <th>Creator</th>
	            <th>Date created</th>
	
	        </tr>
	        <c:forEach var="nfts" items="${listNft}">
	            <tr style="text-align:center">
	                <td><c:out value="${nfts.nftid}" /></td>
	                <td><c:out value="${nfts.unique_name}" /></td>
	                <td><c:out value="${nfts.description}" /></td>
	                <td><c:out value="${nfts.nft_image}" /></td>
	                <td><c:out value="${nfts.owner}" /></td>
	                <td><c:out value="${nfts.creator}" /></td>
	                <td><c:out value="${nfts.mint_time}" /></td>
	        </c:forEach>
      	</table>
      	<div class="flex-container">
      		<h1>Big Creators</h1>
      		<table>
      			<tr>
      				<th>User</th>
      			</tr>
      			<tr>
      				<td>(data goes here)</th>
      			</tr>
      		</table>
      		<h1>Big Sellers</h1>
      		<table>
      			<tr>
      				<th>User</th>
      			</tr>
      			<tr>
      				<td>(data goes here)</th>
      			</tr>
      		</table>
      		<h1>Big Buyers</h1>
      		<table>
      			<tr>
      				<th>User</th>
      			</tr>
      			<tr>
      				<td>(data goes here)</th>
      			</tr>
      		</table>
      		<h1>Hot NFTs</h1>
      		<table>
      			<tr>
      				<th>User</th>
      			</tr>
      			<tr>
      				<td>(data goes here)</th>
      			</tr>
      		</table>
      		<h1>Common NFTs</h1>
      		<table>
      			<tr>
      				<th>User</th>
      			</tr>
      			<tr>
      				<td>(data goes here)</th>
      			</tr>
      		</table>
      		<h1>Diamond Hands</h1>
      		<table>
      			<tr>
      				<th>User</th>
      			</tr>
      			<tr>
      				<td>(data goes here)</th>
      			</tr>
      		</table>
      		<h1>Paper Hands</h1>
      		<table>
      			<tr>
      				<th>User</th>
      			</tr>
      			<tr>
      				<td>(data goes here)</th>
      			</tr>
      		</table>
      		<h1>Good Buyers</h1>
      		<table>
      			<tr>
      				<th>User</th>
      			</tr>
      			<tr>
      				<td>(data goes here)</th>
      			</tr>
      		</table>
      		<h1>Inactive Users</h1>
      		<table>
      			<tr>
      				<th>User</th>
      			</tr>
      			<tr>
      				<td>(data goes here)</th>
      			</tr>
      		</table>
      		<h1>Stats</h1>
      		<table>
      			<tr>
      				<th>User</th>
      			</tr>
      			<tr>
      				<td>(data goes here)</th>
      			</tr>
      		</table>
      	</div>
	</body>
</html>