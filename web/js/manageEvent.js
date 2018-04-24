$(document).ready(function () {

    $("#startButton").click(function () {
        var eventName = $(this).attr("data-title");
        updateEventStatus(eventName, "ONGOING");
        $(this).attr('disabled', 'disabled');
    });

    $("#finishButton").click(function () {
        var eventName = $(this).attr("data-title");
        updateEventStatus(eventName, "COMPLETED");
        $(this).attr('disabled', 'disabled');
    });

    function updateEventStatus(eventName, statusType) {
        $.post("/manageEvent", {
            eventName: eventName,
            statusType: statusType
        }).done(function (data) {
            console.log("Successful");
        });
    }


});