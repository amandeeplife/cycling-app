package controller;

import org.json.simple.JSONObject;
import service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/subscribedList")
public class SubscEventController extends HttpServlet {

    private EventService eventService;

    @Override
    public void init() {
        this.eventService = new EventService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JSONObject> jsonObjects = this.eventService.getAllSubscribedEvents();
        req.setAttribute("eventList", jsonObjects);
        req.getRequestDispatcher("subscribedEvents.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
