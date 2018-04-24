var address;


$(function () {


    //Getting current Location
    navigator.geolocation.getCurrentPosition(function(position){
        console.log(position)
        address = "Latt" +position.coords.latitude+" \nLang :"+ position.coords.longitude;

        //Updating Currne tLocation
        $.post("/emergency", {
            currentLocation: address})
            .done(function (data) {
                console.log("Successful");
            });

        // Checking if there is notifcation
        $.ajax({
            "url":"/emergency",
            "type":"get",
            "success":successEmergncy,
            "error":errorEmergency
        })
    })
    function  successEmergncy(data){
console.log(data+"data")
        if(data!=null) {
            console.log(data)
            $("#notifcationIcon").css("background-color", "red");
            $.each(data, function () {

                this.username
                $("#notificationList").append("<div class=\"col-lg-4\">\n" +
                    "\n" +
                    "                    <div class=\"panel panel-danger\">\n" +
                    "                        <div class=\"panel-heading\">\n" + this.firstName +

                    "                        </div>\n" +
                    "                        <div>\n" +
                    "  <img style='float: right; margin-top: 10px; margin-right: 10px' src=\"https://images.unsplash.com/profile-1462285601040-a9bcbb6514fd?dpr=1&auto=format&fit=crop&w=64&h=64&q=60&cs=tinysrgb&crop=faces&bg=fff\">\n" +
                    "                            <br><br>\n" +
                    "<div  style='margin-left: 10px' >  Rider Name :   "+ this.firstName +" "+ this.lastName +"<hr>"+
                    "                            <div  style='margin-left: 10px' >  Current Location :   "+ this.loc + "<div></div>"+"Email "+this.email+
                    "                            </div>\n" +



                    "                        <div class=\"panel-body\">\n" +

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