package util;

import model.User;

import java.util.LinkedList;
import java.util.List;

/*
 Created by: Amenuel, Bakhodir.

 Purpose: It works as a database that provides sample information
 */
public class Resource {
    private static Resource resource = new Resource();
    private static List<User> users;

    private Resource() {
        users = new LinkedList<User>();
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
}