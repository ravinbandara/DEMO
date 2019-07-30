/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.*;


/**
 *
 * @author Lakith
 */
public class DAO {
    
    Connection conn = null;
    String selectcustomer = "SELECT * FROM customer WHERE username = ? AND password = ?";
    String selectserviceprovider = "SELECT * FROM serviceprovider WHERE companyname = ? AND password = ?";
    String selectadmin = "SELECT * FROM admin WHERE adminname = ? AND password = ?";
    
    String insertcustomer = "INSERT INTO customer VALUES (?,?,?,?,?)";
    String insertserviceprovider = "INSERT INTO serviceprovider VALUES (?,?,?,?,?,?)";
    
    public void connection() throws Exception{
    
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pwdb","root","");
        
    }
    
    public boolean validateCustomerlogin(Customer c1) throws SQLException{
        
        PreparedStatement stmt = conn.prepareStatement(selectcustomer);
        stmt.setString(1,c1.getUsername());
        stmt.setString(2,c1.getPassword());
        ResultSet result = stmt.executeQuery();
        
        if(result.next()){
            return true;
        
        }
        
        return false;
        
    }
    public boolean validateServiceProviderlogin(ServiceProvider sp) throws SQLException{
        
        PreparedStatement stmt = conn.prepareStatement(selectserviceprovider);
        stmt.setString(1,sp.getCompanyname());
        stmt.setString(2,sp.getPassword());
        ResultSet result = stmt.executeQuery();
        
        if(result.next()){
            return true;
        
        }
        
        return false;
        
    }
    public boolean validateAdmin(Admin ad) throws SQLException{
        
        PreparedStatement stmt = conn.prepareStatement(selectadmin);
        stmt.setString(1,ad.getAdminname());
        stmt.setString(2,ad.getPassword());
        ResultSet result = stmt.executeQuery();
        
        if(result.next()){
            return true;
        
        }
        
        return false;
        
    }
    
    public void insertCustomer(Customer c1) throws SQLException{
        PreparedStatement stmt = conn.prepareStatement(insertcustomer);
        stmt.setString(1,c1.getName());
        stmt.setString(2,null);
        stmt.setString(3,c1.getUsername());
        stmt.setString(4,c1.getEmail());
        stmt.setString(5,c1.getPassword());
        stmt.executeUpdate();
        
    }
    
    public void insertServiceProvider(ServiceProvider sp1) throws SQLException{
        PreparedStatement stmt = conn.prepareStatement(insertserviceprovider);
        stmt.setString(1,sp1.getCompanyname());
        stmt.setString(2,null);
        stmt.setString(3,sp1.getEmail());
        stmt.setString(4,sp1.getPassword());
        stmt.setString(5,sp1.getPassword());
        stmt.setString(6,"0");
        stmt.executeUpdate();
        
    }
    
}
