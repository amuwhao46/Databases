<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
 
 
 <!DOCTYPE html>
 <html>
	 <head>
	 	<title>Search</title>
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
			.table-container {
				margin-left:auto;
				margin-right:auto;
				margin-bottom: 2rem;
			}
			.search-container {
				box-sizing: border-box;
				padding: 1rem;
				border: 2px solid black;
				border-radius: 4px;
				outline: none;
				transition: 0.3s;
				margin-bottom: 2rem;
			}
			.search-container:focus {
				border: 2px solid #FFD700;
			}
	 	</style>
	 </head>
	 <body>
	    <h1>Search available NFT's</h1>
	    
		<input class="search-container" type="text" id="nftInput" onkeyup="func()" placeholder="Search" />
		
		<table class="table-container" border="1" cellpadding="6">
	    <tr>
	        <th>NFTID</th>
	        <th>Owner</th>
	        <th>Start Time</th>
	        <th>End Time</th>
	        <th>Price</th>
	    </tr>
	    <c:forEach var="list" items="${allListings}">
	    <tr>
	        <td><c:out value="${list.nftid}" /></td>
	        <td><c:out value="${list.owner}" /></td>
	        <td><c:out value="${list.start}" /></td>
	        <td><c:out value="${list.end}"/></td>
	        <td><fmt:formatNumber type="currency" value="${list.price}" /></td>
	    </tr>
	    </c:forEach>
		</table>
		
		<h3>Listed NFT's can be bought</h3>
		<table class="table-container" border="1" cellpadding="6" id="nftTable">
		    <tr>
		        <th>NFTID</th>
		        <th>Name</th>
		        <th>Description</th>
		        <th>Image</th>
		        <th>Owner</th>
		        <th>Creator</th>
		        <th>Date Created</th>
		        <th>Buy</th>
		    </tr>
		    <c:forEach var="nfts" items="${listNft}">
		    
		    <tr>
		        <td><c:out value="${nfts.nftid}" /></td>
		        <td><c:out value="${nfts.unique_name}" /></td>
		        <td><c:out value="${nfts.description}" /></td>
		        <td><img src="<c:out value="${nfts.nft_image}"/>" alt="url link to image to nft"/></td>
		        <td><c:out value="${nfts.owner}" /></td>
		        <td><c:out value="${nfts.creator}" /></td>  
		        <td><c:out value="${nfts.mint_time}" /></td>
	        <td>
		            <a href="buy?nftid=<c:out value="${nfts.nftid}" />">
		                <button class="unnamed">Buy</button>
		            </a>
		        </td>   
		    </tr>
		    </c:forEach>
		</table>
		<a href="goHome" target="_self">Back</a>
		
			 		<script>
				function func() {
				  let input;
				  let filter;
				  let table;
				  let tr;
				  let td;
				  let i;
				  let textVal;
				  
				  input = document.getElementById("nftInput");
				  filter = input.value.toUpperCase();
				  table = document.getElementById("nftTable");
				  tr = table.getElementsByTagName("tr");
				
				  for (i = 0; i < tr.length; i++) {
				   	td = tr[i].getElementsByTagName("td")[1];
				    if (td) {
				    	textVal = td.textContent || td.innerText;
				      if (textVal.toUpperCase().indexOf(filter) > - 1) {
				        tr[i].style.display = "";
				      } else {
				        tr[i].style.display = "none";
				      }
				    }
				  }
				}
			</script>
	 </body>
 </html>