package com.src.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.data.MainClassificationDao;

@WebServlet("/deleteMain")
public class DeleteMainClassification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteMainClassification() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainClassificationDao mc = new MainClassificationDao();
		
		String deleteId=request.getParameter("id");
		mc.delete(deleteId);
		response.sendRedirect("mainclassification.jsp");
		
	}
}
