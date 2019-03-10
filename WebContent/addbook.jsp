<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

	<%@page import="com.src.data.*,com.src.model.*,java.util.*,java.sql.*"%>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Add Book</title>

<script type="text/javascript">  
      var xmlHttp  
      var xmlHttp
      function showState(str){
    	  //alert(str);
	      if (typeof XMLHttpRequest != "undefined"){
	      	xmlHttp= new XMLHttpRequest();
	      }
	      else if (window.ActiveXObject){
	      	xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
	      }
	      if (xmlHttp==null){
	      	alert("Browser does not support XMLHTTP Request")
	      	return;
	      } 
	      
	      var url ="combobox.jsp";
	      url +="?count=" +str;
	      
	      xmlHttp.onreadystatechange = stateChange;
	      xmlHttp.open("GET", url, true);
	      stateChange();
	      xmlHttp.send(null);
      }

      function stateChange(){   
      	if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
      		document.getElementById("subCategory").innerHTML=xmlHttp.responseText   
      	}   
      }
</script>


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
    </div>
    <br>
	<h2 style="margin-left:20px">Add New Book </h2>
	<br>
	
	
	<form action="BookController"  method="get" style="margin-left:20px">
            <table>
                <tr>
                    <td>Book Id</td>
                    <td><input type="text" name="bookId"/></td>
                </tr>
                
                 <tr>
                    <td>Book Title</td>
                    <td><input type="text" name="bookTitle"/></td>
                </tr>
                
                 <tr>
                    <td>Author</td>
                    <td><input type="text" name="author"/></td>
                </tr>
                
                <%  
				List<MainClassification> list=MainClassificationDao.getAllRecords();  
				request.setAttribute("list",list);  
				%>  
                <tr>
                    <td>Main Category</td>
                    <td>
                    <select name="mainCategory" id="mainCategory" onchange="showState(this.value)">
                    	<!--<c:forEach items="${list}" var="mainClass">
                    		<option>${mainClass.getMainCategoryName()}</option>
                    	</c:forEach>-->
                    	<% 
							try { 
								Class.forName("com.mysql.jdbc.Driver"); 
							} catch (ClassNotFoundException e) { 
								e.printStackTrace(); 
								return; 
							} 
                    	
							Connection connection = null; 
							try { 
								connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root"); 
							} 
							catch (SQLException e) { 
								e.printStackTrace(); 
								return; 
							} 
							
							PreparedStatement stmt=null; 
							stmt=connection.prepareStatement("select * from main_category"); 
							ResultSet rs=null; 
							rs= stmt.executeQuery(); 
							while(rs.next()){ 
						%> 
							<option value="<%=rs.getString("mainClass")%>"><%=rs.getString("mainClass")%></option> 
						<% 
							} 
						%>
                    </select>
                    </td>
                </tr>
                
                <tr>
                    <td>Sub Category</td>
                    <td>
                
                    <select name="subCategory" id="subCategory">
                    	
                    </select>
                    </td>
                </tr>
                <tr><td colspan="2" ><input type="submit" value="Save" /></td></tr>
            </table>
            
        </form>
</body>
</html>