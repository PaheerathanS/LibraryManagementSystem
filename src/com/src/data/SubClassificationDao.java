package com.src.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.src.model.SubClassification;

public class SubClassificationDao {
	public void saveSubCategory(SubClassification subClass) throws ClassNotFoundException, SQLException{
		DatabaseConnection dbConnection=new DatabaseConnection();
        Connection con=dbConnection.getConnection();
        PreparedStatement stmt=con.prepareStatement("insert into sub_category values(?,?,?)");
        stmt.setString(1, subClass.getSubCategoryId());
        stmt.setString(2, subClass.getSubCategoryName());
        stmt.setString(3, subClass.getMainCategoryName());
        stmt.executeUpdate();
    }
	
	public static List<SubClassification> getAllRecords(){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    List<SubClassification> list=new ArrayList<SubClassification>();  
	    try{  
	        Connection con= dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from sub_category");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            SubClassification subClass=new SubClassification();  
	            subClass.setSubCategoryId(rs.getString("subClassId"));
	            subClass.setSubCategoryName(rs.getString("subClass"));
	            subClass.setMainCategoryName(rs.getString("mainClass"));
	            list.add(subClass);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	public static SubClassification getRecordById(String subCategoryId){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    SubClassification subClass=null;  
	    try{  
	        Connection con=dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from sub_category where subClassId=?");  
	        ps.setString(1,subCategoryId);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            subClass=new SubClassification();  
	            subClass.setSubCategoryId(rs.getString("subClassId"));  
	            subClass.setSubCategoryName(rs.getString("subClass"));
	            subClass.setMainCategoryName(rs.getString("mainClass"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return subClass;  
	}
	
	public void delete(String id){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    
		String s="'";
	    try{  
	        Connection con=dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from sub_category where subClassId="+ s +id + s);
	        ps.executeUpdate(); 
	    }catch(Exception e){System.out.println(e);}  
	    
	}
	
	public void update(SubClassification subClass){
		DatabaseConnection dbConnection=new DatabaseConnection();
	    
	    try{  
	        Connection con=dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("update sub_category set subClassId=?,subClass=?,mainClass=? where subClassId=?");  
	        ps.setString(1,subClass.getSubCategoryId());  
	        ps.setString(2,subClass.getSubCategoryName());  
	        ps.setString(3,subClass.getMainCategoryName());  
	        ps.setString(4,subClass.getSubCategoryId());
	        ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	     
	}
	
}
