package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/login";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
  
    
    public static boolean check(String uname, String pass) throws ClassNotFoundException, SQLException {
        String SQL = "select * from credentials where name=? and password=?";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
        PreparedStatement statement = con.prepareStatement(SQL);
        statement.setString(1, uname);
        statement.setString(2, pass);
        ResultSet result = statement.executeQuery();
        return result.next();     
    }
}
