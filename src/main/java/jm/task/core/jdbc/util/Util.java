package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
// реализуйте настройку соеденения с БД

private static final String URL = "jdbc:mysql://localhost:3306/test";
private static final String USERNAME = "roots";
private static final String PASSWORD = "roots";
public static Connection connection;
public static Statement statement;

    private Util() {
    }

    public static Connection getConnection() {


    try {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        connection.setAutoCommit(false);


    } catch (SQLException e) {
        e.printStackTrace();
    }
    return connection;


}




}
