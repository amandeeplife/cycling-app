$(document).ready(function () {
    $("#saveEvent").click(function () {

        console.log("postSucc")
        $.ajax({
            "url": "",
            "tyoe": "POST",
            "success": eventPostSucces,
            "error": eventPostError
        })

    })

    function eventPostSucces() {
        $("#ownEvents").append(" <div class=\"col-lg-3 col-md-6\">\n" +
            "                        <div class=\"panel panel-primary\">\n" +
            "                            <div class=\"panel-heading\">\n" +
            "                                <div class=\"row\">\n" +
            "                                    <div class=\"col-xs-3\">\n" +
            "                                        <i class=\"fa fa-comments fa-5x\"></i>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"col-xs-9 text-right\">\n" +
            "                                        <div class=\"huge\">26</div>\n" +
            "                                        <div>${event.desciption}</div>\n" +
            "\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                            <a href=\"#\">\n" +
            "                                <div class=\"panel-footer\">\n" +
            "                                    <button type=\"button\" class=\"btn btn-primary\">Modify</button>\n" +
            "                                    <button type=\"button\" class=\"btn btn-info\">View</button>\n" +
            "                                    <button type=\"button\" class=\"btn btn-danger\">Delete</button>\n" +
            "                                    <div class=\"clearfix\"></div>\n" +
            "                                </div>\n" +
            "                            </a>\n" +
            "                        </div>\n" +
            "                        </div>")
    }

    function eventPostError() {
        console.log("eventPostError")
    }



})
function emergencyHandler(data){
    var title = data;
    console.log(data)


    $.post( "Emergency", { param: data})
        .done(function( data ) {
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