$(document).ready(function () {
    $(":button").on("click", function (event) {
        const tittle = $(this).attr("tittle");
        console.log(tittle);
        $.post("/participate", {tittle: tittle})
            .done(successFunction);

    });

    function successFunction(tittle) {
        alert("you have been subscribed to " + tittle);
        console.log("success");
    }
});