$(document).ready(function(){
  //alert(localStorage.getItem('name'));
  if(localStorage.getItem('name')){
    document.getElementById("name").innerHTML = localStorage.getItem('name');
  }else{
    alert("gagal");
  }

});
