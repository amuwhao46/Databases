<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
 
 
 <!DOCTYPE html>
 <html>
	 <head>
	 	<title>Search</title>
	 </head>
	 
	 <body>
		<table border="1" cellpadding="6">
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
		<input type="text" id="nftInput" onkeyup="func()" placeholder="Search" />
	    <h1>Search available NFT's</h1>
		<h3>Listed NFT's can be bought</h3>
		<table border="1" cellpadding="6" id="nftTable">
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
		    <c:forEach var="nfts" items="${listNFT}">
		    <tr>
		        <td><c:out value="${nfts.nftid}" /></td>
		        <td><c:out value="${nfts.unique_name}" /></td>
		        <td><c:out value="${nfts.description}" /></td>
		        <td><img src="<c:out value="${nfts.nft_image}"/>" alt="url link to image to nft"/></td>
		        <td><c:out value="${nfts.owner}" /></td>
		        <td><c:out value="${nfts.creator}" /></td>  
		        <td><c:out value="${nfts.mint_time}" /></td>
<%-- 		        <td>
		            <a href="buy?nftid=<c:out value="${nfts.nftid}" />">
		                <button class="unnamed">Buy</button>
		            </a>
		        </td>  --%>  
		    </tr>
		    </c:forEach>
		</table>
		<a href="activitypage.jsp" target="_self">Back</a>
		<script>
			function func() {
			  // Declare variables
			  let input, filter, table, tr, td, i, txtValue;
			  input = document.getElementById("nftInput");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("nftTable");
			  tr = table.getElementsByTagName("tr");
			
			  // Loop through all table rows, and hide those who don't match the search query
			  for (i = 0; i < tr.length; i++) {
			   	td = tr[i].getElementsByTagName("td")[1];
			    if (td) {
			      txtValue = td.textContent || td.innerText;
			      if (txtValue.toUpperCase().indexOf(filter) > - 1) {
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