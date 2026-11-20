package com.saheb.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // try {
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        // } catch (Exception e) {
        //     System.out.println(e);
        // }

        try {
            String url = "jdbc:mysql://localhost:3306/firstDb";
            String user = "root";
            String password = "saheb";

            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                Statement statement = conn.createStatement();

                String query = """
                        INSERT INTO users(name,status)
                        values("saheb",true);
                        """;
                int affected = statement.executeUpdate(query);
                System.out.println("Total row affected : " + affected);

                ResultSet res = statement.executeQuery("select * from users");
                while (res.next()) {
                    String name = res.getString("name");
                    int id = res.getInt("id");
                    boolean status = res.getBoolean("status");
                    System.out.println(name + " : " + id + " : " + status);
                }
                statement.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            System.out.println("Done");
        }

    }
}
