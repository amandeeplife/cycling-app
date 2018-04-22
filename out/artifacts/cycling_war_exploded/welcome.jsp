<%--
  Created by IntelliJ IDEA.
  User: Amanuel
  Date: 4/21/2018
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
* INSPINIA - Responsive Admin Theme
* Version 2.0
*
-->

<!DOCTYPE html>
<html ng-app="inspinia">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Page title set in pageTitle directive -->
    <title page-title></title>

    <!-- Font awesome -->
    <link href="Angular/font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="Angular/css/bootstrap.min.css" rel="stylesheet">

    <!-- Main Inspinia CSS files -->
    <link href="Angular/css/animate.css" rel="stylesheet">
    <link id="loadBefore" href="Angular/css/style.css" rel="stylesheet">


</head>

<!-- ControllerAs syntax -->
<!-- Main controller with serveral data used in Inspinia theme on diferent view -->
<body ng-controller="MainCtrl as main">

<!-- Main view  -->
<div ui-view></div>

<!-- jQuery and Bootstrap -->
<script src="Angular/js/jquery/jquery-2.1.1.min.js"></script>
<script src="Angular/js/plugins/jquery-ui/jquery-ui.js"></script>
<script src="Angular/js/bootstrap/bootstrap.min.js"></script>

<!-- MetsiMenu -->
<script src="Angular/js/plugins/metisMenu/jquery.metisMenu.js"></script>

<!-- SlimScroll -->
<script src="Angular/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Peace JS -->
<script src="Angular/js/plugins/pace/pace.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="Angular/js/inspinia.js"></script>

<!-- Main Angular scripts-->
<script src="Angular/js/angular/angular.min.js"></script>
<script src="Angular/js/plugins/oclazyload/dist/ocLazyLoad.min.js"></script>
<script src="Angular/js/angular-translate/angular-translate.min.js"></script>
<script src="Angular/js/ui-router/angular-ui-router.min.js"></script>
<script src="Angular/js/bootstrap/ui-bootstrap-tpls-0.12.0.min.js"></script>
<script src="Angular/js/plugins/angular-idle/angular-idle.js"></script>

<!--
 You need to include this script on any page that has a Google Map.
 When using Google Maps on your own site you MUST signup for your own API key at:
 https://developers.google.com/maps/documentation/javascript/tutorial#api_key
 After your sign up replace the key in the URL below..
-->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQTpXj82d8UpCi97wzo_nKXL7nYrd4G70"></script>

<!-- Anglar App Script -->
<script src="Angular/js/app.js"></script>
<script src="Angular/js/config.js"></script>
<script src="Angular/js/translations.js"></script>
<script src="Angular/js/directives.js"></script>
<script src="Angular/js/controllers.js"></script>

</body>
</html>

                if (response.status == 'OK') {
                    places = response.places;
                    // loop through places and add markers
                    for (p in places) {
                        //create gmap latlng obj
                        tmpLatLng = new google.maps.LatLng( places[p].geo[0], places[p].geo[1]);
                        // make and place map maker.
                        var marker = new google.maps.Marker({
                            map: map,
                            position: tmpLatLng,
                            title : places[p].name + "<br>" + places[p].geo_name
                        });
                        bindInfoWindow(marker, map, infowindow, '<b>'+places[p].name + "</b><br>" + places[p].geo_name);
                        // not currently used but good to keep track of markers
                        markers.push(marker);
                    }
                }
            }
        })
    };
    // binds a map marker and infoWindow together on click
    var bindInfoWindow = function(marker, map, infowindow, html) {
        google.maps.event.addListener(marker, 'click', function() {
            infowindow.setContent(html);
            infowindow.open(map, marker);
        });
    }

</script>