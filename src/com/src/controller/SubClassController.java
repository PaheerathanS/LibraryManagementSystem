package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.data.SubClassificationDao;
import com.src.model.SubClassification;

@WebServlet("/subClassController")
public class SubClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SubClassification subClass = new SubClassification();
	SubClassificationDao subClassDao = new SubClassificationDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        subClass.setSubCategoryId(request.getParameter("subClassId"));
        subClass.setSubCategoryName(request.getParameter("subClass"));
        subClass.setMainCategoryName(request.getParameter("mainClass"));
        
    try {
    	subClassDao.saveSubCategory(subClass);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(SubClassController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(SubClassController.class.getName()).log(Level.SEVERE, null, ex);
    }
      request.setAttribute("successMessage", "Sub Category Successfully Added..");
        request.getRequestDispatcher("/subclassification.jsp").forward(request, response);
    }
}
