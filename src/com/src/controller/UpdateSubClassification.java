package com.src.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.data.SubClassificationDao;
import com.src.model.SubClassification;

@WebServlet("/updateSubClass")
public class UpdateSubClassification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UpdateSubClassification() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubClassificationDao sc = new SubClassificationDao();
		SubClassification subClass = new SubClassification();
		subClass.setSubCategoryId(request.getParameter("subClassId"));
		subClass.setSubCategoryName(request.getParameter("subClass"));
		subClass.setMainCategoryName(request.getParameter("mainClass"));
		sc.update(subClass);
		response.sendRedirect("subclassification.jsp");
	}
}
