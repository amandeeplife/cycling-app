package controller;

import com.google.gson.Gson;
import model.User;
import org.json.simple.JSONObject;
import service.EmerService;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String currentLoc = request.getParameter("currentLocation");
        if (currentLoc != null) {
            User currentUser = Resource.getCurrentUser();
            currentUser.setCurrentLocation(currentLoc);
        }
        System.out.print(currentLoc);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<JSONObject> jsonObjects = this.emerService.notifyEvent();
        String json = new Gson().toJson(jsonObjects);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
