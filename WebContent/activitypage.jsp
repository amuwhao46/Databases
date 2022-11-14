<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
<style>
	body {
		font-family: 'Roboto', sans-serif;
		background-color: rgb(255, 153, 153);
		text-align: center;
		margin-left: auto;
		margin-right: auto;
  		width: 50%;
		padding: 10px;
	}
	.Button {
		padding: .5rem;
		background-color: red;
		border-radius: 0.25rem;
		margin: 1rem;
		color: white;
	}
	.Button2 {
		padding: .5rem;
		background-color: blue;
		border-radius: 0.25rem;
		margin: 1rem;
		color: white;
	}
	.container {
		display: flex;
		justify-content: center;
		
	}
	.table-container {
		margin-left:auto;
		margin-right:auto;
	}

</style>
</head>
	<body>
			<h1>Welcome!</h1>

		 <a class="Button" href="login.jsp"target ="_self" > logout</a><br><br> 
		 <div class=container>
			 <a class="Button2" href="mint.jsp"target ="_self" > Mint NFT</a>
			 <a class="Button2" href="search.jsp"target ="_self" > Search for a NFT</a>
			 <a class="Button2" href="listings.jsp"target ="_self" > View Listed NFT's</a>
			 <a class="Button2" href="beginTransfer"target ="_self" > Transfer a NFT!</a>
		 </div>
		 <!-- <p> You can show all the transactions or other attributes here like balance, name of the user</p> -->
		 <h1>Current NFTs</h1>
		 		        <table class=table-container border="1" cellpadding="6">
		            <caption><h2>List of NFTs</h2></caption>
		            <tr>
		                <th>NFTid</th>
		                <th>Name</th>
		                <th>Description</th>
		                <th>Date created</th>
		                <th>Image</th>
		                <th>Creator</th>
		                <th>Time Minted</th>
		                
		            </tr>
		            <c:forEach var="nfts" items="${listNft}">
		                <tr style="text-align:center">
		                    <td><c:out value="${nfts.nftid}" /></td>
		                    <td><c:out value="${nfts.unique_name}" /></td>
		                    <td><c:out value="${nfts.description}" /></td>
		                    <td><c:out value="${nfts.created_date}" /></td>
		                    <td><img src="<c:out value="${nfts.nft_image}"/>" alt="url link to image to nft"/></td>
		                    <td><c:out value="${nfts.creator}" /></td>
		                    <td><c:out value="${nfts.mint_time}" /></td>
		                    
		            </c:forEach>
		        </table>
	</body>
</html>