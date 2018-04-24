package controller;

import org.json.simple.JSONObject;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userInfo")
public class UserController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() {
        this.userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getParameter("param") != null) {
//            System.out.print(request.getParameter("param"));
//            UserService userService = new UserService();
//            User user = userService.getUserByName(request.getParameter("param"));
//            request.getSession().setAttribute("Emergencyflag", user.getEmergencySFlag());
//        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JSONObject> jsonObjects = this.userService.getAll();
        req.setAttribute("userList", jsonObjects);
        req.getRequestDispatcher("userInfo.jsp").forward(req, resp);
    }
}

