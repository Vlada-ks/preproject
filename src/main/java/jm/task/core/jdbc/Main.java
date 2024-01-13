package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {


        userService.createUsersTable();
        Util.closes();


        userService.saveUser("Иван", "Иванов", (byte) 20);
        userService.saveUser("Максим", "Максимов", (byte) 35);
        userService.saveUser("Сергей", "Сергеев", (byte) 30);
        userService.saveUser("Петр", "Петров", (byte) 25);
        Util.closes();


        System.out.println(userService.getAllUsers());
        Util.closes();

        userService.cleanUsersTable();
        Util.closes();
        userService.dropUsersTable();
        Util.closes();
    }


}
