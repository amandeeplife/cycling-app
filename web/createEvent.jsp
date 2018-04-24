<!DOCTYPE html>
<html>
<head>

    <link href="Res/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
         <link href="Style/createEvent.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="Res/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
 <script src="JavaScript/googleMap.js"></script>
    <!-- Custom CSS -->
    <link href="Res/dist/css/sb-admin-2.css" rel="stylesheet">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Waypoints in directions</title>
    <link href="Style/createEvent.css">
    <script src="JavaScript/createEvent.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> <!-- load jquery via CDN -->

</head>
<body>
<div id="map"></div>
<div id="right-panel">
    <div>

        <button class="btn btn-primary" style="float: right" onclick="window.location.href='/welcome-dashboard.jsp'">Go to Dashboard</button>

        <button id="checkMap" class="btn btn-info">Check on Map</button>

        <form id="eventCreate" method="post" action="EventController">
        <br><br>
        Please Fill the following information if you would like to create an
        Event!<br><br>
            Event Title :<span id="msg"></span> <input id="title" name="eventTitle" type="text" class="form-control"><br>
        <b>Start:</b>

        <select name="eventStart" id="start">

        </select>
        <br>
        <b>Waypoints:</b> <br>
        <i>(Ctrl+Click or Cmd+Click for multiple selection)</i> <br>
        <select name="eventWayPoints" multiple id="waypoints">

        </select>
        <br>
        <b >End:</b>
        <select name="eventEnd" id="end">
        </select>
        <br>
            Short Discription : <input type="text" class="form-control" name="eventShortSummary" id=""><br>
            Summary : <textarea name = "eventSummary" class="form-control" rows="3"></textarea><br>
        Event date : <input name="eventDate" id="date" type="date"><br>
            <input type="hidden" name="username" value="${sessionScope.currentUser.username}" >
            <input type="submit" class="btn btn-success" value="Save Changes" style="float: right"><br>
        </form>
    </div>
<br><br>
    <div style="height: 30px"></div>

</div>

 </div>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key= AIzaSyAhvWIu3M5vWs0E8b5RIkp_-epj-36wW6I  &callback=initMap">
</script>
</body>
</html>

<!--
