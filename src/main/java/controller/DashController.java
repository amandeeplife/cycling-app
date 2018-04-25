package controller;
/*
 Created by: Bakhodir, Amenuel.

 Purpose: Catches requests with URL = "/dashboard" that come from front end.
 */

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "/dashboard")
public class DashController extends HttpServlet {
}
