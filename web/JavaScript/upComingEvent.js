function participate(elem) {
    const tittle = $(elem).val();
    console.log(tittle);
    $.ajax({
        url: "/participate",
        method: "post",
        data: {
            "tittle": tittle
        },
        success: function (response) {
            console.log(response);
        },
        error: function (error) {
            console.log(error);
        }
    });
    console.log("came");
}