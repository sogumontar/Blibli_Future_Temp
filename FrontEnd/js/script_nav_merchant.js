$(document).ready(function(){
  //alert(localStorage.getItem('name'));
  if(localStorage.getItem('name')){
    var name =localStorage.getItem('name');
    $("#temp").append('<i class="glyphicon glyphicon-user" style="color: white" id="icon_user"></i>\
      <font style="color: white" id="name">'+name+'</font>\
      <span class="badge badge-pill badge-danger"><font size="2em" id="money">Rp 2000<font></span>\
      &nbsp;&nbsp;&nbsp;<a  data-toggle="modal" data-target="#exampleModal"><b style="color: white">Logout</b></a>\
    ');
    document.getElementById("name").innerHTML = localStorage.getItem('name');
  }else{
    $("#temp").append('<a href="login.html" style="font-size:1em"><i class="glyphicon glyphicon-user" style="color: white" id="icon_user">&nbsp;Login</a>')
  }

});
//function logout
$("#logout").click(function(){
  localStorage.removeItem("name");
  localStorage.removeItem("Token");
  localStorage.removeItem("skuLogin");
  location.href ="index.html";
})


var now = new Date().getTime();
    var setupTime = localStorage.getItem('setupTime');
    if(now-setupTime > 2*60*60*1000) {
        localStorage.clear()
        logouts();
    }

    function logouts(){
        alert("Sesi Anda Telah Habis, Silahkan Login Kembali")
        location.href="login.html";
    }
