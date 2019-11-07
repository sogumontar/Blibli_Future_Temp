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
    if(email === "" || name === "" || username === "" || password === ""){
      window.alert("Semua Field Harus di isi")
    }else{
      assignUser()   
    }
  });

  function assignUser(){
    var jsonVar = {
        name: $("#name").val(),  
        email: $("#email").val(),
        password: $("#password").val(),
        username: $("#username").val()
    };
    $.ajax({
              type:"POST",
              url:"http://localhost:9097/account/register",
              data: JSON.stringify(jsonVar),
              contentType: "application/json",
              data: JSON.stringify(jsonVar),
              contentType: "application/json",
              success: function(data){
                  console.log(data.message);
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