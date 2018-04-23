package controller;

import model.User;
import service.EventService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/User")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("param")!=null){
            System.out.print(request.getParameter("param"));
            UserService userService  =    new UserService();
            User user = userService.getUserByName(request.getParameter("param"));
            request.getSession().setAttribute("Emergencyflag", user.getEmergencySFlag());
        }


    }
    }

