<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
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
				padding: 10px;
			}
			.table-container {
				margin-left:auto;
				margin-right:auto;
				margin-bottom: 2rem;
			}
			th {
				height: 4rem;
			}
			.input-container {
				box-sizing: border-box;
				padding: 1rem;
				border: 2px solid black;
				border-radius: 4px;
				outline: none;
				transition: 0.3s;
				margin-bottom: 2rem;
			}
			.input-container:focus {
				border: 2px solid #FFD700;
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
				background-color: red;
				border-radius: 0.25rem;
				margin: 1rem;
				color: white;
				outline: none;
				cursor: pointer;
				transition: 0.3s;
			}
			.Button2:hover {
				background-color: green;
			}
			.Button3 {
				padding: .5rem;
				background-color: blue;
				border-radius: 0.25rem;
				margin: 1rem;
				color: white;
			}
	 	</style>
	 </head>
	 <body>
	    <h1>Search for NFT's</h1>
	    
		<input class="input-container" type="text" id="nftInput" onkeyup="func()" placeholder="Search" />
	    <a class="Button3" href="searchUser" target="_self">Search Users</a>
	    <a class="Button" href="goHome" target="_self">Home</a>
		
		<!-- Lists and allows search for nfts -->
		<h3>Listed NFT's that can be bought</h3>
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
		        <td>
		        	<a href="nftProfile?nftid=<c:out value="${nfts.nftid}" />">
		        		${nfts.unique_name}
		        	</a>
		        </td>
		        <td><c:out value="${nfts.description}" /></td>
		        <td><img src="<c:out value="${nfts.nft_image}"/>" alt="url link to image to nft"/></td>
		        <td><c:out value="${nfts.owner}" /></td>
		        <td><c:out value="${nfts.creator}" /></td>  
		        <td><c:out value="${nfts.mint_time}" /></td>
	        	<td>
		            <a href="buy?nftid=<c:out value="${nfts.nftid}" />">
		                <button class="Button2">Buy</button>
		            </a>
		        </td>  
		    </tr>
		    </c:forEach>
		</table>
		
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