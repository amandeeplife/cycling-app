package controller;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String eventName = request.getParameter("eventName");
        String statusType = request.getParameter("statusType");
        this.emerService.updateStatus(eventName, statusType);
    }
}
