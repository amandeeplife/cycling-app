package controller;
/*
 Created by: Bakhodir, Amenuel.

 Purpose: Catches requests with URL = "/emergency" that come from front end.
 */

import service.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/participate")
public class EventParticipate extends HttpServlet {
    private EventService eventService;

    @Override
    public void init() {
        this.eventService = new EventService();
    }

    // doPost method is to make participated user the specific event
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tittle = req.getParameter("tittle");
        this.eventService.participate(tittle);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("success");
    }
}
