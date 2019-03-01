package com.src.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.data.BookDao;
import com.src.model.Book;


public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Book book =new Book();
	BookDao bookDao=new BookDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        book.setAuthorName(request.getParameter("author"));
        book.setBookId(request.getParameter("bookId"));
        book.setBookTitle(request.getParameter("bookTitle"));
        book.setMainCategory(request.getParameter("mainCategory"));
        book.setSubCategory(request.getParameter("subCategory"));
        
    try {
        bookDao.saveBook(book);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
    }
      request.setAttribute("successMessage", "Book Successfully Added..");
        request.getRequestDispatcher("/books.jsp").forward(request, response);
    }
}
