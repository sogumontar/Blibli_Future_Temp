   var token=localStorage.getItem("token")
   var id=localStorage.getItem("idLogin")
   var gend="";
      const pit=`<img class="card" style="width: 150px; height: 150px;" src="Pict/male.png"><br><br>`;
      const pitt=`<img class="card" style="width: 150px; height: 150px;" src="Pict/girl.png"><br><br>`;
$.ajax({
          type:"GET",
          headers: {
              "Content-Type": "application/json",
              "Authorization": "Bearer "+token
          },
          url:"http://localhost:9081/account/find/"+id,
          success: function(data) {
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
               $("#detail").
                append('<input type="text" id="name" required="" class="form-control" name="" readonly value="${i.name}" placeholder="Nama Lengkap" >\
                      <br>\
                      <input type="text" id="email" required=""  class="form-control" readonly value="${i.email}" name="" placeholder="Email">\
                      <br>\
                      <input type="text" id="username" required="" class="form-control" readonly name="" value="${i.username}" placeholder="Username">\
                      <br>\
                      <input type="text" id="username" required="" class="form-control" readonly name="" value="${i.gender}" placeholder="Username">\
                      <br>\
                      <input type="number" id="telepon" class="form-control" value="${i.telepon}" readonly name="" placeholder="Telepon">\
                      <br>\
                      <input type="text" id="alamat" class="form-control" value="${i.alamat}" name="" readonly placeholder="Alamat">\
                      <br>\
                      <input type="date" id="tanggal_lahir" class="form-control" value=${i.tanggal_lahir} readonly required="required" placeholder="Tanggal Lahir">\
                      <br><br>\
                      <button style="height:  40px;" class="btn btn-primary" id="register">Edit</button>\
                      <br><br>\
                  ');
              }
            }

        });
 if(gend==="male"){
      window.pic.innerHTML=pit;  
    }else{
      // window.pic.innerHTML=pitt;
    }






