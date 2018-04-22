package model;
/*
 Created by: Amenuel, Bakhodir.

 Purpose: Stores event information
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {

    private String tittle;
    private Date createdTime = new Date();
    private String from;
    private String via;
    private String to;
    private Date startingDate;
    private String desciption;
    private List<User> subscribers = new ArrayList<>();

    public Event() {
    }

    public Event(String tittle, String from, String via, String to, Date startingDate, String desciption) {
        this.tittle = tittle;
        this.from = from;
        this.via = via;
        this.to = to;
        this.startingDate = startingDate;
        this.desciption = desciption;
    }

    public void setTittle(String title) {
        this.tittle = title;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setDiscription(String desciption) {
        this.desciption = desciption;
    }

    public void setStartingDate(Date date) {
        this.startingDate = date;
    }

    public void addSubscibers(User user) {
        subscribers.add(user);
    }

    public String getTittle() {
        return tittle;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public String getFrom() {
        return from;
    }

    public String getVia() {
        return via;
    }

    public String getTo() {
        return to;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public String getDesciption() {
        return desciption;
    }
}
