$(document).ready(function(){
	var token=localStorage.getItem("Token")
  var id=localStorage.getItem("skuLogin")

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
			url:"http://localhost:9081/wishlist/",
			headers: {
					"Content-Type": "application/json",
					"Authorization": "Bearer "+token
			},
			success: function(data) {
				var users = JSON.parse(JSON.stringify(data));
				for (var i in users) {
					if(1==1){
						console.log("test")
					 $("#wish").
						append('<div class="row">\
									<div class="col-md-1">\
										<img src="C:\product/'+users[i].pict_product+'" id="img_product" alt="">\
									</div>\
									<div class="col-md-3">\
											<p>'+users[i].title +'</p></td>\
											<p>Rp '+users[i].price+',00</p>\
									</div>\
									<div class="col-md-2">\
											<a class="btn btn-danger" onclick="hap('+users[i].id+')">Delete From Wishlist</a>\
									</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\
									<div class="col-md-3">\
											<a class="btn btn-success" onclick="hap('+users[i].id+')">Process</a>\
									</div>\
								</div>');
					}
				}

			},
			error: function(data) {
				$("#dat2").
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
	// 		url:"http://localhost:9081/cart/purchase/"+id,
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
function hap(test){
	var token=localStorage.getItem("Token");
	$.ajax({
		type:"DELETE",
		url:"http://localhost:9081/wishlist/delete/"+test,
		headers: {
				"Content-Type": "application/json",
				"Authorization": "Bearer "+token
		},
		success:function(data){
			alert("Delete Succes");
		}
	});
	location.href="wishlist.html";
}