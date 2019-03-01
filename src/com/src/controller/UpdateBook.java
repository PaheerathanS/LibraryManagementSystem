package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.data.BookDao;
import com.src.model.Book;


@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateBook() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bd = new BookDao();
		Book book = new Book();
		book.setBookId(request.getParameter("bookId"));
		book.setBookTitle(request.getParameter("bookTitle"));
		book.setAuthorName(request.getParameter("author"));
		book.setMainCategory(request.getParameter("mainCategory"));
		book.setSubCategory(request.getParameter("subCategory"));
		bd.update(book);
		response.sendRedirect("books.jsp");
	}

}
