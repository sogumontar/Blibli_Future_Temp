$(document).ready(function(){
	test();

	var token=localStorage.getItem("Token");
	var val = new URL(location.href).searchParams.get('id')
	function test(){;


		$.ajax({
	          type:"DELETE",
	          url:"http://localhost:9081/cart/delete/"+val,
	          headers: {
	              "Content-Type": "application/json",
	              "Authorization": "Bearer "+token
	          },
	          success: function(data) {
	          	location.href="wistlist.html";
	          } 
	          error: function(data) {
	          	console.log(data);
	          }

	      });

	}
});