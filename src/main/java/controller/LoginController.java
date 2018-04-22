package controller;

/*
 Created by: Amenuel, Bakhodir.

 Purpose: Catches requests with URL = "/login" that come from front end
 */

import service.AuthService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private AuthService authService;

    public LoginController() {
    }

    @Override
    public void init() {
        authService = new AuthService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.authService.login(request, response);
    }
}
