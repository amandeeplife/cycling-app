$(document).ready(function () {

    $.ajax({
        "url":"MapFiles.json",
        "type": "get",
        dataType : 'json',
        async: false,
        "success":fetchMapSuccess,
        "error":fetchMapError
    })
    function fetchMapSuccess(data) {
        $.each(data,function () {
            console.log(this.code);
           $("#start").append(" <option value='"+this.code+"'>"+this.name+"</option>")
            $("#end").append(" <option value='"+this.code+"'>"+this.name+"</option>")
            $("#waypoints").append(" <option value='"+this.code+"'>"+this.name+"</option>")
        })
    }
    function fetchMapError() {
        console.log("Error Fethcing data")
    }
})