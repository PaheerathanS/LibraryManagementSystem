<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<title>Edit Main Category</title>
</head>
<body>
	<%@page import="com.src.data.MainClassificationDao,com.src.model.MainClassification"%>  
	
	<%  
	String id=request.getParameter("id");  
	MainClassification mainClass=MainClassificationDao.getRecordById(id);  
	%>  

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
    </div>
    <br>
	<h2 style="margin-left:20px">Update Main Category </h2>
	<br>
	<form action="updateMainClass"  method="get" style="margin-left:20px">
		<input type="hidden" name="mainClassId" value="<%=mainClass.getMainCategoryId() %>"/>
            <table>
                <tr>
                    <td>Main Category Id</td>
                    <td><input type="text" name="mainClassId" value="<%=mainClass.getMainCategoryId() %>"/></td>
                </tr>
                 <tr>
                    <td>Category Name</td>
                    <td><input type="text" name="mainClass" value="<%=mainClass.getMainCategoryName() %>"/></td>
                </tr>
                <tr><td colspan="2" ><input type="submit" value="Update" /></td></tr>
            </table>
    </form>
</body>
</html>