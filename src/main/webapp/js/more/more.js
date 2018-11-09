function more() {
    $.ajax({
        type: "POST",
        url: "/b/helloKitty",
        dataType: "json",
        success: function(re){
            // var result = JSON.parse(re);
            console.log(re);
            // if(result.retcode == 0){
            //     if (result.body > 0){
            //         crmMobile.hotelFeedbackUnReadNum = true;
            //     }
            // }
            // else{
            //     // alert(result.retdesc)
            // }
        },
        error: function(result){
            // alert(result.retdesc);
        }
    });
}

