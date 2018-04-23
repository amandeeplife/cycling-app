<!DOCTYPE html>
<html>
<head>

    <link href="Res/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="JavaScript/createEvent.js"></script>
    <!-- MetisMenu CSS -->
    <link href="Res/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="Res/dist/css/sb-admin-2.css" rel="stylesheet">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Waypoints in directions</title>
    <style>
        #right-panel {
            font-family: 'Roboto', 'sans-serif';
            line-height: 30px;
            padding-left: 10px;
        }

        #right-panel select, #right-panel input {
            font-size: 15px;
        }

        #right-panel select {
            width: 100%;
        }

        #right-panel i {
            font-size: 12px;
        }

        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }

        #map {
            height: 100%;
            float: left;
            width: 60%;
            height: 100%;
        }

        #right-panel {
            margin: 20px;
            border-width: 2px;
            width: 30%;
            height: 400px;
            float: left;
            text-align: left;
            padding-top: 0;
        }

        #directions-panel {
            margin-top: 10px;
            background-color: #FFEE77;
            padding: 10px;
            overflow: scroll;
            height: 174px;
        }
    </style>
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
            Short Discription : <input type="text" name="eventShortSummary" id=""><br>
            Summary : <textarea name = "eventSummary" class="form-control" rows="3"></textarea><br>
        Event date : <input name="eventDate" id="date" type="date"><br>
            <input type="hidden" name="username" value="${sessionScope.currentUser.username}" >
            <input type="submit" value="Save Changes">
        </form>
    </div>


</div>

    <div id="directions-panel"></div>
</div>
<script>
    $(function () {
      $("#eventCreate").submit(function (event) {
console.log( $("#title").val().length+"text for title");
          if( $("#title").val().length === 0 ){
              console.log("please Fill ou the data")
              event.preventDefault();
              $("#msg").append("<p style='color: red'>Please input Title</p>")

          }
      })
    }
    )


    function initMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 6,
            center: {lat: 41.85, lng: -87.65}
        });
        directionsDisplay.setMap(map);
$("#checkMap").click(function () {
    calculateAndDisplayRoute(directionsService, directionsDisplay);
    console.log(document.getElementById('start').value + "  " + document.getElementById('end').value + " " + document.getElementById('waypoints'))
})

    }

    function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        var waypts = [];
        var checkboxArray = document.getElementById('waypoints');
        for (var i = 0; i < checkboxArray.length; i++) {
            if (checkboxArray.options[i].selected) {
                waypts.push({
                    location: checkboxArray[i].value,
                    stopover: true
                });
            }
        }

        directionsService.route({
            origin: document.getElementById('start').value,
            destination: document.getElementById('end').value,
            waypoints: waypts,
            optimizeWaypoints: true,
            travelMode: 'DRIVING'
        }, function (response, status) {
            if (status === 'OK') {
                directionsDisplay.setDirections(response);
                var route = response.routes[0];
                var summaryPanel = document.getElementById('directions-panel');
                summaryPanel.innerHTML = '';
                // For each route, display summary information.
                for (var i = 0; i < route.legs.length; i++) {
                    var routeSegment = i + 1;
                    summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                        '</b><br>';
                    summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                    summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                    summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                }
            } else {
                window.alert('Directions request failed due to ' + status);
            }
        });
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key= AIzaSyAhvWIu3M5vWs0E8b5RIkp_-epj-36wW6I  &callback=initMap">
</script>
</body>
</html>

<!--
