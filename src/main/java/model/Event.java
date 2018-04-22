package model;
/*
 Created by: Amenuel, Bakhodir.

 Purpose: Stores event information
 */

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
    private List<User> subscribers;

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
