/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Admin;
import com.model.Customer;
import com.model.DAO;
import com.model.ServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lakith
 */
public class LoginServlet1 extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        String uname = request.getParameter("uname");
        String upword = request.getParameter("upword");
        
        
        Customer c1 =  new Customer();
        c1.setUsername(uname);
        c1.setPassword(upword);
        
        ServiceProvider sp = new ServiceProvider();
        sp.setCompanyname(uname);
        sp.setPassword(upword);
        
        Admin ad = new Admin();
        ad.setAdminname(uname);
        ad.setPassword(upword);
        
        DAO result = new DAO();
        try {
            result.connection();
            
            if(result.validateCustomerlogin(c1)){
               
                HttpSession session = request.getSession();
                session.setAttribute("customer",c1 );
                response.sendRedirect("SignupDecision.jsp");
                
            
            }
            else if(result.validateServiceProviderlogin(sp)){
               HttpSession session = request.getSession();
               session.setAttribute("serviceprovider",sp );
               response.sendRedirect("SignupCustomer.jsp");
            }
            else if(result.validateAdmin(ad)){
                HttpSession session = request.getSession();
                session.setAttribute("admin",sp );
                response.sendRedirect("index.html");
                
            }
            response.sendRedirect("HeaderNU.jsp");
            
        } catch (Exception ex) {
            
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
