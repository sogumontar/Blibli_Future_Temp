$(document).ready(function(){

  var id = new URL(location.href).searchParams.get('id')

  updateBlock();

  function updateBlock(){
    $.ajax({
          type:"GET",
          headers: {
              "Content-Type": "application/json",
              // "Authorization": "Bearer "+c
          },
          url:"http://localhost:9080/user/updateStatusBlock/"+id,
          success: function(data) {
            location.href="block_user.html";
          },
          error: function(data) {
            console.log(data);
            }
        });
  }
});
