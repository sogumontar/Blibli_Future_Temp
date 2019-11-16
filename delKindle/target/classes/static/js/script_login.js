$(document).ready(function(){

  var jsonVar = {
      usernameOrEmail: $("#usernameOrEmail").val(),
      password: $("#password").val()
  };
  $.ajax({
            type:"POST",
            url:"http://localhost:9094/api/auth/signin",
            data: JSON.stringify(jsonVar),
            contentType: "application/json",
            success: function(data){
                alert("Berhasil Login");
                console.log("andreas");
                location.href = "index1.html";
            },
            error: function(err) {
                alert("Username dan Password anda salah")
                $("#message").append(err.responseJSON.message);
                console.log(err.responseJSON.message);
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
});
