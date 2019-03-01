package com.src.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.data.BookDao;

@WebServlet("/deleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bd = new BookDao();
		//PrintWriter out=response.getWriter();
		
		String deleteId=request.getParameter("id");
		bd.delete(deleteId);
		response.sendRedirect("books.jsp");
		
	}

}
