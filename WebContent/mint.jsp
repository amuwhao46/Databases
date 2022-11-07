<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<title>Mint an NFT</title>
	</head>
	<body>
	<h1>Mint your first NFT!</h1>
	<div align="center">
		<form action="mint">
			<table border="1" cellpadding="5">
				<tr>
					<th>ID:</th>
					<td align="center" colspan="3">
						<input type="text" name="nftid" size="45"  value="1" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Name:</th>
					<td align="center" colspan="3">
						<input type="text" name="unique_name" size="45"  value="Big Chungus" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Description:</th>
					<td align="center" colspan="3">
						<input type="text" name="description" size="45"  value="Elongated Bugs Bunny" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Date Created:</th>
					<td align="center" colspan="3">
						<input type="text" name="created_date" size="45"  value="1969-07-16" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Image URL:</th>
					<td align="center" colspan="3">
						<input type="text" name="nft_image" size="45"  value="bigchungus.com" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Mint"/>
					</td>
				</tr>
			</table>
		</form>
		<a href="activitypage.jsp" target="_self">Back to Activity Page</a>
	</div>
	</body>
</html>