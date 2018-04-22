package controller;

/*
 Created by: Amenuel, Bakhodir.

 Purpose: Catches requests with URL = "/login" that come from front end
 */

import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
class LoginController extends HttpServlet {
    private UserService userService    = new UserService();





    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.userService.getAll();
    }
}
