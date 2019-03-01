package com.src.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.src.model.Book;

public class BookDao {
	
	static String searchValue;
	
	public void saveBook(Book book) throws ClassNotFoundException, SQLException{
		DatabaseConnection dbConnection=new DatabaseConnection();
        Connection con=dbConnection.getConnection();
        PreparedStatement stmt=con.prepareStatement("insert into book_detail values(?,?,?,?,?)");
        stmt.setString(1, book.getBookId());
        stmt.setString(2, book.getBookTitle());
        stmt.setString(3, book.getAuthorName());
        stmt.setString(4, book.getMainCategory());
        stmt.setString(5, book.getSubCategory());
        stmt.executeUpdate();
    }
	
	public static List<Book> getAllRecords(){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    List<Book> list=new ArrayList<Book>();  
	    try{  
	        Connection con= dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from book_detail");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Book book=new Book();  
	            book.setBookId(rs.getString("bookId"));  
	            book.setBookTitle(rs.getString("bookTitle"));  
	            book.setAuthorName(rs.getString("author"));  
	            book.setMainCategory(rs.getString("mainCategory"));  
	            book.setSubCategory(rs.getString("subCategory")); 
	            list.add(book);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	public static Book getRecordById(String bookId){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    Book book=null;  
	    try{  
	        Connection con=dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from book_detail where bookId=?");  
	        ps.setString(1,bookId);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            book=new Book();  
	            book.setBookId(rs.getString("bookId"));  
	            book.setBookTitle(rs.getString("bookTitle"));  
	            book.setAuthorName(rs.getString("author"));  
	            book.setMainCategory(rs.getString("mainCategory"));  
	            book.setSubCategory(rs.getString("subCategory"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return book;  
	}
	
	public void delete(String id){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    
		String s="'";
	    try{  
	        Connection con=dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from book_detail where bookId="+ s +id + s);  
	        //ps.setString(1,book.getBookId());  
	        ps.executeUpdate(); 
	    }catch(Exception e){System.out.println(e);}  
	    
	}
	
	public void update(Book book){
		DatabaseConnection dbConnection=new DatabaseConnection();
	    
	    try{  
	        Connection con=dbConnection.getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update book_detail set bookId=?,bookTitle=?,author=?,mainCategory=?,subCategory=? where bookId=?");  
	        ps.setString(1,book.getBookId());  
	        ps.setString(2,book.getBookTitle());  
	        ps.setString(3,book.getAuthorName());  
	        ps.setString(4,book.getMainCategory());  
	        ps.setString(5,book.getSubCategory());  
	        ps.setString(6,book.getBookId());  
	        ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	     
	}  
	
	public String getSearchValue(String value) {
		searchValue = value;
		return searchValue;
	}
	
	public static List<Book> getSearchRecords(){  
		DatabaseConnection dbConnection=new DatabaseConnection();
	    List<Book> list=new ArrayList<Book>();  
	    try{  
	        Connection con= dbConnection.getConnection();  
	        String searchQuery = "select * from book_detail where bookId like '%" + searchValue + 
	        		"%' or bookTitle like '%" + searchValue + "%' or author like '%" + searchValue + 
	        		"%' or mainCategory like '%" + searchValue + "%' or subCategory like '%" + searchValue + "%'";
	        System.out.println(searchQuery);
	        PreparedStatement ps=con.prepareStatement(searchQuery);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Book book=new Book();  
	            book.setBookId(rs.getString("bookId"));  
	            book.setBookTitle(rs.getString("bookTitle"));  
	            book.setAuthorName(rs.getString("author"));  
	            book.setMainCategory(rs.getString("mainCategory"));  
	            book.setSubCategory(rs.getString("subCategory")); 
	            list.add(book);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}
}
