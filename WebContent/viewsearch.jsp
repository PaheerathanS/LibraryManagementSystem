<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<title>Search Results</title>
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
                <a href="mainclassification.jsp">Main Classification</a>
                <a href="subclassification.jsp">Sub Classification</a>
              </div>
            </div> 
            <div class="search-container">
			    <form action="searchView" method="get">
			      <input class="searchinput" type="text" placeholder="Search.." name="search">
			      <button type="submit"><i class="fa fa-search"></i></button>
			    </form>
  			</div>
    </div>

	<br><br><br>
	
	<br>
	
	<%@page import="com.src.data.*,com.src.model.*,java.util.*"%>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
  
  	<br><br>
	<h2 style="margin-left:20px">Search Results </h2>  
  	
	<%  
	List<Book> list=BookDao.getSearchRecords();  
	request.setAttribute("list",list);  
	%>  
  
	<table class="w3-table-all" style="width:80%; margin-left:20px">  
		<tr class="w3-green"><th>Book Id</th><th>Book Title</th><th>Author Name</th><th>Main Category</th>  
		<th>Sub Category</th><th>Edit</th><th>Delete</th></tr>  
			<c:forEach items="${list}" var="book">  
				<tr><td>${book.getBookId()}</td><td>${book.getBookTitle()}</td><td>${book.getAuthorName()}</td>  
				<td>${book.getMainCategory()}</td><td>${book.getSubCategory()}</td>  
				<td><a href="editform.jsp?id=${book.getBookId()}"><i style="font-size:20px" class="fa fa-edit"></i></a></td>  
				<td><a href="deleteBook?id=${book.getBookId()}"><i style="font-size:20px" class="fa fa-trash"></i></a></td></tr>  
			</c:forEach>  
			
	</table>  
</body>
</html>