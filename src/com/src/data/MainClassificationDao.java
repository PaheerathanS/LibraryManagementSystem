package com.src.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.src.model.MainClassification;

public class MainClassificationDao {
	
	public void saveMainCategory(MainClassification mainClass) throws ClassNotFoundException, SQLException{
		DatabaseConnection dbConnection=new DatabaseConnection();
        Connection con=dbConnection.getConnection();
        PreparedStatement stmt=con.prepareStatement("insert into main_category values(?,?)");
        stmt.setString(1, mainClass.getMainCategoryId());
        stmt.setString(2, mainClass.getMainCategoryName());
        stmt.executeUpdate();
    }
	
	public static List<MainClassification> getAllRecords(){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    List<MainClassification> list=new ArrayList<MainClassification>();  
	    try{  
	        Connection con= dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from main_category");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            MainClassification mainClass=new MainClassification();  
	            mainClass.setMainCategoryId(rs.getString("mainClassId"));
	            mainClass.setMainCategoryName(rs.getString("mainClass"));
	            list.add(mainClass);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	public static MainClassification getRecordById(String mainCategoryId){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    MainClassification mainClass=null;  
	    try{  
	        Connection con=dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from main_category where mainClassId=?");  
	        ps.setString(1,mainCategoryId);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            mainClass=new MainClassification();  
	            mainClass.setMainCategoryId(rs.getString("mainClassId"));  
	            mainClass.setMainCategoryName(rs.getString("mainClass"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return mainClass;  
	}
	
	public void delete(String id){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    
		String s="'";
	    try{  
	        Connection con=dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from main_category where mainClassId="+ s +id + s);
	        ps.executeUpdate(); 
	    }catch(Exception e){System.out.println(e);}  
	    
	}
	
	public void update(MainClassification mainClass){
		DatabaseConnection dbConnection=new DatabaseConnection();
	    
	    try{  
	        Connection con=dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("update main_category set mainClassId=?,mainClass=? where mainClassId=?");  
	        ps.setString(1,mainClass.getMainCategoryId());  
	        ps.setString(2,mainClass.getMainCategoryName());  
	        ps.setString(3,mainClass.getMainCategoryId());
	        ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	     
	}  
	
	public static List<MainClassification> getAllMainClassNames(){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    List<MainClassification> list=new ArrayList<MainClassification>();  
	    try{  
	        Connection con= dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select mainClass from main_category");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	MainClassification mainClass=new MainClassification();
	            mainClass.setMainCategoryName(rs.getString("subClass"));
	            list.add(mainClass);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	} 
}
