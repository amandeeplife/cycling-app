package service;

import model.Event;
import model.EventStatus;
import model.User;
import org.json.simple.JSONObject;
import util.Resource;

import java.util.ArrayList;
import java.util.List;

public class EmerService {

    private List<User> users;
    private EventService eventService;

    public EmerService() {
        users = Resource.getUsers();
        eventService = new EventService();
    }

    public void updateStatus(String eventName, String eventStatus) {
        Event event = this.eventService.findByName(eventName);
        if (eventStatus.equals(EventStatus.ONGOING.toString())) event.setStatus(EventStatus.ONGOING);
        if (eventStatus.equals(EventStatus.PENDING.toString())) event.setStatus(EventStatus.PENDING);
    }

    public List<JSONObject> notifyEvent() {
        User currentUser = Resource.getCurrentUser();
        List<Event> subscribed = currentUser.getSubscribedEvents();
        List<User> users = new ArrayList<>();

        for (Event event : subscribed) {
            if (event.getStatus() == EventStatus.PENDING) {
                users = event.getSubscribers();
            }
        }

        List<JSONObject> results = new ArrayList<>();
        for (User u : users) {
            JSONObject res = new JSONObject();
            res.put("email", u.getUsername());
            res.put("firstName", u.getFirstName());
            res.put("lastName", u.getLastName());
            res.put("dob", u.getDob());
            res.put("loc", u.getCurrentLocation());
            results.add(res);
        }
        return results;
    }
}
