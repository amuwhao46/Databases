<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Transfer a NFT</title>
	<style>
	 	body {
			font-family: 'Roboto', sans-serif;
			background-color: rgb(255, 153, 153);
			text-align: center;
			margin-left: auto;
			margin-right: auto;
			padding: 10px;
		}
		
		.wrap{
			padding: 1rem;
			align-items: center;
		}
		
		.box {
			background-color:white;
			filter: drop-shadow(0 4px 3px rgb(0 0 0 / 0.07)) drop-shadow(0 2px 2px rgb(0 0 0 / 0.06));
			border-radius: 0.25rem;
			display:flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			padding:1rem;
		}
	</style>
</head>

	<body>
		<div align="center">
		<div class="box">
			<h1>Transfer a NFT to another User:</h1>
			<h2><a href="goHome">Go back to the activity page!</a></h2>
			<form action="endTransfer" method="post">
				<div class="wrap">
					<label>Select the NFT that you wish to transfer</label>
					<select name="nftid">
				  		<c:forEach items="${userNft}" var="nfts" varStatus="loop">
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
		</div>
	</body>
</html>