<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Amanuel
  Date: 4/21/2018
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="js/dashboard.js" type="application/javascript"></script>
    <script src="js/manageEvent.js" type="application/javascript"></script>
    <title>Home page</title>

    <!-- Bootstrap Core CSS -->
    <link href="res/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="res/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="res/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="res/vendor/morrisjs/morris.css" rel="stylesheet">
    <script src="js/emergencyFlag.js"></script>
    <!-- Custom Fonts -->
    <link href="res/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> <!-- load jquery via CDN -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<%
    if (session.getAttribute("currentUser") == null) {
          response.sendRedirect("login.html");
    }
%>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Hi ${sessionScope.currentUser.firstName} !</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">



            <!-- /.dropdown -->
            <li class="dropdown">
                <a id ="notifcationIcon" class="dropdown-toggle"  data-toggle="dropdown" href="#">
                    <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-alerts">
                    <li>
                        <a href="#">
                            <a href="#">
                                <div>
                                    <i class="fa fa-support"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </a> </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                <span class="pull-right text-muted small">12 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-envelope fa-fw"></i> Message Sent
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-tasks fa-fw"></i> New Task
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a class="text-center" href="#">
                            <strong>See All Alerts</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
                <!-- /.dropdown-alerts -->
            </li>
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        <!-- /input-group -->
                    </li>
                    <li>
                        <a href="welcome-dashboard.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>

                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Events <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/subscribedList">Subscribed Events</a>
                            </li>
                            <li>
                                <a href="/upcomingEvents">Upcoming Events</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="/liveEvents"><i class="fa fa-table fa-fw"></i> Live Cycling Rides</a>
                    </li>

                    <li>
                        <a href="/userInfo"><i class="fa fa-edit fa-fw"></i> All Users</a>
                    </li>
                    <li>
                        <a href="notification.jsp"><i class="fa fa-edit fa-fw"></i> Notification </a>
                    </li>



                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>


    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Dashboard</h1>
                <input type="submit" onclick="window.location.href='/createEvent.jsp'" id="" class="btn btn-success"
                       style="float: right" id="createEvent" value=" Create Cycling Event!">
                <!-- Modal -->

                <br><br>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div id="ownEvents" class="row">
                <!-- Show The Events that the current User Admins
                <c:forEach items="${(sessionScope.currentUser).createdEvents}" var="event" varStatus="loop">
                    <div class="row">
                        <div class="col-lg-3 col-md-6">


                    <button onclick="emergencyHandler('${event.tittle}' )" class="flag btn btn-danger"
                            data-title='" + ${event.tittle} + "' style="float: right" data-toggle="modal"
                            data-target="#delete">
                        Emergency Flag
                    </button>

                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div><h3 style="color: yellow">${event.tittle} on ${event.startingDate}</h3></div>
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">
                                    </div>
                                    <div>${event.shortdiscription}</div>

                                </div>
                            </div>
                        </div>

                        <div class="panel-footer">
                                    <span style="color:darkred; float: right">
                                        <div>Starting Location :${event.from}</div>

                                        <div>Destination :${event.to}</div>
                                        <div>Way Points :${event.via}</div>
        <br><br>

                                    </span>
                            <h4 style="clear: both">Summary :</h4>
                                ${event.longDescription}
                            <div class="clearfix"></div>
                            <br>
                        </div>
                        <input type="button" onclick="manageEvent('${event.tittle}')" id="startButton" style="border-radius: unset" value="Start Ride"
                               class="btn btn-success btn-lg btn-block" data-title='${event.tittle}'>

                        <input type="button" id="finishButton" style="border-radius: unset" value="Finish Ride"
                               class="btn btn-danger btn-lg btn-block" data-title='${event.tittle}'>
                    </div>

                </div>


            </c:forEach></div>
        </div>
        <!-- /.row -w->
                    <!-- /.panel-heading -->

    </div>
    <!-- /.panel-body -->
</div>
<!-- /.panel -->

<!-- jQuery -->
<script src="res/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="res/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="res/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="res/vendor/raphael/raphael.min.js"></script>
<script src="res/vendor/morrisjs/morris.min.js"></script>
<script src="res/data/morris-data.js"></script>

<!-- Custom Theme JavaScript -->
<script src="res/dist/js/sb-admin-2.js"></script>

</body>

</html>
