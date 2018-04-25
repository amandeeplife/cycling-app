package controller;

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

@WebServlet( "/EventController")
public class EventController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //Creating Event

         String userName =  request.getParameter("username");
         UserService userService = new UserService();
         User user  =  userService.getUserByName(userName);
         Event ev = new Event();
         ev.setTittle(request.getParameter("eventTitle"));
          ev.setFrom(request.getParameter("eventTitle"));
        ev.setShortdiscription(request.getParameter("eventShortSummary"));
        ev.setLongDescription(request.getParameter("eventSummary"));
        ev.setFrom(request.getParameter("eventStart"));
        ev.setTo(request.getParameter("eventEnd"));
        ev.setVia(request.getParameter("eventWayPoints"));
        try {
            ev.setStartingDate(Util.parseToDate(request.getParameter("eventDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.addEvent(ev);
         response.sendRedirect("welcome-dashboard.jsp");
     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
