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
		<!-- Initialize database -->
		<form action = "initialize">
			<input type = "submit" value = "Initialize the Database"/>
		</form>
		
		<!-- Initialize hotUser and stats -->
		<form action = "hotUserItems">
			<input type = "submit" value = "Initialize Achievements"/>
		</form>
		<form action = "statistics">
			<input type = "submit" value = "Initialize Statistics"/>
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
	            </tr>
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
                </tr>
	        </c:forEach>
      	</table>
      	
      	<!-- For the stats -->
      	<div>
      		<h1>Statistics</h1>
      		<table class="table-container" border="1" cellpadding="6">
      		<tr>
      			<th>User (email)</th>
      			<th>Total Bought NFTs</th>
<!--       			<th>Total Sold NFTs</th>
      			<th>Total Transfers</th>
      			<th>Total Owned NFTs</th> -->
      		</tr>
      		<c:forEach var="stats" items="${selectedUserStats}">
	      		<tr>
	      			<td><c:out value="${stats.user}"></c:out></td>
	      			<td><c:out value="${stats.totalBuys}"></c:out></td>
<%-- 	      			<td><c:out value="${stats.totalSells}"></c:out></td>
	      			<td><c:out value="${stats.totalTransfers}"></c:out></td>
	      			<td><c:out value="${stats.ownedNfts}"></c:out></td> --%>
	      		</tr>
      		</c:forEach>
      		</table>
      	</div>
      	
      	<div class="flex-container">
      		<h1>Big Creators</h1>
      		<table class="table-container" border="1" cellpadding="6">
      			<caption>User that created the most NFT's</caption>
      			<tr>
      				<th>User(s)</th>
      				<th>NFT's Created</th>
      			</tr>
      			<c:forEach var="user" items="${bigCreators}">
	      			<tr>
	      				<td><c:out value="${user.hotUserResult}"></c:out></td>
	      				<td><c:out value="${user.resultNum}"></c:out></td>
	      			</tr>
      			</c:forEach>
      		</table>
      		<h1>Big Sellers</h1>
      		<table class="table-container" border="1" cellpadding="6">
      			<caption>User that sold the most NFT's</caption>
      			<tr>
      				<th>User(s)</th>
      				<th>NFT's Sold</th>
      			</tr>
      			<c:forEach var="user" items="${bigSellers}">
	      			<tr>
	      				<td><c:out value="${user.hotUserResult}"></c:out></td>
	      				<td><c:out value="${user.resultNum}"></c:out></td>
	      			</tr>
      			</c:forEach>
      		</table>
      		<h1>Big Buyers</h1>
      		<table class="table-container" border="1" cellpadding="6">
      			<caption>User that purchased the most NFT's</caption>
      			<tr>
      				<th>User(s)</th>
      				<th>NFT's Bought</th>
      			</tr>
      			<c:forEach var="user" items="${bigBuyers}">
	      			<tr>
	      				<td><c:out value="${user.hotUserResult}"></c:out></td>
	      				<td><c:out value="${user.resultNum}"></c:out></td>
	      			</tr>
      			</c:forEach>
      		</table>      		
      		<h1>Hot NFT's</h1>
      		<table class="table-container" border="1" cellpadding="6">
      			<caption>NFT with the most amount of owners</caption>
      			<tr>
      				<th>User(s)</th>
      				<th>Owned NFTs</th>
      			</tr>
      			<c:forEach var="user" items="${hotNFTs}">
	      			<tr>
	      				<td><c:out value="${user.hotUserResult}"></c:out></td>
	      				<td><c:out value="${user.resultNum}"></c:out></td>
	      			</tr>
      			</c:forEach>
      		</table>  
      		<!-- Still gotta figure out ngl -->    	
      		<h1>Common NFT's</h1>
      			<div>
      				<label>Pick first account</label>
      				<select name="user">
      					<c:forEach var="user" items="user" varStatus="loop">
      						<option value="${user.userid}">
      							<c:out value="${user.userid}" />
      						</option>
      					</c:forEach>
      				</select>
      			</div>
      			<div>
      				<label>Pick second account</label>
      				<select name="user">
      					<c:forEach var="user" items="user" varStatus="loop">
      						<option value="${user.userid}">
      							<c:out value="${user.userid}" />
      						</option>
      					</c:forEach>
      				</select>
      			</div>
      		<table class="table-container" border="1" cellpadding="6">
      			<caption>WORK IN PROGRESS</caption>
      			<tr>
      				<th>User(s)</th>
      				<th>NFT's Created</th>
      			</tr>
      			<c:forEach var="user" items="${bigCreators}">
	      			<tr>
	      				<td><c:out value="${user.hotUserResult}"></c:out></td>
	      				<td><c:out value="${user.resultNum}"></c:out></td>
	      			</tr>
      			</c:forEach>
      		</table>
      		<h1>Diamond Hands</h1>
      		<table class="table-container" border="1" cellpadding="6">
      			<caption>Users that bought and never sold NFTs</caption>
      			<tr>
      				<th>User(s)</th>
      				<th>NFT's Something</th>
      			</tr>
      			<c:forEach var="user" items="${bigCreators}">
	      			<tr>
	      				<td><c:out value="${user.hotUserResult}"></c:out></td>
	      				<td><c:out value="${user.resultNum}"></c:out></td>
	      			</tr>
      			</c:forEach>
      		</table>
      		<h1>Paper Hands</h1>
      		<table class="table-container" border="1" cellpadding="6">
      			<caption>Users that bought NFTs but sold all of them</caption>
      			<tr>
      				<th>User(s)</th>
      				<th>NFT's Something</th>
      			</tr>
      			<c:forEach var="user" items="${bigCreators}">
	      			<tr>
	      				<td><c:out value="${user.hotUserResult}"></c:out></td>
	      				<td><c:out value="${user.resultNum}"></c:out></td>
	      			</tr>
      			</c:forEach>
      		</table>
      		<h1>Good Buyers</h1>
      		<table class="table-container" border="1" cellpadding="6">
      			<caption>Users who've bought at least 3 NFTs</caption>
      			<tr>
      				<th>User(s)</th>
      			</tr>
      			<c:forEach var="user" items="${bigCreators}">
	      			<tr>
	      				<td><c:out value="${user.hotUserResult}"></c:out></td>
	      			</tr>
      			</c:forEach>
      		</table>
      		<h1>Inactive Users</h1>
      		<table class="table-container" border="1" cellpadding="6">
      			<caption>Users that haven't performed any NFT activities</caption>
      			<tr>
      				<th>User(s)</th>
      			</tr>
      			<c:forEach var="user" items="${bigCreators}">
	      			<tr>
	      				<td><c:out value="${user.hotUserResult}"></c:out></td>
	      			</tr>
      			</c:forEach>
      		</table>
    	</div>
	</body>
</html>