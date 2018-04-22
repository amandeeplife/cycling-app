package model;
/*
 Created by: Bakhodir, Amenuel.

 Purpose: Stores user information
 */

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dob;
    private List<Event> createdEvents = new LinkedList<>();
    private List<Event> subscribedEvents = new LinkedList<>();

    public User() {
    }

    public User(String username, String password, String firstName, String lastName, Date dob) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        createdEvents.add(new Event("Cycle challenge", "Fairfield",
                "Chicago", "Ottumuwa", new Date(), "This is gonna be big challenge. Challenge yourself !","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        createdEvents.add(new Event("Be healthy with cycling", "San Francisco",
                "New York", "Chicago", new Date(), "This is gonna be big challenge. Challenge yourself !","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages," +
                " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));

        subscribedEvents.add(new Event("For the good life", "Washington", "Texas", "San Francisco",
                new Date(), "This is gonna be big challenge. Challenge yourself !","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more " +
                "recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
    }

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
