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
                append('<input type="text" id="name" required="" class="form-control" name="" readonly value="'+users.name+'" placeholder="Nama Lengkap" >\
                      <br>\
                      <input type="text" id="email" required=""  class="form-control" readonly value="'+users.email+'" name="" placeholder="Email">\
                      <br>\
                      <input type="text" id="username" required="" class="form-control" readonly name="" value="'+users.username+'" placeholder="Username">\
                      <br>\
                      <input type="text" id="username" required="" class="form-control" readonly name="" value="'+users.gender+'" placeholder="Username">\
                      <br>\
                      <input type="number" id="telepon" class="form-control" value="'+users.telepon+'" readonly name="" placeholder="Telepon">\
                      <br>\
                      <input type="text" id="alamat" class="form-control" value="'+users.alamat+'" name="" readonly placeholder="Alamat">\
                      <br>\
                      <input type="date" id="tanggal_lahir" class="form-control" value="'+users.tanggal_lahir+'" readonly required="required" placeholder="Tanggal Lahir">\
                      <br><br>\
                      <a href="update_profile.html" class="btn btn-primary">Edit</a>\
                      <br><br>\
                  ');
              }
            

        });





