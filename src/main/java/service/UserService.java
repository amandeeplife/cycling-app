package service;

import model.User;
import org.json.simple.JSONObject;
import util.Resource;

import java.util.List;

public class UserService {

    public JSONObject[] getAll() {
        List<User> users = Resource.getUsers();

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
}
