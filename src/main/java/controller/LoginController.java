package controller;

/*
 Created by: Amenuel, Bakhodir.

 Purpose: Catches requests with URL = "/login" that come from front end
 */

import model.User;
import service.UserService;
import util.Resource;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
class LoginController extends HttpServlet {
    private UserService userService;

    public LoginController() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String, String> messages = new HashMap<String, String>();

        if (username == null || username.isEmpty()) {
            messages.put("username", "Please enter username");
        }

        if (password == null || password.isEmpty()) {
            messages.put("password", "Please enter password");
        }

        if (messages.isEmpty()) {
            User user = userService.getUserByName(username, password);

            if (user != null) {
                request.getSession().setAttribute("currentUser", user);
                Resource.setCurrentUser(user);
                response.sendRedirect("welcome-dashboard.jsp");
                return;
            } else {
                messages.put("login", "Unknown login, please try again");
            }
        }

        request.setAttribute("messages", messages);
        request.getRequestDispatcher("login.html").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.userService.getAll();
    }
}
