$(document).ready(function(){

var token=localStorage.getItem("Token");

	hideNavbar();

	function hideNavbar(){
		var prevScrollpos = window.pageYOffset;
		window.onscroll = function() {
		var currentScrollPos = window.pageYOffset;
		  if (prevScrollpos > currentScrollPos) {
		    document.getElementById("navbar").style.top = "0";
		  } else {
		    document.getElementById("navbar").style.top = "-50px";
		  }
		  prevScrollpos = currentScrollPos;
		}
	}
test();
	function test(){

	$.ajax({
          type:"GET",
          url:"http://localhost:9080/cart/",
          headers: {
              "Content-Type": "application/json",
              "Authorization": "Bearer "+token
          },
          success: function(data) {
            var users = JSON.parse(JSON.stringify(data));
            for (var i in users) {
            	if(users[i].id_user){
            		console.log("test")
               $("#wish").
                append('<div class="card">\
        					<img class="card-img-top" src="pict/ensiklopedia.jpg" alt="Card image cap">\
        					<div class="card-body">\
          					<h5 class="card-title">'+users[i].id+'</h5>\
          					<p class="card-text"><a class="btn btn-danger" href="del.html?id='+users[i].id+'" >Hapus dari wishlist</a></p>\
        				</div>');
            	}
            }

          },
          error: function(data) {
          	$("#dat").
          	append("<br><br><br><div class='container-fluid' id='notLogged'>\
          			<center><p>You are not logged in yet <a href='login.html'>Login</a></p></center>\
          		</div>")
            console.log(data);
            }
        });
	}
	// $("#del").click(function(){
	// 	alert("bayar")
	// 	$.ajax({
	// 		type:"POST",
	// 		url:"http://localhost:9080/cart/purchase/"+id,
	// 		Content-Type:"application/json",
	// 		headers: {
 //              "Content-Type": "application/json",
 //              "Authorization": "Bearer "+token
 //          	},
	// 		success: function(data){

	// 		}
	// 	});

	// });


});
