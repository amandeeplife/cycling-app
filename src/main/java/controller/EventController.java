package controller;
/*
 Created by: Amenuel, Bakhodir.

 Purpose: Catches requests with URL = "/EventController" that come from front end.
 */

import model.Event;
import model.User;
import service.UserService;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("/EventController")
public class EventController extends HttpServlet {

    // doPost method is to create new event
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("username");
        UserService userService = new UserService();
        User user = userService.getUserByName(userName);
        Event ev = new Event();
        ev.setTittle(request.getParameter("eventTitle"));
        ev.setFrom(request.getParameter("eventStart"));
        ev.setShortdiscription(request.getParameter("eventShortSummary"));
        ev.setLongDescription(request.getParameter("eventSummary"));
        ev.setFrom(request.getParameter("eventStart"));
        ev.setTo(request.getParameter("eventEnd"));
        ev.setVia(request.getParameter("eventWayPoints"));
        String page;
        try {
            ev.setStartingDate(Util.parseToDate(request.getParameter("eventDate")));
            page = "welcome-dashboard.jsp";
        } catch (ParseException e) {
            page = "createEvent.jsp";
        }
        user.getCreatedEvents().add(ev);
        response.sendRedirect(page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
