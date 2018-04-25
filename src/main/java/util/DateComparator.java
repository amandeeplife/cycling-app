package util;

import model.Event;

import java.util.Comparator;

public class DateComparator implements Comparator<Event> {

    @Override
    public int compare(Event ev, Event ev2) {
        return ev.getStartingDate().compareTo(ev2.getStartingDate()) >= 0 ? -1 : 1;
    }
}
