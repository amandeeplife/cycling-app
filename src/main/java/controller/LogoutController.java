package controller;

/*
 Created by: Bakhodir, Amenuel.

 Purpose: Catches requests with URL = "/logout" that come from front end
 */

import service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    private AuthService authService;

    public LogoutController() {
    }

    @Override
    public void init() {
        this.authService = new AuthService();
    }

    // doGet that provides logout function
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.authService.logOut(req, resp);
    }
}
