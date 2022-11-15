<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>List a NFT</title>
</head>


<style>

.wrap{
padding: 1rem;
align-items: center;
}

</style>


<body>
<div align="center">
	<h1>Please create a listing:</h1>
	<h2><a href="goHome">Go back to the activity page!</a></h2>
	<form method="post" action="createListing">
		<div class="wrap">
			<label>Select the NFT that you wish to make a listing for</label>
			<select name="nftid">
		  		<c:forEach items="${userNFT}" var="nfts" varStatus="loop">
					<option value="${nfts.nftid}">
				        <c:out value="${nfts.unique_name}" />
				  	</option>
				</c:forEach>
			</select>
		</div>
		<div class="wrap">
			<label>List Duration in Months</label>
			<select name="lengthoftime">
		  		<c:forEach var="i" begin = "1" end = "12">
					<option value="${i}">
				        <c:out value="${i}"/>
				  	</option>
				</c:forEach>
			</select>
		</div>
		<div class="wrap">
			<label>Price (Etherium)</label>
			<input type="number" name="price" step="0.005" value=".01" required>
		</div>
		<button type="submit">Create Listing</button>
	</form>
</div>
</body>
</html>