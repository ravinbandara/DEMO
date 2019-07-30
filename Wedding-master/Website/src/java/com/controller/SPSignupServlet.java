/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.DAO;
import com.model.ServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lakith
 */
public class SPSignupServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SPSignupServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SPSignupServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String spcname = request.getParameter("spcname");
        String spcategory = request.getParameter("spcategory");
        String spemail = request.getParameter("spemail");
        String sppword = request.getParameter("sppword");
        String spcpword = request.getParameter("spcpword");
        
        PrintWriter out = response.getWriter();
        out.println(spcategory);
        
        ServiceProvider sp2 = new ServiceProvider();
        sp2.setCompanyname(spcname);
        sp2.setEmail(spemail);
        sp2.setCategory(spcategory);
        sp2.setPassword(spcpword);
        
        DAO insertserviceprovider = new DAO();
        try {
            insertserviceprovider.connection();
        } catch (Exception ex) {
            Logger.getLogger(SPSignupServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            insertserviceprovider.insertServiceProvider(sp2);
        } catch (SQLException ex) {
            Logger.getLogger(SPSignupServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
