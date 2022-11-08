<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <!DOCTYPE html>
 <html>
	 <head>
	 	<title>Search</title>
	 </head>
	 
	 <body>
		 <br>
		 <form action="search">
		 	<label for="searching"><h2>SEARCH</h2></label>
		 	<input type="text" id="searching" name="searching"><br><br>
		 	<input type="submit" value="Submit">
		 </form>
		 <a href="activitypage.jsp" target="_self">Back</a>
	 </body>
 </html>