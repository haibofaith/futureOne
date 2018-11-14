function more() {
    $.ajax({
        type: "POST",
        url: "/b/helloKitty",
        dataType: "json",
        success: function(re){
            // var result = JSON.parse(re);
            console.log(re);
        },
        error: function(result){
            console.log(result);
        }
    });
}



