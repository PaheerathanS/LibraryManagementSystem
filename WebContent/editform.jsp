<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.src.data.BookDao,com.src.model.Book,java.sql.*"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<title>Edit Book</title>

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
                <a href="mainclassification.jsp">Main Classification</a>
                <a href="subclassification.jsp">Sub Classification</a>
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
                    <td><input type="text" name="bookId" readonly="readonly" value="<%=book.getBookId() %>"/></td>
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
                    <td>
                    <select name="mainCategory" id="mainCategory" onchange="showState(this.value)">
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
							
								PreparedStatement stmt=null; 
								stmt=connection.prepareStatement("select * from main_category"); 
								ResultSet rs=null; 
								rs= stmt.executeQuery(); 
								while(rs.next()){ 
							%> 
								<option value="<%=rs.getString("mainClass")%>"><%=rs.getString("mainClass")%></option> 
							<% 
								} 
							} 
							catch (SQLException e) { 
								e.printStackTrace(); 
								return; 
							} 
						%>
                    </select>
                    </td>
                </tr>
                
                <tr>
                    <td>Sub Category</td>
                    <td>
                    <select name="subCategory" id="subCategory">
                    	<option value="<%=book.getSubCategory()%>"> <%=book.getSubCategory()%> </option>
                    </select>
                    </td>
                </tr>
                <tr><td colspan="2" ><input type="submit" value="Update Book" /></td></tr>
            </table>
            
        </form>
</body>
</html>