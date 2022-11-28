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
<%-- 	<%
		String name = (String)session.getAttribute("firstName");
		out.print("Logged in as " + name);
	%> --%>
		<h1>Logged in as: <c:out value="${sessionScope.userid}"/> </h1>

		 <a class="Button" href="login.jsp"target ="_self" > logout</a><br><br> 
		 <div class=container>
			 <a class="Button2" href="mint.jsp"target ="_self" > Mint an NFT</a>
			 <a class="Button2" href="searchNFT"target ="_self" >Search</a>
			 <a class="Button2" href="listing"target ="_self" > List an NFT</a>
			 <a class="Button2" href="beginTransfer"target ="_self" > Transfer an NFT</a>
		 </div>
		 <!-- <p> You can show all the transactions or other attributes here like balance, name of the user</p> -->
		 <h1>NFT Transaction Information</h1>
<%--  	    <table class=table-container border="1" cellpadding="6">
	    <caption>Includes minted, transferred, and purchased NFTs</caption>
           <tr>
               <th>NFTid</th>
               <th>Name</th>
               <th>Description</th>
               <th>Image</th>
               <th>Creator</th>
               <th>Time Minted</th>
           </tr>
           <c:forEach var="nfts" items="${userNFT}">
               <tr style="text-align:center">
                   <td><c:out value="${nfts.nftid}" /></td>
                   <td><c:out value="${nfts.unique_name}" /></td>
                   <td><c:out value="${nfts.description}" /></td>
                   <td><img src="<c:out value="${nfts.nft_image}"/>" alt="url link to image to nft"/></td>
                   <td><c:out value="${nfts.creator}" /></td>
                   <td><c:out value="${nfts.mint_time}" /></td>
           </c:forEach>
       </table>  --%>
       
       	<table class=table-container border="1" cellpadding="6">
	    <caption>Bought NFTs</caption>
           <tr>
               <th>NFTid</th>
               <th>Name</th>
               <th>Description</th>
               <th>Image</th>
               <th>Creator</th>
               <th>Time Minted</th>
           </tr>
           <c:forEach var="nfts" items="${userBoughtNft}">
               <tr style="text-align:center">
                   <td><c:out value="${nfts.nftid}" /></td>
                   <td><c:out value="${nfts.unique_name}" /></td>
                   <td><c:out value="${nfts.description}" /></td>
                   <td><img src="<c:out value="${nfts.nft_image}"/>" alt="url link to image to nft"/></td>
                   <td><c:out value="${nfts.creator}" /></td>
                   <td><c:out value="${nfts.mint_time}" /></td>
           </c:forEach>
       </table>
 
	    <table class=table-container border="1" cellpadding="6">
	    <caption>Sold NFTs</caption>
           <tr>
               <th>NFTid</th>
               <th>Name</th>
               <th>Description</th>
               <th>Image</th>
               <th>Creator</th>
               <th>Time Minted</th>
           </tr>
           <c:forEach var="nfts" items="${userSoldNft}">
               <tr style="text-align:center">
                   <td><c:out value="${nfts.nftid}" /></td>
                   <td><c:out value="${nfts.unique_name}" /></td>
                   <td><c:out value="${nfts.description}" /></td>
                   <td><img src="<c:out value="${nfts.nft_image}"/>" alt="url link to image to nft"/></td>
                   <td><c:out value="${nfts.creator}" /></td>
                   <td><c:out value="${nfts.mint_time}" /></td>
           </c:forEach>
       </table>

	    <table class=table-container border="1" cellpadding="6">
	    <caption>Minted NFTs</caption>
           <tr>
               <th>NFTid</th>
               <th>Name</th>
               <th>Description</th>
               <th>Image</th>
               <th>Creator</th>
               <th>Time Minted</th>
           </tr>
           <c:forEach var="nfts" items="${userMintedNft}">
               <tr style="text-align:center">
                   <td><c:out value="${nfts.nftid}" /></td>
                   <td><c:out value="${nfts.unique_name}" /></td>
                   <td><c:out value="${nfts.description}" /></td>
                   <td><img src="<c:out value="${nfts.nft_image}"/>" alt="url link to image to nft"/></td>
                   <td><c:out value="${nfts.creator}" /></td>
                   <td><c:out value="${nfts.mint_time}" /></td>
           </c:forEach>
       </table>
	</body>
</html>