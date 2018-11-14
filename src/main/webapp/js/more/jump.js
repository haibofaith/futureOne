function jump() {
    $.ajax({
        type: "POST",
        url: "http://localhost:8081/a/helloDog",
        success: function(re){
            // var result = JSON.parse(re);
            console.log(re);
        },
        error: function(result){
            console.log(result);
        }
    });
}

function jsonpJump() {
    $.ajax({
        type: "get",
        dataType:"jsonp",
        url: "http://localhost:8081/a/helloDog",
        jsonp:"callbackparm",
        success: function(re){
            // var result = JSON.parse(re);
            console.log(re);
        },
        error: function(result){
            console.log(result);
        }
    });
}

function completJump() {
    $.ajax({
        type: "post",
        url: "http://localhost:8081/a/completeReq",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({name:"bobo",password:"123456"}),
        success: function(re){
            // var result = JSON.parse(re);
            console.log(re);
        },
        error: function(result){
            console.log(result);
        }
    });
}

function getCookie() {
    $.ajax({
        type: "get",
        url: "http://localhost:8081/a/cookieReq",
        xhrFields:{
          withCredentials:true
        },
        success: function(re){
            // var result = JSON.parse(re);
            console.log(re);
        },
        error: function(result){
            console.log(result);
        }
    });
}

function getHeader() {
    $.ajax({
        type: "get",
        url: "http://localhost:8081/a/getHeader",
        headers:{
          "x-header1":"AAA"
        },
        success: function(re){
            // var result = JSON.parse(re);
            console.log(re);
        },
        error: function(result){
            console.log(result);
        }
    });
}



