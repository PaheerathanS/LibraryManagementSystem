<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book Status</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class="navbar">
            <a href="index.jsp">Home</a>
            <a href="books.jsp">Book</a>

            <div class="dropdown">
              <button class="dropbtn">Classification 
                <i class="fa fa-caret-down"></i>
              </button>
              <div class="dropdown-content">
                <a href="mainclassification.html">Main Classification</a>
                <a href="subclassification.html">Sub Classification</a>
              </div>
            </div> 
    </div>
    <br>
	<h3><c:out value="${successMessage}"/></h3>
	<br><br>
	<a href="books.jsp">View in the Book List</a>
</body>
</html>