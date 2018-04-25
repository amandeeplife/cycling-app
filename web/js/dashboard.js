$(document).ready(function () {



//Checking if there is Notification and Updating the Current Location to Server
setInterval(function () {
    manageNotification();
},2000)

setInterval(function () {
    navigator.geolocation.getCurrentPosition(function(position){
        console.log(position)
        address = "Latt" +position.coords.latitude+" \nLang :"+ position.coords.longitude;

        //Updating Currnet tLocation
        $.post("/emergency", {
            currentLocation: address})
            .done(function (data) {

            })})
},112000)

});

//Gets Current Location and Updates
function manageNotification(){

    navigator.geolocation.getCurrentPosition(function(position){
        console.log(position)
        address = "Latt" +position.coords.latitude+" \nLang :"+ position.coords.longitude;

        //Updating Currne tLocation
        $.post("/emergency", {
            currentLocation: address})
            .done(function (data) {
                console.log("Successful");
            });

        // Checking if there is notifcation
        $.ajax({
            "url":"/emergency",
            "type":"get",
            "success":successEmergncy,
            "error":errorEmergency
        })
    })
    //On Success append Html Element of The Current Users that are subscribed to the same Event with the currnet Users.
    function  successEmergncy(data){
        console.log(data+"data" +this.emergencyFlag )
        if(this.emergencyFlag =="on") {
            console.log(data)
            $("#notifcationIcon").css("background-color", "red");
            $.each(data, function () {

                this.username
                $("#notificationList").empty().append("<div class=\"col-lg-4\">\n" +
                    "\n" +
                    "                    <div class=\"panel panel-danger\">\n" +
                    "                        <div class=\"panel-heading\">\n" + this.firstName +

                    "                        </div>\n" +
                    "                        <div>\n" +
                    "  <img style='float: right; margin-top: 10px; margin-right: 10px' src=\"https://images.unsplash.com/profile-1462285601040-a9bcbb6514fd?dpr=1&auto=format&fit=crop&w=64&h=64&q=60&cs=tinysrgb&crop=faces&bg=fff\">\n" +
                    "                            <br><br>\n" +
                    "<div  style='margin-left: 10px' >  Rider Name :   "+ this.firstName +" "+ this.lastName +"<hr>"+
                    "                            <div  style='margin-left: 10px' >  Current Location :   "+ this.loc + "<div></div>"+"Email "+this.email+
                    "                            </div>\n" +



                    "                        <div class=\"panel-body\">\n" +

                    "                        </div>\n" +
                    "                        \n" +
                    "\n" +
                    "                    </div>\n" +
                    "                    <!-- /.col-lg-4 -->\n" +
                    "\n" +
                    "\n" +
                    "                </div>")
            })
        }
    }
    function errorEmergency() {
        console.log("error message")

    }  }
// Start/Stop the Event

function controllStatus(data){
    var controllButton = $("#controllButton");
    // var eventName = $(this).attr("data-title");
    if ($(this).innerText === "Stop") {
        controllButton.attr('value', 'Stop').css('background-color', '#da534f');
        updateEventStatus(data, "COMPLETED");
    }
    else if ($(this).innerText !== "Start Ride") {
        controllButton.attr('value', 'Stop').css('background-color', '#da534f');
        updateEventStatus(data, "ONGOING");
    }
}
function updateEventStatus(eventName, statusType) {
    $.post("/emergency", {
        eventName: eventName,
        statusType: statusType
    }).done(function (data) {
        console.log("Successful");
    });
}
//Emergency Flag Handler
function emergencyHandler(data) {
    var title = data;
    console.log(data)


    $.post("/emergency", {emergencyFlag: data})
        .done(function (data) {
            console.log("Successful");
        });


    function flagFetchError() {
        console.log("err")

    }

    function flagFetchSuccess(data) {
        console.log("scs")
        if (data == true) {
            $("#notifcationIcon").css("background-color: red");
            console.log(data)
        }
    }}

    $.ajax({
        "url":"emergency",
        dataType: 'json',
        "success":successEmergncy,
        "error":errorEmergency
    })
    function  successEmergncy(data){
        console.log(JSON.stringify(data)+"data" )

        // console.log(data)
        //
        $.each(data, function () {
            if(true) {
                $("#notifcationIcon").css("background-color", "red");
            }})
    }

function errorEmergency() {
    console.log("error message")
}

//
// setInterval(function () {
//         $.ajax({
//             "url": "Emergency",
//             "type": "get",
//             "success": flagFetchSuccess,
//             "error": flagFetchError
//         })
//     }
//     , 1000)
