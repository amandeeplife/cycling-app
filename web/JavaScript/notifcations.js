$(function () {

    //





    // Checking if there is notifcation
    $.ajax({
        "url":"/emergency",
        "type":"get",
        "success":successEmergncy,
        "error":errorEmergency
    })
    function  successEmergncy(data){
console.log(data+"data")
        if(data!=null) {
            $("#notifcationIcon").css("background-color", "red");
            $.each(data, function () {

                this.username
                $("#notificationList").append("<div class=\"col-lg-4\">\n" +
                    "\n" +
                    "                    <div class=\"panel panel-danger\">\n" +
                    "                        <div class=\"panel-heading\">\n" + this.firstName +

                    "                        </div>\n" +
                    "                        <div>\n" +
                    "                            <br><br>\n" +
                    "                            <div style=\"width: 20%; margin: auto\" >   <img src=\"https://images.unsplash.com/profile-1462285601040-a9bcbb6514fd?dpr=1&auto=format&fit=crop&w=64&h=64&q=60&cs=tinysrgb&crop=faces&bg=fff\">\n" +
                    "                            </div>\n" +
                    "                            <hr>\n" +
                    "\n" +
                    "                            <div style=\" margin-left:10px\"> Current Location :   ${user.username}</div><hr></div>\n" +
                    "\n" +
                    "                        <div class=\"panel-body\">\n" +
                    "                              Location " +
                    "                            <c:forEach items=\"${user.createdEvents}\" var=\"ev\">\n" +
                    "                                Title :   ${ev.tittle}<br>\n" +
                    "                                Short Discription :   ${ev.shortdiscription} <br>\n" +
                    "\n" +
                    "                            </c:forEach>\n" +
                    "                        </div>\n" +
                    "                        \n" +
                    "\n" +
                    "                    </div>\n" +
                    "                    <!-- /.col-lg-4 -->\n" +
                    "\n" +
                    "\n" +
                    "                </div>")
            })
        }
    }
    function errorEmergency() {
        console.log("error message")
    }
})