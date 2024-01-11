package jm.task.core.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

private static final String URL = "jdbc:mysql://localhost:3306/test";
private static final String USERNAME = "roots";
private static final String PASSWORD = "roots";
public static Connection connection;

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
