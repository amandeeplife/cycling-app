package model;
/*
 Created by: Amenuel, Bakhodir.

 Purpose: Stores event information
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Event implements Comparable<Event> {

    private String tittle;
    private Date createdTime = new Date();
    private String from;
    private String via;
    private String to;
    private Date startingDate;
    private String shortdiscription;
    private String longDescription;

    private EventStatus status = EventStatus.ONGOING;
    private List<User> subscribers = new ArrayList<>();

    public Event() {
    }

    public Event(String tittle, String from, String via, String to, String shortdisciption, String longDescription, Date startingDate) {
        this.tittle = tittle;
        this.from = from;
        this.via = via;
        this.to = to;
        this.shortdiscription = shortdisciption;
        this.startingDate = startingDate;
        this.longDescription = longDescription;
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

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    @Override
    public int compareTo(Event o) {
        return this.getStartingDate().getTime() > o.getStartingDate().getTime() ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return this.tittle.equals(event.getTittle());
    }

    @Override
    public int hashCode() {

        return Objects.hash(tittle, createdTime, from, via, to, startingDate, shortdiscription, longDescription, status);
    }

    public String getLongDescription() {
        return this.longDescription;
    }

    public void setLongDescription(String st) {
        this.longDescription = st;
    }

    public String getShortdiscription() {
        return this.shortdiscription;
    }

    public void setShortdiscription(String st) {
        this.shortdiscription = st;
    }
}
