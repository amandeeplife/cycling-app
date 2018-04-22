package service;

/*
 Created by: Bakhodir, Amenuel.

 Purpose:  Get data from resource and also does some business stuff
*/

import model.User;
import org.json.simple.JSONObject;
import util.Resource;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private List<User> users = Resource.getUsers();

    public JSONObject[] getAll() {

        if (users.size() > 0) {
            JSONObject[] results = new JSONObject[users.size()];
            for (int i = 0; i < users.size(); i++) {
                JSONObject res = new JSONObject();
                User u = users.get(i);
                res.put("firstName", u.getFirstName());
                res.put("lastName", u.getLastName());
                res.put("dob", u.getDob());
                results[i] = res;
            }
            return results;
        }

        JSONObject[] objectToReturn = new JSONObject[1];
        JSONObject res = new JSONObject();
        res.put("error", "No results found");
        objectToReturn[0] = res;
        return objectToReturn;
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
}
