$(document).ready(function () {

});
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
    }
}