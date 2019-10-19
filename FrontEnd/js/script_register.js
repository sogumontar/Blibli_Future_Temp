$(document).ready(function(){

  $("#register").click(function(){
    var URLS="http://localhost:9094/api/auth/signup"
    fetch(URLS).then((resp)=>resp.json())
    assignUser();
  });

  function assignUser(){
    var jsonVar = {
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val(),
        username: $("#username").val()
    };
    $.ajax({
              type:"POST",
              url:"http://localhost:9094/api/auth/signup",

              data: JSON.stringify(jsonVar),
              contentType: "application/json",

              success: function(data){
                  console.log(data.message);
              },
              error: function(err) {
                  $("#message").append(err.responseJSON.message);
                  console.log(err.responseJSON.message);
              }
    });
  }
});


