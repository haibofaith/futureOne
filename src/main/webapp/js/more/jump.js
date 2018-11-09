function jump() {
    $.ajax({
        type: "POST",
        url: "/a/helloDog",
        success: function(re){
            // var result = JSON.parse(re);
            console.log(re);
        },
        error: function(result){
            // alert(result.retdesc);
        }
    });
}

