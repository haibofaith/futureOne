function jump() {
    $.ajax({
        type: "POST",
        url: "/a/helloDog",
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

