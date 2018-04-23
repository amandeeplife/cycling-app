$(document).ready(function () {
    $(":button").on("click", function (event) {
        const tittle = $(this).attr("tittle");
        console.log(tittle);
        $.ajax({
            url: "/participate",
            type: "post",
            contentType: "application/json",
            data: {
                tittle: tittle
            },
            success: successFunction($(this).val()),
        });
    });

    function successFunction(tittle) {
        alert("you have been subscribed to " + tittle);
    }
});