package service;

import model.Event;
import model.EventStatus;
import model.User;
import org.json.simple.JSONObject;
import util.Resource;

import java.util.LinkedList;
import java.util.List;

public class EventService {
    private List<User> users = Resource.getUsers();

    public List<JSONObject> getAllUpcoming(User currentUser) {
        List<JSONObject> results = new LinkedList<>();
        for (User u : users) {

            if (u.getUsername().equals(currentUser.getUsername())) continue;
            List<Event> eventList = u.getCreatedEvents();

            for (Event event : eventList) {
                JSONObject res = new JSONObject();
                if (event.getStatus() == EventStatus.UPCOMING) {
                    res.put("tittle", event.getTittle());
                    res.put("startingDate", event.getStartingDate());
                    res.put("from", event.getFrom());
                    res.put("via", event.getVia());
                    res.put("to", event.getTo());
                    res.put("description", event.getDesciption());
                    res.put("longDescription", event.getLongDiscription());
                    results.add(res);
                }
            }
        }
        return results;
    }

    public void participate(String eventName) {

    }

    public Event findByName(String eventName) {
//        Event event
//        for (User u : Resource.getUsers()) {
//
//        }
//        for (Event event :) {
//
//        }
        return null;
    }
}
