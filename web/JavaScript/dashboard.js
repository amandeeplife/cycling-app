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


// function emergencyHandler(data) {
//     var title = data;
//     console.log(data)
//
//
//     $.post("/emergency", {param: data})
//         .done(function (data) {
//             console.log("Successful");
//         });
//
//
//     function flagFetchError() {
//         console.log("err")
//
//     }
//
//     function flagFetchSuccess(data) {
//         console.log("scs")
//         if (data == true) {
//             $("#notifcationIcon").css("background-color: red");
//             console.log(data)
//         }
//     }


// setInterval(function () {
//         $.ajax({
//             "url": "Emergency",
//             "type": "get",
//             "success": flagFetchSuccess,
//             "error": flagFetchError
//         })
//     }
//     , 1000)
// }