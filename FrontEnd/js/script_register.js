$(document).ready(function(){

  $("#register").click(function(){
    console.log("cliked")
    // var URLS="http://localhost:9094/api/auth/signup"
    // fetch(URLS).then((resp)=>resp.json())
    // assignUser();
    var email=document.getElementById('email').value;
    var name=document.getElementById('name').value;
    var username=document.getElementById('username').value;
    var password=document.getElementById('password').value;
    var alamat=document.getElementById('alamat').value;
    var tanggal_lahir=document.getElementById('tanggal_lahir').value;
    var telepon=document.getElementById('telepon').value;
    var role=document.getElementById('role').value;
    if(email === "" || name === "" || username === "" || password === "" || alamat === "" || tanggal_lahir === "" || telepon === "" || role === ""){
      window.alert("Semua Field Harus di isi")
    }else{
      assignUser();
    }
  });

  function assignUser(){
    var jsonVar = {
        name: $("#name").val(),
        email: $("#email").val(),
        password: $("#password").val(),
        username: $("#username").val(),
        telepon: $("#telepon").val(),
        alamat: $("#alamat").val(),
        tanggal_lahir: $("#tanggal_lahir").val(),
        role: $("#role").val()
    };
    $.ajax({
              type:"POST",
              url:"http://localhost:9081/api/auth/signup",
              data: JSON.stringify(jsonVar),
              contentType: "application/json",
              success: function(data){
                  console.log(data.message);
                  window.alert("success register account");
                  location.href = "login.html";
              },
              error: function(err) {
                  $("#message").append(err.responseJSON.message);
                  console.log(err.responseJSON.message);
              }
    });
  }
});


// async function makePostRequest() {

//     params = {
//         email: document.getElementById('email'),
//         password: document.getElementById('password'),
//         name: document.getElementById('name'),
//         username: document.getElementById('username')
//       }

//     let res = await axios.post('http://localhost:9094/api/auth/signup', params);

//     console.log(res.data);
// }


// var apiUrl = "https://pokeapi.co/api/v2/pokemon/";
// var input = document.querySelector(".pokemon-input");
// var pokemonName = document.querySelector(".pokemon-name");
// var pokemonImage = document.querySelector(".pokemon-image");

// function getData(){
//   axios.get(apiUrl+input.value)
//   .then(function(response){
//     pokemonName.innerHTML=response.data.forms[0].name;
//     pokemonName.src=response.data.sprites.font_default;
//   })
//   .catch(function(error){
//     pokemonName.innerHTML="(An error has occured)";
//     pokemonImage.src;
//   })
// }


// var button = document.querySelector(".pokemon-button");
// button.addEventListener("click", getData);
