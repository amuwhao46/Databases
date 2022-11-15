<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Registration</title>
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
				padding:1rem;
			}
			
			.login {
				padding: .5rem;
				background-color: grey;
				border-radius: 0.25rem;
				margin: 3rem;
				color: white;
			}
		</style>
</head>
<body>
	<div align="center">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<div class="box">
			<h1>Register</h1>
			<form  action="register">
				<table border="1" cellpadding="5">
					<tr>
						<th>Email: </th>
						<td align="center" colspan="3">
							<input type="text" name="userid" size="45"  placeholder="example@gmail.com">
						</td>
					</tr>
					<tr>
						<th>First Name: </th>
						<td align="center" colspan="3">
							<input type="text" name="firstName" size="45" placeholder="FirstName">
						</td>
					</tr>
					<tr>
						<th>Last Name: </th>
						<td align="center" colspan="3">
							<input type="text" name="lastName" size="45" placeholder="LastName">
						</td>
					</tr>
					<tr>
						<th>Birthday: </th>
						<td align="center" colspan="3">
							<input type="text" name="birthday" size="45" placeholder="YYYY-MM-DD">
						</td>
		
					</tr>
					<tr>
						<th>Password: </th>
						<td align="center" colspan="3"> 
							<input type="password" name="password" size="45" placeholder="password">
						</td>
					</tr>
					<tr>
						<th>Password Confirmation: </th>
						<td align="center" colspan="3">
							<input type="password" name="confirmation" size="45" placeholder="password">
						</td>
					
					</tr>
					<tr>
						<td align="center" colspan="5">
							<input type="submit" value="Register"/>
						</td>
					</tr>
				</table>
			</form>
			<a class="login" href="login.jsp" target="_self">Return to Login Page</a>
		</div>
	</div>
</body>