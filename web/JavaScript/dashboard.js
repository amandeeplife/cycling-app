$(document).ready(function () {

    $("#controllButton").click(function () {
        console.log($(this).innerText+"asdf")
        console.log($(this).text())
        if($(this).innerText ="Stop"){
            $("#controllButton").attr('value', 'Stop').css('background-color','#da534f');
        }
else if($(this).innerText !="Start Ride") {
            $("#controllButton").attr('value', 'Start Ride').addClass("btn btn-success")
        }

    })



})
function emergencyHandler(data){
    var title = data;
    console.log(data)


    $.post( "Emergency", { param: data})
        .done(function( data ) {
            console.log("Successful");
        });


function flagFetchError() {
    console.log("err")

}
function flagFetchSuccess(data) {
    console.log("scs")
    if(data==true){
        $("#notifcationIcon").css("background-color: red");
        console.log(data)

    }


}


    setInterval(function () {

            $.ajax({
                "url": "Emergency",
                "type": "get",
                "success": flagFetchSuccess,
                "error": flagFetchError
            })}
        ,1000)
}