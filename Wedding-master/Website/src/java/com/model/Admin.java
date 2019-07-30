/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Lakith
 */
public class Admin {
    
    private String adminname;
    private String password;

    public Admin() {
    }

    public Admin(String adminname, String adminpassword) {
        this.adminname = adminname;
        this.password = adminpassword;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String adminpassword) {
        this.password = adminpassword;
    }
    
    
    
}
