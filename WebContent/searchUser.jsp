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
	    <a class="Button3" href="searchNFT" target="_self">Search NFTs</a>
	    <a class="Button" href="goHome" target="_self">Back</a>
	    
	    <!-- Lists and allows search for users -->
		<h1>Current Users</h1>
	    <table class="table-container" id="userTable" border="1" cellpadding="6">
		    <tr>
		        <th>Email</th>
 		        <th>First name</th>
		        <th>Last name</th>
		    </tr>
		    <c:forEach var="users" items="${listUser}">
		        <tr id="userItem">
		        	<td>
     				    <a href="userProfile?userid=<c:out value="${users.userid}" />">
		        			<c:out value="${users.userid}"></c:out>
		        		</a>
		        	</td>
 		            <td><c:out value="${users.firstName}" /></td>
		            <td><c:out value="${users.lastName}" /></td>
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
			  table = document.getElementById("userTable");
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