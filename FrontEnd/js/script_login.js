$(document).ready(function(){
    var token="";
    var idLogin;

    //function login
    $("#button").click(function(){
      var temp_token = document.getElementById("temp_token");
      var jsonVar = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
      };

      $.ajax({
              type:"POST",
              url:"http://localhost:9081/api/auth/signin",
              data: JSON.stringify(jsonVar),
              contentType: "application/json",
              success: function(data){
                if(data.status == 1){
                  alert("Login Success");
                  token = data.accessToken;
                  skuLog=data.skuLog;
                  console.log(data.role);
                  localStorage.setItem('Token',token);
                  localStorage.setItem('skuLogin',skuLog);
                  if(data.role == "ROLE_USER"){
                      location.href = "index.html";
                  }else if(data.role == "ROLE_ADMIN"){
                      location.href = "home_admin.html";
                  }else if(data.role == "ROLE_MERCHANT"){
                      // location.href = "home_merchant.html?idLog="+idLogin+"&token="+token;
                      location.href = "home_merchant.html";
                  }
                }else {
                  alert("Your account have block !");
                }


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
