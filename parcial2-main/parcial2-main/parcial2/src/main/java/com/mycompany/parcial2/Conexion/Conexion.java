package com.mycompany.parcial2.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    public static Connection Conectar() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/personas","root","1234");
            Statement stmt=con.createStatement();  
            
            ResultSet rs=stmt.executeQuery("show databases;");
            return con;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }  
}
