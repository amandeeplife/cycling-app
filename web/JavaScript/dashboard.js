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