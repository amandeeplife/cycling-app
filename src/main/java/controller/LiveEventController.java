package controller;

/*
 Created by: Bakhodir, Amenuel.

 Purpose: Catches requests with URL = "/liveEvents" that come from front end.
 */

import org.json.simple.JSONObject;
import service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/liveEvents")
public class LiveEventController extends HttpServlet {

    private EventService eventService;

    @Override
    public void init() {
        eventService = new EventService();
    }

    // doGet method is to get list of events and return it back to front end
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JSONObject> jsonObjects = this.eventService.getAllLiveEvents();
        req.setAttribute("eventList", jsonObjects);
        req.getRequestDispatcher("liveevents.jsp").forward(req, resp);
    }
}
