package com.saheb.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;

class BasicJdbc {
    public static void run() {

        try {
            String url = "jdbc:mysql://localhost:3306/firstDb";
            Statement statement = SimpleInitilization.getConnection(url).createStatement();
            String query = """
                    INSERT INTO users(name,status)
                    values("saheb",true);
                    """;
            int affected = statement.executeUpdate(query);
            System.out.println("Total row affected : " + affected);

            System.out.println("here " + statement.getConnection());

            ResultSet res = statement.executeQuery("select * from users");
            while (res.next()) {
                String name = res.getString("name");
                int id = res.getInt("id");
                boolean status = res.getBoolean("status");
                System.out.println(name + " : " + id + " : " + status);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Done");
        }
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        BasicJdbc.run();
    }
}
