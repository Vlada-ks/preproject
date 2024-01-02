package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

private static final Connection connection = Util.getConnection();
private static final Statement statement = Util.getStatement();


public UserDaoJDBCImpl() {
}

public void createUsersTable() {

    try {
        statement.executeUpdate("CREATE TABLE USERS (ID BIGINT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255), LASTNAME VARCHAR(255), AGE INT)");

    } catch (SQLException e) {
        e.printStackTrace();


    }


}

public void dropUsersTable() {

    try {
        statement.executeUpdate("DROP TABLE IF EXISTS USERS");

    } catch (SQLException e) {
        e.printStackTrace();
    }


}

public void saveUser(String name, String lastName, byte age) {
    PreparedStatement preparedStatement = null;
    try {

        preparedStatement = connection.prepareStatement("INSERT INTO USERS (NAME, LASTNAME, AGE) VALUES(?, ?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, lastName);
        preparedStatement.setByte(3, age);
        preparedStatement.executeUpdate();
        connection.commit();
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    } catch (SQLException e) {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}

public void removeUserById(long id) {
    PreparedStatement preparedStatement = null;
    try {
        preparedStatement = connection.prepareStatement("DELETE FROM USERS WHERE ID = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }


}

public List<User> getAllUsers() {
    List<User> allUserList = new ArrayList<>();
    ResultSet resultSet = null;
    try {
        resultSet = statement.executeQuery("SELECT * FROM USERS");
        while (resultSet.next()) {
            User user = new User(resultSet.getString("NAME"), resultSet.getString("LASTNAME"), resultSet.getByte("AGE"));
            user.setId(resultSet.getLong("ID"));
            allUserList.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return allUserList;

}

public void cleanUsersTable() {

    try {
        statement.executeUpdate("TRUNCATE TABLE USERS");
    } catch (SQLException e) {
        e.printStackTrace();
    }

}
}
