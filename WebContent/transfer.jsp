<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Transfer a NFT</title>
</head>


<style>

.wrap{
padding: 1rem;
align-items: center;
}

</style>


<body>
<div align="center">
	<h1>Transfer a NFT to another User!:</h1>
	<h2><a href="activitypage.jsp">Go back to the activity page!</a></h2>
	<form method="post" action="createListing">
		<div class="wrap">
			<label>Select the NFT that you wish to make a listing for</label>
			<select name="nftid">
		  		<c:forEach items="${userNFT}" var="nfts" varStatus="loop">
					<option value="${nft.nftid}">
				        <c:out value="${nft.unique_name}" />
				  	</option>
				</c:forEach>
			</select>
		</div>
		<div class="wrap">
			<label>Select the user that you would like to transfer the NFT to</label>
			<select name="nftid">
		  		<c:forEach items="${userNFT}" var="user" varStatus="loop">
					<option value="${nft.nftid}">
				        <c:out value="${nft.unique_name}" />
				  	</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit">transfer</button>
	</form>
</div>
</body>
</html>