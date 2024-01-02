package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;


public class Main {
public static void main(String[] args) {
    Connection connection = Util.getConnection();
    Statement statement = Util.getStatement();
    UserDao userDao = new UserDaoJDBCImpl();


    userDao.createUsersTable();


    userDao.saveUser("Иван", "Иванов", (byte) 20);
    userDao.saveUser("Максим", "Максимов", (byte) 35);
    userDao.saveUser("Сергей", "Сергеев", (byte) 30);
    userDao.saveUser("Петр", "Петров", (byte) 25);


    System.out.println(userDao.getAllUsers());

    userDao.cleanUsersTable();
    userDao.dropUsersTable();
}


}
