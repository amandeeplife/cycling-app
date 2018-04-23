package controller;

import com.google.gson.Gson;
import model.Event;
import model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import service.EventService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Emergency")
public class EmergencyController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("param")!=null){
            EventService eventService  =    new EventService();
            Event event = eventService.findByName(request.getParameter("param"));
            List<User>  users = event.getSubscribers();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter out = response.getWriter();
        JSONArray arr = new JSONArray();
        JSONObject obj1 = new JSONObject();
        JSONObject obj2 = new JSONObject();
        JSONObject obj4 = new JSONObject();
        JSONObject obj5 = new JSONObject();
        JSONObject obj6 = new JSONObject();

        obj1.put("text", "abc");
        obj1.put("url", "abc.com");
        obj1.put("leaf", true);

        obj4.put("text", "klm");
        obj4.put("url", "klm.com");
        obj4.put("leaf", true);

        obj5.put("text", "xyz");
        obj5.put("url", "xyz.com");
        obj5.put("leaf", true);

        obj6.put("text", "pqr");
        obj6.put("url", "pqr.com");
        obj6.put("leaf", true);
        arr.add(obj1);
        arr.add(obj4);
        arr.add(obj5);
        arr.add(obj6);
        obj2.put("items",arr);

        out.println(obj2);
    }
}
