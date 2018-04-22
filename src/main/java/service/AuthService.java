package service;

import model.User;
import util.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthService {
    private UserService userService;

    public AuthService() {
        this.userService = new UserService();
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
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

            if (user != null) {
                request.getSession().setAttribute("currentUser", user);

                response.sendRedirect("welcome-dashboard.jsp");
                return;
            } else {
                request.setAttribute("notExist", "The user doesn't exist");
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("login.jsp");
    }

    public void register(User user) {
        Resource.addUser(user);
    }
}
