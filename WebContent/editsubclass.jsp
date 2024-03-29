<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<title>Edit Sub Category</title>
</head>
<body>
	<%@page import="com.src.data.*,com.src.model.*,java.util.*"%>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%  
	String id=request.getParameter("id");  
	SubClassification subClass=SubClassificationDao.getRecordById(id);  
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
	<h2 style="margin-left:20px">Update Sub Category </h2>
	<br>
	<form action="updateSubClass"  method="get" style="margin-left:20px">
		<input type="hidden" name="subClassId" value="<%=subClass.getSubCategoryId() %>"/>
            <table>
                <tr>
                    <td>Sub Category Id</td>
                    <td><input type="text" name="subClassId" value="<%=subClass.getSubCategoryId() %>"/></td>
                </tr>
                 <tr>
                    <td>Category Name</td>
                    <td><input type="text" name="subClass" value="<%=subClass.getSubCategoryName() %>"/></td>
                </tr>
                <%  
				List<MainClassification> list=MainClassificationDao.getAllRecords();  
				request.setAttribute("list",list);  
				%> 
                <tr>
                    <td>Main Category</td>
                    <td>
                    	<!-- <input type="text" name="mainClass" value="<%=subClass.getMainCategoryName() %>"/> -->
                    	<select>
                    		<option value="<%=subClass.getMainCategoryName() %>"> <%=subClass.getMainCategoryName()%></option>
                    		<c:forEach items="${list}" var="mainClass">
                    			<!-- <option value="<%=subClass.getMainCategoryName() %>"> <%=subClass.getMainCategoryName()%> </option> -->
                    		<option>${mainClass.getMainCategoryName()}</option>
                    		</c:forEach>
                    	</select>
                    </td>
                </tr>
                <tr><td colspan="2" ><input type="submit" value="Update" /></td></tr>
            </table>
    </form>
</body>
</html>