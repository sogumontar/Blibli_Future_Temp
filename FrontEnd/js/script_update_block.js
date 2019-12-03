$(document).ready(function(){

  var id = new URL(location.href).searchParams.get('id')

  updateBlock();

  function updateBlock(){
    $.ajax({
          type:"POST",
          headers: {
              "Content-Type": "application/json",
              // "Authorization": "Bearer "+c
          },
          url:"http://localhost:9081/user/updateStatusBlock/"+id,
          success: function(data) {
            JavaScript:history.back()
          },
          error: function(data) {
            console.log(data);
            }
        });
  }
});
