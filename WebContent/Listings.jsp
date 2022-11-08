<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List an NFT!</title>
</head>
<body>
<div align="center">
			<form method="post" action="createListing">
				<table border="1" cellpadding="5">
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