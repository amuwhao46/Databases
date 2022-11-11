<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Transfer a NFT</title>
	<style>
	
	.wrap{
		padding: 1rem;
		align-items: center;
	}
	
	</style>
</head>

	<body>
		<div align="center">
			<h1>Transfer a NFT to another User!:</h1>
			<h2><a href="activitypage.jsp">Go back to the activity page!</a></h2>
			<form action="endTransfer">
				<div class="wrap">
					<label>Select the NFT that you wish to make a listing for</label>
					<select name="nftid">
				  		<c:forEach items="${userNFTs}" var="nfts" varStatus="loop">
							<option value="${nfts.nftid}">
						        <c:out value="${nfts.unique_name}" />
						  	</option>
						</c:forEach>
					</select>
				</div>
				<div class="wrap">
					<label>Select the user that you would like to transfer the NFT to</label>
					<select name="reciever">
				  		<c:forEach items="${allUsers}" var="user" varStatus="loop">
							<option value="${user.userid}">
						        <c:out value="${user.userid}" />
						  	</option>
						</c:forEach>
					</select>
				</div>
				<button type="submit">transfer</button>
			</form>
		</div>
	</body>
</html>