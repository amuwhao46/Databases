<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Login to Database</title>
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
			.register {
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
		 	<h1> NFT</h1>
			<p> ${loginFailedStr} </p>
			<form action="login" method="post">
				<table border="1" cellpadding="5">
					<tr>
						<th>Email: </th>
						<td>
							<input type="text" name="userid" size="45" autofocus>
						</td>
					</tr>
					<tr>
						<th>Password: </th>
						<td> 
							<input type="password" name="password" size="45">
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="Login"/>
						</td>
					</tr>
				</table>
			</form>
			<a class="register" href="register.jsp" target="_self">Register</a>
		</div>
	</body>
</html>