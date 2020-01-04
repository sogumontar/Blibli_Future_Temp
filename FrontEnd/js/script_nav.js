$(document).ready(function(){
  //alert(localStorage.getItem('name'));
  if(localStorage.getItem('name')){
    var name =localStorage.getItem('name');
    $("#temp").append('<i class="glyphicon glyphicon-user" style="color: white" id="icon_user"></i>\
      <a href="profile.html" style="color: white" id="name">'+name+'</a>\
      &nbsp;&nbsp;&nbsp;<a onclick="logout()" href="index.html" ><b style="color: white">Logout</b></a>\
    ');
    // document.getElementById("name").innerHTML = localStorage.getItem('name');
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


function logout() {

    location.href="index.html";
    alert("logout success");
    localStorage.clear();
}
var now = new Date().getTime();
    var setupTime = localStorage.getItem('setupTime');
    if(setupTime){
        if(now-setupTime > 20*60*60*1000) {
            localStorage.clear()
            logouts();
        }
    }


    function logouts(){
        alert("Sesi Anda Telah Habis, Silahkan Login Kembali")
        location.href="login.html";
    }
