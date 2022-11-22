<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>User Profile Page</title>
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
   <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Information for <c:out value="${users.userid}" /></h2></caption>
            <tr>
				<th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <!-- <th>address</th> -->
				<!-- <th>Password</th> -->
                <!-- <th>Birthday</th> -->
                <th>init_bal(ETH)</th>
            </tr>
            <c:forEach var="users" items="${userNFT}">
                <tr style="text-align:center">
                    <td><c:out value="${users.userid}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <%-- <td><c:out value= "${users.address_street_num} ${users.address_street} ${users.address_city} ${users.address_state} ${users.address_zip_code}" /></td> --%>
                    <%-- <td><c:out value="${users.password}" /></td> --%>
                    <%-- <td><c:out value="${users.birthday}" /></td> --%>
                    <td><c:out value="${users.init_bal}"/></td>
                </tr>
            </c:forEach>
        </table>
        
        <h1>Your current NFTs</h1>
	    <table class=table-container border="1" cellpadding="6">
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
       </table>
        
    </div>   
</body>
</html>