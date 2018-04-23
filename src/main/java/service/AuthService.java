package service;

import model.Event;
import model.User;
import util.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AuthService {
    private UserService userService;

    public AuthService() {
        this.userService = new UserService();
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String errorUsername = "";
        String errorPassword = "";
        if (username == null || username.isEmpty()) {
            errorUsername = "Please enter username";
            request.setAttribute("errorUserName", errorUsername);
        }

        if (password == null || password.isEmpty()) {
            errorPassword = "Please enter password";
            request.setAttribute("errorPassword", errorPassword);
        }

        if (errorPassword.isEmpty() && errorUsername.isEmpty()) {
            User user = userService.getUserByName(username, password);

               List<User> users = userService.getAllUsers();
            if (user != null) {
                request.getSession().setAttribute("currentUser", user);
                request.getSession().setAttribute("AllUser", users);
                Resource.setCurrentUser(user);
                response.sendRedirect("welcome-dashboard.jsp");
                return;
            } else {
                request.setAttribute("notExist", "The user doesn't exist");
                response.sendRedirect("login.jsp");
                return;
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        Resource.setCurrentUser(null);
        response.sendRedirect("login.jsp");
    }

    public void register(User user) {
        Resource.addUser(user);
    }
}
