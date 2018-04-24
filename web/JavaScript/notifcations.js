$(function () {
    $.ajax({
        "url":"/emergency",
        "type":"get",
        "success":successEmergncy,
        "error":errorEmergency
    })
    function  successEmergncy(data){
console.log(data)
console.log("success")
        for (var obj in data) {
console.log(obj+"obj")
                var val = obj.username;
                console.log(val);
            }

    }
    function errorEmergency() {
        console.log("error message")
    }
})