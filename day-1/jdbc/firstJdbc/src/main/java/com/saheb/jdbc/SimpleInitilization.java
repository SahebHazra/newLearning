package com.saheb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SimpleInitilization {
    public static Connection getConnection(String url) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String user = "root";
        String password = "saheb";
        return DriverManager.getConnection(url, user, password);
    }
}