<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>
	<body>
			<center><h1>Welcome! You have been successfully logged in</h1> </center>

	 	<center>
		 <a href="login.jsp"target ="_self" > logout</a><br><br> 
		 <a href="mint.jsp"target ="_self" > Mint NFT</a>
		 <a href="#"target ="_self" > Buy/Sell NFT</a>
		 <a href="search.jsp"target ="_self" > Search Users</a>
		 <!-- <p> You can show all the transactions or other attributes here like balance, name of the user</p> -->
		 <h1>Current NFTs</h1>
		 		        <table border="1" cellpadding="6">
		            <caption><h2>List of NFTs</h2></caption>
		            <tr>
		                <th>NFTid</th>
		                <th>Name</th>
		                <th>Description</th>
		                <th>Date created</th>
		                <th>Image</th>
	
		            </tr>
		            <c:forEach var="nfts" items="${listNft}">
		                <tr style="text-align:center">
		                    <td><c:out value="${nfts.nftid}" /></td>
		                    <td><c:out value="${nfts.unique_name}" /></td>
		                    <td><c:out value="${nfts.description}" /></td>
		                    <td><c:out value="${nfts.created_date}" /></td>
		                    <td><c:out value="${nfts.nft_image}" /></td>
		            </c:forEach>
		        </table>
		 </center>
	</body>
</html>