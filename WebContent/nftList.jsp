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
		                <th>Date created</th>
		                <th>Image</th>
	
		            </tr>
		            <c:forEach var="nft" items="${listNft}">
		                <tr style="text-align:center">
		                    <td><c:out value="${nft.nftid}" /></td>
		                    <td><c:out value="${nft.unique_name}" /></td>
		                    <td><c:out value="${nft.description}" /></td>
		                    <td><c:out value="${nft.created_date}" /></td>
		                    <td><c:out value="${nft.nft_image}" /></td>
		            </c:forEach>
		        </table>
			</div>
		</div>
	</body>
</html>