// $(document).ready(function(){

//   $("#register").click(function(){
//     var URLS="http://localhost:9094/api/auth/signup"

//     asd();
//   });

//   function assignUser(){
//     var jsonVar = {
//         name: $("#name").val(),
//         email: $("#email").val(),
//         password: $("#password").val(),
//         username: $("#username").val()
//     };
//     $.ajax({
//               type:"POST",
//               url:"http://localhost:9094/api/auth/signup",
//               data: JSON.stringify(jsonVar),
//               contentType: "application/json",
//               success: function(data){
//                   console.log(data.message);
//               },
//               error: function(err) {
//                   $("#message").append(err.responseJSON.message);
//                   console.log(err.responseJSON.message);
//               }
//     });
//   }
// });


async function asd(){

// The Endpoint URL
let url = "http://localhost:9094/api/auth/signup"
// Data to Post
let data = {
  name: 'foo',
  email: 'bar@gmail.com', 
  password: "asdf",
  username: "yyuqwkd"
  };
// Request options
await fetch(url, options)
.then(function(response) {
  // The Post Result
})
let options = {
  method: 'POST',
  body: JSON.stringify(data)
  };
 

}