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
					 append("<div class='col-lg-4 col-md-6 mb-5'>\
 							<a href='detail_book.html?id="+users[i].sku_product+"' style='text-decoration:none'><div id='h'>\
 								<div class='card-body'>\
 									<h4 class='card-title'> <img src='C:/product/"+users[i].pict_product+"' class='card-img-top' id='image'>\</center></h4>\
 									<p class='card-text' style='color:black'><b>"+users[i].title+"</b></p>\
 								</div>\
 								<div class=''>\
 									<div class='col-md-12'>\
 										<div class='row'>\
 											<div class='col-md-6'>\
 												<p id='harga'><b>Rp "+users[i].price+"</b></p>\
 											</div>\
 											<div class='col-md-6'>\
 												<p></p>\
 											</div>\
 										</div>\
 									</div>\
 								</div>\
 								<div id='bawah'><hr>\
									<button type=button' class='btn btn-outline-danger btn-block'>Remove From Wishlist</button>\
								</div>\
 							</div></a>\
 					</div>\
 						");
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
