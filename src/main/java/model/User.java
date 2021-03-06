package model;
/*
 Created by: Bakhodir, Amenuel.

 Purpose: Stores user information
 */

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String currentLocation;
    public String emergencyFlag;
    private Date dob;
    private List<Event> createdEvents = new LinkedList<>();
    private List<Event> subscribedEvents = new LinkedList<>();

    public User() {
    }

    public User(String username, String password, String firstName, String lastName, Date dob) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.emergencyFlag = "false";
        this.lastName = lastName;
        this.dob = dob;
        currentLocation = "test";
//        createdEvents.add(new Event("Cycle challenge", "Fairfield",
//                "Chicago", "Ottumuwa",
//                "This is short discription for own event", "Lorem Ipsum is simply dummy text of " +
//                "the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the" +
//                " 1500s," + " more recently with desktop publishing software like Aldus PageMaker including versions of Lorem ", new Date()));
//
//        Event e = new Event("For the good life", "Washington", "Texas", "San Francisco",
//                "this is short discription for subscribed event",
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry" +
//                        "recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", new Date());
//        e.getSubscribers().add(this);
//        subscribedEvents.add(e);

    }

    public String getUsername() {
        return username;
    }

    public String getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(String loc) {
        this.currentLocation = loc;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void changeEmergencyFlag() {
        this.emergencyFlag = "on";
    }

    public String getEmergencySFlag() {
        return emergencyFlag;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    public List<Event> getCreatedEvents() {
        return createdEvents;
    }

    public List<Event> getSubscribedEvents() {
        return subscribedEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username);
    }
}
