package controller;

/*
 Created by: Bakhodir, Amenuel.

 Purpose: Catches requests with URL = "/emergency" that come from front end.
 */

import com.google.gson.Gson;
import model.Event;
import model.EventStatus;
import model.User;
import org.json.simple.JSONObject;
import service.EmerService;
import service.EventService;
import util.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/emergency")
public class EmerController extends HttpServlet {
    private EmerService emerService;

    @Override
    public void init() {
        this.emerService = new EmerService();
    }

    // doPost method is to change the status of event to "PENDING"
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String currentLoc = request.getParameter("currentLocation");
        if (currentLoc != null) {
            User currentUser = Resource.getCurrentUser();
            currentUser.setCurrentLocation(currentLoc);
        }

        if (request.getParameter("emergencyFlag") != null) {
            EventService eventService = new EventService();
            Event event = eventService.findByName(request.getParameter("emergencyFlag"));
            event.setStatus(EventStatus.PENDING);
            for (User user : event.getSubscribers()) {
                user.changeEmergencyFlag();
            }
            System.out.println("Emergncy Flag" + request.getParameter("emergencyFlag"));
        }
    }

    // doGet method to all users ask if there is something new
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<JSONObject> jsonObjects = this.emerService.notifyEvent();
        String json = new Gson().toJson(jsonObjects);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
