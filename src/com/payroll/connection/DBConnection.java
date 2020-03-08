/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payroll.connection;


import com.payroll.business.MessageForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kashif Ali
 */
public class DBConnection {

    private static Connection con = null;
    
    public static void main(String [] args)
    {
       Connection c =  DBConnection.getInstance();
       if(c!=null)
       {
           System.out.println("Connected.");
           Statement st;
           try {
               st = c.createStatement();
               ResultSet rs = st.executeQuery("Select * from users;");
               while(rs.next())
               {
                   System.out.println(rs.getString(2));
               }
           } catch (SQLException ex) {
               Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else{
           System.out.println("Error.");
       }
    }
    
    private DBConnection(){};
    
    public static Connection getInstance(){
       
        if(con == null){
            try {
                makeConnection();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system","root","tiger");
            } catch (Exception ex) {
                new MessageForm("Error",ex.toString(),"error.png");
            }
            
        }
        
        return con;
    }
    
    private static void makeConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
    }
}


