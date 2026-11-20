package com.saheb.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class BasicJdbc {
    private static String quary = """
            INSERT INTO users(name,status) values("saheb",true);
                                  """;

    public static void updateQuary(Statement statement) throws Exception {
        System.out.println("Row's Affected : " + statement.executeUpdate(quary));
        System.out.println("here " + statement.getConnection());
    }

    public static void executeQuery(Statement statement) throws Exception {
        ResultSet res = statement.executeQuery("select * from users");
        while (res.next()) {
            String name = res.getString("name");
            int id = res.getInt("id");
            boolean status = res.getBoolean("status");
            System.out.println(name + " : " + id + " : " + status);
        }
    }

    public static void execute(Statement statement, String quary) throws Exception {
        if (statement.execute(quary)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void runSQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/firstDb";
        String user = "root";
        String password = "saheb";

        Statement statement = DriverManager.getConnection(url, user, password).createStatement();
        updateQuary(statement);
        // execute(statement, "UPDATE users SET name='Unknown' WHERE id=1 ");
        // execute(statement, "SELECT * FROM users ");
        // execute(statement, "DELETE FROM users WHERE name='saheb'");
        execute(statement,"ALTER TABLE users MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT FIRST");
        executeQuery(statement);

        statement.close();
    }
}

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try {
            BasicJdbc.runSQL();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
