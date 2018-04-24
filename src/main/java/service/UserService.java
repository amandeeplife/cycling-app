package service;

/*
 Created by: Bakhodir, Amenuel.

 Purpose:  Get data from resource and also does some business stuff
*/

import model.User;
import org.json.simple.JSONObject;
import util.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private List<User> users = Resource.getUsers();

    public List<JSONObject> getAll() {

        List<JSONObject> results = new ArrayList<>();
        for (User u : users) {
            JSONObject res = new JSONObject();
            res.put("email", u.getUsername());
            res.put("firstName", u.getFirstName());
            res.put("lastName", u.getLastName());
            res.put("dob", u.getDob());
            results.add(res);
        }
        return results;
    }

    public User getUserByName(String username) {
        List<User> resultList = this.users.stream().filter(u -> u.getUsername().equals(username)).
                collect(Collectors.toList());
        if (resultList.size() != 1) throw new IllegalStateException();
        return resultList.get(0);
    }

    public User getUserByName(String username, String password) {
        List<User> resultList = this.users.stream().filter(u -> u.getUsername().equals(username)
                && u.getPassword().equals(password)).
                collect(Collectors.toList());
        if (resultList.size() != 1) return null;
        return resultList.get(0);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
