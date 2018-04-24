$(document).ready(function () {

    $("#controllButton").click(function () {
        var controllButton = $("#controllButton");

        if ($(this).innerText = "Stop") {
            controllButton.attr('value', 'Stop').css('background-color', '#da534f');

        }
        else if ($(this).innerText != "Start Ride") {
            controllButton.attr('value', 'Stop').css('background-color', '#da534f');
        }
    });
});

function updateEventStatus(statusType) {
    $.post("/emergency", {param: statusType})
        .done(function (data) {
            console.log("Successful");
        });
}


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