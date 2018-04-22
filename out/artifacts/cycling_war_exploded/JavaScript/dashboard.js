$(document).ready(function () {
    $("#saveEvent").click(function () {
        $.ajax ({
            "url" :"",
            "tyoe":"POST",
            "success" : eventPostSucces,
            "error": eventPostError
        })
    })
function eventPostSucces() {
    console.log("eventPostSucces")
}
function eventPostError() {
        console.log("eventPostError")
    }
})