<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.sql.*"%> 
	<%!int i;%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		String str=request.getParameter("count"); 
		//i=Integer.parseInt(str); 
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
		stmt=connection.prepareStatement("select * from sub_category where mainClass=?"); 
		stmt.setString(1, str);
		ResultSet rs=null; 
		rs= stmt.executeQuery();
		System.out.println(stmt);
		while(rs.next()){ 
	%> 
			<option value="<%=rs.getString("subClass")%>"><%=rs.getString("subClass")%></option> 
	<% 
		} 
	%> 
	
</body>
</html>