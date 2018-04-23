package util;

import model.User;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/*
 Created by: Amenuel, Bakhodir.

 Purpose: It works as a database that provides information
 */
public class Resource {
    private static Resource resource = new Resource();
    private static List<User> users;
    private static User currentUser;

    private Resource() {
        users = new LinkedList<>();
        users.add(new User("bakhodir@gmail.com", "10", "Bakhodir", "Boydedaev", new Date()));
        users.add(new User("amanuel@gmail.com", "10", "Emanuel", "Mulat", new Date()));
    }

    public static Resource getInstance() {
        return resource;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}