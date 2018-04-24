package service;

import model.Event;
import model.EventStatus;
import model.User;
import org.json.simple.JSONObject;
import util.Resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EventService {
    private List<User> users = Resource.getUsers();

    public List<JSONObject> getAllUpcoming() {
        User currentUser = Resource.getCurrentUser();
        List<JSONObject> results = new LinkedList<>();

        List<Event> eventList = getAllEvents();
        for (Event event : eventList) {
            JSONObject res = new JSONObject();
            if (currentUser.getSubscribedEvents().contains(event)) continue;
            if (event.getStatus() == EventStatus.UPCOMING) {
                res.put("tittle", event.getTittle());
                res.put("startingDate", event.getStartingDate());
                res.put("from", event.getFrom());
                res.put("via", event.getVia());
                res.put("to", event.getTo());
                res.put("shortDescription", event.getShortdiscription());
                res.put("longDescription", event.getLongDescription());

                results.add(res);
            }
        }
        return results;
    }

    private List<Event> getAllEvents() {
        User currentUser = Resource.getCurrentUser();
        List<Event> events = new ArrayList<>();
        for (User u : users) {
            if (currentUser.equals(u)) continue;
            List<Event> eventList = u.getCreatedEvents();
            eventList.addAll(eventList);
        }
        Collections.sort(events);
        return events;
    }

    public List<JSONObject> getAllLiveEvents() {
        List<JSONObject> results = new LinkedList<>();
        for (User u : users) {
            List<Event> eventList = u.getCreatedEvents();
            for (Event event : eventList) {
                JSONObject res = new JSONObject();
                if (event.getStatus() == EventStatus.ONGOING) {
                    res.put("tittle", event.getTittle());
                    res.put("startingDate", event.getStartingDate());
                    res.put("from", event.getFrom());
                    res.put("via", event.getVia());
                    res.put("to", event.getTo());
                    res.put("shortDescription", event.getShortdiscription());
                    res.put("longDescription", event.getLongDescription());

                    results.add(res);
                }
            }
        }
        return results;
    }


    public void participate(String eventName) {
        User currentUser = Resource.getCurrentUser();
        Event event = findByName(eventName);
        if (event != null) {
            event.addSubscibers(currentUser);
            currentUser.getSubscribedEvents().add(event);
        }
    }

    public Event findByName(String eventName) {
        List<User> users = Resource.getUsers();
        Event event = null;
        for (User u : users) {
            List<Event> events = u.getCreatedEvents();
            for (Event e : events) {
                if (e.getTittle().equals(eventName)) {
                    event = e;
                }
            }
        }
        return event;
    }
}
