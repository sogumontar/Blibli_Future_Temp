$(document).ready(function(){
    var token="";

    //function login
    $("#button").click(function(){
      var temp_token = document.getElementById("temp_token");
      var jsonVar = {
        usernameOrEmail: document.getElementById("usernameOrEmail").value,
        password: document.getElementById("password").value

      };

      $.ajax({
              type:"POST",
              url:"http://localhost:9097/api/auth/signin",
              data: JSON.stringify(jsonVar),
              contentType: "application/json",
              success: function(data){
                token = data.accessToken;
                location.href = "index.html?token="+token;
                // location.href = "index.html";
              },
              error: function(err) {
                  alert("Username dan Password anda salah")
                  $("#message").append(err.responseJSON.message);
                  console.log(err.responseJSON.message);
              }
      });
    });

    function coba(x){
      console.log(x);
    }


});


  // let response = await fetch('localhost:9094/api/auth/signin');
  //
  // if (response.ok) { // if HTTP-status is 200-299
  //   // get the response body (the method explained below)
  //   let json = await response.json();
  // } else {
  //   alert("HTTP-Error: " + response.status);
  // }
