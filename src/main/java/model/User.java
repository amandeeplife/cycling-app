package model;
/*
 Created by: Bakhodir, Amenuel.

 Purpose: Stores user information
 */

import java.util.Date;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dob;
    private List<Event> createdEvents;
    private List<Event> subscribedEvents;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
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
}
