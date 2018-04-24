package controller;

import model.User;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JSONObject> jsonObjects = this.eventService.getAllLiveEvents();
        req.setAttribute("eventList", jsonObjects);
        req.getRequestDispatcher("liveevents.jsp").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
