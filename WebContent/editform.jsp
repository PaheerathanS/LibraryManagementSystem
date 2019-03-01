<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<title>Edit Book</title>
</head>
<body>

	<%@page import="com.src.data.BookDao,com.src.model.Book"%>  
	
	<%  
	String id=request.getParameter("id");  
	Book book=BookDao.getRecordById(id);  
	%>  

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
	<h2 style="margin-left:20px">Update Book </h2>
	<br>
	<form action="UpdateBook"  method="get" style="margin-left:20px">
		<input type="hidden" name="bookId" value="<%=book.getBookId()%>"/>
            <table>
                <tr>
                    <td>Book Id</td>
                    <td><input type="text" name="bookId" value="<%=book.getBookId() %>"/></td>
                </tr>
                
                 <tr>
                    <td>Book Title</td>
                    <td><input type="text" name="bookTitle" value="<%=book.getBookTitle() %>"/></td>
                </tr>
                
                 <tr>
                    <td>Author</td>
                    <td><input type="text" name="author" value="<%=book.getAuthorName() %>"/></td>
                </tr>
                
                <tr>
                    <td>Main Category</td>
                    <td><input type="text" name="mainCategory" value="<%=book.getMainCategory() %>"/></td>
                </tr>
                
                <tr>
                    <td>Sub Category</td>
                    <td><input type="text" name="subCategory" value="<%=book.getSubCategory() %>"/></td>
                </tr>
                <tr><td colspan="2" ><input type="submit" value="Update Book" /></td></tr>
            </table>
            
        </form>
</body>
</html>