<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<title>Mint an NFT</title>
			<style>
				body {
					font-family: 'Roboto', sans-serif;
					background-color: rgb(255, 153, 153);
					padding: 5rem;
				}
				
				.box {
					background-color:white;
					filter: drop-shadow(0 4px 3px rgb(0 0 0 / 0.07)) drop-shadow(0 2px 2px rgb(0 0 0 / 0.06));
					border-radius: 0.25rem;
					display:flex;
					flex-direction: column;
					justify-content: center;
					align-items: center;
					padding-bottom:1rem;
				}
				.button {
					position: relative;
					padding: .5rem;
					background-color: grey;
					border-radius: 0.25rem;
					margin: 3rem;
					color: white;
				}
			</style>
	</head>
	<body>
		<div class="box">
			<h1>Mint your first NFT!</h1>
			<form method="post" action="mint">
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
			<a class="button" href="activitypage.jsp" target="_self">Back to Activity Page</a>
		</div>
	</body>
</html>