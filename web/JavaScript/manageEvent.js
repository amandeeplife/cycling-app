$(document).ready(function () {

    $("#startButton").click(function () {
        var eventName = $(this).attr("data-title");
        updateEventStatus(eventName, "ONGOING");
    });

    $("#finishButton").click(function () {
        var eventName = $(this).attr("data-title");
        updateEventStatus(eventName, "COMPLETED");
    });

    function updateEventStatus(eventName, statusType) {
        $.post("/manageEvent", {
            eventName: eventName,
            statusType: statusType
        }).done(function (data) {
            console.log("Successful");
        });
    }

    $(".flag").on("click", function () {
        var tittle = $(this).attr("data-tittle");
        updateEventStatus(tittle, "PENDING")
    })
});