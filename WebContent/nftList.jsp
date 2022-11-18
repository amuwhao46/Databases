<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>NFT</title>
</head>
	<body>
		<div align = "center">
			<h1>List all NFTs</h1>
		    <div align="center">
		        <table border="1" cellpadding="6">
		            <caption><h2>List of NFTs</h2></caption>
		            <tr>
		               <th>NFTid</th>
		               <th>Name</th>
		               <th>Description</th>
		               <th>Image</th>
		               <th>Creator</th>
		               <th>Time Minted</th>
		               <th>Mint</th>
		               <th>Transfer</th>
		               <th>Sell</th>
		            </tr>
		            <c:forEach var="nfts" items="${userNFT}">
		                <tr style="text-align:center">
		                    <td><c:out value="${nfts.nftid}" /></td>
		                    <td><c:out value="${nfts.unique_name}" /></td>
		                    <td><c:out value="${nfts.description}" /></td>
		                    <td><img src="<c:out value="${nfts.nft_image}"/>" alt="url link to image to nft"/></td>
                            <td><c:out value="${nfts.creator}" /></td>
                			<td><c:out value="${nfts.mint_time}" /></td>
                			<td><a class="Button2" href="mint.jsp"target ="_self" > Mint</a></td>
                			<td><a class="Button2" href="beginTransfer"target ="_self" > Transfer</a></td>
                			<td>
            					<a class="Button2" href="buy?nftid=<c:out value="${nfts.nftid}" />">
				                <button class="Button2">Sell</button>
				            	</a>
                			</td>
		            </c:forEach>
		        </table>
			</div>
		</div>
	</body>
</html>