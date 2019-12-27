   var token=localStorage.getItem("token")
   var id=localStorage.getItem("skuLogin")
   var gend="";
      const pit=`<img class="card" style="width: 150px; height: 150px;" src="Pict/male.png"><br><br>`;
      const pitt=`<img class="card" style="width: 150px; height: 150px;" src="Pict/girl.png"><br><br>`;
$.ajax({
          type:"GET",
          headers: {
              "Content-Type": "application/json",
              "Authorization": "Bearer "+token
          },
          url:"http://localhost:9081/user/findById/"+id,
          success: function(data) {
            var users = JSON.parse(JSON.stringify(data));

               $("#detail").
                append('<input type="text" id="name" required="" class="form-control" name="" value="'+users.name+'" placeholder="Nama Lengkap" >\
                      <br>\
                      <input type="text" id="email" required=""  class="form-control"  value="'+users.email+'" name="" placeholder="Email">\
                      <br>\
                      <input type="text" id="username" required="" class="form-control"  name="" value="'+users.username+'" placeholder="Username">\
                      <br>\
                      <input type="number" id="telepon" class="form-control" value="'+users.telepon+'"  name="" placeholder="Telepon">\
                      <br>\
                      <input type="text" id="alamat" class="form-control" value="'+users.alamat+'" name=""  placeholder="Alamat">\
                      <br>\
                      <input type="date" id="tanggal_lahir" class="form-control" value="'+users.tanggal_lahir+'"  required="required" placeholder="Tanggal Lahir">\
                      <br><br>\
                      <button style="height:  40px;" onclick="test()" class="btn btn-primary" id="register">Save</button>\
                      <br><br>\
                  ');
              }


        });
function test()
{
    var email=document.getElementById('email').value;
    var name=document.getElementById('name').value;
    var username=document.getElementById('username').value;
    var alamat=document.getElementById('alamat').value;
    var tanggal_lahir=document.getElementById('tanggal_lahir').value;
    var telepon=document.getElementById('telepon').value;


    // var jsonVar = {
    //     name: $("#name").val(),
    //     email: $("#email").val(),
    //     password: $("#password").val(),
    //     username: $("#username").val(),
    //     telepon: $("#telepon").val(),
    //     alamat: $("#alamat").val(),
    //     tanggal_lahir: $("#tanggal_lahir").val(),
    //     role: $("#role").val()
    // };
    $.ajax({
              type:"PUT",
              url:"http://localhost:9081/user/updateProfile/"+name+"/"+email+"/"+username+"/"+telepon+"/"+alamat+"/"+id,
              contentType: "application/json",
              headers: {
				"Content-Type": "application/json",
				"Authorization": "Bearer "+token
		        },
              success: function(data){
                  console.log(data.message);
                  window.alert("Update Profile Success");
                  location.href = "profile.html";
              },
              error: function(err) {
                  $("#message").append(err.responseJSON.message);
                  console.log(err.responseJSON.message);
              }
    });

    alert(localStorage.getItem("skuLogin"));
}
