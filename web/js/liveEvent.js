$(document).ready(function () {
    console.log("works");
    $(":button").on("click", function (event) {
        const tittle = $(this).attr("tittle");
        console.log(tittle);
        $.post("/participate", {tittle: tittle})
            .done(successFunction);
        alert("you have been subscribed to " + tittle);
    });

    function successFunction(tittle) {
        alert("you have been subscribed to " + tittle);
        console.log("success");
    }
});