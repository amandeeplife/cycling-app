package controller;

/*
 Created by: Amenuel, Bakhodir.

 Purpose: Catches requests with URL = "/register" that come from front end
 */

import model.User;
import service.AuthService;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet("/register")
public class RegUserController extends HttpServlet {
    private AuthService authService;

    public RegUserController() {
    }

    @Override
    public void init() {
        this.authService = new AuthService();
    }


    // doPost method is to register a new user
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Date dob = null;
        try {
            dob = Util.parseToDate(req.getParameter("dob"));
        } catch (ParseException e) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        User newUser = new User(userName, password, firstName, lastName, dob);
        this.authService.register(newUser);
        req.getSession().setAttribute("currentUser", newUser);
        resp.sendRedirect("welcome-dashboard.jsp");
    }
}
