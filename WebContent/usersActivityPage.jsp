<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Activity</title>
</head>
<body>


<h1>Your current NFT Activity</h1>
	    <table class=table-container border="1" cellpadding="6">
	    <caption>Includes bought, sold, and minted NFTs</caption>
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