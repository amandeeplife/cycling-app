package controller;

/*
 Created by: Bakhodir, Amenuel.

 Purpose: Catches requests with URL = "/manageEvent" that come from front end
 */

import service.EmerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manageEvent")
public class ManageEventController extends HttpServlet {
    private EmerService emerService;

    @Override
    public void init() {
        this.emerService = new EmerService();
    }

    // doPost method is to update status type of event
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String eventName = request.getParameter("eventName");
        String statusType = request.getParameter("statusType");
        this.emerService.updateStatus(eventName, statusType);
    }
}
