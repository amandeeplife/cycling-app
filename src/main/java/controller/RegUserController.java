package controller;

import model.User;
import service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Date dob = null;
        try {
            dob = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("dob"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.authService.register(new User(userName, password, firstName, lastName, dob));
    }
}
