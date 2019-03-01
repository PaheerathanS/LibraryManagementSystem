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

import com.src.data.MainClassificationDao;
import com.src.model.MainClassification;

@WebServlet("/mainClassController")
public class MainClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MainClassification mainClass = new MainClassification();
	MainClassificationDao mainClassDao = new MainClassificationDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        mainClass.setMainCategoryId(request.getParameter("mainClassId"));
        mainClass.setMainCategoryName(request.getParameter("mainClass"));
        
    try {
        mainClassDao.saveMainCategory(mainClass);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MainClassController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(MainClassController.class.getName()).log(Level.SEVERE, null, ex);
    }
      request.setAttribute("successMessage", "Main Category Successfully Added..");
        request.getRequestDispatcher("/mainclassification.jsp").forward(request, response);
    }
}
