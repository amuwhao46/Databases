<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>NFT</title>
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
		<div align = "center">
			<a class="Button" href="goHome" target="_self">Home</a>
			<h1>List all userNFT</h1>
		    <div align="center">
		        <table border="1" cellpadding="6">
		            <caption>List of userNFT</caption>
		            <tr>
		               <th>NFTid</th>
		               <th>Name</th>
		               <th>Description</th>
		               <th>Image</th>
		               <th>Creator</th>
		               <th>Time Minted</th>
		               <th>Minted by</th>
		            </tr>
		                <tr style="text-align:center">
		                    <td><c:out value="${userNFT.nftid}" /></td>
		                    <td><c:out value="${userNFT.unique_name}" /></td>
		                    <td><c:out value="${userNFT.description}" /></td>
		                    <td><img src="<c:out value="${userNFT.nft_image}"/>" alt="url link to image to nft"/></td>
                            <td><c:out value="${userNFT.creator}" /></td>
                			<td><c:out value="${userNFT.mint_time}" /></td>
                		</tr>
		        </table>
		        <table border="1" cellpadding="6">
		            <caption>Activity of userNFT</caption>
		            <tr>
		               <th>Receiver</th>
		               <th>Sender</th>
		               <th>Transaction Type</th>
		               <th>Price</th>
		               <th>Timestamp</th>
		            </tr>
		            <c:forEach var="entry" items="${nftActivity}">
		                <tr style="text-align:center">
		                    <td><c:out value="${entry.reciever}}" /></td>
		                    <td><c:out value="${entry.sender}" /></td>
		                    <td><c:out value="${entry.transType}" /></td>
		                    <td><c:out value="${entry.price}" /></td>
                            <td><c:out value="${entry.timeStamp}}" /></td>

		            </c:forEach>
		        </table>
			</div>
		</div>
	</body>
</html>